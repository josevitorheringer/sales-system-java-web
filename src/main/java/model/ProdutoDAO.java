package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProdutoDAO {

	public void inserirProduto(Produto prod) {
		String sql = "insert into produto ( nome , custo , quantidade ) values (?,?,?)";
		try {
			ConnectionFactory dao = new ConnectionFactory();

			Connection con = dao.getConnection();

			PreparedStatement pst = con.prepareStatement(sql);

			pst.setString(1, prod.getNome());
			pst.setDouble(2, prod.getCusto());
			pst.setDouble(3, prod.getQuantidade());

			pst.executeUpdate();

			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public ArrayList<Produto> listarProdutosAjax(String produto) {
		ArrayList<Produto> arrayProdutos = new ArrayList<>();
		String sql = "select * from produto where nome like '%" + produto + "%' order by nome limit 10";
		try {
			ConnectionFactory dao = new ConnectionFactory();
			Connection con = dao.getConnection();

			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				String nome = rs.getString(2);
				Double custo = rs.getDouble(3);
				Double quantidade = rs.getDouble(4);

				arrayProdutos.add(new Produto(id, nome, custo, quantidade));
			}
			con.close();
			return arrayProdutos;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}

	}
	
	public void removeUm(int idProduto) {
		String sql = "update produto set quantidade = quantidade-1  where produto_id = (?)";
		try {
			ConnectionFactory dao = new ConnectionFactory();

			Connection con = dao.getConnection();

			PreparedStatement pst = con.prepareStatement(sql);

			pst.setInt(1, idProduto);

			pst.executeUpdate();

			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public Produto listaPorId(int id) {
		
		String sql = "select produto_id, nome, custo from produto where produto_id =" + id;
		try {
			Produto prod = null;
			ConnectionFactory dao = new ConnectionFactory();
			Connection con = dao.getConnection();

			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				int idProduto = rs.getInt(1);
				String nome = rs.getString(2);
				double custo = rs.getDouble(3);
				
				prod = new Produto(idProduto, nome, custo);
			}	
			con.close();
			return prod;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		
	}
	
}
