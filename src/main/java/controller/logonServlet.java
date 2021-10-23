package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Usuario;
import model.UsuarioDAO;

@WebServlet("/logonServlet")
public class logonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public logonServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		efetuarLogout(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		efetuarLogin(request, response);
	}

	protected void efetuarLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		UsuarioDAO uCon = new UsuarioDAO();
		
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		HttpSession s = request.getSession(false);
		
		if( s!=null)
			s.invalidate();
		
		if( login != null && senha != null) {
			Usuario user = uCon.efetuarLogin(login, senha);
			if(user.getNome()!= null) {
				if(user.getSenha().equals( senha )) {
					s = request.getSession();
					user.setSenha("****");
					s.setAttribute("usuario", user);
					response.setStatus(200);
					response.sendRedirect("home");
				}else {
					s = request.getSession();
					s.setAttribute("usuario", null);
					response.sendRedirect("login.jsp?error=error");
				}

			} else {
				s = request.getSession();
				s.setAttribute("usuario", null);
				response.sendRedirect("login.jsp?error=error");
			}



		}
		
	}
	
	protected void efetuarLogout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession s = request.getSession(false);
		s.invalidate();
		
		response.sendRedirect("login.jsp");
	}
	
}
