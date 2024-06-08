package Persistencia.vehiculoDTO;

import java.io.Serializable;

public class VehiculoDTO  implements Serializable
{
	protected String patente;
	protected int cantMaxPas;
	protected boolean ocupado = false;
	protected int mascota;
	protected int equipaje;
	
	public VehiculoDTO() {
    }

    public VehiculoDTO(String patente, int cantMaxPas, int mascota, int equipaje) {
        this.patente = patente;
        this.cantMaxPas = cantMaxPas;
        this.mascota = mascota;
        this.equipaje = equipaje;
    }
	
	public String getPatente() {
		return patente;
	}
	public void setPatente(String patente) {
		this.patente = patente;
	}
	public int getCantMaxPas() {
		return cantMaxPas;
	}
	public void setCantMaxPas(int cantMaxPas) {
		this.cantMaxPas = cantMaxPas;
	}
	public boolean isOcupado() {
		return ocupado;
	}
	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}
	public int getMascota() {
		return mascota;
	}
	public void setMascota(int mascota) {
		this.mascota = mascota;
	}
	public int getEquipaje() {
		return equipaje;
	}
	public void setEquipaje(int equipaje) {
		this.equipaje = equipaje;
	}
}
