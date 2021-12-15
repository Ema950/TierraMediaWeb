package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import jdbc.ConnectionProvider;
import model.Administrador;

public class AdministradorDao implements GenericDao<Administrador> {

	@Override
	public List<Administrador> findAll() throws SQLException {
		String sql = "SELECT * FROM Administrador;";
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement statement = conn.prepareStatement(sql);
		ResultSet resultados = statement.executeQuery();

		LinkedList<Administrador> administradores = new LinkedList<Administrador>();
		while (resultados.next()) {
			administradores.add(toAdministrador(resultados));
		}
		return administradores;
	}

	@Override
	public int countAll() throws SQLException {
		String sql = "SELECT COUNT(1) AS TOTAL FROM Administrador;";
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement statement = conn.prepareStatement(sql);
		ResultSet resultados = statement.executeQuery();

		resultados.next();
		int total = resultados.getInt("TOTAL");

		return total;
	}

	@Override
	public int insert(Administrador t) throws SQLException {
		try {
			String sql = "INSERT INTO Administrador (Nombre, Contraseña) VALUES (?, ?))";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, t.getNombre());
			statement.setString(2, t.getContrasenia());
			int rows = statement.executeUpdate();
			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int update(Administrador t) throws SQLException {
		try {
			String sql = "UPDATE Administrador SET Contrasenia = ?, WHERE Nombre = ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, t.getContrasenia());
			int rows = statement.executeUpdate();
			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int delete(Administrador t) throws SQLException {
		try {
			String sql = "DELETE FROM Atraccion WHERE Nombre = ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, t.getNombre());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	private Administrador toAdministrador(ResultSet resultados) throws SQLException {
		return new Administrador(resultados.getString(2), resultados.getString(3));
	}

	public Administrador findByNombre(String nombre) {
		try {
			String sql = "SELECT * FROM Administrador WHERE Nombre = ?;";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, nombre);
			ResultSet resultados = statement.executeQuery();
			Administrador retorno = toAdministrador(resultados);
			return retorno;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}



}
