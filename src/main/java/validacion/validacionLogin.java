package validacion;

import co.edu.unbosque.frontend.encrypt;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.unbosque.frontend.TestJSON;
import co.edu.unbosque.frontend.Usuarios;

@WebServlet("/validacionLogin")
public class validacionLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public validacionLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String listar = request.getParameter("Listar");
		String agregar = request.getParameter("Agregar");
		if(agregar != null) {
			agregarUsuario(request, response);
		}
		if(listar != null) {
			listarUsuarios(request, response);
		}
	}
	public void agregarUsuario(HttpServletRequest request, HttpServletResponse response) {
		encrypt encryptar = new encrypt();
		Usuarios usuario = new Usuarios();
		usuario.setCedula_usuario(Long.parseLong(request.getParameter("cedula")));
		usuario.setNombre_usuario(request.getParameter("nombre"));
		usuario.setEmail_usuario(request.getParameter("correo"));
		usuario.setUsuario(request.getParameter("usuario"));
		try {
			usuario.setPassword(encryptar.passEncrypt(request.getParameter("password")));
		} catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException | IllegalBlockSizeException
				| BadPaddingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int respuesta = 0;
		try {
			respuesta = TestJSON.postJSON(usuario);
			PrintWriter writer = response.getWriter();
			if (respuesta == 200) {
				writer.println("Usuario registrado");
			}else writer.println("Error: "+respuesta);
			writer.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void listarUsuarios(HttpServletRequest request, HttpServletResponse response) {
		try {
			ArrayList<Usuarios> lista = TestJSON.getJSON();
			String pagina = "/resultado.jsp";
			request.setAttribute("lista", lista);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
			dispatcher.forward(request, response);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String usuario = String.valueOf(request.getParameter("usuario")).trim();
		String password = String.valueOf(request.getParameter("password")).trim();

		String url = null;

		
		if (usuario.equals("admin") && password.equals("admin123")) {
			url = "/View/menu/menu.jsp";
		} else {
			url = "/View/Login/login.jsp";
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
