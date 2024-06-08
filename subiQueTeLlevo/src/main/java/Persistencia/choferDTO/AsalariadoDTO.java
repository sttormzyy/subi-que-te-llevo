package Persistencia.choferDTO;

public abstract class AsalariadoDTO extends ChoferDTO
{
    protected double aportes;
    
    public AsalariadoDTO() {
    }
    
    public AsalariadoDTO(String dni, String nombre) {
    	super(dni, nombre);
    }
    
	public AsalariadoDTO(String dni, String nombre, int puntos, Boolean ocupado) {
		super(dni, nombre, puntos, ocupado);
	}

	public double getAportes() {
		return aportes;
	}

	public void setAportes(double aportes) {
		this.aportes = aportes;
	}
 
}
