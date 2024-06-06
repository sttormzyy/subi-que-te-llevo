package Persistencia;

public class VehiculoDTO
{
	protected String patente;
	protected int cantMaxPas;
	protected boolean ocupado=false;
	protected int mascota;
	protected int equipaje;
	
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
