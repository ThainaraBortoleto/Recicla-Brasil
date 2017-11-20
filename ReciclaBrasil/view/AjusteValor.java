package view;

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
import javax.swing.border.EmptyBorder;

public class AjusteValor extends JFrame {
	private JPanel contentPane, panelAjuste;
	private JMenuBar menuBar;
	private JMenu menuHome, menuColetor, menuEmpresa, menuAjustarValores, menuSair;
	private JMenuItem pagInicial, cadastrarColetor, consultarColetor, cadastrarEmpresa, consultarEmpresa, ajusteValor,
			sair;
	private JPanel panelBody, panelRodape;
	private JLabel lblAjustarValores, lblPainelDeControle, lblMateriais, lblAluminio, lblPapelao, lblPlastico, lblVidro,
			lblPrecoAluminio, lblPreco, lblMaterial, lblPrecoPapelao, lblPrecoPlastico, lblPrecoVidro, lblCopyRight,
			lblDesenvolvedores;
	private JButton btnEditarAluminio, btnEditarPapelao, btnEditarPlastico, btnEditarVidro;
	private Observador observador;
<<<<<<< HEAD
	MaterialDAO mDao;
	Material aluminio, papelao, plastico, vidro;
=======
	MateriaisDAO mDao;
	Materiais aluminio, papelao, plastico, vidro;
>>>>>>> b80149968e776b7ec2a9c6938330ecbd88fcbb55

	public AjusteValor() throws SQLException {
		super("ReciclaBrasil");

		try (Connection con = new ConexaoBD().conectar()) {

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

			// Conteúdo
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

			lblPreco = new JLabel("Preço");
			lblPreco.setFont(new Font("Lucida Grande", Font.BOLD, 13));
			lblPreco.setBounds(320, 44, 61, 16);
			panelAjuste.add(lblPreco);

			lblMaterial = new JLabel("Material");
			lblMaterial.setFont(new Font("Lucida Grande", Font.BOLD, 13));
			lblMaterial.setBounds(6, 44, 61, 16);
			panelAjuste.add(lblMaterial);

<<<<<<< HEAD
			mDao = new MaterialDAO(con);
			aluminio = new Material();
			aluminio.setIdMateriais(1);
			papelao = new Material();
			papelao.setIdMateriais(2);
			plastico = new Material();
			plastico.setIdMateriais(3);
			vidro = new Material();
=======
			mDao = new MateriaisDAO(con);
			aluminio = new Materiais();
			aluminio.setIdMateriais(1);
			papelao = new Materiais();
			papelao.setIdMateriais(2);
			plastico = new Materiais();
			plastico.setIdMateriais(3);
			vidro = new Materiais();
>>>>>>> b80149968e776b7ec2a9c6938330ecbd88fcbb55
			vidro.setIdMateriais(4);

			int aluminioId = aluminio.getIdMateriais();
			int papelaoId = papelao.getIdMateriais();
			int plasticoId = plastico.getIdMateriais();
			int vidroId = vidro.getIdMateriais();

			lblPrecoAluminio = new JLabel("R$ " + mDao.carregarPreco(aluminioId));
			lblPrecoAluminio.setBounds(320, 72, 61, 16);
			panelAjuste.add(lblPrecoAluminio);

			lblPrecoPapelao = new JLabel("R$ " + mDao.carregarPreco(papelaoId));
			lblPrecoPapelao.setBounds(320, 114, 61, 16);
			panelAjuste.add(lblPrecoPapelao);

			lblPrecoPlastico = new JLabel("R$ " + mDao.carregarPreco(plasticoId));
			lblPrecoPlastico.setBounds(320, 161, 61, 16);
			panelAjuste.add(lblPrecoPlastico);

			lblPrecoVidro = new JLabel("R$ " + mDao.carregarPreco(vidroId));
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
			setVisible(true);

			// observador
			observador = new Observador();
			// MenuBar
			pagInicial.addActionListener(observador);
			cadastrarColetor.addActionListener(observador);
			consultarColetor.addActionListener(observador);
			cadastrarEmpresa.addActionListener(observador);
			consultarEmpresa.addActionListener(observador);
			ajusteValor.addActionListener(observador);
			sair.addActionListener(observador);
			// Editar
			btnEditarAluminio.addActionListener(observador);
			btnEditarPapelao.addActionListener(observador);
			btnEditarPlastico.addActionListener(observador);
			btnEditarVidro.addActionListener(observador);
		}

	}

