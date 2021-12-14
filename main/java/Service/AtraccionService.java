package Service;

import java.util.LinkedList;

import dao.AtraccionDao;
import model.Atraccion;

public class AtraccionService {
	AtraccionDao atraccionDB = new AtraccionDao();
	
	public Atraccion find(int Id) {
		return atraccionDB.findById(Id);

	}
	public Atraccion findName(String nombre) {
		int id = atraccionDB.getId(nombre);
		return atraccionDB.findById(id);
	}
	public LinkedList<Atraccion> findAll(){
		return atraccionDB.findAll();
	}

}
