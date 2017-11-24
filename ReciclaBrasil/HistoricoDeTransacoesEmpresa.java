import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class HistoricoDeTransacoesEmpresa extends JFrame {
	private JLabel lblColetor, lblNome, lblTotalEmConta, lblTotalValor;
	// variáveis em negrito
	private JLabel lblCodigoNegrito, lblMaterialNegrito, lblNomeNegrito, lblPesoNegrito, lblDinheiroNegrito;
	// variáveis primeira linha
	private JLabel lblUm, lblAluminio, lblJose, lblQuatro, lblQuatorze;
	// variáveis segunda linha
	private JLabel lblDois, lblPapel, lblAlex, lblCinco, lblQuinze;
	// variáveis terceira linha
	private JLabel lblTres, lblVidro, lblJuninho, lblCincoPonto, lblVinteEQuatro;
	// variáveis quarta linha
	private JLabel lblQuatroKleber, lblPlastico, lblKleber, lblSeis, lblQuinzeKleber;
	// variáveis quinta linha
	private JLabel lblCincoNascimento, lblVidroNascimento, lblNascimento, lblSete, lblTrintaEUm;
	// variáveis sexta linha
	private JLabel lblSeisLima, lblPlasticoLima, lblLima, lblSeisLimaPeso, lblQuinzeLima;

	private JLabel lblIncio, lblPainelDeControle, lblCopyRight, lblDesenvolvedores;
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu menuHome, menuColetor, menuEmpresa, menuAjustarValores, menuSair;
	private JMenuItem pagInicial, cadastrarColetor, consultarColetor, cadastrarEmpresa, consultarEmpresa, ajusteValor,
			sair;
	private JPanel panelBody, panelRodape, panelTituloHistorico;
	private JButton compraMaterialButton, folhaPagButton, histDeTransacoesButton, editCadastroButton;
	private Observador observador;
	private EmpresaDAO eDao;
	private MaterialDAO mDao;
	private Empresa e1; 

	public HistoricoDeTransacoesEmpresa() throws SQLException{
		super("ReciclaBrasil");
		try(Connection con = new ConexaoBD().conectar()){
			
			Toolkit tk = Toolkit.getDefaultToolkit();
			int xsize = (int) tk.getScreenSize().getWidth();
			int ysize = (int) tk.getScreenSize().getHeight();
			this.setSize(xsize, ysize);
			
			menuBar = new JMenuBar();
			menuBar.setBackground(Color.LIGHT_GRAY);
			setJMenuBar(menuBar);
			
			menuHome = new JMenu("Home");
			menuBar.add(menuHome);
			
			pagInicial = new JMenuItem("Página Inicial");
			menuHome.add(pagInicial);
			
			menuColetor = new JMenu("Coletor");
			menuBar.add(menuColetor);
			
			cadastrarColetor = new JMenuItem("Cadastrar");
			menuColetor.add(cadastrarColetor);
			
			consultarColetor = new JMenuItem("Consultar");
			menuColetor.add(consultarColetor);
			
			menuEmpresa = new JMenu("Empresa");
			menuBar.add(menuEmpresa);
			
			cadastrarEmpresa = new JMenuItem("Cadastrar");
			menuEmpresa.add(cadastrarEmpresa);
			
			consultarEmpresa = new JMenuItem("Consultar");
			menuEmpresa.add(consultarEmpresa);
			
			menuAjustarValores = new JMenu("Ajustar Valores");
			menuBar.add(menuAjustarValores);
			
			ajusteValor = new JMenuItem("Ajustar valores");
			menuAjustarValores.add(ajusteValor);
			
			menuSair = new JMenu("Sair");
			menuBar.add(menuSair);
			
			sair = new JMenuItem("Sair");
			menuSair.add(sair);
			
			contentPane = new JPanel();
			contentPane.setBackground(Color.WHITE);
			contentPane.setLayout(new BorderLayout(0, 0));
			setContentPane(contentPane);
			
			panelBody = new JPanel();
			panelBody.setBackground(Color.WHITE);
			contentPane.add(panelBody, BorderLayout.CENTER);
			panelBody.setLayout(null);
			
			// Titulo
			lblIncio = new JLabel("Empresa");
			lblIncio.setForeground(Color.DARK_GRAY);
			lblIncio.setFont(new Font("Lucida Grande", Font.BOLD, 18));
			lblIncio.setBounds(16, 6, 91, 25);
			panelBody.add(lblIncio);
			
			lblPainelDeControle = new JLabel("Consultar");
			lblPainelDeControle.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
			lblPainelDeControle.setForeground(Color.LIGHT_GRAY);
			lblPainelDeControle.setBounds(95, 12, 111, 16);
			panelBody.add(lblPainelDeControle);
			
			// Histórico de Transações
			
			lblColetor = new JLabel("Empresa");
			lblColetor.setForeground(Color.BLACK);
			lblColetor.setFont(new Font("Lucida Grande", Font.BOLD, 18));
			lblColetor.setBounds(200, 20, 200, 300);
			panelBody.add(lblColetor);

			eDao = new EmpresaDAO(con);
			mDao = new MaterialDAO(con);
			e1 = new Empresa();
			e1.setIdEmpresa(1);
			
			lblNome = new JLabel("Nome: " + eDao.getNome(1));
			lblNome.setForeground(Color.BLACK);
			lblNome.setBounds(200, 30, 200, 370);
			lblNome.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
			panelBody.add(lblNome);
			
			lblTotalEmConta = new JLabel("Total em Conta:");
			lblTotalEmConta.setForeground(Color.BLACK);
			lblTotalEmConta.setBounds(690, 30, 600, 380);
			lblTotalEmConta.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
			panelBody.add(lblTotalEmConta);
			
			
			lblTotalValor = new JLabel(String.format("R$ %.2f", eDao.getValorAPagar(e1)));
			lblTotalValor.setForeground(Color.DARK_GRAY);
			lblTotalValor.setBounds(800, 30, 620, 380);
			lblTotalValor.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
			panelBody.add(lblTotalValor);
			
			compraMaterialButton = new JButton("Compra de Materiais");
			compraMaterialButton.setForeground(Color.BLACK);
			compraMaterialButton.setBackground(new Color(248, 248, 255));
			compraMaterialButton.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
			compraMaterialButton.setBounds(200, 300, 200, 20);
			panelBody.add(compraMaterialButton);
			
			folhaPagButton = new JButton("Folha de Pagamento");
			folhaPagButton.setForeground(Color.BLACK);
			folhaPagButton.setBackground(new Color(248, 248, 255));
			folhaPagButton.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
			folhaPagButton.setBounds(400, 300, 200, 20);
			panelBody.add(folhaPagButton);
			
			histDeTransacoesButton = new JButton("Histórico de Transações");
			histDeTransacoesButton.setForeground(Color.BLACK);
			histDeTransacoesButton.setBackground(new Color(248, 248, 255));
			histDeTransacoesButton.setFont(new Font("Lucida Grande", Font.BOLD, 12));
			histDeTransacoesButton.setBounds(600, 300, 200, 20);
			panelBody.add(histDeTransacoesButton);
			
			editCadastroButton = new JButton("Editar Cadastro");
			editCadastroButton.setForeground(Color.BLACK);
			editCadastroButton.setBackground(new Color(248, 248, 255));
			editCadastroButton.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
			editCadastroButton.setBounds(800, 300, 200, 20);
			panelBody.add(editCadastroButton);
			
			lblCodigoNegrito = new JLabel("Codigo");
			lblCodigoNegrito.setForeground(Color.BLACK);
			lblCodigoNegrito.setFont(new Font("Lucida Grande", Font.BOLD, 14));
			lblCodigoNegrito.setBounds(200, 200, 200, 300);
			panelBody.add(lblCodigoNegrito);
			
			lblMaterialNegrito = new JLabel("Material");
			lblMaterialNegrito.setForeground(Color.BLACK);
			lblMaterialNegrito.setFont(new Font("Lucida Grande", Font.BOLD, 14));
			lblMaterialNegrito.setBounds(400, 200, 200, 300);
			panelBody.add(lblMaterialNegrito);
			
			lblNomeNegrito = new JLabel("Nome");
			lblNomeNegrito.setForeground(Color.BLACK);
			lblNomeNegrito.setFont(new Font("Lucida Grande", Font.BOLD, 14));
			lblNomeNegrito.setBounds(600, 200, 200, 300);
			panelBody.add(lblNomeNegrito);
			
			lblPesoNegrito = new JLabel("Peso");
			lblPesoNegrito.setForeground(Color.BLACK);
			lblPesoNegrito.setFont(new Font("Lucida Grande", Font.BOLD, 14));
			lblPesoNegrito.setBounds(800, 200, 200, 300);
			panelBody.add(lblPesoNegrito);
			
			lblDinheiroNegrito = new JLabel("Valor");
			lblDinheiroNegrito.setForeground(Color.BLACK);
			lblDinheiroNegrito.setFont(new Font("Lucida Grande", Font.BOLD, 14));
			lblDinheiroNegrito.setBounds(970, 200, 200, 300);
			panelBody.add(lblDinheiroNegrito);
			
			
			
			// Primeira Linha
			lblUm = new JLabel("1");
			lblUm.setForeground(Color.BLACK);
			lblUm.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
			lblUm.setBounds(200, 250, 200, 300);
			panelBody.add(lblUm);
			
			lblAluminio = new JLabel("" + mDao.getNome(1));
			lblAluminio.setForeground(Color.BLACK);
			lblAluminio.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
			lblAluminio.setBounds(400, 250, 200, 300);
			panelBody.add(lblAluminio);
			
			lblJose = new JLabel("" + eDao.getNome(1));
			lblJose.setForeground(Color.BLACK);
			lblJose.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
			lblJose.setBounds(600, 250, 200, 300);
			panelBody.add(lblJose);
			
			lblQuatro = new JLabel("4");
			lblQuatro.setForeground(Color.BLACK);
			lblQuatro.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
			lblQuatro.setBounds(800, 250, 200, 300);
			panelBody.add(lblQuatro);
			
			lblQuatorze = new JLabel(String.format("%.2f", 4 * mDao.carregarPreco(1)));
			lblQuatorze.setForeground(Color.BLACK);
			lblQuatorze.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
			lblQuatorze.setBounds(970, 250, 200, 300);
			panelBody.add(lblQuatorze);
			
			// Segunda Linha
			lblDois = new JLabel("2");
			lblDois.setForeground(Color.BLACK);
			lblDois.setFont(new Font("Arial", Font.PLAIN, 12));
			lblDois.setBounds(200, 250, 200, 350);
			panelBody.add(lblDois);
			
			lblPapel = new JLabel("" + mDao.getNome(2));
			lblPapel.setForeground(Color.BLACK);
			lblPapel.setFont(new Font("Arial", Font.PLAIN, 12));
			lblPapel.setBounds(400, 250, 200, 350);
			panelBody.add(lblPapel);
			
			lblAlex = new JLabel("" + eDao.getNome(2));
			lblAlex.setForeground(Color.BLACK);
			lblAlex.setFont(new Font("Arial", Font.PLAIN, 12));
			lblAlex.setBounds(600, 250, 200, 350);
			panelBody.add(lblAlex);
			
			lblCinco = new JLabel("5");
			lblCinco.setForeground(Color.BLACK);
			lblCinco.setFont(new Font("Arial", Font.PLAIN, 12));
			lblCinco.setBounds(800, 250, 200, 350);
			panelBody.add(lblCinco);
			
			lblQuinze = new JLabel(String.format("%.2f", 5 * mDao.carregarPreco(2)));
			lblQuinze.setForeground(Color.BLACK);
			lblQuinze.setFont(new Font("Arial", Font.PLAIN, 12));
			lblQuinze.setBounds(970, 250, 200, 350);
			panelBody.add(lblQuinze);
			
			
			
			// RodapÃ©
			panelRodape = new JPanel();
			panelRodape.setBackground(Color.LIGHT_GRAY);
			contentPane.add(panelRodape, BorderLayout.SOUTH);
			
			lblCopyRight = new JLabel("© Copyright 2001-2017");
			lblCopyRight.setForeground(Color.WHITE);
			panelRodape.add(lblCopyRight);
			
			lblDesenvolvedores = new JLabel(
					"André Gianfratti, Arthur Grigoletto, Guilherme Araújo, Raul Machado, Thainara Bortoleto");
			lblDesenvolvedores.setForeground(Color.WHITE);
			lblDesenvolvedores.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
			panelRodape.add(lblDesenvolvedores);
			
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setVisible(true);
			
			// observador
			observador = new Observador();
			pagInicial.addActionListener(observador);
			cadastrarColetor.addActionListener(observador);
			consultarColetor.addActionListener(observador);
			cadastrarEmpresa.addActionListener(observador);
			consultarEmpresa.addActionListener(observador);
			ajusteValor.addActionListener(observador);
			sair.addActionListener(observador);
			editCadastroButton.addActionListener(observador);
			folhaPagButton.addActionListener(observador);
			compraMaterialButton.addActionListener(observador);
		}
	}

	class Observador implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == pagInicial) {
				try {
					new Home();
					dispose();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			} else if (e.getSource() == cadastrarColetor) {
				new CadastrarColetor();
				dispose();
			} else if (e.getSource() == consultarColetor) {
				try {
					new ColetorRecebimentoMaterial();
					dispose();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			} else if (e.getSource() == cadastrarEmpresa) {
				new CadastrarEmpresa();
				dispose();
			} else if (e.getSource() == consultarEmpresa) {
				try {
					new CompraMaterial();
					dispose();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			} else if (e.getSource() == ajusteValor) {
				try {
					new AjusteValor();
					dispose();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			} else if(e.getSource() == compraMaterialButton) {
				try {
					new CompraMaterial();
					dispose();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}else if(e.getSource() == histDeTransacoesButton) {
				try {
					new HistoricoDeTransacoesEmpresa();
					dispose();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}else if(e.getSource() == folhaPagButton) {
				try {
					new FolhaDePagamentoEmpresa();
					dispose();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}else if(e.getSource() == editCadastroButton) {
				try {
					new EditarCadastroEmpresa();
					dispose();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}else {
				new TelaLogin();
				dispose();
			}
		}
	}
}
