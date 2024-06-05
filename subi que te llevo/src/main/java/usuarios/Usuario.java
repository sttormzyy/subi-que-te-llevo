package usuarios;

import java.io.Serializable;

/**
 * La clase Usuario es una clase abstracta de la cual se extienden Cliente y Administrador.
 */
public abstract class Usuario implements Cloneable, Serializable{
	protected String nombreUsuario;
	protected String nombreReal;
	protected String contrasena;
	
	/**
     * Crea una nueva instancia de Usuario.
     * <b>PRE: </b> nombreUsuario, nombreReal, contrasena distintos de null y vacio<br>
     * @param nombreUsuario El nombre de usuario del usuario.
     * @param nombreReal    El nombre real del usuario.
     * @param contrasena    La contraseña del usuario.
     */
	public Usuario(String nombreUsuario, String nombreReal, String contrasena) {
		
		assert (nombreUsuario!=null && nombreUsuario!=""):"Fallo pre: Nombre usuario invalido";
		assert (nombreReal!=null && nombreReal!=""):"Fallo pre: Nombre real invalido";
		assert (contrasena!=null && contrasena!=""):"Fallo pre: Contrasena invalida";
		
		this.nombreUsuario = nombreUsuario;
		this.nombreReal = nombreReal;
		this.contrasena = contrasena;
	}

	/**
     * Obtiene el nombre de usuario del usuario.
     * @return El nombre de usuario del usuario.
     */
	public String getNombreUsuario() {
		return nombreUsuario;
	}

	 /**
     * Establece el nombre de usuario del usuario.
     * @param nombreUsuario El nuevo nombre de usuario del usuario.
     */
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	/**
     * Obtiene el nombre real del usuario.
     * @return El nombre real del usuario.
     */
	public String getNombreReal() {
		return nombreReal;
	}

	/**
     * Establece el nombre real del usuario.
     * @param nombreReal El nuevo nombre real del usuario.
     */
	public void setNombreReal(String nombreReal) {
		this.nombreReal = nombreReal;
	}
	
	/**
     * Obtiene la contraseña del usuario.
     * @return La contraseña del usuario del usuario.
     */
	public String getContrasena() {
		return contrasena;
	}
	
	/**
     * Establece la contraseña del usuario.
     * @param contrasena La nueva contraseña del usuario.
     */
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	@Override
	public Usuario clone() {
		Usuario clonado = null;
        try {
			clonado = (Usuario) super.clone();
        }
        catch (CloneNotSupportedException e) {
        	// No salta nunca ya que estamos implementando Cloneable
        }
		return clonado;
    }
}
