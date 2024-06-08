package Persistencia.usuarioDTO;

public class AdministradorDTO extends UsuarioDTO {
	// Esta clase esta preparada para futuras actualizaciones con atributos especificos
    // por ahora, hereda todos los atributos de UsuarioDTO
	
	public AdministradorDTO() {
	}
	
	public AdministradorDTO(String nombre, String usuario, String contrasena) {
		super(nombre, usuario, contrasena);
	}
}
