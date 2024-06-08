package Persistencia.choferDTO;

import java.time.LocalDateTime;

import Persistencia.LocalDateTimeDTO;

public class ChoferPermanenteDTO extends ChoferDTO
{             
	private int cantidadHijos;
	private LocalDateTimeDTO fechaIngresoDTO;
	
	public ChoferPermanenteDTO() {
	}
	
	public ChoferPermanenteDTO(String dni, String nombre,int cantHijos, LocalDateTimeDTO fechaIngreso) {
		super(dni, nombre);
		this.cantidadHijos = cantHijos;
		this.fechaIngresoDTO = fechaIngreso;
	}

	public ChoferPermanenteDTO(String dni, String nombre, int puntos, Boolean ocupado, int cantidadHijos, LocalDateTimeDTO fechaIngreso) {
		super(dni, nombre, puntos, ocupado);
		this.cantidadHijos = cantidadHijos;
		this.fechaIngresoDTO = fechaIngreso;
	}
	
	public int getCantidadHijos() {
		return cantidadHijos;
	}
	public void setCantidadHijos(int cantidadHijos) {
		this.cantidadHijos = cantidadHijos;
	}
	public LocalDateTimeDTO getFechaIngresoDTO() {
		return fechaIngresoDTO;
	}
	public void setFechaIngresoDTO(LocalDateTimeDTO fechaIngresoDTO) {
		this.fechaIngresoDTO = fechaIngresoDTO;
	}

}
