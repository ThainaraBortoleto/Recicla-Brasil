import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpresaDAO {
	private Connection con;

	public EmpresaDAO(Connection con) {
		this.con = con;
	}

	public void inserir(Empresa empresa) throws SQLException {
		String slqInsert = "insert into empresa (id, nome_responsavel, razao_social, cnpj, cep, endereco, telefone, email) values (?, ?, ?, ?, ?, ?, ?, ?)";

		try (PreparedStatement stm = con.prepareStatement(slqInsert)) {
			stm.setInt(1, empresa.getIdEmpresa());
			stm.setString(2, empresa.getNomeResponsavel());
			stm.setString(3, empresa.getRazaoSocial());
			stm.setString(4, empresa.getCnpj());
			stm.setString(5, empresa.getCep());
			stm.setString(6, empresa.getEndereco());
			stm.setString(7, empresa.getTelefone());
			stm.setString(8, empresa.getEmail());
			
			stm.execute();
		}
	}

	public void alterar(Empresa empresa) throws SQLException {
		String sqlUpdate = "update empresa set nome_responsavel = ?, razao_social = ?, cnpj = ?, cep = ?, endereco = ?, telefone = ?, email = ? when id = ?";

		try (PreparedStatement stm = con.prepareStatement(sqlUpdate)) {
			stm.setString(1, empresa.getNomeResponsavel());
			stm.setString(2, empresa.getRazaoSocial());
			stm.setString(3, empresa.getCnpj());
			stm.setString(4, empresa.getCep());
			stm.setString(5, empresa.getEndereco());
			stm.setString(6, empresa.getTelefone());
			stm.setString(7, empresa.getEmail());
			

			stm.execute();
		}
	}

	public void excluir(Empresa empresa) throws SQLException {
		String sqlDelete = "delete from empresa where id = ?";

		try (PreparedStatement stm = con.prepareStatement(sqlDelete)) {
			stm.setInt(1, empresa.getIdEmpresa());

			stm.execute();
		}
	}

	public List<Empresa> carregar() throws SQLException {
		List<Empresa> empresas = new ArrayList<>();
		String sqlSelect = "select * from empresa";

		try (PreparedStatement stm = con.prepareStatement(sqlSelect)) {
			stm.execute();
			transformaResultadosEmColetores(empresas, stm);
			return empresas;
		}
	}

	private void transformaResultadosEmColetores(List<Empresa> empresas, PreparedStatement stm) throws SQLException {

		try (ResultSet rs = stm.getResultSet()) {
			while (rs.next()) {
				int idEmpresa = rs.getInt("id");
				String nomeResposavel = rs.getString("nome_responsavel");
				String razaoSocial = rs.getString("razao_social");
				String cnpj = rs.getString("cnpj");
				String cep = rs.getString("cep");
				String endereco = rs.getString("endereco");
				String telefone = rs.getString("telefone");
				String email = rs.getString("email");
				
				Empresa empresa = new Empresa(idEmpresa, nomeResposavel, razaoSocial, cnpj, cep, endereco, telefone, email);
				empresas.add(empresa);
			
			}
		}
	}
}
