package model;

import java.util.LinkedList;

public class Itinerario {
	Usuario usuario;
	int costoTotal;
	Double duracionTotal;
	
	public Itinerario(Usuario usuario, int costoTotal, Double duracionTotal) {
		this.usuario = usuario;
		this.costoTotal = costoTotal;
		this.duracionTotal = duracionTotal;
	} 
	
	public LinkedList<Sugerible> crearSugerencia(LinkedList<Sugerible> unaLista){
		LinkedList<Sugerible> retorno = new LinkedList<Sugerible>();
		for (Sugerible s : unaLista) {
			if(s.contieneTipo(this.usuario.getAtraccionPreferida())){
				retorno.add(s);
			}
		}
		return retorno; 
	}
}
