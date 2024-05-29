package viajes;

/**
 * La clase concreta de Viaje que se extiende de ViajeAbstracto y representa un Viaje en una zona estandar.
 */
public class ZonaEstandar extends ViajeAbstracto {

    /**
     * Constructor de la clase ZonaEstandar.<br>
     * @param pedido El pedido asociado al Viaje.
     * @param distancia La distancia del Viaje.
     */
    public ZonaEstandar(Pedido pedido, double distancia) {
        super(pedido, distancia);
    }

    /**
     * Calcula el incremento en el costo por kilometro para un Viaje en zona estandar.<br>
     * @return El incremento en el costo por kilometro.
     */
    public double getIncrKm() {
        return 0.1 * this.getDistancia();
    }

    /**
     * Calcula el incremento en el costo por pasajero para un viaje en zona estandar.<br>
     * @return El incremento en el costo por pasajero.
     */
    public double getIncrPax() {
        return 0.1 * this.getCantPax();
    }
}
