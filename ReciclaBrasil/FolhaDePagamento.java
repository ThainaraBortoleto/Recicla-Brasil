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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FolhaDePagamento extends JFrame {
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

	private JTextField txtSacar;

	private JLabel lblIncio, lblPainelDeControle, lblCopyRight, lblDesenvolvedores;
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu menuHome, menuColetor, menuEmpresa, menuAjustarValores, menuSair;
	private JMenuItem pagInicial, cadastrarColetor, consultarColetor, cadastrarEmpresa, consultarEmpresa, ajusteValor,
			sair;
	private JPanel panelBody, panelRodape, panelTituloHistorico;
	private JButton recebMaterialButton, folhaPagButton, histDeTransacoesButton, editCadastroButton, sacarButton;
	private Observador observador;
	private ColetorDAO cDao;
	private Coletor c1; 

	public FolhaDePagamento() throws SQLException{
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
			lblIncio = new JLabel("Início");
			lblIncio.setForeground(Color.DARK_GRAY);
			lblIncio.setFont(new Font("Lucida Grande", Font.BOLD, 18));
			lblIncio.setBounds(16, 6, 61, 25);
			panelBody.add(lblIncio);
			
			lblPainelDeControle = new JLabel("Painel de Controle");
			lblPainelDeControle.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
			lblPainelDeControle.setForeground(Color.LIGHT_GRAY);
			lblPainelDeControle.setBounds(75, 12, 111, 16);
			panelBody.add(lblPainelDeControle);
			
			// Histórico de Transações
			
			lblColetor = new JLabel("Coletor");
			lblColetor.setForeground(Color.BLACK);
			lblColetor.setFont(new Font("Lucida Grande", Font.BOLD, 18));
			lblColetor.setBounds(200, 20, 200, 300);
			panelBody.add(lblColetor);
			
			cDao = new ColetorDAO(con);
			c1 = new Coletor(2);
			
			lblNome = new JLabel("Nome: " + cDao.getNome(2));
			lblNome.setForeground(Color.BLACK);
			lblNome.setBounds(200, 30, 200, 370);
			lblNome.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
			panelBody.add(lblNome);
			
			lblTotalEmConta = new JLabel("Total em Conta:");
			lblTotalEmConta.setForeground(Color.BLACK);
			lblTotalEmConta.setBounds(690, 30, 600, 380);
			lblTotalEmConta.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
			panelBody.add(lblTotalEmConta);
			
			
			lblTotalValor = new JLabel(String.format("R$ %.2f", cDao.getSaldo(c1)));
			lblTotalValor.setForeground(Color.DARK_GRAY);
			lblTotalValor.setBounds(800, 30, 620, 380);
			lblTotalValor.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
			panelBody.add(lblTotalValor);
			
			recebMaterialButton = new JButton("Recebimento de Materiais");
			recebMaterialButton.setForeground(Color.BLACK);
			recebMaterialButton.setBackground(new Color(248, 248, 255));
			recebMaterialButton.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
			recebMaterialButton.setBounds(200, 300, 200, 20);
			panelBody.add(recebMaterialButton);
			
			folhaPagButton = new JButton("Folha de Pagamento");
			folhaPagButton.setForeground(Color.BLACK);
			folhaPagButton.setBackground(new Color(248, 248, 255));
			folhaPagButton.setFont(new Font("Lucida Grande", Font.BOLD, 12));
			folhaPagButton.setBounds(400, 300, 200, 20);
			panelBody.add(folhaPagButton);
			
			histDeTransacoesButton = new JButton("Histórico de Transações");
			histDeTransacoesButton.setForeground(Color.BLACK);
			histDeTransacoesButton.setBackground(new Color(248, 248, 255));
			histDeTransacoesButton.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
			histDeTransacoesButton.setBounds(600, 300, 200, 20);
			panelBody.add(histDeTransacoesButton);
			
			editCadastroButton = new JButton("Editar Cadastro");
			editCadastroButton.setForeground(Color.BLACK);
			editCadastroButton.setBackground(new Color(248, 248, 255));
			editCadastroButton.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
			editCadastroButton.setBounds(800, 300, 200, 20);
			panelBody.add(editCadastroButton);
			
			lblCodigoNegrito = new JLabel("Código");
			lblCodigoNegrito.setForeground(Color.BLACK);
			lblCodigoNegrito.setFont(new Font("Lucida Grande", Font.BOLD, 14));
			lblCodigoNegrito.setBounds(200, 200, 200, 300);
			panelBody.add(lblCodigoNegrito);
			
			lblNomeNegrito = new JLabel("Material");
			lblNomeNegrito.setForeground(Color.BLACK);
			lblNomeNegrito.setFont(new Font("Lucida Grande", Font.BOLD, 14));
			lblNomeNegrito.setBounds(400, 200, 200, 300);
			panelBody.add(lblNomeNegrito);
			
			lblPesoNegrito = new JLabel("Peso");
			lblPesoNegrito.setForeground(Color.BLACK);
			lblPesoNegrito.setFont(new Font("Lucida Grande", Font.BOLD, 14));
			lblPesoNegrito.setBounds(600, 200, 200, 300);
			panelBody.add(lblPesoNegrito);
			
			lblDinheiroNegrito = new JLabel("R$ por kg");
			lblDinheiroNegrito.setForeground(Color.BLACK);
			lblDinheiroNegrito.setFont(new Font("Lucida Grande", Font.BOLD, 14));
			lblDinheiroNegrito.setBounds(800, 200, 200, 300);
			panelBody.add(lblDinheiroNegrito);
			
			MaterialDAO mDAO = new MaterialDAO(con);
			// Primeira Linha
			lblUm = new JLabel("1");
			lblUm.setForeground(Color.BLACK);
			lblUm.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
			lblUm.setBounds(200, 250, 200, 300);
			panelBody.add(lblUm);
			
			lblJose = new JLabel("" + mDAO.getNome(1));
			lblJose.setForeground(Color.BLACK);
			lblJose.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
			lblJose.setBounds(400, 250, 200, 300);
			panelBody.add(lblJose);
			
			lblQuatro = new JLabel("4");
			lblQuatro.setForeground(Color.BLACK);
			lblQuatro.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
			lblQuatro.setBounds(600, 250, 200, 300);
			panelBody.add(lblQuatro);
			
			lblQuatorze = new JLabel(String.format("%.2f", mDAO.carregarPreco(1)));
			lblQuatorze.setForeground(Color.BLACK);
			lblQuatorze.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
			lblQuatorze.setBounds(800, 250, 200, 300);
			panelBody.add(lblQuatorze);
			
			// Segunda Linha
			lblDois = new JLabel("2");
			lblDois.setForeground(Color.BLACK);
			lblDois.setFont(new Font("Arial", Font.PLAIN, 12));
			lblDois.setBounds(200, 250, 200, 350);
			panelBody.add(lblDois);
			
			lblAlex = new JLabel("" + mDAO.getNome(2));
			lblAlex.setForeground(Color.BLACK);
			lblAlex.setFont(new Font("Arial", Font.PLAIN, 12));
			lblAlex.setBounds(400, 250, 200, 350);
			panelBody.add(lblAlex);
			
			lblCinco = new JLabel("5");
			lblCinco.setForeground(Color.BLACK);
			lblCinco.setFont(new Font("Arial", Font.PLAIN, 12));
			lblCinco.setBounds(600, 250, 200, 350);
			panelBody.add(lblCinco);
			
			lblQuinze = new JLabel(String.format("%.2f",  mDAO.carregarPreco(2)));
			lblQuinze.setForeground(Color.BLACK);
			lblQuinze.setFont(new Font("Arial", Font.PLAIN, 12));
			lblQuinze.setBounds(800, 250, 200, 350);
			panelBody.add(lblQuinze);
			
			// Terceira Linha
			lblTres = new JLabel("3");
			lblTres.setForeground(Color.BLACK);
			lblTres.setFont(new Font("Arial", Font.PLAIN, 12));
			lblTres.setBounds(200, 250, 200, 400);
			panelBody.add(lblTres);
			
			lblJuninho = new JLabel("" + mDAO.getNome(4));
			lblJuninho.setForeground(Color.BLACK);
			lblJuninho.setFont(new Font("Arial", Font.PLAIN, 12));
			lblJuninho.setBounds(400, 250, 200, 400);
			panelBody.add(lblJuninho);
			
			lblCincoPonto = new JLabel("5.5");
			lblCincoPonto.setForeground(Color.BLACK);
			lblCincoPonto.setFont(new Font("Arial", Font.PLAIN, 12));
			lblCincoPonto.setBounds(600, 250, 200, 400);
			panelBody.add(lblCincoPonto);
			
			lblVinteEQuatro = new JLabel(String.format("%.2f",  mDAO.carregarPreco(4)));
			lblVinteEQuatro.setForeground(Color.BLACK);
			lblVinteEQuatro.setFont(new Font("Arial", Font.PLAIN, 12));
			lblVinteEQuatro.setBounds(800, 250, 200, 400);
			panelBody.add(lblVinteEQuatro);
			
			// Quarta Linha
			lblQuatroKleber = new JLabel("4");
			lblQuatroKleber.setForeground(Color.BLACK);
			lblQuatroKleber.setFont(new Font("Arial", Font.PLAIN, 12));
			lblQuatroKleber.setBounds(200, 250, 200, 450);
			panelBody.add(lblQuatroKleber);
			
			lblKleber = new JLabel("" + mDAO.getNome(3));
			lblKleber.setForeground(Color.BLACK);
			lblKleber.setFont(new Font("Arial", Font.PLAIN, 12));
			lblKleber.setBounds(400, 250, 200, 450);
			panelBody.add(lblKleber);
			
			lblSeis = new JLabel("6");
			lblSeis.setForeground(Color.BLACK);
			lblSeis.setFont(new Font("Arial", Font.PLAIN, 12));
			lblSeis.setBounds(600, 250, 200, 450);
			panelBody.add(lblSeis);
			
			lblQuinzeKleber = new JLabel(String.format("%.2f",  mDAO.carregarPreco(3)));
			lblQuinzeKleber.setForeground(Color.BLACK);
			lblQuinzeKleber.setFont(new Font("Arial", Font.PLAIN, 12));
			lblQuinzeKleber.setBounds(800, 250, 200, 450);
			panelBody.add(lblQuinzeKleber);
			
			
			sacarButton = new JButton("Sacar");
			sacarButton.setForeground(Color.BLACK);
			sacarButton.setBackground(new Color(100, 30, 200));
			sacarButton.setBounds(900, 550, 100, 30);
			panelBody.add(sacarButton);
			
			txtSacar = new JTextField("Digite o valor para sacar", 100);
			txtSacar.setBounds(700, 550, 190, 30);
			panelBody.add(txtSacar);
			
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
			sacarButton.addActionListener(observador);
			histDeTransacoesButton.addActionListener(observador);
			recebMaterialButton.addActionListener(observador);
		}

	}

	class Observador implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try(Connection con = new ConexaoBD().conectar()){
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
				} else if(e.getSource() == recebMaterialButton) {
					try {
						new ColetorRecebimentoMaterial();
						dispose();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}else if(e.getSource() == histDeTransacoesButton) {
					try {
						new HistoricoDeTransacoes();
						dispose();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}else if(e.getSource() == sacarButton) {
					double valor = Double.parseDouble(txtSacar.getText());
					cDao = new ColetorDAO(con);
					if(cDao.getSaldo(c1) > 0) {
						cDao.sacar(c1, valor);
						lblTotalValor.setText(String.format("R$ %.2f", cDao.getSaldo(c1)));
						txtSacar.setText("");
						
						JOptionPane.showMessageDialog(null, "Sacado com sucesso");
					} else {
						JOptionPane.showMessageDialog(null, "Saldo insuficiente");
					}
				}else if(e.getSource() == editCadastroButton) {
					try {
						new EditarCadastro();
						dispose();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}else {
					new TelaLogin();
					dispose();
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
}
