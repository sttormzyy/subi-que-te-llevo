package prueba;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import Persistencia.IPersistencia;
import Persistencia.PersistenciaXML;
import Persistencia.PersistenciaBIN;
import Persistencia.UTILAdmSubSistema;
import Persistencia.UTILEmpresa;
import Persistencia.sistemaDTO.EmpresaDTO;
import choferes.Chofer;
import choferes.ChoferContratado;
import choferes.ChoferPermanente;
import choferes.ChoferTemporario;
import excepciones.chofer.ExceptionChofer;
import excepciones.usuario.ExceptionUsuario;
import excepciones.vehiculo.ExceptionVehiculo;
import sistema.Empresa;
import usuarios.Administrador;
import usuarios.Cliente;
import usuarios.Usuario;
import vehiculos.Auto;
import vehiculos.Combi;
import vehiculos.Moto;
import vehiculos.Vehiculo;

public class PruebaEscritura {

	public static void main(String[] args) {
		
		
		Moto moto1 = new Moto("ABC123");
		Auto auto1 = new Auto("DEF456");
		Combi combi1 = new Combi("GHI789");
		
		ChoferContratado ChoferC1 = new ChoferContratado("1234567", "Juan");    //8 de junio de 2024, 15:30
		ChoferPermanente ChoferP1 = new ChoferPermanente("2234567", "Pablo", 5, LocalDateTime.of(2024, 6, 8, 15, 30));
		ChoferTemporario ChoferT1 = new ChoferTemporario("3234567", "Franco");
		
		Cliente Cliente1 = new Cliente("GianSanPedro", "Gianfranco San Pedro", "123");
		Cliente Cliente2 = new Cliente("GianMagliotti", "Gian Franco Magliotti", "456");
		Cliente Cliente3 = new Cliente("IvanAhumada", "Ivan Ahumada", "789");
		
		Administrador Adm = new Administrador("Dios", "Morgan Freeman", "0000");
		
		Empresa empresa = Empresa.getInstance();
		
		try {
			empresa.addAdmin(Adm);
			empresa.addCliente(Cliente1);
			empresa.addCliente(Cliente2);
			empresa.addCliente(Cliente3);
		} catch (ExceptionUsuario e) {
			e.printStackTrace();
		}
		
		try {
			empresa.addChofer(ChoferC1);
			empresa.addChofer(ChoferP1);
			empresa.addChofer(ChoferT1);
		} catch (ExceptionChofer e) {
			e.printStackTrace();
		}
		
		try {
			empresa.addVehiculo(moto1);
			empresa.addVehiculo(auto1);
			empresa.addVehiculo(combi1);
		} catch (ExceptionVehiculo e) {
			e.printStackTrace();
		}
		
		IPersistencia persistencia = new PersistenciaXML();
	    //IPersistencia persistencia = new PersistenciaBIN();
		
		System.out.println("Directorio de trabajo actual: " + System.getProperty("user.dir"));
		
		try
        {
            persistencia.abrirOutput("Empresa.xml");
			//persistencia.abrirOutput("Empresa.ser");
            System.out.println("Grabando datos en disco");
            
            EmpresaDTO empresaDTO = UTILEmpresa.empresaDTOFromEmpresa(empresa);
            persistencia.escribir(empresaDTO);
            
            System.out.println("Empresa grabada exitosamente");
            persistencia.cerrarOutput();
            
        } 
		catch (IOException e)
        {
            System.out.println(e.getLocalizedMessage());
        }

		ArrayList<Usuario> listaClientes = empresa.getUsuarioLista();
		
		for (int i = 0; i < listaClientes.size(); i++) {
		    Usuario cliente = listaClientes.get(i);
		    String nombreArchivo = "Cliente" + (i + 1) + ".xml";
		    //String nombreArchivo = "Cliente" + (i + 1) + ".ser";
            
            try {
                persistencia.abrirOutput(nombreArchivo);
                System.out.println("Grabando datos en disco");

                persistencia.escribir(UTILAdmSubSistema.usuarioDTOFromUsuario(cliente));

                System.out.println("Cliente grabado exitosamente");
                persistencia.cerrarOutput();
            } catch (IOException e) {
                System.out.println(e.getLocalizedMessage());
            }
        }
		
		ArrayList<Chofer> listaChoferes = empresa.getChoferLista();
		
		for (int i = 0; i < listaChoferes.size(); i++) {
		    Chofer chofer = listaChoferes.get(i);
		    String nombreArchivo = "Chofer" + (i + 1) + ".xml"; 
		    //String nombreArchivo = "Chofer" + (i + 1) + ".ser"; 

		    try {
		        persistencia.abrirOutput(nombreArchivo);
		        System.out.println("Grabando datos en disco");

		        persistencia.escribir(UTILAdmSubSistema.ChoferDTOFromChofer(chofer));

		        System.out.println("Chofer grabado exitosamente");
		        persistencia.cerrarOutput();
		    } catch (IOException e) {
		        System.out.println(e.getLocalizedMessage());
		    }
		}

		ArrayList<Vehiculo> listaVehiculos = empresa.getVehiculoLista();
		
		for (int i = 0; i < listaVehiculos.size(); i++) {
		    Vehiculo vehiculo = listaVehiculos.get(i);
		    String nombreArchivo = "Vehiculo" + (i + 1) + ".xml";
		    //String nombreArchivo = "Vehiculo" + (i + 1) + ".ser";

		    try {
		        persistencia.abrirOutput(nombreArchivo);
		        System.out.println("Grabando datos en disco");

		        persistencia.escribir(UTILAdmSubSistema.vehiculoDTOFromVehiculo(vehiculo));

		        System.out.println("Vehiculo grabado exitosamente");
		        persistencia.cerrarOutput();
		    } catch (IOException e) {
		        System.out.println(e.getLocalizedMessage());
		    }
		}

	}

}
