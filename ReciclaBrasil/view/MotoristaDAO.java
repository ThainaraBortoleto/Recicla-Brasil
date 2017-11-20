package view;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class MotoristaDAO {
	private Connection con;

	public MotoristaDAO(Connection con) {
		this.con = con;
	}

	public void inserir(Motorista motorista) throws SQLException {
		String slqInsert = "insert into motorista (id_motorista, id_empresa, nome, cpf, peso_max, placa) values (?, ?, ?, ?, ?, ?)";

		try (PreparedStatement stm = con.prepareStatement(slqInsert)) {
			stm.setInt(1, motorista.getId());
			stm.setInt(2, motorista.getIdEmpresa());
			stm.setString(3, motorista.getNome());
			stm.setString(4, motorista.getCpf());
			stm.setInt(5, motorista.getPesoMaximo());
			stm.setString(6, motorista.getPlaca());

			stm.execute();
		}
	}

	public void alterar(Motorista motorista) throws SQLException {
		String sqlUpdate = "update motorista set id_empresa = ?, nome = ?, cpf = ?, peso_max = ?, placa = ? when id_motorista = ?";

		try (PreparedStatement stm = con.prepareStatement(sqlUpdate)) {
			stm.setInt(1, motorista.getIdEmpresa());
			stm.setString(2, motorista.getNome());
			stm.setString(3, motorista.getCpf());
			stm.setInt(4, motorista.getPesoMaximo());
			stm.setString(5, motorista.getPlaca());

			stm.execute();
		}
	}

	public void excluir(Motorista motorista) throws SQLException {
		String sqlDelete = "delete from motorista where id_motorista = ?";

		try (PreparedStatement stm = con.prepareStatement(sqlDelete)) {
			stm.setInt(1, motorista.getId());

			stm.execute();
		}
	}

	public List<Motorista> lista() throws SQLException {
		List<Motorista> motoristas = new ArrayList<>();

		String sqlSelect = "select * from motorista";
		try (PreparedStatement stmt = con.prepareStatement(sqlSelect)) {
			stmt.execute();
			try (ResultSet rs = stmt.getResultSet()) {
				while (rs.next()) {
					int id = rs.getInt("id");
					int idEmpresa = rs.getInt("id_empresa");
					String nome = rs.getString("nome");
					String cpf = rs.getString("cpf");
					int pesoMaximo = rs.getInt("peso_max");
					String placa = rs.getString("placa");

					Motorista motorista = new Motorista(id, idEmpresa, pesoMaximo, placa);
					motorista.setNome(nome);
					motorista.setCpf(cpf);
					motoristas.add(motorista);
				}
			}
		}
		return motoristas;
	}

	public List<Motorista> listaComEmpresas() throws SQLException{
		List<Motorista> motoristas = new ArrayList<>();
		Motorista ultimo = null;
		
		String sqlSelect = "select m.id_motorista as ID_motorista, m.nome as Motorista, m.cpf as CPF, m.peso_max as Peso_Suportado, m.placa as Placa, m.id_empresa as ID_Empresa, e.nome_responsavel as Responsavel, e.cnpj as CNPJ from motorista m join empresa e on m.id_empresa = e.id_empresa";
		try(PreparedStatement stm = con.prepareStatement(sqlSelect)){
			stm.execute();
			try(ResultSet rs = stm.getResultSet()){
				while (rs.next()) {
					int idMotorista = rs.getInt("ID_motorista");
					int idEmpresa = rs.getInt("ID_Empresa");
					String nome = rs.getString("Motorista");
					String cpf = rs.getString("CPF");
					int pesoMaximo = rs.getInt("Peso_Suportado");
					String placa = rs.getString("Placa");
					
					Motorista motorista = new Motorista(idMotorista, idEmpresa, pesoMaximo, placa);
					motorista.setNome(nome);
					motorista.setCpf(cpf);

					if (ultimo == null || !ultimo.getNome().equals(nome)) {
						motoristas.add(motorista);
						ultimo = motorista;
					}
					
					String cnpj = rs.getString("CNPJ");
					String nomeResponsavel = rs.getString("Responsavel");
					Empresa empresa = new Empresa(idEmpresa, nomeResponsavel, cnpj);
					
					ultimo.adiciona(empresa);
				}
			}
		}
		return motoristas;
	}
}
