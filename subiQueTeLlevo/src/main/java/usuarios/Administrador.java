package usuarios;

/**
 * La clase Administrador representa a un administrador en el sistema. Extiende la clase Usuario.
 */
public class Administrador extends Usuario{

	/**
     * Crea una nueva instancia de Administrador.<br>
     * <b>PRE: </b> nombreUsuario, nombreReal, contrasena distintos de null y vacio<br>
     * @param nombre        El nombre real del administrador.
     * @param usuario El nombre de usuario del administrador.
     * @param contrasena    La contraseña del administrador.
     */
	public Administrador(String nombre, String usuario, String contrasena) {
		super(nombre, usuario, contrasena);
	}
	
}
