package viajes;

/**
 * La Clase encargada de crear instancias de IViaje basados en el tipo de pedido y la distancia.
 */
public class ViajeFactory {
    IViaje viaje = null;
	
	/**
	 * Devuelve un objeto de tipo IViaje segun el tipo de zona del pedido y otros atributos.<br>
	 * <b>PRE: </b> El Pedido es distinto de Null y distancia es mayor a 0.<br>
	 * @param pedido El Pedido para el cual se va a crear el Viaje.
	 * @param distancia La distancia del Viaje.
	 * @return Un objeto de tipo IViaje creado segun los parametros dados.
	 */
	public IViaje getViaje(Pedido pedido, double distancia) 
	{	
		assert pedido != null : "Fallo Pre: El Pedido no puede ser Null ";
		assert distancia > 0 : "Fallo Pre: la distancia debe ser mayor a 0";
		
		switch(pedido.getZona().toUpperCase()) {
			case "ESTANDAR": 
			    viaje = new ZonaEstandar(pedido,distancia);
			    break;
			case "SIN ASFALTAR": 
			    viaje = new ZonaSinAsfaltar(pedido,distancia);
			    break;
			case "PELIGROSA": 
			    viaje = new ZonaPeligrosa(pedido,distancia);

		}
		
		if(pedido.getMascota() == 1) {
			viaje= new Mascota(viaje);
		}
		
		if(pedido.getEquipaje() == 1) {
			viaje = new Equipaje(viaje);
		}
		
		return viaje;		
	}
}

