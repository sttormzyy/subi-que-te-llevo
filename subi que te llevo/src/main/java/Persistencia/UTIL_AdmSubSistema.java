package Persistencia;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import choferes.Chofer;
import choferes.ChoferContratado;
import choferes.ChoferPermanente;
import choferes.ChoferTemporario;
import excepciones.chofer.ExceptionDNIrepetido;
import excepciones.vehiculo.ExceptionPatenteRepetida;
import sistema.AdmSubSistema;
import usuarios.Cliente;
import usuarios.Usuario;
import vehiculos.Auto;
import vehiculos.Combi;
import vehiculos.Moto;
import vehiculos.Vehiculo;

public class UTIL_AdmSubSistema implements Serializable
{
	
	public static DTO_AdmSubSistema admSubSistemaDTOfromAdmSubSistema(AdmSubSistema admSubSistema)
    {
		DTO_AdmSubSistema admSubDTO = new DTO_AdmSubSistema();
		
		ArrayList<DTO_Chofer> choferListaDTO = new ArrayList<DTO_Chofer>();
		for (int i = 0; i < admSubSistema.getChoferLista().size(); i++)
			choferListaDTO.add(UTIL_AdmSubSistema.ChoferDTOFromChofer(admSubSistema.getChoferLista().get(i)));
		admSubDTO.setChoferListaDTO(choferListaDTO);
		
		ArrayList<DTO_Vehiculo> vehiculoListaDTO = new ArrayList<DTO_Vehiculo>();
		for (int i = 0; i < admSubSistema.getVehiculoLista().size(); i++)
			vehiculoListaDTO.add(UTIL_AdmSubSistema.vehiculoDTOFromVehiculo(admSubSistema.getVehiculoLista().get(i)));
		admSubDTO.setVehiculoListaDTO(vehiculoListaDTO);
		
		HashMap<String, DTO_Usuario> usuarioMapDTO = new HashMap<String, DTO_Usuario>();
		for (Usuario usuario : admSubSistema.getUsuarioMap().values()) {
		    usuarioMapDTO.put(usuario.getNombreUsuario(), UTIL_AdmSubSistema.clienteDTOFromCliente((Cliente) usuario));
		}
		admSubDTO.setUsuarioMapDTO(usuarioMapDTO);

		return admSubDTO;
    }
	
	public static AdmSubSistema admSubSistemaFromAdmSubSistemaDTO(DTO_AdmSubSistema admSubDTO) throws ExceptionDNIrepetido, ExceptionPatenteRepetida 
	{
	    AdmSubSistema admSubSistema = new AdmSubSistema();
	    
	    for (DTO_Chofer choferDTO : admSubDTO.getChoferListaDTO()) 
	    {
	        try {
	            admSubSistema.addChofer(choferFromChoferDTO(choferDTO));
	        } 
	        catch (ExceptionDNIrepetido e) {
	            System.err.println("Error: " + e.getMessage());
	        }
	    }
	    
	    for (DTO_Vehiculo vehiculoDTO : admSubDTO.getVehiculoListaDTO()) 
	    {
	        try {
	            admSubSistema.addVehiculo(vehiculoFromVehiculoDTO(vehiculoDTO));
	        } 
	        catch (ExceptionPatenteRepetida e) {
	            System.err.println("Error: " + e.getMessage());
	        }
	    }
	    
	    for (DTO_Usuario usuarioDTO : admSubDTO.getUsuarioMapDTO().values()) {
	        admSubSistema.getUsuarioMap().put(usuarioDTO.getNombreUsuario() ,clienteFromClienteDTO((DTO_Cliente) usuarioDTO)); 
	    }
	    
	    return admSubSistema;
	}

	// ---------------------------------------- Choferes ---------------------------------------- //

