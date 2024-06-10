package Persistencia;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import Persistencia.choferDTO.ChoferContratadoDTO;
import Persistencia.choferDTO.ChoferDTO;
import Persistencia.choferDTO.ChoferPermanenteDTO;
import Persistencia.choferDTO.ChoferTemporarioDTO;
import Persistencia.sistemaDTO.AdmSubSistemaDTO;
import Persistencia.usuarioDTO.AdministradorDTO;
import Persistencia.usuarioDTO.ClienteDTO;
import Persistencia.usuarioDTO.UsuarioDTO;
import Persistencia.vehiculoDTO.AutoDTO;
import Persistencia.vehiculoDTO.CombiDTO;
import Persistencia.vehiculoDTO.MotoDTO;
import Persistencia.vehiculoDTO.VehiculoDTO;
import choferes.Chofer;
import choferes.ChoferContratado;
import choferes.ChoferPermanente;
import choferes.ChoferTemporario;
import excepciones.chofer.ExceptionDNIrepetido;
import excepciones.vehiculo.ExceptionPatenteRepetida;
import sistema.AdmSubSistema;
import usuarios.Administrador;
import usuarios.Cliente;
import usuarios.Usuario;
import vehiculos.Auto;
import vehiculos.Combi;
import vehiculos.Moto;
import vehiculos.Vehiculo;

/**
 * Clase de utilidad para la gestion de AdmSubSistema.
 * Proporciona metodos estaticos para la conversión entre objetos del modelo y DTOs (Data Transfer Objects)
 * relacionados con el AdmSubSistema.
 * Esta clase es serializable.
 */
public class UTILAdmSubSistema implements Serializable
{
	/**
     * Convierte un objeto de tipo AdmSubSistema en un objeto de tipo AdmSubSistemaDTO.
     * 
     * @param admSubSistema Objeto de tipo AdmSubSistema a convertir.
     * @return Objeto de tipo AdmSubSistemaDTO resultante de la conversion.
     */
	public static AdmSubSistemaDTO admSubSistemaDTOfromAdmSubSistema(AdmSubSistema admSubSistema)
    {
		AdmSubSistemaDTO admSubDTO = new AdmSubSistemaDTO();
		
		ArrayList<ChoferDTO> choferListaDTO = new ArrayList<ChoferDTO>();
		for (int i = 0; i < admSubSistema.getChoferLista().size(); i++)
			choferListaDTO.add(UTILAdmSubSistema.ChoferDTOFromChofer(admSubSistema.getChoferLista().get(i)));
		admSubDTO.setChoferListaDTO(choferListaDTO);
		
		ArrayList<VehiculoDTO> vehiculoListaDTO = new ArrayList<VehiculoDTO>();
		for (int i = 0; i < admSubSistema.getVehiculoLista().size(); i++)
			vehiculoListaDTO.add(UTILAdmSubSistema.vehiculoDTOFromVehiculo(admSubSistema.getVehiculoLista().get(i)));
		admSubDTO.setVehiculoListaDTO(vehiculoListaDTO);
		
		HashMap<String, UsuarioDTO> usuarioMapDTO = new HashMap<String, UsuarioDTO>();
		for (Usuario usuario : admSubSistema.getUsuarioMap().values()) {
		    usuarioMapDTO.put(usuario.getNombreUsuario(), UTILAdmSubSistema.clienteDTOFromCliente((Cliente) usuario));
		}
		admSubDTO.setUsuarioMapDTO(usuarioMapDTO);

		return admSubDTO;
    }
	
	/**
     * Convierte un objeto de tipo AdmSubSistemaDTO en un objeto de tipo AdmSubSistema.
     * 
     * @param admSubDTO Objeto de tipo AdmSubSistemaDTO a convertir.
     * @return Objeto de tipo AdmSubSistema resultante de la conversion.
     */
	public static AdmSubSistema admSubSistemaFromAdmSubSistemaDTO(AdmSubSistemaDTO admSubDTO)
	{
	    AdmSubSistema admSubSistema = new AdmSubSistema();
	    
	    for (ChoferDTO choferDTO : admSubDTO.getChoferListaDTO())
	    {
	        try {
	            admSubSistema.addChofer(choferFromChoferDTO(choferDTO));
	        } 
	        catch (ExceptionDNIrepetido e) {
	            System.err.println("Error: " + e.getMessage());
	        }
	    }
	    
	    for (VehiculoDTO vehiculoDTO : admSubDTO.getVehiculoListaDTO())
	    {
	        try {
	            admSubSistema.addVehiculo(vehiculoFromVehiculoDTO(vehiculoDTO));
	        } 
	        catch (ExceptionPatenteRepetida e) {
	            System.err.println("Error: " + e.getMessage());
	        }
	    }
	    
	    for (UsuarioDTO usuarioDTO : admSubDTO.getUsuarioMapDTO().values()) {
	        admSubSistema.getUsuarioMap().put(usuarioDTO.getNombreUsuario() ,clienteFromClienteDTO((ClienteDTO) usuarioDTO));
	    }
	    
	    return admSubSistema;
	}

