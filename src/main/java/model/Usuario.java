package model;

public class Usuario{
	private int id;
	private String nome;
	private String endereco;
	private String cpf;
	private String login;
	private String senha;
	
	public Usuario() {
		super();
	}
	
	public Usuario(int id, String nome, String endereco, String cpf, String login, String senha) {
		this.setIdCliente(id);
		this.setNome(nome);
		this.setEndereco(endereco);
		this.setCpf(cpf);
		this.setLogin(login);
		this.setSenha(senha);;
	}
	
	public Usuario(int id, String nome, String endereco, String cpf, String login) {
		this.setIdCliente(id);
		this.setNome(nome);
		this.setEndereco(endereco);
		this.setCpf(cpf);
		this.setLogin(login);
	}
	
	public Usuario(int id, String nome, String endereco, String cpf) {
		this.setIdCliente(id);
		this.setNome(nome);
		this.setEndereco(endereco);
		this.setCpf(cpf);
	}
	
	public Usuario(String login, String senha) {
		this.setLogin(login);
		this.setSenha(senha);
	}

	public int getIdCliente() {
		return id;
	}

	public void setIdCliente(int idCliente) {
		this.id = idCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
}