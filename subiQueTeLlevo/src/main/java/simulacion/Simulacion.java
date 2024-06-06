/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simulacion;

import Persistencia.PersistenciaXML;
import choferes.Chofer;
import choferes.ChoferContratado;
import choferes.ChoferPermanente;
import choferes.ChoferTemporario;
import excepciones.chofer.ExceptionChofer;
import excepciones.usuario.ExceptionUsuario;
import excepciones.vehiculo.ExceptionVehiculo;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import sistema.Empresa;
import usuarios.Cliente;
import usuarios.Usuario;
import vehiculos.Auto;
import vehiculos.Combi;
import vehiculos.Moto;

/**
 *
 * @author Usuario
 */
public class Simulacion {
   private RecursoCompartido rc;
   private Empresa empresa;
   private ArrayList<ClienteThread> robotsCliente = new ArrayList<>();
   private ArrayList<ChoferThread> robotsChofer = new ArrayList<>();
   private String nombresC[] = { "Moria Casan","Mirtha","Jennifer Anniston", "Mafalda"};
   private String nombresCh[] = { "Vin Diesel","Schumacher","Fangio", "Chano"}; 
   
   
     public  Simulacion(RecursoCompartido rc, Empresa empresa)
   {
       this.rc = rc;
       this.empresa = empresa;
   }
   
 
   public void iniciarSimulacionNueva(int cantClientes,int cantMaxViajeCliente,int cantChoferTemporario,
               int cantChoferContratado,int  cantChoferPermanente,int cantMaxViajeChofer, 
               int cantAutos,int cantMotos, int cantCombis)
   {
        initClientes(cantClientes, cantMaxViajeCliente);
        initChoferes(cantChoferTemporario, cantChoferContratado, cantChoferPermanente, cantMaxViajeChofer);
        initVehiculos(cantAutos, cantMotos, cantCombis);
        rc.setCantClientes(cantClientes);
        rc.setCantChoferes(cantChoferContratado + cantChoferPermanente + cantChoferTemporario);
        comienzaSimulacion();
   }
   
   public void iniciarSimulacionConDatosViejos(int cantMaxViajeCliente,int cantMaxViajeChofer)
   {
       PersistenciaXML p = new PersistenciaXML();
       
       try {
           p.abrirInput("empresa.xml");
           try {
               empresa = (Empresa) p.leer();
           } catch (ClassNotFoundException ex) {
               Logger.getLogger(Simulacion.class.getName()).log(Level.SEVERE, null, ex);
           }
       } catch (IOException ex) {
           Logger.getLogger(Simulacion.class.getName()).log(Level.SEVERE, null, ex);
       }
       
       initThreads(cantMaxViajeCliente, cantMaxViajeChofer);
       comienzaSimulacion();
   }
   
   public void comienzaSimulacion()
   {
       for(ClienteThread c : robotsCliente)
            c.start();
        
        SistemaThread sistema = new SistemaThread(rc);
        sistema.start();

        for (ChoferThread c : robotsChofer) 
            c.start();
   }
   
   private void initClientes(int cantClientes, int cantMaxViajeCliente) {
        for (int i = 0; i < cantClientes; i++) {
            try {
                Cliente nuevoCliente = new Cliente(nombresC[Util.rand(3)] + i, "Cliente" + i, i * 2 + "77" + 3 * i);
                empresa.addCliente(nuevoCliente);
                robotsCliente.add(new ClienteThread(nuevoCliente, rc, Util.rand(cantMaxViajeCliente)));
            } catch (ExceptionUsuario ex) {
                // no entra nunca
            }
        }
    }
    
    private void initChoferes(int cantChoferTemporario,int cantChoferContratado,int cantChoferPermanente,int cantMaxViajeChofer)
    {
        for(int i=0; i<cantChoferTemporario; i++)
        {
            ChoferTemporario nuevoChoferT = new ChoferTemporario(i*2+"777"+3*i,nombresCh[Util.rand(3)]);
            try {
                empresa.addChofer(nuevoChoferT);
            } catch (ExceptionChofer ex) {
            
            }
            robotsChofer.add(new ChoferThread((Chofer)nuevoChoferT,rc,Util.rand(cantMaxViajeChofer)));
        }
        for(int i=0; i<cantChoferContratado; i++)
        {
            ChoferContratado nuevoChoferC = new ChoferContratado(i*2+"777"+3*i,nombresCh[Util.rand(3)]);
            try {
                empresa.addChofer(nuevoChoferC);
            } catch (ExceptionChofer ex) {
            
            }
            robotsChofer.add(new ChoferThread((Chofer)nuevoChoferC,rc,Util.rand(cantMaxViajeChofer)));
        }
        for(int i=0; i<cantChoferPermanente; i++)
        {
            ChoferPermanente nuevoChoferP = new ChoferPermanente(i*2+"777"+3*i,nombresCh[Util.rand(3)], Util.rand(5), LocalDateTime.now());
            try {
                empresa.addChofer(nuevoChoferP);
            } catch (ExceptionChofer ex) {
            
            }
            robotsChofer.add(new ChoferThread((Chofer)nuevoChoferP,rc,Util.rand(cantMaxViajeChofer)));
        }
    }

    private void initVehiculos(int cantAutos,int cantMotos,int cantCombis) {
        
        for (int i = 0; i < cantAutos; i++) {
            try {
                empresa.addVehiculo(new Auto(Util.rand(400000)+""));
            } catch (ExceptionVehiculo ex) {
                //puede tocar patente repetida
                i--;
            }
        }
        for (int i = 0; i < cantMotos; i++) {
            try {
                empresa.addVehiculo(new Moto(Util.rand(400000)+""));
            } catch (ExceptionVehiculo ex) {
                //puede tocar patente repetida
                i--;
            }
        }
        for (int i = 0; i < cantCombis; i++) {
            try {
                empresa.addVehiculo(new Combi(Util.rand(400000)+""));
            } catch (ExceptionVehiculo ex) {
                //puede tocar patente repetida
                i--;
            }
        }
    }
    
    private void initThreads(int cantMaxViajeCliente ,int cantMaxViajeChofer )
    {
        for(Usuario c: empresa.getUsuarioLista())
        {
            robotsCliente.add(new ClienteThread((Cliente)c,rc,Util.rand(cantMaxViajeCliente)));
        }
        for(Chofer c: empresa.getChoferLista())
        {
            robotsChofer.add(new ChoferThread(c,rc,Util.rand(cantMaxViajeChofer)));
        }
        rc.setCantClientes(empresa.getUsuarioLista().size());
        rc.setCantChoferes(empresa.getChoferLista().size());
    }
    
}
