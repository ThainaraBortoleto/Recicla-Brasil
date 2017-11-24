public class Empresa {
	private int idEmpresa;
	private String nomeResponsavel, razaoSocial, cnpj, cep, endereco, telefone, email, horarioMarcado, nome;

	public Empresa() {
		
	}
	
	public Empresa(int idEmpresa, String nomeResponsavel, String cnpj) {
		this.idEmpresa = idEmpresa;
		this.nomeResponsavel = nomeResponsavel;
		this.cnpj = cnpj;
	}
	
	public Empresa(int idEmpresa, String nomeResponsavel, String razaoSocial, String cnpj, String cep, String endereco,
			String telefone, String email, String horarioMarcado) {
		super();
		this.idEmpresa = idEmpresa;
		this.nomeResponsavel = nomeResponsavel;
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
		this.cep = cep;
		this.endereco = endereco;
		this.telefone = telefone;
		this.email = email;
		this.horarioMarcado = horarioMarcado;
	}

	public String getHorarioMarcado() {
		return horarioMarcado;
	}

	public void setHorarioMarcado(String horarioMarcado) {
		this.horarioMarcado = horarioMarcado;
	}

	public int getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(int idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public String getNomeResponsavel() {
		return nomeResponsavel;
	}

	public void setNomeResponsavel(String nomeResponsavel) {
		this.nomeResponsavel = nomeResponsavel;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
