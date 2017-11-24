public class Operador extends Pessoa {
	private int idOperador;
	private String login;
	private String senha;
	
	public Operador(int idOperador, String login, String senha) {
		super();
		this.idOperador = idOperador;
		this.login = login;
		this.senha = senha;
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


	public Operador(int idOperador) {
		this.idOperador = idOperador;
	}
	
	
	public int getIdOperador() {
		return idOperador;
	}


	public void setIdOperador(int idOperador) {
		this.idOperador = idOperador;
	}


	public String toString() {
		return String.format("#%d\nNome: %s %s\nCPF: %s\nData de Nascimento: %s", this.getIdOperador(), this.getNome(), this.getSobrenome(), this.getCpf(), this.getDataDeNascimento());
	}
	
}
