package view;

public class Material {
	private int idMateriais, quantidade, limite;
	private double preco;
	private String nome;

	public Material() {
		
	}

	public Material(int idMateriais, String nome, int quantidade, int limite, double preco) {
		super();
		this.idMateriais = idMateriais;
		this.quantidade = quantidade;
		this.limite = limite;
		this.nome = nome;
		this.preco = preco;
	}

	public int getIdMateriais() {
		return idMateriais;
	}

	public void setIdMateriais(int idMateriais) {
		this.idMateriais = idMateriais;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public int getLimite() {
		return limite;
	}

	public void setLimite(int limite) {
		this.limite = limite;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	

}
