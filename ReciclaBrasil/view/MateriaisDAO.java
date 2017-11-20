import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MateriaisDAO {
	private Connection con;
	
	public MateriaisDAO(Connection con) {
		this.con = con;
	}
	
	public void inserir(Materiais material) throws SQLException {
		String slqInsert = "insert into materiais (id, nome, quantidade, limite) values (?, ?, ?, ?)";

		try (PreparedStatement stm = con.prepareStatement(slqInsert)) {
			stm.setInt(1, material.getIdMateriais());
			stm.setString(2, material.getNome());
			stm.setInt(3, material.getQuantidade());
			stm.setInt(4, material.getLimite());
			
			stm.execute();
		}
	}

	public void alterar(Materiais material) throws SQLException {
		String sqlUpdate = "update materias set quantidade = ?, limite = ? where id = ?";

		try (PreparedStatement stm = con.prepareStatement(sqlUpdate)) {
			stm.setInt(1, material.getQuantidade());
			stm.setInt(2, material.getLimite());
			stm.setInt(3, material.getIdMateriais());
			

			stm.execute();
		}
	}
	
	public void alterarPreco(Materiais material) throws SQLException {
		String sql = "update materiais set preco = ? where id = ?";
		
		try(PreparedStatement stm = con.prepareStatement(sql)){
			stm.setDouble(1, material.getPreco());
			stm.setInt(2, material.getIdMateriais());
			
			stm.execute();
		}
	}

	public void excluir(Materiais material) throws SQLException {
		String sqlDelete = "delete from materiais where id = ?";

		try (PreparedStatement stm = con.prepareStatement(sqlDelete)) {
			stm.setInt(1, material.getIdMateriais());

			stm.execute();
		}
	}

	public List<Materiais> carregar() throws SQLException {
		List<Materiais> materiais = new ArrayList<>();
		String sqlSelect = "select * from materiais";

		try (PreparedStatement stm = con.prepareStatement(sqlSelect)) {
			stm.execute();
			transformaResultadosEmMateriais(materiais, stm);
			return materiais;
		}
	}

	private void transformaResultadosEmMateriais(List<Materiais> materiais, PreparedStatement stm) throws SQLException {

		try (ResultSet rs = stm.getResultSet()) {
			while (rs.next()) {
				int idMaterial = rs.getInt("id");
				String nome = rs.getString("nome");
				int quantidade = rs.getInt("quantidade");
				int limite = rs.getInt("limite");
				double preco = rs.getDouble("preco");
				
				Materiais material = new Materiais(idMaterial, nome, quantidade, limite, preco);
				materiais.add(material);
			}
		}
	}
	
	public double carregarPreco(int id) throws SQLException {
		double preco = 0;
		String sql = "select preco from materiais where id = ?";
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
		String sql = "select quantidade from materiais where id = ?";

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
