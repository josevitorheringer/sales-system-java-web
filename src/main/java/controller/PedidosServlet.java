package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Pedido;
import model.PedidoDAO;
import model.Usuario;

@WebServlet("/PedidosServlet")
public class PedidosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PedidosServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		if (action.equals("/comprarProduto")) {
			comprarProduto(request, response);
		} else if (action.equals("/listarPedido")) {
			listarPedido(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	protected void comprarProduto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		Usuario u = (Usuario) session.getAttribute("usuario");
		PedidoDAO pDAO = new PedidoDAO();
		
		int idUsuario = 	u.getIdCliente();
		int idProduto = Integer.parseInt(request.getParameter("id"));
		pDAO.efetuarCompra(idUsuario, idProduto);
		response.sendRedirect("home");
	}
	
	protected void listarPedido(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		PedidoDAO pedidoDAO = new PedidoDAO();
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		Pedido pedido= pedidoDAO.listarUmPedido(id);
		
		
		request.setAttribute("pedido", pedido);

		RequestDispatcher rd = request.getRequestDispatcher("pedido.jsp");
		rd.forward(request, response);
	}
	
	
}
