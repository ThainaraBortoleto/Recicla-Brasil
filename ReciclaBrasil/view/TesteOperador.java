import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TesteOperador {
	//main com a exception
	public static void main(String[] args) throws SQLException{
		//try com a conexao para não precisar fechar depois
		try(Connection con = new ConexaoBD().conectar()){
			//Passando a conexao para a classe que manipula o banco
			OperadorDAO operadorDao = new OperadorDAO(con);
			
			//Criando o Objeto Operador
			Operador operador = new Operador(1);
			operador.setNome("Teste");
			operador.setSobrenome("teste");
			operador.setDataDeNascimento("13/11/2017");
			operador.setCpf("xxx.xxx.xxx/xx");
			
			//Inserir
			operadorDao.inserir(operador);
			System.out.println("inserido com sucesso");
			
			//Listando todos operadores
			List<Operador> operadores = operadorDao.carregar();
			for(Operador operador1 : operadores) {
				System.out.println(operador1);
			}
			
			//Excluindo operador
			operadorDao.excluir(operador);
			
		}
	}
}
