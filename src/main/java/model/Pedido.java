package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Pedido {
	private int id;
	private Usuario usuario;
	private Produto produto;
	private Date data;
	
	public Pedido(Usuario usuario, Produto produto) {
		this.usuario = usuario;
		this.produto = produto;
	}
	
	public Pedido(int id, Usuario usuario, Produto produto, Date data) {
		this.id = id;
		this.usuario = usuario;
		this.produto = produto;
		this.data = data;
	}
	
	public Pedido(int id, Usuario usuario, Date data) {
		this.id = id;
		this.usuario = usuario;
		this.data = data;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public String getData() {
		SimpleDateFormat f = new SimpleDateFormat("dd/MM/yy");
		String dataFormatada = f.format(this.data);
		return dataFormatada;
	}
	public void setData(Date data) {
		this.data = data;
	}
}
