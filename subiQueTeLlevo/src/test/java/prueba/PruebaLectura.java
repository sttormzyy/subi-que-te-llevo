package prueba;

import java.io.IOException;

import Persistencia.IPersistencia;
import Persistencia.PersistenciaXML;
import Persistencia.UTILAdmSubSistema;
import Persistencia.UTILEmpresa;
import Persistencia.choferDTO.ChoferDTO;
import Persistencia.sistemaDTO.EmpresaDTO;
import Persistencia.usuarioDTO.UsuarioDTO;
import Persistencia.vehiculoDTO.VehiculoDTO;
import choferes.Chofer;
import sistema.Empresa;
import usuarios.Usuario;
import vehiculos.Vehiculo;

public class PruebaLectura {

	public static void main(String[] args) {
		
		IPersistencia persistencia = new PersistenciaXML();
		// IPersistencia persistencia = new PersistenciaBIN();
		Empresa empresa = null;

		try {
			persistencia.abrirInput("Empresa.xml");
			//persistencia.abrirInput("Empresa.ser");
			System.out.println("-Archivo Empresa abierto");

			EmpresaDTO empresaDTO = (EmpresaDTO) persistencia.leer();
			empresa = UTILEmpresa.empresaFromEmpresaDTO(empresaDTO);

			System.out.println("Empresa recuperada");
			persistencia.cerrarInput();
			System.out.println("-Archivo cerrado\n");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			persistencia.abrirInput("Cliente1.xml");
			//persistencia.abrirInput("Cliente1.ser");
			System.out.println("-Archivo abierto: ");

			UsuarioDTO usuarioDTO = (UsuarioDTO) persistencia.leer();
			Usuario usuario = UTILAdmSubSistema.usuarioFromUsuarioDTO(usuarioDTO);
			System.out.println(usuario.toString());

			persistencia.cerrarInput();
			System.out.println("-Archivo cerrado\n");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}

		try {
		    persistencia.abrirInput("Chofer1.xml");
		    //persistencia.abrirInput("Chofer1.ser");
		    System.out.println("-Archivo abierto: ");

		    ChoferDTO choferDTO = (ChoferDTO) persistencia.leer();
		    Chofer chofer = UTILAdmSubSistema.choferFromChoferDTO(choferDTO);
		    System.out.println(chofer.toString());

		    persistencia.cerrarInput();
		    System.out.println("-Archivo cerrado\n");
		} catch (IOException e) {
		    System.out.println(e.getMessage());
		} catch (ClassNotFoundException e) {
		    System.out.println(e.getMessage());
		}

		try {
		    persistencia.abrirInput("Vehiculo1.xml");
		    //persistencia.abrirInput("Vehiculo1.ser");
		    System.out.println("-Archivo abierto: ");

		    VehiculoDTO vehiculoDTO = (VehiculoDTO) persistencia.leer();
		    Vehiculo vehiculo = UTILAdmSubSistema.vehiculoFromVehiculoDTO(vehiculoDTO);
		    System.out.println(vehiculo.toString());

		    persistencia.cerrarInput();
		    System.out.println("-Archivo cerrado\n");
		} catch (IOException e) {
		    System.out.println(e.getMessage());
		} catch (ClassNotFoundException e) {
		    System.out.println(e.getMessage());
		}

	}
}
