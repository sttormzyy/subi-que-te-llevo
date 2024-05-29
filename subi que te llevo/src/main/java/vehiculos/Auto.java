package vehiculos;

import viajes.Pedido;

/**
 * La clase Auto representa un tipo de vehiculo que se puede utilizar en los viajes. Extiende la clase Vehiculo.
 */
public class Auto extends Vehiculo {

    /**
     * Crea una nueva instancia de Auto con la patente especificada.<br>
     * <b>PRE: </b>Patente distinto de null y vacio<br>
     * @param patente La patente del auto.
     */
    public Auto(String patente) {
        super(patente, 4, 1, 1);
    }

    /**
     * Calcula la prioridad del auto para un Pedido dado.
     * Si el Pedido tiene equipaje, se asigna una prioridad mayor.<br>
     * <b>PRE: </b> El pedido es distinto de null<br>
     * @param pedido El Pedido para el que se calcula la prioridad.
     * @return La prioridad calculada.
     */
    public Integer calculoPrioridad(Pedido pedido) {
        if (pedido.getEquipaje() != 0 ) {
            return 40 * pedido.getCantPax();
        } else {
            return 30 * pedido.getCantPax();
        }
    }

    /**
   	 * Verifica si el vehiculo cumple el requerimiento de equipaje del pedido.<br>
   	 * @param equipaje Valor 1 si tiene, cualquier otro numero si no tiene disponibilidad.
   	 * @return true porque se requiera o no equipaje en baul, el auto puede
   	 */
	@Override
	protected boolean verificaEquipaje(int equipaje) {
		return true;
	}

	/**
	 * Verifica si el vehiculo cumple el requerimiento de mascota del pedido.<br>
	 * @param mascota Valor 1 si tiene, cualquier otro numero si no tiene disponibilidad
	 * @return true porque se requiera o no traslado de mascota, el auto puede
	 */
	@Override
	protected boolean verificaMascota(int mascota) {
		return true;
	}
}

