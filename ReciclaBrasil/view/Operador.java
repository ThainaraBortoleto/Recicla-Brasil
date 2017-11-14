public class Operador extends Pessoa {
	private int idOperador;
	
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
