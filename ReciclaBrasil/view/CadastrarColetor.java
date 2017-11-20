package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;

public class CadastrarColetor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu menuCadastrarColetor, menuColetor, menuEmpresa, menuAjustarValores, menuSair;
	private JMenuItem pagInicial, cadastrarColetor, ConsultarColetor, cadastrarEmpresa, consultarEmpresa, ajusteValor,
			sair;
	private JPanel panelBody, panelRodape;
	private JLabel lblIncio, lblPainelDeControle, lblCopyRight, lblDesenvolvedores;
	private Observador observador;
	private JLabel lblCadastrarColetor;
	private JPanel panel_1;
	private JTextField textField;
	private JLabel lblApelido;
	private JLabel lblDataDeNascimento;
	private JTextField textField_1;
	private JTextField txtDdmmaaaa;
	private JLabel label;
	private JButton btnCancelar, btnCadastrarDigital, btnGerarQrcode, btnPronto;

	public CadastrarColetor() {
		super("ReciclaBrasil");

		Toolkit tk = Toolkit.getDefaultToolkit();
		int xsize = (int) tk.getScreenSize().getWidth();
		int ysize = (int) tk.getScreenSize().getHeight();
		this.setSize(xsize, ysize);

		menuBar = new JMenuBar();
		menuBar.setBackground(Color.LIGHT_GRAY);
		setJMenuBar(menuBar);

		menuCadastrarColetor = new JMenu("Home");
		menuBar.add(menuCadastrarColetor);

		pagInicial = new JMenuItem("Pagina Inicial");
		menuCadastrarColetor.add(pagInicial);

		menuColetor = new JMenu("Coletor");
		menuBar.add(menuColetor);

		cadastrarColetor = new JMenuItem("Cadastrar");
		menuColetor.add(cadastrarColetor);

		ConsultarColetor = new JMenuItem("Consultar");
		menuColetor.add(ConsultarColetor);

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
		panelBody.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelBody.setBackground(Color.WHITE);
		contentPane.add(panelBody, BorderLayout.CENTER);
		panelBody.setLayout(null);

		// Titulo
		lblIncio = new JLabel("Inicio");
		lblIncio.setBounds(16, 6, 61, 25);
		lblIncio.setForeground(Color.DARK_GRAY);
		lblIncio.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		panelBody.add(lblIncio);

		lblPainelDeControle = new JLabel("Cadastrar Coletor");
		lblPainelDeControle.setBounds(75, 12, 111, 16);
		lblPainelDeControle.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		lblPainelDeControle.setForeground(Color.LIGHT_GRAY);
		panelBody.add(lblPainelDeControle);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setForeground(Color.BLACK);
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBounds(147, 76, 906, 591);
		panelBody.add(panel);
		panel.setLayout(null);

		panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.inactiveCaptionBorder);
		panel_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(89, 11, 731, 55);
		panel.add(panel_1);
		panel_1.setLayout(null);

		lblCadastrarColetor = new JLabel("Cadastrar Coletor");
		lblCadastrarColetor.setBounds(289, 11, 142, 32);
		panel_1.add(lblCadastrarColetor);
		lblCadastrarColetor.setFont(new Font("Times New Roman", Font.BOLD, 16));

		textField = new JTextField();
		textField.setBounds(275, 125, 407, 29);
		panel.add(textField);
		textField.setColumns(10);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNome.setBounds(148, 131, 46, 14);
		panel.add(lblNome);

		lblApelido = new JLabel("Apelido:");
		lblApelido.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblApelido.setBounds(148, 181, 81, 23);
		panel.add(lblApelido);

		lblDataDeNascimento = new JLabel("Data de Nascimento:");
		lblDataDeNascimento.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblDataDeNascimento.setBounds(148, 231, 138, 23);
		panel.add(lblDataDeNascimento);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(275, 175, 407, 29);
		panel.add(textField_1);

		txtDdmmaaaa = new JTextField();
		txtDdmmaaaa.setColumns(10);
		txtDdmmaaaa.setBounds(296, 229, 163, 28);
		panel.add(txtDdmmaaaa);

		btnCadastrarDigital = new JButton("Cadastrar Digital");
		btnCadastrarDigital.setBackground(new Color(135, 206, 235));
		btnCadastrarDigital.setBounds(296, 309, 136, 29);
		panel.add(btnCadastrarDigital);

		btnGerarQrcode = new JButton("Gerar QRCode");
		btnGerarQrcode.setBackground(new Color(135, 206, 235));
		btnGerarQrcode.setBounds(462, 309, 117, 29);
		panel.add(btnGerarQrcode);

		btnPronto = new JButton("Pronto!");
		btnPronto.setBackground(Color.GREEN);
		btnPronto.setBounds(751, 535, 117, 29);
		panel.add(btnPronto);
		

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(new Color(255, 160, 122));
		btnCancelar.setBounds(28, 538, 117, 29);
		panel.add(btnCancelar);

		label = new JLabel("");
		label.setIcon(new ImageIcon(
				"C:\\Users\\thain\\Documents\\ProjetoPI\\ReciclaBrasil\\ReciclaBrasil\\view\\green-nature-vector-backgrounds-powerpoint.jpg"));
		label.setBounds(0, 0, 906, 591);
		panel.add(label);

		// Rodape
		panelRodape = new JPanel();
		panelRodape.setBackground(Color.LIGHT_GRAY);
		contentPane.add(panelRodape, BorderLayout.SOUTH);

		lblCopyRight = new JLabel("� Copyright 2017");
		lblCopyRight.setForeground(Color.WHITE);
		panelRodape.add(lblCopyRight);

		lblDesenvolvedores = new JLabel(
				"Andre Gianfratti, Arthur Grigoletto, Guilherme Araujo, Raul Machado, Thainara Bortoleto");
		lblDesenvolvedores.setForeground(Color.WHITE);
		lblDesenvolvedores.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		panelRodape.add(lblDesenvolvedores);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		// observador
		observador = new Observador();
		pagInicial.addActionListener(observador);
		cadastrarColetor.addActionListener(observador);
		ConsultarColetor.addActionListener(observador);
		cadastrarEmpresa.addActionListener(observador);
		consultarEmpresa.addActionListener(observador);
		ajusteValor.addActionListener(observador);
		btnCancelar.addActionListener(observador);
		btnPronto.addActionListener(observador);
		btnCadastrarDigital.addActionListener(observador);
		btnGerarQrcode.addActionListener(observador);
		sair.addActionListener(observador);
		

	}

	class Observador implements ActionListener {
		public void actionPerformed(ActionEvent e) {
<<<<<<< HEAD
			try (Connection con = new ConexaoBD().conectar()){
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
				} else if (e.getSource() == ConsultarColetor) {
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
					new ConsultarEmpresa1();
					dispose();
				} else if (e.getSource() == ajusteValor) {
					try {
						new AjusteValor();
						dispose();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				} else if(e.getSource() == btnCancelar){
					try {
						new Home();
						dispose();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				} else if(e.getSource() == btnCadastrarDigital) {
					JOptionPane.showMessageDialog(null, "Pressione a digital no leitor Biométrico");
					JOptionPane.showMessageDialog(null, "Digital cadastrada com sucesso");
				} else if(e.getSource() == btnGerarQrcode) {
					JOptionPane.showMessageDialog(null, "QRCode gerado com sucesso!");
				} else if(e.getSource() == btnPronto) {
					ColetorDAO cDAO = new ColetorDAO(con);
					String nome = textField.getText();
					String apelido = textField_1.getText();
					
					Coletor c1 = new Coletor (2);
					c1.setNome(nome);
					c1.setApelido(apelido);
					
					cDAO.inserir(c1);
					JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
				}
				
				else {
					new TelaLogin();
					dispose();
				}
			}catch(SQLException e1) {
				e1.printStackTrace();
=======
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
			} else if (e.getSource() == ConsultarColetor) {
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
			} else if(e.getSource() == btnCancelar){
				try {
					new Home();
					dispose();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			} else if(e.getSource() == btnCadastrarDigital) {
				JOptionPane.showMessageDialog(null, "Pressione a digital no leitor Biométrico");
				JOptionPane.showMessageDialog(null, "Digital cadastrada com sucesso");
			} else if(e.getSource() == btnGerarQrcode) {
				JOptionPane.showMessageDialog(null, "QRCode gerado com sucesso!");
			} else if(e.getSource() == btnPronto) {
				ColetorRecebimentoMaterial tela = new ColetorRecebimentoMaterial();
				tela.setVisible(true);
				dispose();
			}
			
			else {
				new TelaLogin();
				dispose();
>>>>>>> b80149968e776b7ec2a9c6938330ecbd88fcbb55
			}
		}
	}
}
