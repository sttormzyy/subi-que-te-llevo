package Persistencia;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import choferes.ChoferPermanente;

public class DTO_ChoferPermanente extends DTO_Asalariado
{
	private static double sueldoBasico=2000;
	private static double plusAntiguedad = 10;       
	private static double plusXHijos = 10;          
	private static double aportes = 10;              
	private int cantidadHijos;
	private LocalDateTime fechaIngreso;
	
	public static double getSueldoBasico() {
		return sueldoBasico;
	}
	public static void setSueldoBasico(double sueldoBasico) {
		DTO_ChoferPermanente.sueldoBasico = sueldoBasico;
	}
	public static double getPlusAntiguedad() {
		return plusAntiguedad;
	}
	public static void setPlusAntiguedad(double plusAntiguedad) {
		DTO_ChoferPermanente.plusAntiguedad = plusAntiguedad;
	}
	public static double getPlusXHijos() {
		return plusXHijos;
	}
	public static void setPlusXHijos(double plusXHijos) {
		DTO_ChoferPermanente.plusXHijos = plusXHijos;
	}
	public static double getAportes() {
		return aportes;
	}
	public static void setAportes(double aportes) {
		DTO_ChoferPermanente.aportes = aportes;
	}
	public int getCantidadHijos() {
		return cantidadHijos;
	}
	public void setCantidadHijos(int cantidadHijos) {
		this.cantidadHijos = cantidadHijos;
	}
	public LocalDateTime getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(LocalDateTime fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

}
