package Service;

import dao.UsuarioDao;
import model.Usuario;

public class UsuarioService {
	UsuarioDao usuarioBD = new UsuarioDao();
	
	public Usuario find(String nombre) {
		return usuarioBD.findByNombre(nombre);
	}
}
