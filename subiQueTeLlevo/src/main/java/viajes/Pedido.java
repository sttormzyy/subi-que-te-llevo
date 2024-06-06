package viajes;

import java.time.LocalDateTime;
import usuarios.Cliente;

/**
 * Representa un Pedido de Viaje realizado por un cliente en una determinada fecha y zona.
 */
public class Pedido implements Cloneable {
    private LocalDateTime fecha;
    private Cliente cliente;
    private String zona;
    private int mascota;
    private int equipaje;
    private int cantPax;

    /**
     * Constructor de la clase Pedido.<br>
     * <b>PRE: </b> cliente != null, fecha != null, zona != null, zona != "", cantPax > 0
     * @param cliente El cliente que realiza el Pedido.
     * @param fecha La fecha en la que se realiza el Pedido.
     * @param zona La zona del Pedido.
     * @param mascota La indicación de si el pedido incluye mascota.
     * @param equipaje La indicación de si el pedido incluye equipaje.
     * @param cantPax La cantidad de pasajeros en el Pedido.
     */
    public Pedido(Cliente cliente, LocalDateTime fecha, String zona, int mascota, int equipaje, int cantPax) {
        super();
        assert cliente != null : "Fallo pre: El cliente no puede ser nulo";
        assert fecha != null : "Fallo pre: La fecha no puede ser nula";
        assert zona != null && !zona.isEmpty() : "Fallo pre: La zona no puede ser nula o vacía";
        assert cantPax > 0 : "Fallo pre: La cantidad de pasajeros debe ser un valor entero mayor que cero";

        this.fecha = fecha;
        this.zona = zona;
        this.mascota = mascota;
        this.equipaje = equipaje;
        this.cantPax = cantPax;
        this.cliente = cliente;
    }

    /**
     * Obtiene la fecha del Pedido.<br>
     * @return La fecha del Pedido.
     */
    public LocalDateTime getFecha() {
        return fecha;
    }

    /**
     * Obtiene la zona del Pedido.<br>
     * @return La zona del Pedido.
     */
    public String getZona() {
        return zona;
    }

    /**
     * Obtiene la indicación de si el Pedido incluye mascota.<br>
     * @return 1 si el pedido incluye mascota, 0 si no.
     */
    public int getMascota() {
        return mascota;
    }

    /**
     * Obtiene la indicación de si el pedido incluye equipaje.<br>
     * @return 1 si el pedido incluye equipaje, 0 si no.
     */
    public int getEquipaje() {
        return equipaje;
    }

    /**
     * Obtiene la cantidad de pasajeros en el Pedido.<br>
     * @return La cantidad de pasajeros en el Pedido.
     */
    public int getCantPax() {
        return cantPax;
    }

    /**
     * Obtiene el cliente que realizó el Pedido.<br>
     * @return El cliente del pedido.
     */
    public Cliente getCliente() {
        return this.cliente;
    }

    /**
     * Realiza una copia superficial del objeto Pedido.<br>
     * @return Una copia superficial del objeto Pedido.
     */
    public Object clone() throws CloneNotSupportedException 
    {
        Pedido clonado = null;
        try {
            clonado = (Pedido) super.clone();
            clonado.cliente = (Cliente) cliente.clone();
        } 
        catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clonado;
    }
}

