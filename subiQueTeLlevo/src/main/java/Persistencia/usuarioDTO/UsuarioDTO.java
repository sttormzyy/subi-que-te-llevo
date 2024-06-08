package Persistencia.usuarioDTO;

import java.io.Serializable;

public abstract class UsuarioDTO implements Serializable
{
	protected String nombreUsuario;
	protected String nombreReal;
	protected String contrasena;

	public UsuarioDTO() {
	}
	
	public UsuarioDTO(String nombreUsuario, String nombreReal, String contrasena) {
		this.nombreUsuario = nombreUsuario;
		this.nombreReal = nombreReal;
		this.contrasena = contrasena;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getNombreReal() {
		return nombreReal;
	}
	public void setNombreReal(String nombreReal) {
		this.nombreReal = nombreReal;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
}
