package vehiculos;

import viajes.Pedido;

/**
 * La clase Combi representa un tipo de vehículo que se puede utilizar en los viajes. Extiende la clase Vehiculo.
 */
public class Combi extends Vehiculo {

    /**
     * Crea una nueva instancia de Combi con la patente especificada.<br>
     * @param patente La patente de la combi.
     */
    public Combi(String patente) {
        super(patente, 10, 0, 1);
    }

    /**
     * Calcula la prioridad de la combi para un pedido dado.
     * Si el pedido tiene equipaje, se asigna una prioridad mayor.<br>
     * <b>PRE: </b> Pedido distinto de null<br>
     * @param pedido El pedido para el que se calcula la prioridad.
     * @return La prioridad calculada.
     */
    public Integer calculoPrioridad(Pedido pedido) {
        if (pedido.getEquipaje() != 0) {
            return 10 * pedido.getCantPax() + 100;
        } else {
            return 10 * pedido.getCantPax();
        }
    }

    /**
	 * Verifica si el vehiculo cumple el requerimiento de equipaje del pedido.<br>
	 * @param equipaje Valor 1 si tiene, cualquier otro numero si no tiene disponibilidad.
	 * @return true porque se requiera o no equipaje en baul, la combi puede
	 */
	@Override
	protected boolean verificaEquipaje(int equipaje) {
		return true;
	}

	/**
	 * Verifica si el vehiculo cumple el requerimiento de mascota del pedido.<br>
	 * @param mascota Valor 1 si tiene, cualquier otro numero si no tiene disponibilidad
	 * @return true si el pedido no requiere traslado de mascota, false caso contrario
	 */
	@Override
	protected boolean verificaMascota(int mascota) {
		if(mascota!=0)
			return false;
		else
			return true;
	}
}

