package controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import Service.AtraccionService;
import Service.UsuarioService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Atraccion;
import model.Usuario;

@WebServlet("/index")
public class SugerenciaServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = -8916615040680741475L;
	UsuarioService usuario;
	AtraccionService atracciones;

	@Override
	public void init() throws ServletException {
		super.init();
		usuario = new UsuarioService();
		atracciones = new AtraccionService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nombre = req.getParameter("nombre");
		Usuario usuarioIngresado = usuario.find(nombre);
		LinkedList<Atraccion> sugerencias = atracciones.findAll();
		LinkedList<Atraccion> usuarioIngresadoSugerencias = new LinkedList<Atraccion>();
		for (Atraccion a : sugerencias) {
			if (a.contieneTipo(usuarioIngresado.getAtraccionPreferida())) {
				usuarioIngresadoSugerencias.add(a);
			}
		}

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/Sugerencias.jsp");
		req.setAttribute("h1", usuarioIngresado.getNombre());
		req.setAttribute("descripcion", usuarioIngresado.getDescripcion());
		req.setAttribute("lista", usuarioIngresadoSugerencias);
		dispatcher.forward(req, resp);
	}

}
