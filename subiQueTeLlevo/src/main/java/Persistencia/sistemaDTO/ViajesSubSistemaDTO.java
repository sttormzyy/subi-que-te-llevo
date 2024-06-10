package Persistencia.sistemaDTO;

import java.io.Serializable;
import java.util.ArrayList;

import Persistencia.viajeDTO.ViajeDTO;

/**
 * La clase ViajesSubSistemaDTO es una clase que representa el sub-sistema de viajes del sistema.
 * Contiene una lista de viajes.
 */
public class ViajesSubSistemaDTO implements Serializable {
    
    private ArrayList<ViajeDTO> viajeListaDTO = new ArrayList<ViajeDTO>(); // La lista de viajes del sub-sistema
    
    /**
     * Constructor por defecto de la clase ViajesSubSistemaDTO.
     */
    public ViajesSubSistemaDTO() {
    }

    /**
     * Constructor de la clase ViajesSubSistemaDTO que inicializa la lista de viajes del sub-sistema.
     * 
     * @param viajeListaDTO La lista de viajes del sub-sistema.
     */
    public ViajesSubSistemaDTO(ArrayList<ViajeDTO> viajeListaDTO) {
        this.viajeListaDTO = viajeListaDTO;
    }

    /**
     * Obtiene la lista de viajes del sub-sistema.
     * 
     * @return La lista de viajes del sub-sistema.
     */
    public ArrayList<ViajeDTO> getViajeListaDTO() {
        return viajeListaDTO;
    }

    /**
     * Establece la lista de viajes del sub-sistema.
     * 
     * @param viajeLista La nueva lista de viajes del sub-sistema.
     */
    public void setViajeListaDTO(ArrayList<ViajeDTO> viajeLista) {
        this.viajeListaDTO = viajeLista;
    }
}
