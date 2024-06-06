package Persistencia;

import java.time.LocalDateTime;

public class ChoferPermanenteDTO extends AsalariadoDTO
{
	private static double sueldoBasico=2000;
	private static double plusAntiguedad = 10;       
	private static double plusXHijos = 10;          
	private static double aportes = 10;              
	private int cantidadHijos;
	private LocalDateTimeDTO fechaIngresoDTO;
	
	public static double getSueldoBasico() {
		return sueldoBasico;
	}
	public static void setSueldoBasico(double sueldoBasico) {
		ChoferPermanenteDTO.sueldoBasico = sueldoBasico;
	}
	public static double getPlusAntiguedad() {
		return plusAntiguedad;
	}
	public static void setPlusAntiguedad(double plusAntiguedad) {
		ChoferPermanenteDTO.plusAntiguedad = plusAntiguedad;
	}
	public static double getPlusXHijos() {
		return plusXHijos;
	}
	public static void setPlusXHijos(double plusXHijos) {
		ChoferPermanenteDTO.plusXHijos = plusXHijos;
	}
	public static double getAportes() {
		return aportes;
	}
	public static void setAportes(double aportes) {
		ChoferPermanenteDTO.aportes = aportes;
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
