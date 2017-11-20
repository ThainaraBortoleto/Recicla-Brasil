package view;

public class Pessoa {
	private String nome;
	private String sobrenome;
	private String apelido;
	private String cpf;
	private String dataDeNascimento;

	public Pessoa() {
	}

	public Pessoa(String nome, String sobrenome, String apelido, String cpf, String dataDeNascimento) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.apelido = apelido;
		this.cpf = cpf;
		this.dataDeNascimento = dataDeNascimento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(String dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public String toString() {
		return String.format("Nome: %s %s\nApelido: %s\nCPF: %s\nData de Nascimento: %s", getNome(), getSobrenome(),
				getApelido(), getCpf(), getDataDeNascimento());
	}

}
