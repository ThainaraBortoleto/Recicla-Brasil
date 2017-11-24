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

public class EditarCadastroEmpresa extends JFrame {
	private JLabel lblColetor, lblNome, lblTotalEmConta, lblTotalValor;

	// variáveis Editar Cadastro
	private JLabel lblEditar, lblNomeCadastro, lblRazaoSocial, lblTelefone, lblCep, lblEndereco, lblEmail, lblNomeResponsavel;
	private JTextField txtNome, txtRazaoSocial, txtEmail, txtEndereco, txtCep, txtTelefone, txtNomeResponsavel;
	private JButton excluirButton, novaDigitalButton, salvarButton;

	private JLabel lblIncio, lblPainelDeControle, lblCopyRight, lblDesenvolvedores;
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu menuHome, menuColetor, menuEmpresa, menuAjustarValores, menuSair;
	private JMenuItem pagInicial, cadastrarColetor, consultarColetor, cadastrarEmpresa, consultarEmpresa, ajusteValor,
			sair;
	private JPanel panelBody, panelRodape;
	private JButton compraMaterialButton, folhaPagButton, histDeTransacoesButton, editCadastroButton;
	private Observador observador;
	private EmpresaDAO eDao;
	private Empresa e1;

	public EditarCadastroEmpresa() throws SQLException {
		super("ReciclaBrasil");
		try(Connection con = new ConexaoBD().conectar()){
			
			// deixando em fullsize
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
			e1 = new Empresa();
			e1.setIdEmpresa(1);
			
			lblNome = new JLabel("Nome: " + eDao.getNome(1));
			lblNome.setForeground(Color.BLACK);
			lblNome.setBounds(200, 30, 200, 370);
			lblNome.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
			panelBody.add(lblNome);
			
			lblTotalEmConta = new JLabel("Valor a pagar:");
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
			histDeTransacoesButton.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
			histDeTransacoesButton.setBounds(600, 300, 200, 20);
			panelBody.add(histDeTransacoesButton);
			
			editCadastroButton = new JButton("Editar Cadastro");
			editCadastroButton.setForeground(Color.BLACK);
			editCadastroButton.setBackground(new Color(248, 248, 255));
			editCadastroButton.setFont(new Font("Lucida Grande", Font.BOLD, 12));
			editCadastroButton.setBounds(800, 300, 200, 20);
			panelBody.add(editCadastroButton);
			
			// Campo Editar Cadastro
			
			lblEditar = new JLabel("Editar Cadastro");
			lblEditar.setForeground(Color.BLACK);
			lblEditar.setBounds(200, 20, 200, 700);
			lblEditar.setFont(new Font("Lucida Grande", Font.BOLD, 16));
			panelBody.add(lblEditar);
			
			lblNomeCadastro = new JLabel("Nome");
			lblNomeCadastro.setForeground(Color.BLACK);
			lblNomeCadastro.setBounds(320, 20, 600, 750);
			lblNomeCadastro.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
			panelBody.add(lblNomeCadastro);
			
			lblRazaoSocial = new JLabel("Razão Social");
			lblRazaoSocial.setForeground(Color.BLACK);
			lblRazaoSocial.setBounds(280, 20, 600, 800);
			lblRazaoSocial.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
			panelBody.add(lblRazaoSocial);
			
			lblTelefone = new JLabel("Telefone");
			lblTelefone.setForeground(Color.BLACK);
			lblTelefone.setBounds(300, 46, 600, 800);
			lblTelefone.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
			panelBody.add(lblTelefone);
			
			lblCep = new JLabel("CEP");
			lblCep.setForeground(Color.BLACK);
			lblCep.setBounds(325, 71, 600, 800);
			lblCep.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
			panelBody.add(lblCep);

			lblEndereco = new JLabel("Endereço");
			lblEndereco.setForeground(Color.BLACK);
			lblEndereco.setBounds(297, 97, 600, 800);
			lblEndereco.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
			panelBody.add(lblEndereco);

			lblEmail = new JLabel("Email");
			lblEmail.setForeground(Color.BLACK);
			lblEmail.setBounds(320, 125, 600, 800);
			lblEmail.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
			panelBody.add(lblEmail);

			lblNomeResponsavel = new JLabel("Nome do Responsável");
			lblNomeResponsavel.setForeground(Color.BLACK);
			lblNomeResponsavel.setBounds(220, 153, 600, 800);
			lblNomeResponsavel.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
			panelBody.add(lblNomeResponsavel);
			
			txtNome = new JTextField(30);
			txtNome.setForeground(Color.GRAY);
			txtNome.setBounds(370, 386, 632, 20);
			txtNome.setBackground(new Color(248, 248, 255));
			txtNome.setFont(new Font("Arial", Font.ITALIC, 12));
			panelBody.add(txtNome);
			
			txtRazaoSocial = new JTextField(30);
			txtRazaoSocial.setForeground(Color.GRAY);
			txtRazaoSocial.setBounds(370, 411, 632, 20);
			txtRazaoSocial.setBackground(new Color(248, 248, 255));
			txtRazaoSocial.setFont(new Font("Arial", Font.ITALIC, 12));
			panelBody.add(txtRazaoSocial);

			txtTelefone = new JTextField(30);
			txtTelefone.setForeground(Color.GRAY);
			txtTelefone.setBounds(370, 437, 632, 20);
			txtTelefone.setBackground(new Color(248, 248, 255));
			txtTelefone.setFont(new Font("Arial", Font.ITALIC, 12));
			panelBody.add(txtTelefone);

			txtCep = new JTextField(30);
			txtCep.setForeground(Color.GRAY);
			txtCep.setBounds(370, 462, 632, 20);
			txtCep.setBackground(new Color(248, 248, 255));
			txtCep.setFont(new Font("Arial", Font.ITALIC, 12));
			panelBody.add(txtCep);

			txtEndereco = new JTextField(30);
			txtEndereco.setForeground(Color.GRAY);
			txtEndereco.setBounds(370, 488, 632, 20);
			txtEndereco.setBackground(new Color(248, 248, 255));
			txtEndereco.setFont(new Font("Arial", Font.ITALIC, 12));
			panelBody.add(txtEndereco);

			txtEmail = new JTextField(30);
			txtEmail.setForeground(Color.GRAY);
			txtEmail.setBounds(370, 515, 632, 20);
			txtEmail.setBackground(new Color(248, 248, 255));
			txtEmail.setFont(new Font("Arial", Font.ITALIC, 12));
			panelBody.add(txtEmail);

			txtNomeResponsavel = new JTextField(30);
			txtNomeResponsavel.setForeground(Color.GRAY);
			txtNomeResponsavel.setBounds(370, 542, 632, 20);
			txtNomeResponsavel.setBackground(new Color(248, 248, 255));
			txtNomeResponsavel.setFont(new Font("Arial", Font.ITALIC, 12));
			panelBody.add(txtNomeResponsavel);
			
			excluirButton = new JButton("Excluir");
			excluirButton.setForeground(Color.BLACK);
			excluirButton.setBackground(new Color(248, 10, 10));
			excluirButton.setBounds(200, 600, 90, 20);
			panelBody.add(excluirButton);
			
			
			salvarButton = new JButton("Salvar");
			salvarButton.setForeground(Color.BLACK);
			salvarButton.setBackground(new Color(141, 219, 85));
			salvarButton.setBounds(915, 600, 90, 20);
			panelBody.add(salvarButton);
			
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
			setLocationRelativeTo(null);
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
			salvarButton.addActionListener(observador);
			excluirButton.addActionListener(observador);
			histDeTransacoesButton.addActionListener(observador);
			folhaPagButton.addActionListener(observador);
			compraMaterialButton.addActionListener(observador);
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
				}else if(e.getSource() == compraMaterialButton) {
					try {
						new CompraMaterial();
						dispose();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}else if(e.getSource() == salvarButton) {
					eDao = new EmpresaDAO(con);
					
					String novoNome = txtNome.getText();
					String razaoSocial = txtRazaoSocial.getText();
					String novoCep = txtCep.getText();
					String novoEndereco = txtEndereco.getText();
					String novoTelefone = txtTelefone.getText();
					String novoEmail = txtEmail.getText();
					String novoResponsavel = txtNomeResponsavel.getText();
					
					e1.setNome(novoNome);
					e1.setRazaoSocial(razaoSocial);
					e1.setCep(novoCep);
					e1.setEndereco(novoEndereco);
					e1.setTelefone(novoTelefone);
					e1.setEmail(novoEmail);
					e1.setNomeResponsavel(novoResponsavel);
					
					eDao.alterar(e1);
					lblNome.setText("Nome: " + eDao.getNome(1));
					
					JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
				}else if(e.getSource() == excluirButton) {
					eDao = new EmpresaDAO(con);
					eDao.excluir(e1);
					
					JOptionPane.showMessageDialog(null, "Excluido com sucesso");
				}else{
					new TelaLogin();
					dispose();
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
}
