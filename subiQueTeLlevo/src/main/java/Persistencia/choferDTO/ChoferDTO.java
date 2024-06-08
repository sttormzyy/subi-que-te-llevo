package Persistencia.choferDTO;

import java.io.Serializable;

public class ChoferDTO implements Serializable
{
	protected String dni;
    protected String nombre;
    protected int puntos;
    protected Boolean ocupado = false;
    
    public ChoferDTO() {
	}
    
    public ChoferDTO(String dni, String nombre) {
		this.dni = dni;
		this.nombre = nombre;
	}
    
	public ChoferDTO(String dni, String nombre, int puntos, Boolean ocupado) {
		this.dni = dni;
		this.nombre = nombre;
		this.puntos = puntos;
		this.ocupado = ocupado;
	}
	
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getPuntos() {
		return puntos;
	}
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	public Boolean getOcupado() {
		return ocupado;
	}
	public void setOcupado(Boolean ocupado) {
		this.ocupado = ocupado;
	}
    
}
