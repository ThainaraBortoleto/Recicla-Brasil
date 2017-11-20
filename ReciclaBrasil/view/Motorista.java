package view;

import java.util.ArrayList;
import java.util.List;

public class Motorista extends Pessoa {
	private int id;
	private int idEmpresa;
	private int pesoMaximo;
	private String placa;
	private List<Empresa> empresas = new ArrayList<>();

	public Motorista(int id, int id_empresa, int pesoMaximo, String placa) {
		super();
		this.id = id;
		this.idEmpresa = id_empresa;
		this.pesoMaximo = pesoMaximo;
		this.placa = placa;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(int id_empresa) {
		this.idEmpresa = id_empresa;
	}

	public int getPesoMaximo() {
		return pesoMaximo;
	}

	public void setPesoMaximo(int pesoMaximo) {
		this.pesoMaximo = pesoMaximo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	public List<Empresa> getEmpresas(){
		return empresas;
	}
	
	public void adiciona(Empresa e) {
		empresas.add(e);
	}

}
