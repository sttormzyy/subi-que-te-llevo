package Persistencia.sistemaDTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import Persistencia.choferDTO.ChoferDTO;
import Persistencia.usuarioDTO.UsuarioDTO;
import Persistencia.vehiculoDTO.VehiculoDTO;

/**
 * La clase AdmSubSistemaDTO es una clase que representa la administracion de un sub-sistema del sistema.
 * Contiene listas de usuarios, choferes y vehiculos.
 */
public class AdmSubSistemaDTO implements Serializable {
    
    private HashMap<String, UsuarioDTO> usuarioMapDTO;    // El mapa de usuarios del sub-sistema
    private ArrayList<ChoferDTO> choferListaDTO;          // La lista de choferes del sub-sistema
    private ArrayList<VehiculoDTO> vehiculoListaDTO;      // La lista de vehiculos del sub-sistema

    /**
     * Constructor por defecto de la clase AdmSubSistemaDTO.
     */
    public AdmSubSistemaDTO() {
    }

    /**
     * Constructor de la clase AdmSubSistemaDTO que inicializa el mapa de usuarios, la lista de choferes
     * y la lista de vehiculos del sub-sistema.
     * 
     * @param usuarioMap El mapa de usuarios del sub-sistema.
     * @param choferLista La lista de choferes del sub-sistema.
     * @param vehiculoLista La lista de vehiculos del sub-sistema.
     */
    public AdmSubSistemaDTO(HashMap<String, UsuarioDTO> usuarioMap, ArrayList<ChoferDTO> choferLista, ArrayList<VehiculoDTO> vehiculoLista) {
        this.usuarioMapDTO = usuarioMap;
        this.choferListaDTO = choferLista;
        this.vehiculoListaDTO = vehiculoLista;
    }

    /**
     * Obtiene el mapa de usuarios del sub-sistema.
     * 
     * @return El mapa de usuarios del sub-sistema.
     */
    public HashMap<String, UsuarioDTO> getUsuarioMapDTO() {
        return usuarioMapDTO;
    }

    /**
     * Establece el mapa de usuarios del sub-sistema.
     * 
     * @param usuarioMapDTO El nuevo mapa de usuarios del sub-sistema.
     */
    public void setUsuarioMapDTO(HashMap<String, UsuarioDTO> usuarioMapDTO) {
        this.usuarioMapDTO = usuarioMapDTO;
    }

    /**
     * Obtiene la lista de choferes del sub-sistema.
     * 
     * @return La lista de choferes del sub-sistema.
     */
    public ArrayList<ChoferDTO> getChoferListaDTO() {
        return choferListaDTO;
    }

    /**
     * Establece la lista de choferes del sub-sistema.
     * 
     * @param choferListaDTO La nueva lista de choferes del sub-sistema.
     */
    public void setChoferListaDTO(ArrayList<ChoferDTO> choferListaDTO) {
        this.choferListaDTO = choferListaDTO;
    }

    /**
     * Obtiene la lista de vehiculos del sub-sistema.
     * 
     * @return La lista de vehiculos del sub-sistema.
     */
    public ArrayList<VehiculoDTO> getVehiculoListaDTO() {
        return vehiculoListaDTO;
    }

    /**
     * Establece la lista de vehiculos del sub-sistema.
     * 
     * @param vehiculoListaDTO La nueva lista de vehiculos del sub-sistema.
     */
    public void setVehiculoListaDTO(ArrayList<VehiculoDTO> vehiculoListaDTO) {
        this.vehiculoListaDTO = vehiculoListaDTO;
    }
}

