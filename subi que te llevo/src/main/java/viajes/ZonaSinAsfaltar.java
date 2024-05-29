package viajes;

/**
 * La clase concreta de Viaje que se extiende de ViajeAbstracto y representa un Viaje en una zona sin asfaltar. 
 */
public class ZonaSinAsfaltar extends ViajeAbstracto {

    /**
     * Constructor de la clase ZonaSinAsfaltar.<br>
     * @param pedido El pedido asociado al viaje.
     * @param distancia La distancia del viaje.
     */
    public ZonaSinAsfaltar(Pedido pedido, double distancia) {
        super(pedido, distancia);
    }

    /**
     * Calcula el incremento en el costo por kilometro para un viaje en zona sin asfaltar.<br>
     * @return El incremento en el costo por kilometro.
     */
    public double getIncrKm() {
        return 0.15 * this.getDistancia();
    }

    /**
     * Calcula el incremento en el costo por pasajero para un viaje en zona sin asfaltar.<br>
     * @return El incremento en el costo por pasajero.
     */
    public double getIncrPax() {
        return 0.2 * this.getCantPax();
    }
}