	// ---------------------------------------- Choferes ---------------------------------------- //
	
	/**
     * Convierte un objeto de tipo AdmSubSistema en un objeto de tipo AdmSubSistemaDTO.
     * 
     * @param chofer Objeto de tipo Chofer a convertir.
     * @return Objeto de tipo ChoferDTO resultante de la conversion.
     */
	public static ChoferDTO ChoferDTOFromChofer(Chofer chofer) {
		if (chofer instanceof ChoferTemporario) {
			return ChoferTemporarioDTOFromChoferTemporario((ChoferTemporario) chofer);
		} else if (chofer instanceof ChoferPermanente) {
			return ChoferPermanenteDTOFromChoferPermanente((ChoferPermanente) chofer);
		} else if (chofer instanceof ChoferContratado) {
			return ChoferContratadoDTOFromChoferContratado((ChoferContratado) chofer);
		}
		//Vemos si lanzamos excepcion
		return null;
	}

	/**
     * Convierte un objeto de tipo ChoferTemporario en un objeto de tipo ChoferTemporarioDTO.
     * 
     * @param chofer Objeto de tipo ChoferTemporario a convertir.
     * @return Objeto de tipo ChoferTemporarioDTO resultante de la conversion.
     */
	public static ChoferTemporarioDTO ChoferTemporarioDTOFromChoferTemporario(ChoferTemporario chofer) {
		ChoferTemporarioDTO choferDTO = new ChoferTemporarioDTO();
		choferDTO.setDni(chofer.getDni());
		choferDTO.setNombre(chofer.getNombre());
		choferDTO.setOcupado(chofer.isOcupado());
		choferDTO.setPuntos(chofer.getPuntos());
		return choferDTO;
	}
	
	/**
     * Convierte un objeto de tipo ChoferPermanente en un objeto de tipo ChoferPermanenteDTO.
     * 
     * @param chofer Objeto de tipo ChoferPermanente a convertir.
     * @return Objeto de tipo ChoferPermanenteDTO resultante de la conversion.
     */
	public static ChoferPermanenteDTO ChoferPermanenteDTOFromChoferPermanente(ChoferPermanente chofer) {
		ChoferPermanenteDTO choferDTO = new ChoferPermanenteDTO();
		choferDTO.setDni(chofer.getDni());
		choferDTO.setNombre(chofer.getNombre());
		choferDTO.setOcupado(chofer.isOcupado());
		choferDTO.setPuntos(chofer.getPuntos());
		choferDTO.setCantidadHijos(chofer.getCantidadHijos());
		choferDTO.setFechaIngresoDTO(
				UTILViajesSubSistema.localDateTimeDTOFromLocalDateTime(chofer.getFechaIngreso())
		);
		return choferDTO;
	}
	
	/**
     * Convierte un objeto de tipo ChoferContratado en un objeto de tipo ChoferContratadoDTO.
     * 
     * @param chofer Objeto de tipo ChoferContratado a convertir.
     * @return Objeto de tipo ChoferContratadoDTO resultante de la conversion.
     */
	public static ChoferContratadoDTO ChoferContratadoDTOFromChoferContratado(ChoferContratado chofer) {
		ChoferContratadoDTO choferDTO = new ChoferContratadoDTO();
		choferDTO.setDni(chofer.getDni());
		choferDTO.setNombre(chofer.getNombre());
		choferDTO.setOcupado(chofer.isOcupado());
		choferDTO.setPuntos(chofer.getPuntos());
		return choferDTO;
	}
	
