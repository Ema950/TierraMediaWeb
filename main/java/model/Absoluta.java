package model;
import java.util.ArrayList;
public class Absoluta extends Promocion {

	// Atributo que representa el descuento fijo en monedas que brinda la promocion
	private int descuento;

	public Absoluta(String nombre, ArrayList<Atraccion> atracciones, int descuento) {
		super(nombre, atracciones);
		this.descuento = descuento;
	}

	/**
	 * Metodo que determina el costo de una Promocion, recorre la lista de
	 * atracciones que compone la promocion sumando los costos de cada atraccion y
	 * al total se le resta un costo fijo en monedas.
	 * 
	 * @return el costo de la promocion en monedas.
	 */
	public int costo() {
		int costo = 0;
		for (Atraccion c : this.atracciones)
			costo += c.costo();
		if (costo > this.descuento) {
			costo -= this.getDescuento();
			return costo;
		} else {
			return 0;
		}
	}

	@Override
	public String toString() {
		return super.toString() + " \nSu costo total es de: " + this.costo()
				+ " monedas, donde se aplico un descuento de: " + this.getDescuento()
				+ " monedas.  \nSu duracion es de: " + this.duracion() + " horas. \n";
	}

	public int getDescuento() {
		return descuento;
	}
}
