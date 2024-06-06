package viajes;

/**
 * La clase decoradora que agrega un incremento al costo del Viaje por solicitar la opcion Pet Friendly.
 */
public class Mascota extends ViajeDecorator {

    /**
     * Constructor para la clase Mascota (Pet Friendly).<br>
	 * <b>PRE:</b> El viaje no puede ser nulo.
     * @param viaje El viaje al que se agrega la mascota.
     */
    public Mascota(IViaje viaje) {
    	assert viaje != null : "Fallo pre: El viaje no puede ser nulo";
    	
        super.setEncapsulado(viaje);
    }

    /**
     * Calcula el costo del Viaje con el incremento por opcion Pet Friendly.<br>
     * @return El costo total del Viaje con el incremento por opcion Pet Friendly.
     */
    @Override
    public double getCosto() {
        return ViajeAbstracto.getCostoBase() * (1 + this.getIncrKm() + this.getIncrPax());
    }
    
    /**
     * Obtiene el incremento por pasajero asociado a la opcion Pet Friendly.<br>
     * @return El incremento por pasajero.
     */
    public double getIncrPax() {
        return this.getEncapsulado().getIncrPax() + 0.1 * this.getEncapsulado().getCantPax();
    }
    
    /**
     * Obtiene el incremento por kilometro asociado a la opcion Pet Friendly.<br>
     * @return El incremento por kilometro.
     */
    public double getIncrKm() {
        return this.getEncapsulado().getIncrKm() + 0.2 * this.getEncapsulado().getDistancia();
    }
}

