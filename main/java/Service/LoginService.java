package Service;

import dao.AdministradorDao;
import model.Administrador;
import model.NullUser;

public class LoginService {
	public Administrador login(String username, String password) {
		AdministradorDao userDao = new AdministradorDao();
    	Administrador user = userDao.findByNombre(username);
    	
    	if (user.isNull() || !user.checkPassword(password)) {
    		user = NullUser.build();
    	}
    	return user;
	}

}
