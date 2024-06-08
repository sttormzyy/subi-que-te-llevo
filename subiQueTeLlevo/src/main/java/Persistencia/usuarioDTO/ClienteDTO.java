package Persistencia.usuarioDTO;

public class ClienteDTO extends UsuarioDTO {
	private int puntos;
	
	public ClienteDTO() {
	}
	
	public ClienteDTO(String nombre, String usuario, String contrasena) {
		super(nombre, usuario, contrasena);
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
}
