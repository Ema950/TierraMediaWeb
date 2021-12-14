package model;

import java.util.*;

public class TierraMedia {

	private LinkedList<Sugerible> sugerencias = new LinkedList<Sugerible>();

	public TierraMedia(LinkedList<Sugerible> sugerencias) {
		this.sugerencias = sugerencias;
	}

	/**
	 * Metodo que brinda una lista con las sugerencias(promociones y atracciones)
	 * acordes a las preferencias de un usuario.
	 * 
	 * @param unUsuario es el usuario para quien hay que generar las sugerencias
	 * @return lista con sugerencias.
	 */
	public LinkedList<Sugerible> sugerenciasUsuario(Usuario unUsuario) {
		LinkedList<Sugerible> retorno = new LinkedList<Sugerible>();
		for (Sugerible s : this.sugerencias) {
			if (unUsuario.puedeRecorrer(s) && s.contieneTipo(unUsuario.getAtraccionPreferida())) {
				retorno.addLast(s);
			}
		}
		return retorno;
	}

	public LinkedList<Sugerible> getSugerencias() {
		return sugerencias;
	}

}
