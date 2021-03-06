package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class PedidoDAO {
	public void efetuarCompra(Pedido pedido){
		String sql = "insert into pedido ( cliente_id , produto_id ) values (?,?)";
		try {
			ConnectionFactory dao = new ConnectionFactory();

			Connection con = dao.getConnection();

			PreparedStatement pst = con.prepareStatement(sql);

			pst.setInt(1, pedido.getUsuario().getIdCliente());
			pst.setInt(2, pedido.getProduto().getId());

			pst.executeUpdate();

			con.close();

			ProdutoDAO prodDAO = new ProdutoDAO();
			prodDAO.removeUm(pedido.getProduto().getId());
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public ArrayList<Pedido> listarPedidos(Usuario u){
		ProdutoDAO prodDao = new ProdutoDAO();
		Produto prod = new Produto();
		ArrayList<Pedido> arrayPedidos = new ArrayList<>();
		
		String sql = "select pedido_id, produto_id, data from pedido where cliente_id =" + u.getIdCliente();
		try {
			ConnectionFactory dao = new ConnectionFactory();
			Connection con = dao.getConnection();

			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				int idPedido = rs.getInt(1);
				int idProduto= rs.getInt(2);
				java.sql.Date data = rs.getDate(3);
				
				prod = prodDao.listaPorId(idProduto);
				

				arrayPedidos.add(new Pedido(idPedido,u, prod ,data));
			}
			con.close();
			return arrayPedidos;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	public Pedido listarUmPedido(int id) {
		
		Produto prod = new Produto();
		ProdutoDAO prodDao = new ProdutoDAO();
		Usuario usuario = new Usuario();
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		Pedido pedido = null;
		
		String sql = "select * from pedido where pedido_id =" + id;
		try {
			ConnectionFactory dao = new ConnectionFactory();
			Connection con = dao.getConnection();
			
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				int idPedido = rs.getInt(1);
				int idUsuario = rs.getInt(2);
				int idProduto = rs.getInt(3);
				java.sql.Date data = rs.getDate(4);
				
				prod = prodDao.listaPorId(idProduto);
				usuario = usuarioDAO.listaPorId(idUsuario);
				
				
				pedido = new Pedido(idPedido, usuario, prod, data);
			}	
			con.close();
			return pedido;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
}
