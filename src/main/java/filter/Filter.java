package filter;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Usuario;

@WebFilter(filterName="Filter", urlPatterns="*")
public class Filter implements javax.servlet.Filter {

    public Filter() {
    }


	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req =(HttpServletRequest) request;

		HttpServletResponse resp =(HttpServletResponse) response;
		
		String url = req.getRequestURI();
		Usuario u = null;
		HttpSession session = req.getSession(false);
		if(session!=null) {
			u = (Usuario) session.getAttribute("usuario");
		}
		
		if(url.endsWith("login.jsp") || url.endsWith("logon") || url.endsWith("logout") || url.endsWith("cadastrar_usuario.jsp") || url.endsWith("signup") || url.endsWith("loginVerify") || url.endsWith("jquery-3.6.0.js")) {
			chain.doFilter(request, response);
		}else if(u != null){
			chain.doFilter(request, response);
		}else{
			resp.sendRedirect("login.jsp");
		}
		
	}


	public void init(FilterConfig fConfig) throws ServletException {

	}

}
