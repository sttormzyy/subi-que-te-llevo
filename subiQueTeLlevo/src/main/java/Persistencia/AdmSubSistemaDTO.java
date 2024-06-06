package Persistencia;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class AdmSubSistemaDTO implements Serializable
{
	private HashMap<String, UsuarioDTO> usuarioMapDTO = new HashMap<String, UsuarioDTO>();

	private ArrayList<ChoferDTO> choferListaDTO = new ArrayList<ChoferDTO>();

	private ArrayList<VehiculoDTO> vehiculoListaDTO = new ArrayList<VehiculoDTO>();

	public HashMap<String, UsuarioDTO> getUsuarioMapDTO() {
		return usuarioMapDTO;
	}

	public void setUsuarioMapDTO(HashMap<String, UsuarioDTO> usuarioMapDTO) {
		this.usuarioMapDTO = usuarioMapDTO;
	}

	public ArrayList<ChoferDTO> getChoferListaDTO() {
		return choferListaDTO;
	}

	public void setChoferListaDTO(ArrayList<ChoferDTO> choferListaDTO) {
		this.choferListaDTO = choferListaDTO;
	}

	public ArrayList<VehiculoDTO> getVehiculoListaDTO() {
		return vehiculoListaDTO;
	}

	public void setVehiculoListaDTO(ArrayList<VehiculoDTO> vehiculoListaDTO) {
		this.vehiculoListaDTO = vehiculoListaDTO;
	}
}
