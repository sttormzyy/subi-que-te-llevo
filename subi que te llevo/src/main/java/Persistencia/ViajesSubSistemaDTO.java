package Persistencia;

import java.io.Serializable;
import java.util.ArrayList;

public class ViajesSubSistemaDTO implements Serializable {
    private ArrayList<ViajeDTO> viajeLista = new ArrayList<ViajeDTO>();


    public ArrayList<ViajeDTO> getViajeLista() {
        return viajeLista;
    }

    public void setViajeLista(ArrayList<ViajeDTO> viajeLista) {
        this.viajeLista = viajeLista;
    }
}