	/**
     * Convierte un objeto de tipo ChoferDTO en un objeto de tipo Chofer.
     * 
     * @param choferDTO Objeto de tipo ChoferDTO a convertir.
     * @return Objeto de tipo Chofer resultante de la conversion.
     */
	public static Chofer choferFromChoferDTO(ChoferDTO choferDTO) {
		if (choferDTO instanceof ChoferTemporarioDTO) {
			return choferTemporarioFromChoferTemporarioDTO((ChoferTemporarioDTO) choferDTO);
		} else if (choferDTO instanceof ChoferPermanenteDTO) {
			return choferPermanenteFromChoferPermanenteDTO((ChoferPermanenteDTO) choferDTO);
		} else if (choferDTO instanceof ChoferContratadoDTO) {
			return choferContratadoFromChoferContratadoDTO((ChoferContratadoDTO) choferDTO);
		}
		
		return null;
	}
	
	/**
     * Convierte un objeto de tipo ChoferTemporarioDTO en un objeto de tipo ChoferTemporario.
     * 
     * @param chofer Objeto de tipo ChoferTemporarioDTO a convertir.
     * @return Objeto de tipo ChoferTemporario resultante de la conversion.
     */
	public static ChoferTemporario choferTemporarioFromChoferTemporarioDTO(ChoferTemporarioDTO chofer) {
		return new ChoferTemporario(
				chofer.getDni(),
				chofer.getNombre()
		);
	}
	
	/**
     * Convierte un objeto de tipo ChoferPermanenteDTO en un objeto de tipo ChoferPermanente.
     * 
     * @param chofer Objeto de tipo ChoferPermanenteDTO a convertir.
     * @return Objeto de tipo ChoferPermanente resultante de la conversion.
     */
	public static ChoferPermanente choferPermanenteFromChoferPermanenteDTO(ChoferPermanenteDTO chofer) {
		return new ChoferPermanente(
				chofer.getDni(),
				chofer.getNombre(),
				chofer.getPuntos(),
				chofer.getOcupado(),
				chofer.getCantidadHijos(),
				UTILViajesSubSistema.localDateTimeFromLocalDateTimeDTO(chofer.getFechaIngresoDTO())
		);
	}
	
	/**
     * Convierte un objeto de tipo ChoferContratadoDTO en un objeto de tipo ChoferContratado.
     * 
     * @param chofer Objeto de tipo ChoferContratadoDTO a convertir.
     * @return Objeto de tipo ChoferContratado resultante de la conversion.
     */
	public static ChoferContratado choferContratadoFromChoferContratadoDTO(ChoferContratadoDTO chofer) {
		return new ChoferContratado(
				chofer.getDni(),
				chofer.getNombre(),
				chofer.getPuntos(),
				chofer.getOcupado()
		);
	}

	//---------------------------------------- Vehiculos ---------------------------------------- //

	/**
     * Convierte un objeto de tipo Vehiculo en un objeto de tipo VehiculoDTO.
     * 
     * @param vehiculo Objeto de tipo Vehiculo a convertir.
     * @return Objeto de tipo VehiculoDTO resultante de la conversion.
     */
	public static VehiculoDTO vehiculoDTOFromVehiculo(Vehiculo vehiculo) {
		VehiculoDTO vehiculoDTO;
		if (vehiculo instanceof Auto) {
			vehiculoDTO = new AutoDTO();
		} else if (vehiculo instanceof Moto) {
			vehiculoDTO = new MotoDTO();
		} else {
			vehiculoDTO = new CombiDTO();
		}
		vehiculoDTO.setPatente(vehiculo.getPatente());
		vehiculoDTO.setCantMaxPas(vehiculo.getCantMaxPas());
		vehiculoDTO.setEquipaje(vehiculo.getEquipaje());
		vehiculoDTO.setMascota(vehiculo.getMascota());
		vehiculoDTO.setOcupado(vehiculo.isOcupado());
		return vehiculoDTO;
	}

	/**
     * Convierte un objeto de tipo VehiculoDTO en un objeto de tipo Vehiculo.
     * 
     * @param vehiculoDTO Objeto de tipo VehiculoDTO a convertir.
     * @return Objeto de tipo Vehiculo resultante de la conversion.
     */
	public static Vehiculo vehiculoFromVehiculoDTO(VehiculoDTO vehiculoDTO) {
		Vehiculo vehiculo;
	    if (vehiculoDTO instanceof AutoDTO) {
	        vehiculo = new Auto(vehiculoDTO.getPatente());
	    } else if (vehiculoDTO instanceof MotoDTO) {
			vehiculo = new Moto(vehiculoDTO.getPatente());
	    } else {
			vehiculo = new Combi(vehiculoDTO.getPatente());
	    }
		vehiculo.setCantMaxPas(vehiculoDTO.getCantMaxPas());
		vehiculo.setEquipaje(vehiculoDTO.getEquipaje());
		vehiculo.setMascota(vehiculoDTO.getMascota());
		vehiculo.setOcupado(vehiculoDTO.isOcupado());
	    return vehiculo;
	}
	