	public static DTO_Chofer ChoferDTOFromChofer(Chofer chofer) {
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

	public static DTO_ChoferTemporario ChoferTemporarioDTOFromChoferTemporario(ChoferTemporario chofer) {
		DTO_ChoferTemporario choferDTO = new DTO_ChoferTemporario();
		choferDTO.setDni(chofer.getDni());
		choferDTO.setNombre(chofer.getNombre());
		choferDTO.setOcupado(chofer.isOcupado());
		choferDTO.setPuntos(chofer.getPuntos());
		return choferDTO;
	}
	public static DTO_ChoferPermanente ChoferPermanenteDTOFromChoferPermanente(ChoferPermanente chofer) {
		DTO_ChoferPermanente choferDTO = new DTO_ChoferPermanente();
		choferDTO.setDni(chofer.getDni());
		choferDTO.setNombre(chofer.getNombre());
		choferDTO.setOcupado(chofer.isOcupado());
		choferDTO.setPuntos(chofer.getPuntos());
		choferDTO.setCantidadHijos(chofer.getCantidadHijos());
		choferDTO.setFechaIngreso(chofer.getFechaIngreso());
		return choferDTO;
	}
	public static DTO_ChoferContratado ChoferContratadoDTOFromChoferContratado(ChoferContratado chofer) {
		DTO_ChoferContratado choferDTO = new DTO_ChoferContratado();
		choferDTO.setDni(chofer.getDni());
		choferDTO.setNombre(chofer.getNombre());
		choferDTO.setOcupado(chofer.isOcupado());
		choferDTO.setPuntos(chofer.getPuntos());
		return choferDTO;
	}

	public static Chofer choferFromChoferDTO(DTO_Chofer choferDTO) {
		if (choferDTO instanceof DTO_ChoferTemporario) {
			return choferTemporarioFromChoferTemporarioDTO((DTO_ChoferTemporario) choferDTO);
		} else if (choferDTO instanceof DTO_ChoferPermanente) {
			return choferPermanenteFromChoferPermanenteDTO((DTO_ChoferPermanente) choferDTO);
		} else if (choferDTO instanceof DTO_ChoferContratado) {
			return choferContratadoFromChoferContratadoDTO((DTO_ChoferContratado) choferDTO);
		}
		//Vemos si lanzamos excepcion
		return null;
	}

	public static ChoferTemporario choferTemporarioFromChoferTemporarioDTO(DTO_ChoferTemporario chofer) {
		return new ChoferTemporario(chofer.getDni(), chofer.getNombre());
	}
	public static ChoferPermanente choferPermanenteFromChoferPermanenteDTO(DTO_ChoferPermanente chofer) {
		return new ChoferPermanente(chofer.getDni(), chofer.getNombre(), chofer.getPuntos(), chofer.getOcupado(), chofer.getCantidadHijos(), chofer.getFechaIngreso());
	}
	public static ChoferContratado choferContratadoFromChoferContratadoDTO(DTO_ChoferContratado chofer) {
		return new ChoferContratado(chofer.getDni(), chofer.getNombre(), chofer.getPuntos(), chofer.getOcupado());
	}

	//---------------------------------------- Vehiculos ---------------------------------------- //

	public static DTO_Vehiculo vehiculoDTOFromVehiculo(Vehiculo vehiculo) {
		if (vehiculo instanceof Auto) {
			return autoDTOFromAuto((Auto) vehiculo);
		} else if (vehiculo instanceof Moto) {
			return motoDTOFromMoto((Moto) vehiculo);
		} else if (vehiculo instanceof Combi) {
			return combiDTOFromCombi((Combi) vehiculo);
		}
		//Vemos si lanzamos excepcion
		return null; 
	}

	public static DTO_Auto autoDTOFromAuto(Auto auto) {
		DTO_Auto autoDTO = new DTO_Auto();
		autoDTO.setPatente(auto.getPatente());
		autoDTO.setCantMaxPas(auto.getCantMaxPas());
		autoDTO.setEquipaje(auto.getEquipaje());
		autoDTO.setMascota(auto.getMascota());
		autoDTO.setOcupado(auto.isOcupado());
		//CRI CRI no tiene nada especifico
		return autoDTO;
	}
	public static DTO_Moto motoDTOFromMoto(Moto moto) {
		DTO_Moto motoDTO = new DTO_Moto();
		motoDTO.setPatente(moto.getPatente());
		motoDTO.setCantMaxPas(moto.getCantMaxPas());
		motoDTO.setEquipaje(moto.getEquipaje());
		motoDTO.setMascota(moto.getMascota());
		motoDTO.setOcupado(moto.isOcupado());
		//CRI CRI no tiene nada especifico
		return motoDTO;
	}
	public static DTO_Combi combiDTOFromCombi(Combi combi) {
		DTO_Combi combiDTO = new DTO_Combi();
		combiDTO.setPatente(combi.getPatente());
		combiDTO.setCantMaxPas(combi.getCantMaxPas());
		combiDTO.setEquipaje(combi.getEquipaje());
		combiDTO.setMascota(combi.getMascota());
		combiDTO.setOcupado(combi.isOcupado());
		//CRI CRI no tiene nada especifico
		return combiDTO;
	}

	public static Vehiculo vehiculoFromVehiculoDTO(DTO_Vehiculo vehiculoDTO) {
	    if (vehiculoDTO instanceof DTO_Auto) {
	        return autoFromAutoDTO((DTO_Auto) vehiculoDTO);
	    } else if (vehiculoDTO instanceof DTO_Moto) {
	        return motoFromMotoDTO((DTO_Moto) vehiculoDTO);
	    } else if (vehiculoDTO instanceof DTO_Combi) {
	        return combiFromCombiDTO((DTO_Combi) vehiculoDTO);
	    }
	    //Vemos si lanzamos excepcion
	    return null; 
	}

	public static Auto autoFromAutoDTO(DTO_Auto autoDTO) {
	    Auto auto = new Auto(autoDTO.getPatente());
	    auto.setCantMaxPas(autoDTO.getCantMaxPas());
	    auto.setEquipaje(autoDTO.getEquipaje());
	    auto.setMascota(autoDTO.getMascota());
	    auto.setOcupado(autoDTO.isOcupado());
	    return auto;
	}
	public static Moto motoFromMotoDTO(DTO_Moto motoDTO) {
	    Moto moto = new Moto(motoDTO.getPatente());
	    moto.setCantMaxPas(motoDTO.getCantMaxPas());
	    moto.setEquipaje(motoDTO.getEquipaje());
	    moto.setMascota(motoDTO.getMascota());
	    moto.setOcupado(motoDTO.isOcupado());
	    return moto;
	}
	public static Combi combiFromCombiDTO(DTO_Combi combiDTO) {
	    Combi combi = new Combi(combiDTO.getPatente());
	    combi.setCantMaxPas(combiDTO.getCantMaxPas());
	    combi.setEquipaje(combiDTO.getEquipaje());
	    combi.setMascota(combiDTO.getMascota());
	    combi.setOcupado(combiDTO.isOcupado());
	    return combi;
	}
	
	//---------------------------------------- Usuarios ---------------------------------------- //
	
	public static DTO_Cliente clienteDTOFromCliente(Cliente cliente) {
		DTO_Cliente clienteDTO = new DTO_Cliente();
		clienteDTO.setNombreReal(cliente.getNombreReal());
		clienteDTO.setNombreUsuario(cliente.getNombreUsuario());
		clienteDTO.setContrasena(cliente.getContrasena());
		clienteDTO.setPuntos(cliente.getPuntos());
		return clienteDTO;
	}

	public static Cliente clienteFromClienteDTO(DTO_Cliente clienteDTO) {
		Cliente cliente = new Cliente(clienteDTO.getNombreUsuario(), clienteDTO.getNombreReal(), clienteDTO.getContrasena());
		cliente.addPuntos(clienteDTO.getPuntos());
	    return cliente;
	}
	
}