	class Observador implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try (Connection con = new ConexaoBD().conectar()) {
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
				} else if (e.getSource() == btnEditarAluminio) {
					try {
<<<<<<< HEAD
						mDao = new MaterialDAO(con);
						aluminio = new Material();
=======
						mDao = new MateriaisDAO(con);
						aluminio = new Materiais();
>>>>>>> b80149968e776b7ec2a9c6938330ecbd88fcbb55
						aluminio.setIdMateriais(1);
						int aluminioId = aluminio.getIdMateriais();
						
						double novoPreco = Double.parseDouble(JOptionPane.showInputDialog("Novo valor Alumínio: "));
						aluminio.setPreco(novoPreco);
						
						mDao.alterarPreco(aluminio);
						System.out.println("Preço alterado");
						
						lblPrecoAluminio.setText("R$ " + mDao.carregarPreco(aluminioId)); 
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				} else if (e.getSource() == btnEditarPapelao) {
					try {
<<<<<<< HEAD
						mDao = new MaterialDAO(con);
						papelao = new Material();
=======
						mDao = new MateriaisDAO(con);
						papelao = new Materiais();
>>>>>>> b80149968e776b7ec2a9c6938330ecbd88fcbb55
						papelao.setIdMateriais(2);
						int papelaoId = papelao.getIdMateriais();
						
						double novoPreco = Double.parseDouble(JOptionPane.showInputDialog("Novo valor papelão: "));
						papelao.setPreco(novoPreco);
						
						mDao.alterarPreco(papelao);
						System.out.println("Preço alterado");
						
						lblPrecoPapelao.setText("R$ " + mDao.carregarPreco(papelaoId)); 
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				} else if (e.getSource() == btnEditarPlastico) {
					try {
<<<<<<< HEAD
						mDao = new MaterialDAO(con);
						plastico = new Material();
=======
						mDao = new MateriaisDAO(con);
						plastico = new Materiais();
>>>>>>> b80149968e776b7ec2a9c6938330ecbd88fcbb55
						plastico.setIdMateriais(3);
						int plasticoId = plastico.getIdMateriais();
						
						double novoPreco = Double.parseDouble(JOptionPane.showInputDialog("Novo valor plastico: "));
						plastico.setPreco(novoPreco);
						
						mDao.alterarPreco(plastico);
						System.out.println("Preço alterado");
						
						lblPrecoPlastico.setText("R$ " + mDao.carregarPreco(plasticoId)); 
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				} else if (e.getSource() == btnEditarVidro) {
					try {
<<<<<<< HEAD
						mDao = new MaterialDAO(con);
						vidro = new Material();
=======
						mDao = new MateriaisDAO(con);
						vidro = new Materiais();
>>>>>>> b80149968e776b7ec2a9c6938330ecbd88fcbb55
						vidro.setIdMateriais(4);
						int vidroId = vidro.getIdMateriais();
						
						double novoPreco = Double.parseDouble(JOptionPane.showInputDialog("Novo valor vidro: "));
						vidro.setPreco(novoPreco);
						
						mDao.alterarPreco(vidro);
						System.out.println("Preço alterado");
						
						lblPrecoVidro.setText("R$ " + mDao.carregarPreco(vidroId)); 
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				} else {
					new TelaLogin();
					dispose();
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
}