	//---------------------------------------- Usuarios ---------------------------------------- //
	
	/**
     * Convierte un objeto de tipo Usuario en un objeto de tipo UsuarioDTO.
     * 
     * @param usuario Objeto de tipo Usuario a convertir.
     * @return Objeto de tipo UsuarioDTO resultante de la conversion.
     */
	public static UsuarioDTO usuarioDTOFromUsuario(Usuario usuario) {
		if (usuario instanceof Cliente) {
			return clienteDTOFromCliente( (Cliente) usuario);
		} else if (usuario instanceof Administrador) {
			return administradorDTOFromAdministrador( (Administrador) usuario);
		} 
		return null;
	}
	
	/**
     * Convierte un objeto de tipo UsuarioDTO en un objeto de tipo Usuario.
     * 
     * @param usuarioDTO Objeto de tipo UsuarioDTO a convertir.
     * @return Objeto de tipo Usuario resultante de la conversion.
     */
	public static Usuario usuarioFromUsuarioDTO(UsuarioDTO usuarioDTO) {
		if (usuarioDTO instanceof ClienteDTO) {
			return clienteFromClienteDTO( (ClienteDTO) usuarioDTO);
		} else if (usuarioDTO instanceof AdministradorDTO) {
			return administradorFromAdministradorDTO( (AdministradorDTO) usuarioDTO);
		}
		return null;
	}
	
	/**
     * Convierte un objeto de tipo Cliente en un objeto de tipo ClienteDTO.
     * 
     * @param cliente Objeto de tipo Cliente a convertir.
     * @return Objeto de tipo ClienteDTO resultante de la conversion.
     */
	public static ClienteDTO clienteDTOFromCliente(Cliente cliente) {
		ClienteDTO clienteDTO = new ClienteDTO();
		clienteDTO.setNombreReal(cliente.getNombreReal());
		clienteDTO.setNombreUsuario(cliente.getNombreUsuario());
		clienteDTO.setContrasena(cliente.getContrasena());
		clienteDTO.setPuntos(cliente.getPuntos());
        clienteDTO.setUsandoApp(cliente.isUsandoApp());
		return clienteDTO;
	}

	/**
     * Convierte un objeto de tipo ClienteDTO en un objeto de tipo Cliente.
     * 
     * @param clienteDTO Objeto de tipo ClienteDTO a convertir.
     * @return Objeto de tipo Cliente resultante de la conversion.
     */
	public static Cliente clienteFromClienteDTO(ClienteDTO clienteDTO) {
		Cliente cliente = new Cliente(clienteDTO.getNombreUsuario(), clienteDTO.getNombreReal(), clienteDTO.getContrasena());
		cliente.addPuntos(clienteDTO.getPuntos());
                cliente.setUsandoApp(clienteDTO.isUsandoApp());
	    return cliente;
	}
	
	/**
     * Convierte un objeto de tipo Administrador en un objeto de tipo AdministradorDTO.
     * 
     * @param administrador Objeto de tipo Administrador a convertir.
     * @return Objeto de tipo AdministradorDTO resultante de la conversion.
     */
	public static AdministradorDTO administradorDTOFromAdministrador(Administrador administrador) {
		AdministradorDTO administradorDTO = new AdministradorDTO();
		administradorDTO.setNombreReal(administrador.getNombreReal());
		administradorDTO.setNombreUsuario(administrador.getNombreUsuario());
		administradorDTO.setContrasena(administrador.getContrasena());
		return administradorDTO;
	}

	/**
     * Convierte un objeto de tipo AdministradorDTO en un objeto de tipo Administrador.
     * 
     * @param administradorDTO Objeto de tipo AdministradorDTO a convertir.
     * @return Objeto de tipo Administrador resultante de la conversion.
     */
	public static Administrador administradorFromAdministradorDTO(AdministradorDTO administradorDTO) {
		return new Administrador(administradorDTO.getNombreUsuario(), administradorDTO.getNombreReal(), administradorDTO.getContrasena());
	}

}

