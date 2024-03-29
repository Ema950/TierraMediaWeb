package model;

public interface Sugerible {

	/**
	 * Metodo que devuelve el costo de una sugerencia;
	 * 
	 * @return el coste en monedas.
	 */
	public abstract int costo();

	/**
	 * Metodo que devuelve la duracion de una sugerencia.
	 * 
	 * @return la duracion expresada en horas.
	 */
	public abstract double duracion();

	/**
	 * Metodo que determina si una sugerencia posee cupo.
	 * 
	 * @return true si existe cupo.
	 */
	public abstract boolean existeCupo();
	
	/**
	 * Metodo que resta en una unidad (-1) el cupo de una sugerencia 
	 */
	public abstract void restarCupo();

	/**
	 * Metodo que indica si una Sugerencia tiene un determinado tipo de atraccion.
	 * 
	 * @return true si posee dicho tipo.
	 */
	public abstract boolean contieneTipo(TipoAtraccion unTipo);

}
