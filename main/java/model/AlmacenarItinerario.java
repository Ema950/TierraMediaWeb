package model;
import java.io.*;
import java.sql.SQLException;
import dao.ItinerarioDao;

public class AlmacenarItinerario {

	public static void crearArchivoItinerario(Usuario unUsuario) throws IOException {
		PrintWriter salida = new PrintWriter(new File("./ArchivosSalida/" + unUsuario.getNombre() + ".csv"));
		salida.println("El Itineario de " + unUsuario.getNombre() + " Esta compuesto por: ");
		for (Atraccion a : unUsuario.getHistorialAtracciones()) {
			salida.println(a);
		}
		salida.println("El costo total del Itinerario es de: " + unUsuario.costoItinerario() + " Monedas.");
		salida.println("La duracion total del recorrido es de: " + unUsuario.duracionItinerario() + " Horas.");
		salida.close();
	}
	public static void escribirBD(Usuario unUsuario) throws SQLException {
		ItinerarioDao itinerario = new ItinerarioDao();
		itinerario.insert(unUsuario.getNombre(), unUsuario.costoItinerario(), unUsuario.duracionItinerario());
	}

}
