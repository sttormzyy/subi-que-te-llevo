/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simulacion;

import Persistencia.PersistenciaXML;
import Persistencia.UTILEmpresa;
import Persistencia.sistemaDTO.EmpresaDTO;
import choferes.Chofer;
import choferes.ChoferContratado;
import choferes.ChoferPermanente;
import choferes.ChoferTemporario;
import controladores.ControladorCliente;
import excepciones.chofer.ExceptionChofer;
import excepciones.usuario.ExceptionUsuario;
import excepciones.vehiculo.ExceptionVehiculo;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import sistema.Empresa;
import usuarios.Administrador;
import usuarios.Cliente;
import usuarios.Usuario;
import vehiculos.Auto;
import vehiculos.Combi;
import vehiculos.Moto;
import vista.VentanaCliente;
import vista.VentanaGeneral;

/**
 *Clase encargada de gestionar la simulacion, tanto la inicializacion de la empresa y recurso compartido asi como los hilos involucrados
**/
public class Simulacion {
   private RecursoCompartido rc;
   private ArrayList<ClienteThread> robotsCliente = new ArrayList<>();
   private ArrayList<ChoferThread> robotsChofer = new ArrayList<>();
   
 /**
  * Gestiona el inicio de una nueva simulacion. Crea el recurso compartido y la cantidad de clientes y choferes indicadas por el usuario.<br>
  * Por cada uno de ellos, crea un hilo del tipo correspondiente.<br>
  * Por ultimo, da inicio a la simulacion
  * @param Parametros parametros de la nueva simulacion
  */
   public void iniciarSimulacionNueva(ParametrosSimulacion p)
   {
        Empresa empresa = Empresa.getInstance();
        rc =  new RecursoCompartido(empresa,p.getCantClientes(),p.CantChoferes());
        initClientes(empresa,p.getCantClientes(), p.getCantMaxViajeCliente());
        initChoferes(empresa,p.getCantChoferTemporario(), p.getCantChoferContratado(), p.getCantChoferPermanente(), p.getCantMaxViajeChofer());
        initVehiculos(empresa,p.getCantAutos(), p.getCantMotos(), p.getCantCombis());
        simular(empresa,p);
   }
   
   /**
    * gestiona el inicio de una simulacion con datos persistidos.<br>
    * Obtiene de archivos la empresa, a partir de sus listas de choferes y clientes inicializa los hilos necesarios.<br>
    */
   public void iniciarSimulacionConDatosViejos()
   {
       PersistenciaXML leeParametros = new PersistenciaXML();
       PersistenciaXML leeEmpresa = new PersistenciaXML();
       ParametrosSimulacion parametros =  new ParametrosSimulacion();
       
       try {
    	   leeEmpresa.abrirInput("Empresa.xml");
    	   EmpresaDTO empresaDTO = (EmpresaDTO) leeEmpresa.leer();
    	   Empresa empresa = UTILEmpresa.empresaFromEmpresaDTO(empresaDTO);
    	   leeEmpresa.cerrarInput();
           
    	   leeParametros.abrirInput("Parametros.xml");
           parametros = (ParametrosSimulacion) leeParametros.leer();
           leeParametros.cerrarInput();
           
    	   rc = new RecursoCompartido(empresa,empresa.getUsuarioLista().size(), empresa.getChoferLista().size());
    	   initThreads(empresa,parametros.getCantMaxViajeChofer(),parametros.getCantMaxViajeCliente());
    	   simular(empresa,null);
           
       } catch (IOException ex) {
    	   Logger.getLogger(Simulacion.class.getName()).log(Level.SEVERE, null, ex);
       }catch (ClassNotFoundException ex) {
           Logger.getLogger(Simulacion.class.getName()).log(Level.SEVERE, null, ex);
       }
   }
   
    /**
     * Ejecuta la simulacion.Crea las ventanas generales y de cliente unico.<br>
     * Ademas, ejecuta metodo start() de cada uno de los hilos y persiste los datos de la empresa y la simulacion
     * @param empresa
     * @param parametros
     **/
    public void simular(Empresa empresa, ParametrosSimulacion parametros)
    {
       PersistenciaXML persisteEmpresa = new PersistenciaXML();
       PersistenciaXML persisteParametros = new PersistenciaXML();
       VentanaGeneral vistaGeneral = new VentanaGeneral();
       VentanaCliente vistaCliente = new VentanaCliente();
       
       OjoGeneral ojoGeneral = new OjoGeneral(vistaGeneral, rc);
       OjoClienteSimulacion ojoClienteSimulacion = new OjoClienteSimulacion(vistaGeneral, rc, (Cliente) empresa.getUsuarioLista().get(Util.rand(5)));
       OjoChoferSimulacion ojoChoferSimulacion = new OjoChoferSimulacion(vistaGeneral, rc, empresa.getChoferLista().get(0));
       OjoCliente ojoClienteApp = new OjoCliente(vistaCliente,rc);
       
       ControladorCliente controladorCliente = new ControladorCliente(rc,vistaCliente);
       
       try {
           persisteEmpresa.abrirOutput("Empresa.xml");
           EmpresaDTO empresaDTO = UTILEmpresa.empresaDTOFromEmpresa(empresa);
           persisteEmpresa.escribir(empresaDTO);
           persisteEmpresa.cerrarOutput();
           if(parametros!=null)
           {
                persisteParametros.abrirOutput("Parametros.xml");
                persisteParametros.escribir(parametros);
                persisteParametros.cerrarOutput();
           }
       } catch (IOException ex) {
           Logger.getLogger(Simulacion.class.getName()).log(Level.SEVERE, null, ex);
       }

       
       for(ClienteThread c : robotsCliente)
            c.start();
        
        SistemaThread sistema = new SistemaThread(rc);
        sistema.start();

       for (ChoferThread c : robotsChofer) 
            c.start();

   }
   
