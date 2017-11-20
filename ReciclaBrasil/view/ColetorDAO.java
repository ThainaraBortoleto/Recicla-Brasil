package view;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ColetorDAO {
	private Connection con;

	public ColetorDAO(Connection con) {
		this.con = con;
	}

	public void inserir(Coletor coletor) throws SQLException {
		String slqInsert = "insert into coletor (id_coletor, nome, apelido) values (?, ?, ?)";

		try (PreparedStatement stm = con.prepareStatement(slqInsert)) {
			stm.setInt(1, coletor.getIdColetor());
			stm.setString(2, coletor.getNome());
			stm.setString(3, coletor.getApelido());
			stm.execute();
		}
	}

	public void alterar(Coletor coletor) throws SQLException {
		String sqlUpdate = "update coletor set nome = ?, apelido = ? where id_coletor = ?";

		try (PreparedStatement stm = con.prepareStatement(sqlUpdate)) {
			stm.setString(1, coletor.getNome());
			stm.setString(2, coletor.getApelido());
			stm.setInt(3, coletor.getIdColetor());

			stm.execute();
		}
	}

	public void excluir(Coletor coletor) throws SQLException {
		String sqlDelete = "delete from coletor where id_coletor = ?";

		try (PreparedStatement stm = con.prepareStatement(sqlDelete)) {
			stm.setInt(1, coletor.getIdColetor());

			stm.execute();
		}
	}

	public List<Coletor> carregar() throws SQLException {
		List<Coletor> coletores = new ArrayList<>();
		String sqlSelect = "select * from coletor";
		
		try(PreparedStatement stm = con.prepareStatement(sqlSelect)){
			stm.execute();
			transformaResultadosEmColetores(coletores, stm);
			return coletores;
		}
	}

	private void transformaResultadosEmColetores(List<Coletor> coletores, PreparedStatement stm) throws SQLException {
		
		try(ResultSet rs = stm.getResultSet()){
			while(rs.next()) {
				int idColetor = rs.getInt("id_coletor");
				String nome = rs.getString("nome");
				String apelido = rs.getString("apelido");
				Coletor coletor = new Coletor(idColetor);
				coletor.setNome(nome);
				coletor.setApelido(apelido);
				coletores.add(coletor);
			}
		}
	}
	
	public double getSaldo(Coletor coletor) throws SQLException{ 
		double saldo = 0;
		String sqlSaldo = "select saldo from coletor where id_coletor = ?";
		try(PreparedStatement stm = con.prepareStatement(sqlSaldo)){
			stm.setInt(1, coletor.getIdColetor());
			stm.execute();
			
			try(ResultSet rs = stm.getResultSet()){
				while(rs.next()) {
					saldo = rs.getDouble("saldo");
				}
			}
			return saldo;
		}
	}
	
	public void setValorVenda(Coletor coletor, Material material, double peso) throws SQLException {
		String sqlUpdateValorVenda = "update materiais_coletor set valor_venda = (select ? * preco from material where id_material = ?) where id_coletor = ?";
		try(PreparedStatement stm = con.prepareStatement(sqlUpdateValorVenda)){
			stm.setDouble(1, peso);
			stm.setInt(2, material.getIdMateriais());
			stm.setInt(3, coletor.getIdColetor());
			
			stm.execute();
			
		}
	}
	
	public double getValorVenda(Coletor coletor) throws SQLException{
		double valor = 0;
		String sqlSelectValorVenda = "select valor_venda from materiais_coletor where id_coletor = ?";
		
		try(PreparedStatement stm = con.prepareStatement(sqlSelectValorVenda)){
			stm.setInt(1, coletor.getIdColetor());
			
			stm.execute();
			try(ResultSet rs = stm.getResultSet()){
				while(rs.next()) {
					valor = rs.getDouble("valor_venda");
				}
			}
			return valor;
		}
	}
	
	public void setSaldo(Coletor coletor, double valor) throws SQLException{
		String sqlUpdateSaldo = "update coletor set saldo = ? + (select ? from materiais_coletor where id_coletor = ?) where id_coletor = ?";
		
		try(PreparedStatement stm = con.prepareStatement(sqlUpdateSaldo)){
			stm.setDouble(1, getSaldo(coletor));
			stm.setDouble(2, getValorVenda(coletor));
			stm.setInt(3, coletor.getIdColetor());
			stm.setInt(4, coletor.getIdColetor());
			
			stm.execute();
			
		}
	}
	
	public String getNome(Coletor coletor) throws SQLException{
		String nome = null;
		String sqlSelectNome = "select nome from coletor where id_coletor = ?";
		try(PreparedStatement stm = con.prepareStatement(sqlSelectNome)){
			stm.setInt(1, coletor.getIdColetor());
			
			stm.execute();
			try(ResultSet rs = stm.getResultSet()){
				while(rs.next()) {
					nome = rs.getString("nome");
				}
			}
		}
		return nome;
	}
}
