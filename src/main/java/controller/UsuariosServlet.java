package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.Usuario;
import model.UsuarioDAO;

@WebServlet("/usuariosServlet")
public class UsuariosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UsuariosServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		if (action.equals("/listarUsuarios")) {
			listarUsuariosAjax(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	protected void listarUsuariosAjax(HttpServletRequest request, HttpServletResponse response) throws IOException {
		UsuarioDAO cliDao = new UsuarioDAO();
		
		response.setContentType("text/plain");
		String pesquisa = request.getParameter("formCliente");
		PrintWriter out = response.getWriter();

		ArrayList<Usuario> lista = cliDao.listarUsuariosAjax(pesquisa);
		
		Gson gson = new Gson();
		
		String json = gson.toJson(lista);
		
		out.print(json);
	}
}
