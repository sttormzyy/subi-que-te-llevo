package Persistencia.usuarioDTO;

import java.io.Serializable;

/**
 * La clase UsuarioDTO es una clase abstracta que implementa la interfaz Serializable.
 * Representa a un Usuario genérico.
 */
public abstract class UsuarioDTO implements Serializable {
    
    protected String nombreUsuario;  // El nombre de usuario del Usuario
    protected String nombreReal;     // El nombre real del Usuario
    protected String contrasena;     // La contraseña del Usuario
    
    /**
     * Constructor por defecto de la clase UsuarioDTO.
     */
    public UsuarioDTO() {
    }
    
    /**
     * Constructor de la clase UsuarioDTO que inicializa el nombre de usuario, el nombre real y la contraseña del Usuario.
     * 
     * @param nombreUsuario El nombre de usuario del Usuario.
     * @param nombreReal El nombre real del Usuario.
     * @param contrasena La contraseña del Usuario.
     */
    public UsuarioDTO(String nombreUsuario, String nombreReal, String contrasena) {
        this.nombreUsuario = nombreUsuario;
        this.nombreReal = nombreReal;
        this.contrasena = contrasena;
    }

    /**
     * Obtiene el nombre de usuario del Usuario.
     * 
     * @return El nombre de usuario del Usuario.
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }
    
    /**
     * Establece el nombre de usuario del Usuario.
     * 
     * @param nombreUsuario El nuevo nombre de usuario del Usuario.
     */
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
    
    /**
     * Obtiene el nombre real del Usuario.
     * 
     * @return El nombre real del Usuario.
     */
    public String getNombreReal() {
        return nombreReal;
    }
    
    /**
     * Establece el nombre real del Usuario.
     * 
     * @param nombreReal El nuevo nombre real del Usuario.
     */
    public void setNombreReal(String nombreReal) {
        this.nombreReal = nombreReal;
    }
    
    /**
     * Obtiene la contraseña del Usuario.
     * 
     * @return La contraseña del Usuario.
     */
    public String getContrasena() {
        return contrasena;
    }
    
    /**
     * Establece la contraseña del Usuario.
     * 
     * @param contrasena La nueva contraseña del Usuario.
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
