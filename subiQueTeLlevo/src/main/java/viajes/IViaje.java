package viajes;

import java.io.Serializable;
import java.time.LocalDateTime;

import choferes.Chofer;
import usuarios.Cliente;
import vehiculos.Vehiculo;

/**
 * Interfaz que define los metodos de los Viajes.
 */
public interface IViaje extends Comparable<IViaje>, Cloneable{

    /**
     * Vector de Estados que representa los posibles estados de un viaje.
     */
    static enum EstadosViajes {
        SOLICITADO, CONVEHICULO, INICIADO, PAGO, FINALIZADO
    };

    Pedido getPedido();
    /**
     * Obtiene el costo del Viaje.<br>
     * @return El costo del Viaje.
     */
    double getCosto();

    /**
     * Obtiene el cliente asociado al Viaje.<br>
     * @return El cliente del Viaje.
     */
    Cliente getCliente();

    /**
     * Obtiene el Chofer asignado al Viaje.<br>
     * @return El Chofer asignado al Viaje.
     */
    Chofer getChofer();

    /**
     * Establece el Chofer asignado al Viaje.<br>
     * @param chofer El Chofer asignado al Viaje.
     */
    void setChofer(Chofer chofer);

    /**
     * Obtiene el vehiculo asociado al Viaje.<br>
     * @return El vehiculo del Viaje.
     */
    Vehiculo getVehiculo();

    /**
     * Establece el vehiculo asociado al Viaje.<br>
     * @param vehiculo El vehiculo del Viaje.
     */
    void setVehiculo(Vehiculo vehiculo);

    /**
     * Obtiene la distancia del Viaje.<br>
     * @return La distancia del Viaje.
     */
    double getDistancia();

    /**
     * Obtiene la zona del Viaje.<br>
     * @return La zona del Viaje.
     */
    String getZona();

    /**
     * Obtiene la cantidad de pasajeros del Viaje.<br>
     * @return La cantidad de pasajeros del Viaje.
     */
    int getCantPax();

    /**
     * Consulta si transporta una mascota en el Viaje.<br>
     * @return La cantidad de mascotas del Viaje.
     */
    int getMascota();

    /**
     * Consulta si lleva equipaje en el Viaje.<br>
     * @return La cantidad de equipaje del Viaje.
     */
    int getEquipaje();

    /**
     * Obtiene la fecha del Viaje.<br>
     * @return La fecha del Viaje.
     */
    LocalDateTime getFecha();

    /**
     * Obtiene el incremento por kilometro del Viaje.<br>
     * @return El incremento por kilometro del Viaje.
     */
    double getIncrKm();

    /**
     * Obtiene el incremento por pasajero del Viaje.<br>
     * @return El incremento por pasajero del Viaje.
     */
    double getIncrPax();

    /**
     * Establece el estado del Viaje.<br>
     * @param e El estado del Viaje.
     */
    void setEstado(EstadosViajes e);

    /**
     * Obtiene el estado del Viaje.<br>
     * @return El estado del Viaje.
     */
    EstadosViajes getEstado();

    /**
     * Obtiene la calificacion del Chofer asociada al Viaje.<br>
     * @return La calificación del Chofer asociada al Viaje.
     */
    int getCalificacionChofer();

    /**
     * Establece la calificacion del Chofer asociada al Viaje.<br>
     * <b>PRE: la calificacion es mayor que 0</b><br>
     * @param calificacionChofer La calificación del Chofer asociada al Viaje.
     */
    void setCalificacionChofer(int calificacionChofer);

    /**
     * Obtiene una representacion en forma de cadena del Viaje listarlo<br>.
     * <b>PRE: el costo es mayor que 0</b><br>
     * @return Una cadena que representa el Viaje para listarlo.
     */
    String toStringListado();

    /**
     * Obtiene una representacion en forma de cadena del Viaje para el reporte del Chofer<br>
     * <b>PRE: el costo es mayor que 0</b><br>.
     * @return Una cadena que representa el Viaje para el reporte del Chofer.
     */
    String toStringReporteChofer();

    /**
     * Obtiene una representación en forma de cadena del Viaje para el reporte del cliente.
     * <b>PRE: el costo es mayor que 0</b><br>
     * @return Una cadena que representa el Viaje para el reporte del cliente.
     */
    String toStringReporteCliente();

    /**
     * Clona el objeto.
     * @return Una copia del objeto.
     */
    public Object clone();
}

