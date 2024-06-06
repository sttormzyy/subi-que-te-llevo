package viajes;

/**
 * La clase concreta de Viaje que se extiende de ViajeAbstracto y representa un Viaje en una zona peligrosa.
 */
public class ZonaPeligrosa extends ViajeAbstracto {

    /**
     * Constructor de la clase ZonaPeligrosa.<br>
     * @param pedido El Pedido asociado al Viaje.
     * @param distancia La distancia del Viaje.
     */
    public ZonaPeligrosa(Pedido pedido, double distancia) {
        super(pedido, distancia);
    }

    /**
     * Calcula el incremento en el costo por kilometro para un Viaje en zona peligrosa.<br>
     * @return El incremento en el costo por kilometro.
     */
    @Override
    public double getIncrKm() {
        return 0.2 * this.getDistancia();
    }

    /**
     * Calcula el incremento en el costo por pasajero para un Viaje en zona peligrosa.<br>
     * @return El incremento en el costo por pasajero.
     */
    @Override
    public double getIncrPax() {
        return 0.1 * this.getCantPax();
    }
}

