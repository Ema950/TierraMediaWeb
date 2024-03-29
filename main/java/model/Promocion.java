package model;

import java.util.ArrayList;

public abstract class Promocion implements Sugerible {

	protected String nombre;
	protected ArrayList<Atraccion> atracciones;

	public Promocion(String nombre, ArrayList<Atraccion> atracciones) {
		this.nombre = nombre;
		this.atracciones = atracciones;
	}

	
	public double duracion() {
		double duracion = 0;
		for (Atraccion c : this.atracciones)
			duracion += c.duracion();
		return duracion;
	}

	
	public boolean existeCupo() {
		boolean retorno = true;
		for (Atraccion c : this.atracciones)
			retorno = retorno && c.existeCupo();
		return retorno;
	}
	
	
	public void restarCupo() {
		for (Atraccion a : this.getAtracciones()) {
			a.restarCupo();
		}
	}

	/**
	 * Metodo que indica si una atraccion esta incluida en la promocion
	 */
	public boolean contieneAtraccion(Atraccion unaAtraccion) {
		boolean retorno = false;
		for (Atraccion a : this.getAtracciones()) {
			if (unaAtraccion.equals(a)) {
				retorno = true;
			}
		}
		return retorno;
	}

	/**
	 * Metodo que determina si en la lista de atracciones de una promocion existe
	 * alguna de un determinado tipo pasado por parametros.
	 */
	
	public boolean contieneTipo(TipoAtraccion unTipo) {
		boolean retorno = false;
		for (Atraccion a : this.getAtracciones()) {
			if (a.getTipoDeAtraccion().toString().equals(unTipo.toString())) {
				retorno = true;
			}
		}
		return retorno;
	}

	@Override
	public String toString() {
		String nombreAtracciones = "";
		for (Atraccion a : this.atracciones) {
			nombreAtracciones += a.getNombre() + ", ";
		}
		return "Promocion: " + nombre + ".  \nCompuesta por las atracciones: " + nombreAtracciones;
	}

	public String getNombre() {
		return nombre;
	}

	public ArrayList<Atraccion> getAtracciones() {
		return atracciones;
	}
}
