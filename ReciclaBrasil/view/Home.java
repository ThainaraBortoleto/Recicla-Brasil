import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

public class Home extends JFrame {
	private JPanel contentPane, panelBody, panelRodape;
	private JMenuBar menuBar;
	private JMenu menuHome, menuColetor, menuEmpresa, menuAjustarValores, menuSair;
	private JMenuItem pagInicial, cadastrarColetor, consultarColetor, cadastrarEmpresa, consultarEmpresa, ajusteValor,
			sair;
	private JLabel lblAluminio, lblPapelao, lblPlastico, lblVidro, lblTotalDeMaterial, lblIncio, lblPainelDeControle,
			lblAgenda, porcentagemAluminio, porcentagemPapelao, porcentagemPlastico, porcentagemVidro, lblNoveHoras,
			lblDezHoras, lblOnzeHoras, lblDozeHoras, lblTrezeHoras, lblQuatorzeHoras, lblQuinzeHoras, lblDezesseisHoras,
			lblDezeseteHoras, lblDezoitoHoras, lblEmpresaX, lblEmpresaY, lblEmpresaXy, lblEmpresaK, lblCopyRight,
			lblDesenvolvedores;
	private JTable agenda;
	private Observador observador;

	public Home() {
		super("ReciclaBrasil");
		
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
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
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

		// ProgressBar
		lblTotalDeMaterial = new JLabel("Total de Material");
		lblTotalDeMaterial.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		lblTotalDeMaterial.setBounds(485, 82, 186, 25);
		panelBody.add(lblTotalDeMaterial);

		JProgressBar progressBarAluminio = new JProgressBar();
		progressBarAluminio.setValue(55);
		progressBarAluminio.setBounds(284, 133, 579, 20);
		panelBody.add(progressBarAluminio);

		lblAluminio = new JLabel("Alumínio");
		lblAluminio.setBounds(154, 133, 61, 16);
		panelBody.add(lblAluminio);

		lblPapelao = new JLabel("Papelão");
		lblPapelao.setBounds(154, 161, 61, 16);
		panelBody.add(lblPapelao);

		lblPlastico = new JLabel("Plástico");
		lblPlastico.setBounds(154, 189, 61, 16);
		panelBody.add(lblPlastico);

		lblVidro = new JLabel("Vidro");
		lblVidro.setBounds(154, 217, 61, 16);
		panelBody.add(lblVidro);

		JProgressBar progressBarPapelao = new JProgressBar();
		progressBarPapelao.setValue(70);
		progressBarPapelao.setBounds(284, 157, 579, 20);
		panelBody.add(progressBarPapelao);

		JProgressBar progressBarPlastico = new JProgressBar();
		progressBarPlastico.setValue(30);
		progressBarPlastico.setBounds(284, 185, 579, 20);
		panelBody.add(progressBarPlastico);

		JProgressBar progressBarVidro = new JProgressBar();
		progressBarVidro.setValue(90);
		progressBarVidro.setBounds(284, 213, 579, 20);
		panelBody.add(progressBarVidro);

		porcentagemAluminio = new JLabel("55%");
		porcentagemAluminio.setBounds(916, 133, 61, 16);
		panelBody.add(porcentagemAluminio);

		porcentagemPapelao = new JLabel("70%");
		porcentagemPapelao.setBounds(916, 161, 61, 16);
		panelBody.add(porcentagemPapelao);

		porcentagemPlastico = new JLabel("30%");
		porcentagemPlastico.setBounds(916, 189, 61, 16);
		panelBody.add(porcentagemPlastico);

		porcentagemVidro = new JLabel("90%");
		porcentagemVidro.setBounds(916, 217, 61, 16);
		panelBody.add(porcentagemVidro);

		// Agenda
		lblAgenda = new JLabel("Agenda");
		lblAgenda.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		lblAgenda.setBounds(515, 450, 186, 25);
		panelBody.add(lblAgenda);
		
		String[] nomesColunas = {"Hora", "Empresa"};
		Object[][] data = {
				{"09:00", null},
				{"10:00", null},
				{"11:00", null},
				{"12:00", null},
				{"13:00", null},
				{"14:00", null},
				{"15:00", null},
				{"16:00", null},
				{"17:00", null},
				{"18:00", null}
				
		};
		agenda = new JTable(data, nomesColunas);
		JScrollPane scrollPane = new JScrollPane(agenda);
		scrollPane.setBounds(323, 500, 463, 190);
		panelBody.add(scrollPane);
		
		
		

		// Rodapé
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
		
		

	}
	
	class Observador implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == pagInicial) {
				new Home();
				dispose();
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
				new AjusteValor();
				dispose();
			} else {
				new TelaLogin();
				dispose();
			}
		}
	}
}
