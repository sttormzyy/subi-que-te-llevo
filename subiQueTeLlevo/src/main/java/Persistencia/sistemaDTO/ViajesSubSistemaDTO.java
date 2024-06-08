package Persistencia.sistemaDTO;

import java.io.Serializable;
import java.util.ArrayList;

import Persistencia.viajeDTO.ViajeDTO;

public class ViajesSubSistemaDTO implements Serializable {
    private ArrayList<ViajeDTO> viajeListaDTO = new ArrayList<ViajeDTO>();
    
    public ViajesSubSistemaDTO() {
    }

    public ViajesSubSistemaDTO(ArrayList<ViajeDTO> viajeListaDTO) {
        this.viajeListaDTO = viajeListaDTO;
    }

    public ArrayList<ViajeDTO> getViajeListaDTO() {
        return viajeListaDTO;
    }

    public void setViajeListaDTO(ArrayList<ViajeDTO> viajeLista) {
        this.viajeListaDTO = viajeLista;
    }
     
}
