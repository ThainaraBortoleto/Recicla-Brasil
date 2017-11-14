import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class EditarCadastro extends JFrame {
	private JLabel lblColetor, lblNome, lblTotalEmConta, lblTotalValor;

	// variáveis Editar Cadastro
	private JLabel lblEditar, lblNomeCadastro, lblApelido;
	private JTextField txtNome, txtApelido;
	private JButton cancelarButton, novaDigitalButton, salvarButton;

	private JLabel lblIncio, lblPainelDeControle, lblCopyRight, lblDesenvolvedores;
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu menuHome, menuColetor, menuEmpresa, menuAjustarValores, menuSair;
	private JMenuItem pagInicial, cadastrarColetor, consultarColetor, cadastrarEmpresa, consultarEmpresa, ajusteValor,
			sair;
	private JPanel panelBody, panelRodape;
	private JButton recebMaterialButton, folhaPagButton, histDeTransacoesButton, editCadastroButton;
	private Observador observador;

	public EditarCadastro() {
		super("ReciclaBrasil");

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
		lblIncio = new JLabel("Coletor");
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

		lblColetor = new JLabel("Coletor");
		lblColetor.setForeground(Color.BLACK);
		lblColetor.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		lblColetor.setBounds(200, 20, 200, 300);
		panelBody.add(lblColetor);

		lblNome = new JLabel("Nome");
		lblNome.setForeground(Color.BLACK);
		lblNome.setBounds(200, 30, 200, 370);
		lblNome.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		panelBody.add(lblNome);

		lblTotalEmConta = new JLabel("Total em Conta:");
		lblTotalEmConta.setForeground(Color.BLACK);
		lblTotalEmConta.setBounds(690, 30, 600, 380);
		lblTotalEmConta.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		panelBody.add(lblTotalEmConta);

		lblTotalValor = new JLabel("44,90 reais");
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

		lblApelido = new JLabel("Apelido");
		lblApelido.setForeground(Color.BLACK);
		lblApelido.setBounds(320, 20, 600, 800);
		lblApelido.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		panelBody.add(lblApelido);

		txtNome = new JTextField(30);
		txtNome.setForeground(Color.GRAY);
		txtNome.setBounds(370, 386, 632, 20);
		txtNome.setBackground(new Color(248, 248, 255));
		txtNome.setFont(new Font("Arial", Font.ITALIC, 12));
		panelBody.add(txtNome);

		txtApelido = new JTextField(30);
		txtApelido.setForeground(Color.GRAY);
		txtApelido.setBounds(370, 411, 632, 20);
		txtApelido.setBackground(new Color(248, 248, 255));
		txtNome.setFont(new Font("Arial", Font.ITALIC, 12));
		panelBody.add(txtApelido);

		cancelarButton = new JButton("Cancelar");
		cancelarButton.setForeground(Color.BLACK);
		cancelarButton.setBackground(new Color(248, 10, 10));
		cancelarButton.setBounds(200, 600, 90, 20);
		panelBody.add(cancelarButton);

		novaDigitalButton = new JButton("<html>Nova<br /> Digital</html>");
		novaDigitalButton.setForeground(Color.BLACK);
		novaDigitalButton.setBackground(new Color(20, 30, 255));
		novaDigitalButton.setBounds(550, 450, 119, 85);
		panelBody.add(novaDigitalButton);

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
		novaDigitalButton.addActionListener(observador);
		histDeTransacoesButton.addActionListener(observador);
		folhaPagButton.addActionListener(observador);
		recebMaterialButton.addActionListener(observador);

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
				new ColetorRecebimentoMaterial();
				dispose();
			} else if (e.getSource() == cadastrarEmpresa) {
				new CadastrarEmpresa();
				dispose();
			} else if (e.getSource() == consultarEmpresa) {
				new ConsultarEmpresa1();
				dispose();
			} else if (e.getSource() == ajusteValor) {
				try {
					new AjusteValor();
					dispose();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}else if(e.getSource() == histDeTransacoesButton) {
				new HistoricoDeTransacoes();
				dispose();
			}else if(e.getSource() == folhaPagButton) {
				new FolhaDePagamento();
				dispose();
			}else if(e.getSource() == recebMaterialButton) {
				new ColetorRecebimentoMaterial();
				dispose();
			}else if(e.getSource() == salvarButton) {
				System.out.println("Salvo com sucesso");
			}else if(e.getSource() == novaDigitalButton) {
				JOptionPane.showMessageDialog(null, "Pressione a digital no leitor Biométrico");
				JOptionPane.showMessageDialog(null, "Digital cadastrada com sucesso");
			}else {
				new TelaLogin();
				dispose();
			}
		}

	}
}
