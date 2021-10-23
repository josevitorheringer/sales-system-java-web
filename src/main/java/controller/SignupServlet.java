package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Usuario;
import model.UsuarioDAO;

@WebServlet("/signupServlet")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SignupServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		if (action.equals("/loginVerify")) {
			verificarUsuarioAjaxPorLogin(request, response);
		} else if (action.equals("/signup")) {	
			novoUsuario(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void novoUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Usuario user = new Usuario();
		UsuarioDAO userDao = new UsuarioDAO();
		
		String nome = request.getParameter("nome");
		String endereco = request.getParameter("endereco");
		String cpf = request.getParameter("cpf");
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		user.setNome(nome);
		user.setEndereco(endereco);
		user.setCpf(cpf);
		user.setLogin(login);
		user.setSenha(senha);
		
		userDao.inserirUsuario(user);
		
		response.sendRedirect("./login.jsp");
	}
	
	protected void verificarUsuarioAjaxPorLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
		UsuarioDAO userDao = new UsuarioDAO();
		response.setContentType("text/plain");
		String pesquisa = request.getParameter("loginForm");
		PrintWriter out = response.getWriter();

		String result = userDao.verificarUsuarioAjaxPorLogin(pesquisa);
		
		out.print(result);
	}
	
}
