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

public class UTILAdmSubSistema implements Serializable
{

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

	public static ChoferTemporarioDTO ChoferTemporarioDTOFromChoferTemporario(ChoferTemporario chofer) {
		ChoferTemporarioDTO choferDTO = new ChoferTemporarioDTO();
		choferDTO.setDni(chofer.getDni());
		choferDTO.setNombre(chofer.getNombre());
		choferDTO.setOcupado(chofer.isOcupado());
		choferDTO.setPuntos(chofer.getPuntos());
		return choferDTO;
	}
	
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
	
	public static ChoferContratadoDTO ChoferContratadoDTOFromChoferContratado(ChoferContratado chofer) {
		ChoferContratadoDTO choferDTO = new ChoferContratadoDTO();
		choferDTO.setDni(chofer.getDni());
		choferDTO.setNombre(chofer.getNombre());
		choferDTO.setOcupado(chofer.isOcupado());
		choferDTO.setPuntos(chofer.getPuntos());
		return choferDTO;
	}

	public static Chofer choferFromChoferDTO(ChoferDTO choferDTO) {
		if (choferDTO instanceof ChoferTemporarioDTO) {
			return choferTemporarioFromChoferTemporarioDTO((ChoferTemporarioDTO) choferDTO);
		} else if (choferDTO instanceof ChoferPermanenteDTO) {
			return choferPermanenteFromChoferPermanenteDTO((ChoferPermanenteDTO) choferDTO);
		} else if (choferDTO instanceof ChoferContratadoDTO) {
			return choferContratadoFromChoferContratadoDTO((ChoferContratadoDTO) choferDTO);
		}
		//Vemos si lanzamos excepcion
		return null;
	}
	
	public static ChoferTemporario choferTemporarioFromChoferTemporarioDTO(ChoferTemporarioDTO chofer) {
		return new ChoferTemporario(
				chofer.getDni(),
				chofer.getNombre()
		);
	}
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
	public static ChoferContratado choferContratadoFromChoferContratadoDTO(ChoferContratadoDTO chofer) {
		return new ChoferContratado(
				chofer.getDni(),
				chofer.getNombre(),
				chofer.getPuntos(),
				chofer.getOcupado()
		);
	}

	//---------------------------------------- Vehiculos ---------------------------------------- //

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
	
	public static UsuarioDTO usuarioDTOFromUsuario(Usuario usuario) {
		if (usuario instanceof Cliente) {
			return clienteDTOFromCliente( (Cliente) usuario);
		} else if (usuario instanceof Administrador) {
			return administradorDTOFromAdministrador( (Administrador) usuario);
		} 
		//Vemos si lanzamos excepcion
		return null;
	}
	public static Usuario usuarioFromUsuarioDTO(UsuarioDTO usuarioDTO) {
		if (usuarioDTO instanceof ClienteDTO) {
			return clienteFromClienteDTO( (ClienteDTO) usuarioDTO);
		} else if (usuarioDTO instanceof AdministradorDTO) {
			return administradorFromAdministradorDTO( (AdministradorDTO) usuarioDTO);
		}
		//Vemos si lanzamos excepcion
		return null;
	}
	
	public static ClienteDTO clienteDTOFromCliente(Cliente cliente) {
		ClienteDTO clienteDTO = new ClienteDTO();
		clienteDTO.setNombreReal(cliente.getNombreReal());
		clienteDTO.setNombreUsuario(cliente.getNombreUsuario());
		clienteDTO.setContrasena(cliente.getContrasena());
		clienteDTO.setPuntos(cliente.getPuntos());
                clienteDTO.setUsandoApp(cliente.isUsandoApp());
		return clienteDTO;
	}

	public static Cliente clienteFromClienteDTO(ClienteDTO clienteDTO) {
		Cliente cliente = new Cliente(clienteDTO.getNombreUsuario(), clienteDTO.getNombreReal(), clienteDTO.getContrasena());
		cliente.addPuntos(clienteDTO.getPuntos());
                cliente.setUsandoApp(clienteDTO.isUsandoApp());
	    return cliente;
	}
	
	public static AdministradorDTO administradorDTOFromAdministrador(Administrador administrador) {
		AdministradorDTO administradorDTO = new AdministradorDTO();
		administradorDTO.setNombreReal(administrador.getNombreReal());
		administradorDTO.setNombreUsuario(administrador.getNombreUsuario());
		administradorDTO.setContrasena(administrador.getContrasena());
		return administradorDTO;
	}

	public static Administrador administradorFromAdministradorDTO(AdministradorDTO administradorDTO) {
		return new Administrador(administradorDTO.getNombreUsuario(), administradorDTO.getNombreReal(), administradorDTO.getContrasena());
	}

}

