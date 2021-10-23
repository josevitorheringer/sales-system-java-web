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

import model.Produto;
import model.ProdutoDAO;

@WebServlet("/produtosServlet")
public class ProdutosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProdutosServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		if (action.equals("/listarProdutos")) {
			listarProdutosAjax(request, response);
		}else if (action.equals("/insertProduto")) {
			novoProduto(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void listarProdutosAjax(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ProdutoDAO prodDao = new ProdutoDAO();
		
		response.setContentType("text/plain");
		String pesquisa = request.getParameter("formProduto");
		PrintWriter out = response.getWriter();

		ArrayList<Produto> lista = prodDao.listarProdutosAjax(pesquisa);
		
		Gson gson = new Gson();
		
		String json = gson.toJson(lista);
		out.print(json);
	}
	
	protected void novoProduto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Produto produto = new Produto();
		ProdutoDAO prodDao = new ProdutoDAO();
		
		String nome = request.getParameter("nome");
		String custo = request.getParameter("custo");
		String quantidade = request.getParameter("quantidade");
		
		produto.setNome(nome);
		produto.setCusto(Double.parseDouble(custo));
		produto.setQuantidade(Double.parseDouble(quantidade));
		
		prodDao.inserirProduto(produto);
		
		response.sendRedirect("cadastrar_produto.jsp");
	}

}
