package view;

public class Coletor extends Pessoa{
	private int idColetor;
	private double saldo;
	
	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public Coletor(int idColetor) {
		setIdColetor(idColetor);
	}

	public int getIdColetor() {
		return idColetor;
	}

	public void setIdColetor(int idColetor) {
		this.idColetor = idColetor;
	}
	
	
}