   /**
    * Crea la cantidad indicada de clientes e hilos cliente
    * @param empresa
    * @param cantClientes cantidad de hilos cliente nueva simulacion
    * @param cantMaxViajeCliente cantidad maxima de viajes por hilo cliente
    */
   private void initClientes(Empresa empresa,int cantClientes, int cantMaxViajeCliente) {
       String nombresC[] = { "Moria Casan","Mirtha","Jennifer Anniston", "Mafalda"};

        for (int i = 0; i < cantClientes; i++) {
            try {
                Cliente nuevoCliente = new Cliente(nombresC[Util.rand(3)] + i, "Cliente" + i, i * 2 + "77" + 3 * i);
                empresa.addCliente(nuevoCliente);
                robotsCliente.add(new ClienteThread(nuevoCliente, rc, Util.rand(cantMaxViajeCliente)));
            } catch (ExceptionUsuario ex) {
                // no entra nunca porque los datos son validos siempre
            }
        }
    }
    
   /**
    * Crea la cantidad indicada de chofer e hilos chofer, segun su tipo
    * @param empresa
    * @param cantChoferTemporario cantidad de hilos chofer temporario nueva simulacion
    * @param cantChoferContratado cantidad de hilos chofer contratado nueva simulacion
    * @param cantChoferPermanente cantidad de hilos chofer permanente nueva simulacion
    * @param cantMaxViajeChofer  cantidad maxima de viajes por hilo chofer
    */
   private void initChoferes(Empresa empresa, int cantChoferTemporario, int cantChoferContratado, int cantChoferPermanente, int cantMaxViajeChofer) {
       String nombresCh[] = { "Vin Diesel","Schumacher","Fangio", "Chano"}; 
       
       for (int i = 0; i < cantChoferTemporario; i++) {
            ChoferTemporario nuevoChoferT = new ChoferTemporario(i * 2 + "777" + 3 * i, nombresCh[Util.rand(4)]+i);
            try {
                empresa.addChofer(nuevoChoferT);
                robotsChofer.add(new ChoferThread((Chofer) nuevoChoferT, rc, Util.rand(cantMaxViajeChofer)));
            } catch (ExceptionChofer ex) {
              // no entra nunca porque los datos son validos siempre
            }
     
        }
        for (int i = 0; i < cantChoferContratado; i++) {
            ChoferContratado nuevoChoferC = new ChoferContratado(i * 2 + "777" + 3 * i, nombresCh[Util.rand(4)]+i);
            try {
                empresa.addChofer(nuevoChoferC);
                robotsChofer.add(new ChoferThread((Chofer) nuevoChoferC, rc, Util.rand(cantMaxViajeChofer)));
            } catch (ExceptionChofer ex) {
              // no entra nunca porque los datos son validos siempre
            }

        }
        for (int i = 0; i < cantChoferPermanente; i++) {
            ChoferPermanente nuevoChoferP = new ChoferPermanente(i * 2 + "777" + 3 * i, nombresCh[Util.rand(4)]+i, Util.rand(5), LocalDateTime.now());
            try {
                empresa.addChofer(nuevoChoferP);
                robotsChofer.add(new ChoferThread((Chofer) nuevoChoferP, rc, Util.rand(cantMaxViajeChofer)));
            } catch (ExceptionChofer ex) { 
             // no entra nunca porque los datos son validos siempre
            }
        }
    }

   /**
    * Crea la cantidad indicada de vehiculos para la empresa, segun su tipo
    * @param empresa
    * @param cantAutos  cantidad de autos de la empresa
    * @param cantMotos  cantidad de motos de la empresa
    * @param cantCombis  cantidad de combis de la empresa
    */
   private void initVehiculos(Empresa empresa, int cantAutos, int cantMotos, int cantCombis) {

        int i=0;
        while(i<cantAutos)
        {
            try {
                empresa.addVehiculo(new Auto(Util.rand(400000) + ""));
                i++;
            } catch (ExceptionVehiculo ex) {}
        }
        i=0;
        while(i < cantMotos) 
        {
            try {
                empresa.addVehiculo(new Moto(Util.rand(400000) + ""));
                i++;
            } catch (ExceptionVehiculo ex) {
            }
        }
        while(i<cantCombis) 
        {
            try {
                empresa.addVehiculo(new Combi(Util.rand(400000) + ""));
                i++;
            } catch (ExceptionVehiculo ex) {}
        }
    }

   /**
    * En caso de simulacion a partir de datos persistidos, inicializa los hilos chofer y clientes necesarios de acuerdo a la informacion almacenada en la empresa persistida
    * @param empresa
    * @param cantAutos  cantidad de autos de la empresa
    * @param cantMotos  cantidad de motos de la empresa
    * @param cantCombis  cantidad de combis de la empresa
    */
   private void initThreads(Empresa empresa, int cantMaxViajeCliente, int cantMaxViajeChofer) {
       Cliente cliente;
        for (Usuario c : empresa.getUsuarioLista()) {
            cliente = (Cliente) c;
            if(!cliente.isUsandoApp())
              robotsCliente.add(new ClienteThread((Cliente) c, rc, Util.rand(cantMaxViajeCliente)));
        }
        for (Chofer c : empresa.getChoferLista()) {
            robotsChofer.add(new ChoferThread(c, rc, Util.rand(cantMaxViajeChofer)));
        }
        rc.setCantClientes(empresa.getUsuarioLista().size());
        rc.setCantChoferes(empresa.getChoferLista().size());
    }

}
