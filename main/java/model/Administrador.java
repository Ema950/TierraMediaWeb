package model;
import Utilidades.Crypt;

public class Administrador {
	private String nombre;
	private String contrasenia;
	
	
	public Administrador(String nombre, String contrasenia) {
		this.nombre = nombre;
		this.contrasenia = contrasenia;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getContrasenia() {
		return contrasenia;
	}


	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}


	public boolean isNull() {
		return false;
	}


	public boolean checkPassword(String password) {
		return Crypt.match(password, this.contrasenia);
	} 
	
	
	
	

}
