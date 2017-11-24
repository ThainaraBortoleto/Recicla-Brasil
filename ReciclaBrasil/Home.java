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
	private JButton chamarCaminhaoButton;
	private JLabel lblAluminio, lblPapelao, lblPlastico, lblVidro, lblTotalDeMaterial, lblIncio, lblPainelDeControle,
			porcentagemAluminio, porcentagemPapelao, porcentagemPlastico, porcentagemVidro, lblAgenda, lblCopyRight,
			lblDesenvolvedores;
	private JTable agenda;
	private Observador observador;
	private JProgressBar progressBarAluminio, progressBarPapelao, progressBarPlastico, progressBarVidro;

	public Home() throws SQLException {
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

			MaterialDAO mDao = new MaterialDAO(con);
			Material aluminio = new Material();
			aluminio.setIdMateriais(1);
			Material papelao = new Material();
			papelao.setIdMateriais(2);
			Material plastico = new Material();
			plastico.setIdMateriais(3);
			Material vidro = new Material();
			vidro.setIdMateriais(4);

			int aluminioId = aluminio.getIdMateriais();
			int papelaoId = papelao.getIdMateriais();
			int plasticoId = plastico.getIdMateriais();
			int vidroId = vidro.getIdMateriais();

			progressBarAluminio = new JProgressBar();
			progressBarAluminio.setValue(mDao.carregarQuantidade(aluminioId));
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

			progressBarPapelao = new JProgressBar();
			progressBarPapelao.setValue(mDao.carregarQuantidade(papelaoId));
			progressBarPapelao.setBounds(284, 157, 579, 20);
			panelBody.add(progressBarPapelao);

			progressBarPlastico = new JProgressBar();
			progressBarPlastico.setValue(mDao.carregarQuantidade(plasticoId));
			progressBarPlastico.setBounds(284, 185, 579, 20);
			panelBody.add(progressBarPlastico);

			progressBarVidro = new JProgressBar();
			progressBarVidro.setValue(mDao.carregarQuantidade(vidroId));
			progressBarVidro.setBounds(284, 213, 579, 20);
			panelBody.add(progressBarVidro);

			porcentagemAluminio = new JLabel("" + mDao.carregarQuantidade(aluminioId) + "%");
			porcentagemAluminio.setBounds(916, 133, 61, 16);
			panelBody.add(porcentagemAluminio);

			porcentagemPapelao = new JLabel("" + mDao.carregarQuantidade(papelaoId) + "%");
			porcentagemPapelao.setBounds(916, 161, 61, 16);
			panelBody.add(porcentagemPapelao);

			porcentagemPlastico = new JLabel("" + mDao.carregarQuantidade(plasticoId) + "%");
			porcentagemPlastico.setBounds(916, 189, 61, 16);
			panelBody.add(porcentagemPlastico);

			porcentagemVidro = new JLabel("" + mDao.carregarQuantidade(vidroId) + "%");
			porcentagemVidro.setBounds(916, 217, 61, 16);
			panelBody.add(porcentagemVidro);

			chamarCaminhaoButton = new JButton("Chamar caminhão");
			chamarCaminhaoButton.setBounds(485, 250, 150, 50);
			panelBody.add(chamarCaminhaoButton);

			// Agenda
			lblAgenda = new JLabel("Agenda");
			lblAgenda.setFont(new Font("Lucida Grande", Font.BOLD, 20));
			lblAgenda.setBounds(515, 350, 186, 25);
			panelBody.add(lblAgenda);

			EmpresaDAO eDao = new EmpresaDAO(con);
			Empresa e1 = new Empresa();
			e1.setIdEmpresa(1);
			int e1Id = e1.getIdEmpresa();

			Empresa e2 = new Empresa();
			e2.setIdEmpresa(2);
			int e2Id = e2.getIdEmpresa();

			String[] nomesColunas = { "Hora", "Empresa" };
			Object[][] data = { { "09:00", eDao.listarNome(e1Id) }, { "10:00", null }, { "11:00", null },
					{ "12:00", null }, { "13:00", null }, { "14:00", null }, { "15:00", eDao.listarNome(e2Id) },
					{ "16:00", null }, { "17:00", null }, { "18:00", null }

			};
			agenda = new JTable(data, nomesColunas);
			JScrollPane scrollPane = new JScrollPane(agenda);
			scrollPane.setBounds(323, 400, 463, 190);
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
			chamarCaminhaoButton.addActionListener(observador);
			sair.addActionListener(observador);
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
				} else if (e.getSource() == chamarCaminhaoButton) {
					
					MaterialDAO mDao = new MaterialDAO(con);
					
					String material = JOptionPane.showInputDialog("Para qual material deseja chamar um caminhão?");
					int quantidade = Integer.parseInt(JOptionPane.showInputDialog("Qual a quantidade que deseja descarregar?"));
					if(material.equalsIgnoreCase("alumínio")) {
						Material m1 = new Material();
						m1.setIdMateriais(1);
						mDao.diminuiQuantidade(m1, quantidade);
						
						progressBarAluminio.setValue(mDao.carregarQuantidade(m1.getIdMateriais()));
						porcentagemAluminio.setText("" + mDao.carregarQuantidade(m1.getIdMateriais()) + "%");
						
						JOptionPane.showMessageDialog(null, "Retirada de materiais concluida");
					}
					
					if(material.equalsIgnoreCase("papelão")) {
						Material m1 = new Material();
						m1.setIdMateriais(2);
						mDao.diminuiQuantidade(m1, quantidade);
						
						progressBarPapelao.setValue(mDao.carregarQuantidade(m1.getIdMateriais()));
						porcentagemPapelao.setText("" + mDao.carregarQuantidade(m1.getIdMateriais()) + "%");
						
						JOptionPane.showMessageDialog(null, "Retirada de materiais concluida");
					}
					
					if(material.equalsIgnoreCase("plástico")) {
						Material m1 = new Material();
						m1.setIdMateriais(3);
						mDao.diminuiQuantidade(m1, quantidade);
						
						progressBarPlastico.setValue(mDao.carregarQuantidade(m1.getIdMateriais()));
						porcentagemPlastico.setText("" + mDao.carregarQuantidade(m1.getIdMateriais()) + "%");
						
						JOptionPane.showMessageDialog(null, "Retirada de materiais concluida");
					}
					
					if(material.equalsIgnoreCase("vidro")) {
						Material m1 = new Material();
						m1.setIdMateriais(4);
						mDao.diminuiQuantidade(m1, quantidade);
						
						progressBarVidro.setValue(mDao.carregarQuantidade(m1.getIdMateriais()));
						porcentagemVidro.setText("" + mDao.carregarQuantidade(m1.getIdMateriais()) + "%");
						
						JOptionPane.showMessageDialog(null, "Retirada de materiais concluida");
					}
					
				} else {
					new TelaLogin();
					dispose();
				}
			} catch (SQLException e1) {
				System.out.println(e1);
			}
		}
	}
}
