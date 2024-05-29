package usuarios;

/**
 * La clase Cliente representa a un cliente en el sistema. Extiende la clase Usuario.
 */
public class Cliente extends Usuario {
	private int puntos;
	
	/**
     * Crea una nueva instancia de Cliente.<br>
     * <b>PRE: </b> nombreUsuario, nombreReal, contrasena distintos de null y vacio<br>
     * @param nombreUsuario El nombre de usuario del cliente.
     * @param nombreReal    El nombre real del cliente.
     * @param contrasena    La contraseña del cliente.
     */
	public Cliente(String nombreUsuario, String nombreReal, String contrasena) {
		super(nombreUsuario, nombreReal, contrasena);
		this.puntos = 0;
	}
	
	/**
     * Obtiene los puntos acumulados por el cliente.<br>
     * @return Los puntos acumulados por el cliente.
     */
	public int getPuntos() {
		return puntos;
	}

	/**
     * Añade puntos al total de puntos acumulados por el cliente.<br>
     * <b>PRE: </b> puntosGanados mayor que 0
     * @param puntosGanados Los puntos que se van a añadir.
     */
	public void addPuntos(int puntosGanados) {
		this.puntos += puntosGanados;
	}

	/**
     * Genera una representacion en forma de cadena de caracteres para mostrar en un listado.<br>
     * @return La representacion del cliente en forma de cadena de caracteres.
     */
	public String toStringListado() {
		return  String.format("%-25s%-25s",this.nombreUsuario,this.nombreReal);
	}

	/**
     * Genera una representacion en forma de cadena de caracteres del cliente.<br>
     * @return La representacion del cliente en forma de cadena de caracteres.
     */
	public String toString() {
		return "\nNOMBRE DE USUARIO: " + nombreUsuario + 
				"\nNOMBRE REAL: " + nombreReal;
	}
}
