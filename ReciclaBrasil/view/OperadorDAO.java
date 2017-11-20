package view;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OperadorDAO {
	private Connection con;

	public OperadorDAO(Connection con) {
		this.con = con;
	}

	public void inserir(Operador operador) throws SQLException {
		String slqInsert = "insert into operador (id_operador, nome, cpf, login, senha) values (?, ?, ?, ?, ?)";

		try (PreparedStatement stm = con.prepareStatement(slqInsert)) {
			stm.setInt(1, operador.getIdOperador());
			stm.setString(2, operador.getNome());
			stm.setString(3, operador.getCpf());
			stm.setString(4, operador.getLogin());
			stm.setString(5, operador.getSenha());
			stm.execute();
		}
	}

	public void alterar(Operador operador) throws SQLException {
		String sqlUpdate = "update operador set nome = ?, cpf = ? where id_operador = ?";

		try (PreparedStatement stm = con.prepareStatement(sqlUpdate)) {
			stm.setString(1, operador.getNome());
			stm.setString(2, operador.getCpf());
			stm.setInt(3, operador.getIdOperador());

			stm.execute();
		}
	}

	public void excluir(Operador operador) throws SQLException {
		String sqlDelete = "delete from operador where id_operador = ?";

		try (PreparedStatement stm = con.prepareStatement(sqlDelete)) {
			stm.setInt(1, operador.getIdOperador());

			stm.execute();
		}
	}

	public List<Operador> carregar() throws SQLException {
		List<Operador> operadores = new ArrayList<>();
		String sqlSelect = "select * from operador";

		try (PreparedStatement stm = con.prepareStatement(sqlSelect)) {
			stm.execute();
			transformaResultadosEmColetores(operadores, stm);
			return operadores;
		}
	}

	private void transformaResultadosEmColetores(List<Operador> operadores, PreparedStatement stm) throws SQLException {

		try (ResultSet rs = stm.getResultSet()) {
			while (rs.next()) {
				int idOperador = rs.getInt("id");
				String nome = rs.getString("nome");
				String cpf = rs.getString("cpf");
				
				Operador operador = new Operador(idOperador);
				operador.setNome(nome);
				operador.setCpf(cpf);
				operadores.add(operador);
			}
		}
	}
	
	public boolean validaLogin(String login, String senha) throws SQLException{
		String sql = "select * from operador where login = ? and senha = ?";
		try(PreparedStatement stm = con.prepareStatement(sql)){
			stm.setString(1, login);
			stm.setString(2, senha);
			
			stm.execute();
			try(ResultSet rs = stm.getResultSet()){
				if(rs.next()) {
					return true;
				}
				return false;
			}
		}
	}
}
