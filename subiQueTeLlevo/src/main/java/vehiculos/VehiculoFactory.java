package vehiculos;

/**
 * La Clase encargada de crear instancias de vehiculos.
 */
public  class VehiculoFactory {
	
	/**
     * Genera una instancia de vehiculo segun el tipo especificado.<br>
     * <b>PRE: </b> Patente y tipo distinto de null y vacio<br> 
     * @param tipo    El tipo de vehiculo (AUTO, MOTO, COMBI).
     * @param patente La patente del vehiculo.
     * @return Una instancia del tipo de vehiculo especificado, o null si el tipo no es valido.
     */
	public Vehiculo getVehiculo(String tipo, String patente)
	{
		tipo = tipo.toUpperCase();
		
		switch(tipo)
		{
		case "AUTO":
			return new Auto(patente);
		case "MOTO":
			return new Moto(patente);
		case "COMBI":
			return new Combi(patente);
		default:
	    	return null;
		}
	}
}
