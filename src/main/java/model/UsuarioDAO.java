package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UsuarioDAO {

	public void inserirUsuario(Usuario usuario) {
		String sql = "insert into cliente ( nome , endereco , cpf , login , senha ) values (?,?,?,?,?)";
		try {
			ConnectionFactory dao = new ConnectionFactory();

			Connection con = dao.getConnection();

			PreparedStatement pst = con.prepareStatement(sql);

			pst.setString(1, usuario.getNome());
			pst.setString(2, usuario.getEndereco());
			pst.setString(3, usuario.getCpf());
			pst.setString(4, usuario.getLogin());
			pst.setString(5, usuario.getSenha());

			pst.executeUpdate();

			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public ArrayList<Usuario> listarUsuariosAjax(String usuario) {
		ArrayList<Usuario> arrayUsuarios = new ArrayList<>();
		String sql = "select cliente_id, nome, endereco, cpf, login from cliente where nome like '%" + usuario + "%' order by nome limit 5";
		try {
			ConnectionFactory dao = new ConnectionFactory();
			Connection con = dao.getConnection();

			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				String nome = rs.getString(2);
				String endereco = rs.getString(3);
				String cpf = rs.getString(4);
				String login = rs.getString(5);

				arrayUsuarios.add(new Usuario(id, nome, endereco, cpf, login));
			}
			con.close();
			return arrayUsuarios;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}

	}

	public String verificarUsuarioAjaxPorLogin(String pesquisa) {
		String sql = "select login from cliente where login ='" + pesquisa + "'";
		
		try {
			ConnectionFactory dao = new ConnectionFactory();
			Connection con = dao.getConnection();
			String login = "";

			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				login = rs.getString(1);
			}	
			con.close();
			return login;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	public Usuario efetuarLogin(String username, String password) {
		
		
		String sql = "select * from cliente where login ='" + username + "'";
		try {
			Usuario u = new Usuario();
			ConnectionFactory dao = new ConnectionFactory();
			Connection con = dao.getConnection();

			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				String nome = rs.getString(2);
				String endereco = rs.getString(3);
				String cpf = rs.getString(4);
				String login = rs.getString(5);
				String senha = rs.getString(6);
				
				u = new Usuario(id, nome, endereco, cpf, login, senha);
			}	
			con.close();
			return u;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public Usuario listaPorId(int idUsuario) {
		
		String sql = "select cliente_id, nome, endereco, cpf from cliente where cliente_id =" + idUsuario;
		try {
			Usuario u = null;
			ConnectionFactory dao = new ConnectionFactory();
			Connection con = dao.getConnection();

			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				String nome = rs.getString(2);
				String endereco = rs.getString(3);
				String cpf = rs.getString(4);
				
				u = new Usuario(id, nome, endereco, cpf);
			}	
			con.close();
			return u;
		} catch (Exception e) {
			return null;
		}
	}
}
