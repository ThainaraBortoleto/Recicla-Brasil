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
		String slqInsert = "insert into coletor (id, nome, apelido) values (?, ?, ?)";

		try (PreparedStatement stm = con.prepareStatement(slqInsert)) {
			stm.setInt(1, coletor.getIdColetor());
			stm.setString(2, coletor.getNome());
			stm.setString(3, coletor.getApelido());
			stm.execute();
		}
	}

	public void alterar(Coletor coletor) throws SQLException {
		String sqlUpdate = "update coletor set nome = ?, apelido = ? when id = ?";

		try (PreparedStatement stm = con.prepareStatement(sqlUpdate)) {
			stm.setString(1, coletor.getNome());
			stm.setString(2, coletor.getApelido());
			stm.setInt(3, coletor.getIdColetor());

			stm.execute();
		}
	}

	public void excluir(Coletor coletor) throws SQLException {
		String sqlDelete = "delete from coletor where id = ?";

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
				int idColetor = rs.getInt("id");
				String nome = rs.getString("nome");
				String apelido = rs.getString("apelido");
				Coletor coletor = new Coletor(idColetor);
				coletor.setNome(nome);
				coletor.setApelido(apelido);
				coletores.add(coletor);
			}
		}
	}
}
