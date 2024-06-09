package viajes;

/**
 * La clase decoradora que agrega un incremento al costo del viaje por solicitar la opcion de baul.
 */
public class Equipaje extends ViajeDecorator {

    /**
     * Constructor para la clase Equipaje.<br>
     * <b>PRE: </b>El viaje no puede ser nulo. <br>
     * @param viaje El viaje que utiliza el baul.
     */
    public Equipaje(IViaje viaje) {
    	assert viaje != null: "Fallo pre: viaje no puede ser nulo.";
    	
        super.setEncapsulado(viaje);
    }

    /**
     * Calcula el costo del viaje con el incremento por el uso del baul.<br>
     * @return El costo total del viaje con el incremento por el uso del baul.
     */
    @Override
    public double getCosto() {
        return ViajeAbstracto.getCostoBase() * (1 + this.getIncrKm() + this.getIncrPax());
    }
    
    /**
     * Obtiene el incremento por pasajero asociado al equipaje.<br>
     * @return El incremento por pasajero.
     */
    @Override
    public double getIncrPax() {
        return this.getEncapsulado().getIncrPax() + 0.1 * this.getEncapsulado().getCantPax();
    }
    
    /**
     * Obtiene el incremento por kilometro asociado al equipaje.<br>
     * @return El incremento por kilometro.
     */
    @Override
    public double getIncrKm() {
        return this.getEncapsulado().getIncrKm() + 0.05 * this.getEncapsulado().getDistancia();
    }
}

