import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class AjusteValor extends JFrame{
	private JPanel contentPane, panelAjuste;
	private JMenuBar menuBar;
	private JMenu menuHome, menuColetor, menuEmpresa, menuAjustarValores, menuSair;
	private JMenuItem pagInicial, cadastrarColetor, consultarColetor, cadastrarEmpresa, consultarEmpresa, ajusteValor, sair;
	private JPanel panelBody, panelRodape;
	private JLabel lblAjustarValores, lblPainelDeControle, lblMateriais, lblAluminio, lblPapelao, lblPlastico, lblVidro, lblPrecoAluminio,  lblPreco, lblMaterial, lblPrecoPapelao, lblPrecoPlastico, lblPrecoVidro, lblCopyRight, lblDesenvolvedores;
	private JButton btnEditarAluminio, btnEditarPapelao, btnEditarPlastico, btnEditarVidro;
	private Observador observador;
	
	public AjusteValor() {
		super("ReciclaBrasil");

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
		lblAjustarValores = new JLabel("Ajustar Valores");
		lblAjustarValores.setForeground(Color.DARK_GRAY);
		lblAjustarValores.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		lblAjustarValores.setBounds(16, 6, 148, 25);
		panelBody.add(lblAjustarValores);
		
		lblPainelDeControle = new JLabel("Painel de Controle");
		lblPainelDeControle.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		lblPainelDeControle.setForeground(Color.LIGHT_GRAY);
		lblPainelDeControle.setBounds(163, 12, 111, 16);
		panelBody.add(lblPainelDeControle);

		//Conteúdo
		panelAjuste = new JPanel();
		panelAjuste.setBounds(60, 168, 1026, 336);
		panelBody.add(panelAjuste);
		panelAjuste.setLayout(null);
		
		lblMateriais = new JLabel("Materiais");
		lblMateriais.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		lblMateriais.setBounds(6, 6, 94, 16);
		panelAjuste.add(lblMateriais);
		
		lblAluminio = new JLabel("Alumínio");
		lblAluminio.setBounds(6, 72, 61, 16);
		panelAjuste.add(lblAluminio);
		
		lblPapelao = new JLabel("Papelão");
		lblPapelao.setBounds(6, 114, 61, 16);
		panelAjuste.add(lblPapelao);
		
		lblPlastico = new JLabel("Plástico");
		lblPlastico.setBounds(6, 161, 61, 16);
		panelAjuste.add(lblPlastico);
		
		lblVidro = new JLabel("Vidro");
		lblVidro.setBounds(6, 207, 61, 16);
		panelAjuste.add(lblVidro);
		
		lblPrecoAluminio = new JLabel("3.50");
		lblPrecoAluminio.setBounds(320, 72, 61, 16);
		panelAjuste.add(lblPrecoAluminio);
		
		lblPreco = new JLabel("Preço");
		lblPreco.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblPreco.setBounds(320, 44, 61, 16);
		panelAjuste.add(lblPreco);
		
		lblMaterial = new JLabel("Material");
		lblMaterial.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblMaterial.setBounds(6, 44, 61, 16);
		panelAjuste.add(lblMaterial);
		
		lblPrecoPapelao = new JLabel("3.00");
		lblPrecoPapelao.setBounds(320, 114, 61, 16);
		panelAjuste.add(lblPrecoPapelao);
		
		lblPrecoPlastico = new JLabel("2.50");
		lblPrecoPlastico.setBounds(320, 161, 61, 16);
		panelAjuste.add(lblPrecoPlastico);
		
		lblPrecoVidro = new JLabel("4.50");
		lblPrecoVidro.setBounds(320, 207, 61, 16);
		panelAjuste.add(lblPrecoVidro);
		
		btnEditarAluminio = new JButton("Editar");
		btnEditarAluminio.setBounds(669, 67, 117, 29);
		panelAjuste.add(btnEditarAluminio);
		
		btnEditarPapelao = new JButton("Editar");
		btnEditarPapelao.setBounds(669, 109, 117, 29);
		panelAjuste.add(btnEditarPapelao);
		
		btnEditarPlastico = new JButton("Editar");
		btnEditarPlastico.setBounds(669, 156, 117, 29);
		panelAjuste.add(btnEditarPlastico);
		
		btnEditarVidro = new JButton("Editar");
		btnEditarVidro.setBounds(669, 202, 117, 29);
		panelAjuste.add(btnEditarVidro);
		

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
		setBounds(100, 100, 1161, 808);
		setVisible(true);

		// observador
		observador = new Observador();
		//MenuBar
		pagInicial.addActionListener(observador);
		cadastrarColetor.addActionListener(observador);
		consultarColetor.addActionListener(observador);
		cadastrarEmpresa.addActionListener(observador);
		consultarEmpresa.addActionListener(observador);
		ajusteValor.addActionListener(observador);
		sair.addActionListener(observador);
		//Editar
		btnEditarAluminio.addActionListener(observador);
		btnEditarPapelao.addActionListener(observador);
		btnEditarPlastico.addActionListener(observador);
		btnEditarVidro.addActionListener(observador);
		

	}

	class Observador implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == pagInicial) {
				new Home();
				dispose();
			}else if (e.getSource() == cadastrarColetor) {
				System.out.println("Cadastrar coletor");
			} else if (e.getSource() == consultarColetor) {
				System.out.println("Consultar coletor");
			} else if (e.getSource() == cadastrarEmpresa) {
				System.out.println("Cadastrar Empresa");
			} else if (e.getSource() == consultarEmpresa) {
				System.out.println("Consultar Empresa");
			} else if (e.getSource() == ajusteValor) {
				new AjusteValor();
				dispose();
			} else if(e.getSource() == btnEditarAluminio) {
				lblPrecoAluminio.setText(JOptionPane.showInputDialog("Novo valor Alumínio: "));
			} else if(e.getSource() == btnEditarPapelao) {
				lblPrecoPapelao.setText(JOptionPane.showInputDialog("Novo valor Alumínio: "));
			} else if(e.getSource() == btnEditarPlastico) {
				lblPrecoPlastico.setText(JOptionPane.showInputDialog("Novo valor Alumínio: "));
			} else if(e.getSource() == btnEditarVidro) {
				lblPrecoVidro.setText(JOptionPane.showInputDialog("Novo valor Alumínio: "));
			} else {
				System.exit(0);
			}
		}
	}
}
