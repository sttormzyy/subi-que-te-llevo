package Persistencia.usuarioDTO;

/**
 * La clase AdministradorDTO es una clase que extiende la clase UsuarioDTO.
 * Representa a un Administrador del sistema.
 * 
 * Esta clase está preparada para futuras actualizaciones con atributos específicos.
 * Por ahora, hereda todos los atributos de UsuarioDTO.
 */
public class AdministradorDTO extends UsuarioDTO {
    
    /**
     * Constructor vacio por defecto de la clase AdministradorDTO.
     */
    public AdministradorDTO() {
    }
    
    /**
     * Constructor de la clase AdministradorDTO que inicializa el nombre, el usuario y la contraseña del Administrador.
     * 
     * @param nombre El nombre real del Administrador.
     * @param usuario El nombre de usuario del Administrador.
     * @param contrasena La contraseña del Administrador.
     */
    public AdministradorDTO(String nombre, String usuario, String contrasena) {
        super(nombre, usuario, contrasena);
    }
}

