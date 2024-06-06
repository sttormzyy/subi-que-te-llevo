package vehiculos;

import viajes.Pedido;

/**
 * La clase Moto representa un tipo de vehículo que se puede utilizar en los viajes. Extiende la clase Vehiculo.
 */
public class Moto extends Vehiculo {

    /**
     * Crea una nueva instancia de Moto con la patente especificada.<br>
     * <b>PRE: </b> Patente distinto de null y vacio<br>
     * @param patente La patente de la moto.
     */
    public Moto(String patente) {
        super(patente, 1, 0, 0);
    }

    /**
     * Calcula la prioridad de la moto para un pedido dado.
     * La moto siempre tiene la maxima prioridad.<br>
     * @param pedido El pedido para el que se calcula la prioridad.
     * @return La prioridad calculada.
     */
    public Integer calculoPrioridad(Pedido pedido) {
        return 1000;
    }

    /**
	 * Verifica si el vehiculo cumple el requerimiento de equipaje del pedido.<br>
	 * @param equipaje Valor 1 si tiene, cualquier otro numero si no tiene disponibilidad.
	 * @return true si el pedido no requiere transportar equipaje en baul, false de lo contrario.
	 */
	@Override
	protected boolean verificaEquipaje(int equipaje) {
		if(equipaje!=0)
			return false;
		else
			return true;
	}

	/**
	 * Verifica si el vehiculo cumple el requerimiento de mascota del pedido.<br>
	 * @param mascota Valor 1 si tiene, cualquier otro numero si no tiene disponibilidad
	 * @return true si el pedido no requiere traslado de mascota, false de lo contrario
	 */
	@Override
	protected boolean verificaMascota(int mascota) {
		if(mascota!=0)
			return false;
		else
			return true;
	}
}
