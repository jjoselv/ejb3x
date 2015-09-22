package controladores;

import java.io.IOException;
import java.io.PrintWriter;

import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import anotaciones.Informal;
import anotaciones.MaxNumber;
import anotaciones.Random;
import definiciones.Mensaje;

/**
 * Servlet implementation class CdiServlet
 */
@WebServlet("/CdiServlet")
public class CdiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	private Mensaje simpleMensaje;
	@Inject
	@Informal
	private Mensaje informalMensaje;
	@Inject
	@MaxNumber
	private int numero;
	@Inject @Random private Instance<Integer> aleatorio;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CdiServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();
		out.println(simpleMensaje.get());
		out.println(informalMensaje.get());
		out.println("El número fijo es " + numero);
		out.println("El número aleatorio es " + aleatorio.get());
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
