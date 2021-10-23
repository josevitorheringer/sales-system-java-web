package model;

public class Pedido {
	private int id;
	private Usuario usuario;
	private Produto produto;
	private String data;
	
	public Pedido(int id, Usuario usuario, Produto produto, String data) {
		this.id = id;
		this.usuario = usuario;
		this.produto = produto;
		this.data = data;
	}
	
	public Pedido(int id, Usuario usuario, String data) {
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
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
}
