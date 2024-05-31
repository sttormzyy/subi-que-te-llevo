package Persistencia;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class DTO_AdmSubSistema implements Serializable
{
	private HashMap<String, DTO_Usuario> usuarioMapDTO = new HashMap<String, DTO_Usuario>();

	private ArrayList<DTO_Chofer> choferListaDTO = new ArrayList<DTO_Chofer>();

	private ArrayList<DTO_Vehiculo> vehiculoListaDTO = new ArrayList<DTO_Vehiculo>();

	public HashMap<String, DTO_Usuario> getUsuarioMapDTO() {
		return usuarioMapDTO;
	}

	public void setUsuarioMapDTO(HashMap<String, DTO_Usuario> usuarioMapDTO) {
		this.usuarioMapDTO = usuarioMapDTO;
	}

	public ArrayList<DTO_Chofer> getChoferListaDTO() {
		return choferListaDTO;
	}

	public void setChoferListaDTO(ArrayList<DTO_Chofer> choferListaDTO) {
		this.choferListaDTO = choferListaDTO;
	}

	public ArrayList<DTO_Vehiculo> getVehiculoListaDTO() {
		return vehiculoListaDTO;
	}

	public void setVehiculoListaDTO(ArrayList<DTO_Vehiculo> vehiculoListaDTO) {
		this.vehiculoListaDTO = vehiculoListaDTO;
	}
}
