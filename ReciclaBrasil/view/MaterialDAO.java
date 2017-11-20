package view;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MaterialDAO {
	private Connection con;
	
	public MaterialDAO(Connection con) {
		this.con = con;
	}
	
	public void inserir(Material material) throws SQLException {
		String slqInsert = "insert into material (id, nome, quantidade, limite) values (?, ?, ?, ?)";

		try (PreparedStatement stm = con.prepareStatement(slqInsert)) {
			stm.setInt(1, material.getIdMateriais());
			stm.setString(2, material.getNome());
			stm.setInt(3, material.getQuantidade());
			stm.setInt(4, material.getLimite());
			
			stm.execute();
		}
	}

	public void alterar(Material material) throws SQLException {
		String sqlUpdate = "update material set quantidade = ?, limite = ? where id_material = ?";

		try (PreparedStatement stm = con.prepareStatement(sqlUpdate)) {
			stm.setInt(1, material.getQuantidade());
			stm.setInt(2, material.getLimite());
			stm.setInt(3, material.getIdMateriais());
			

			stm.execute();
		}
	}
	
	public void alterarPreco(Material material) throws SQLException {
		String sql = "update material set preco = ? where id_material = ?";
		
		try(PreparedStatement stm = con.prepareStatement(sql)){
			stm.setDouble(1, material.getPreco());
			stm.setInt(2, material.getIdMateriais());
			
			stm.execute();
		}
	}

	public void excluir(Material material) throws SQLException {
		String sqlDelete = "delete from material where id_material = ?";

		try (PreparedStatement stm = con.prepareStatement(sqlDelete)) {
			stm.setInt(1, material.getIdMateriais());

			stm.execute();
		}
	}

	public List<Material> carregar() throws SQLException {
		List<Material> materiais = new ArrayList<>();
		String sqlSelect = "select * from material";

		try (PreparedStatement stm = con.prepareStatement(sqlSelect)) {
			stm.execute();
			transformaResultadosEmMateriais(materiais, stm);
			return materiais;
		}
	}

	private void transformaResultadosEmMateriais(List<Material> materiais, PreparedStatement stm) throws SQLException {

		try (ResultSet rs = stm.getResultSet()) {
			while (rs.next()) {
				int idMaterial = rs.getInt("id");
				String nome = rs.getString("nome");
				int quantidade = rs.getInt("quantidade");
				int limite = rs.getInt("limite");
				double preco = rs.getDouble("preco");
				
				Material material = new Material(idMaterial, nome, quantidade, limite, preco);
				materiais.add(material);
			}
		}
	}
	
	public double carregarPreco(int id) throws SQLException {
		double preco = 0;
		String sql = "select preco from material where id_material = ?";
		try(PreparedStatement stm = con.prepareStatement(sql)){
			stm.setInt(1, id);
			try(ResultSet rs = stm.executeQuery()){
				if(rs != null) {
					while(rs.next()) {
						preco = rs.getDouble(1);
					}
				}
			}
		}
		return preco;
	}
	
	public int carregarQuantidade(int id) {
		int quantidade = 0;
		String sql = "select quantidade from material where id_material = ?";

		PreparedStatement stm = null;
		ResultSet rs = null;
		try {
			stm = con.prepareStatement(sql);
			stm.setInt(1, id);
			rs = stm.executeQuery();
			
			if(rs != null) {
				while(rs.next()) {
					quantidade = rs.getInt(1);
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				System.out.println(e1.getStackTrace());
			}
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e1) {
					System.out.println(e1.getStackTrace());
				}
			}
			if(stm != null) {
				try {
					stm.close();
				} catch(SQLException e1) {
					System.out.println(e1.getStackTrace());
				}
			}
		}
		return quantidade;
		
			
	}
}
