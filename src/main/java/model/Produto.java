package model;

public class Produto{
	private int id;
	private String nome;
	private double custo;
	private double quantidade;
	
	public Produto() {
		super();
	}
	
	public Produto(int id, String nome, double custo, double quantidade) {
		this.id = id;
		this.nome = nome;
		this.custo = custo;
		this.quantidade = quantidade;
	}
	
	public Produto(int id, String nome, double custo) {
		this.id = id;
		this.nome = nome;
		this.custo = custo;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getCusto() {
		return custo;
	}
	public void setCusto(double custo) {
		this.custo = custo;
	}
	public double getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(double quantidade) {
		this.quantidade = quantidade;
	}
	
}