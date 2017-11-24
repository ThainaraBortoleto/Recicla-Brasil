package view;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CadastrarEmpresa extends javax.swing.JFrame {

	// Incicio da declaração das variáveis
	private JButton JBsalvar;
	private JCheckBoxMenuItem JCaixaDeMenu;
	private JFrame jFrame1, jFrame2;
	private JLabel jLabel1, jLabel10, jLabel11, jLabel12, jLabel13, jLabel14, jLabel15, jLabel16, jLabel17, jLabel18,
			jLabel19, jLabel2, jLabel20, jLabel21, jLabel22, jLabel23, jLabel24, jLabel25, jLabel3, jLabel4, jLabel5,
			jLabel6, jLabel7, jLabel8, jLabel9, lblCopyRight, lblDesenvolvedores;
	private JPanel jPanel1, contentPane, panelRodape;
	private JTextField jTextField1, jTextField10, jTextField11, jTextField12, jTextField13, jTextField14, jTextField15,
			jTextField16, jTextField17, jTextField18, jTextField19;
	private JTextField jTextField2, jTextField3, jTextField4, jTextField5, jTextField6, jTextField7, jTextField8,
			jTextField9;
	private JMenuBar menuBar;
	private JMenu menuHome, menuColetor, menuEmpresa, menuAjustarValores, menuSair;
	private JMenuItem pagInicial, cadastrarColetor, consultarColetor, cadastrarEmpresa, consultarEmpresa, ajusteValor,
			sair;
	private Observador observador;
	// Fim da declaração das variáveis

	public CadastrarEmpresa() {
		// NavBar
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

		// Body
		JCaixaDeMenu = new javax.swing.JCheckBoxMenuItem();
		jFrame1 = new javax.swing.JFrame();
		jFrame2 = new javax.swing.JFrame();
		jPanel1 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jTextField1 = new javax.swing.JTextField();
		jLabel3 = new javax.swing.JLabel();
		jTextField2 = new javax.swing.JTextField();
		jLabel4 = new javax.swing.JLabel();
		jTextField3 = new javax.swing.JTextField();
		jLabel5 = new javax.swing.JLabel();
		jTextField4 = new javax.swing.JTextField();
		jLabel6 = new javax.swing.JLabel();
		jTextField5 = new javax.swing.JTextField();
		jLabel7 = new javax.swing.JLabel();
		jTextField6 = new javax.swing.JTextField();
		jLabel8 = new javax.swing.JLabel();
		jLabel9 = new javax.swing.JLabel();
		jLabel10 = new javax.swing.JLabel();
		jLabel11 = new javax.swing.JLabel();
		jLabel12 = new javax.swing.JLabel();
		jTextField7 = new javax.swing.JTextField();
		jTextField8 = new javax.swing.JTextField();
		jTextField9 = new javax.swing.JTextField();
		jLabel13 = new javax.swing.JLabel();
		jLabel14 = new javax.swing.JLabel();
		jLabel15 = new javax.swing.JLabel();
		jLabel16 = new javax.swing.JLabel();
		jTextField10 = new javax.swing.JTextField();
		jTextField11 = new javax.swing.JTextField();
		jTextField12 = new javax.swing.JTextField();
		jLabel17 = new javax.swing.JLabel();
		jTextField13 = new javax.swing.JTextField();
		JBsalvar = new javax.swing.JButton();
		jLabel18 = new javax.swing.JLabel();
		jLabel19 = new javax.swing.JLabel();
		jLabel20 = new javax.swing.JLabel();
		jLabel21 = new javax.swing.JLabel();
		jTextField14 = new javax.swing.JTextField();
		jTextField15 = new javax.swing.JTextField();
		jTextField16 = new javax.swing.JTextField();
		jLabel22 = new javax.swing.JLabel();
		jLabel23 = new javax.swing.JLabel();
		jLabel24 = new javax.swing.JLabel();
		jTextField17 = new javax.swing.JTextField();
		jTextField18 = new javax.swing.JTextField();
		jTextField19 = new javax.swing.JTextField();
		jLabel25 = new javax.swing.JLabel();

		JCaixaDeMenu.setSelected(true);
		JCaixaDeMenu.setText("JCaixaDeMenu");

		javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
		jFrame1.getContentPane().setLayout(jFrame1Layout);
		jFrame1Layout.setHorizontalGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 400, Short.MAX_VALUE));
		jFrame1Layout.setVerticalGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 300, Short.MAX_VALUE));

		javax.swing.GroupLayout jFrame2Layout = new javax.swing.GroupLayout(jFrame2.getContentPane());
		jFrame2.getContentPane().setLayout(jFrame2Layout);
		jFrame2Layout.setHorizontalGroup(jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 400, Short.MAX_VALUE));
		jFrame2Layout.setVerticalGroup(jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 300, Short.MAX_VALUE));

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Cadastro de Empresa");
		setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

		jLabel1.setFont(new java.awt.Font("Arial", 1, 14));
		jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		jLabel1.setText("Cadastrar nova empresa");

		jLabel2.setFont(new java.awt.Font("Arial", 0, 13));
		jLabel2.setText("Razão social");

		jTextField1.setFont(new java.awt.Font("Arial", 0, 11));

		jLabel3.setFont(new java.awt.Font("Arial", 0, 13));
		jLabel3.setText("Cep");

		jTextField2.setFont(new java.awt.Font("Arial", 0, 11));

		jLabel4.setFont(new java.awt.Font("Arial", 0, 13));
		jLabel4.setText("E-mail");

		jTextField3.setFont(new java.awt.Font("Arial", 0, 11));

		jLabel5.setFont(new java.awt.Font("Arial", 0, 13));
		jLabel5.setText("Cnpj");

		jTextField4.setFont(new java.awt.Font("Arial", 0, 11));

		jLabel6.setFont(new java.awt.Font("Arial", 0, 13));
		jLabel6.setText("Telefone");

		jTextField5.setFont(new java.awt.Font("Arial", 0, 11));

		jLabel7.setFont(new java.awt.Font("Arial", 0, 13));
		jLabel7.setText("Endereço");

		jTextField6.setFont(new java.awt.Font("Arial", 0, 11));

		jLabel8.setFont(new java.awt.Font("Arial", 1, 14));
		jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		jLabel8.setText("Responsável:");

		jLabel9.setFont(new java.awt.Font("Arial", 0, 13));
		jLabel9.setText("Mostorista 1");

		jLabel10.setFont(new java.awt.Font("Arial", 0, 13));
		jLabel10.setText("Digite o peso suportado");

		jLabel11.setFont(new java.awt.Font("Arial", 0, 13));
		jLabel11.setText("Digite o nome completo");

		jLabel12.setFont(new java.awt.Font("Arial", 0, 13));
		jLabel12.setText("Digite a placa");

		jTextField7.setFont(new java.awt.Font("Arial", 0, 11));

		jTextField8.setFont(new java.awt.Font("Arial", 0, 11));

		jTextField9.setFont(new java.awt.Font("Arial", 0, 11));

		jLabel13.setFont(new java.awt.Font("Arial", 0, 13));
		jLabel13.setText("Mostorista 1");

		jLabel14.setFont(new java.awt.Font("Arial", 0, 13));
		jLabel14.setText("Digite o nome completo");

		jLabel15.setFont(new java.awt.Font("Arial", 0, 13));
		jLabel15.setText("Digite a placa");

		jLabel16.setFont(new java.awt.Font("Arial", 0, 13));
		jLabel16.setText("Digite o peso suportado");

		jTextField10.setFont(new java.awt.Font("Arial", 0, 11));

		jTextField11.setFont(new java.awt.Font("Arial", 0, 11));

		jTextField12.setFont(new java.awt.Font("Arial", 0, 11));

		jLabel17.setFont(new java.awt.Font("Arial", 1, 14));
		jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		jLabel17.setText("Cadastrar novo caminhão");

		jTextField13.setFont(new java.awt.Font("Arial", 0, 11));

		JBsalvar.setFont(new java.awt.Font("Arial", 1, 13));
		JBsalvar.setText("Salvar");

		jLabel18.setFont(new java.awt.Font("Arial", 0, 13));
		jLabel18.setText("Mostorista 1");

		jLabel19.setFont(new java.awt.Font("Arial", 0, 13));
		jLabel19.setText("Digite o nome completo");

		jLabel20.setFont(new java.awt.Font("Arial", 0, 13));
		jLabel20.setText("Digite a placa");

		jLabel21.setFont(new java.awt.Font("Arial", 0, 13));
		jLabel21.setText("Digite o peso suportado");

		jTextField14.setFont(new java.awt.Font("Arial", 0, 11));

		jTextField15.setFont(new java.awt.Font("Arial", 0, 11));

		jTextField16.setFont(new java.awt.Font("Arial", 0, 11));

		jLabel22.setFont(new java.awt.Font("Arial", 0, 13));
		jLabel22.setText("Digite o nome completo");

		jLabel23.setFont(new java.awt.Font("Arial", 0, 13));
		jLabel23.setText("Digite a placa");

		jLabel24.setFont(new java.awt.Font("Arial", 0, 13));
		jLabel24.setText("Digite o peso suportado");

		jTextField17.setFont(new java.awt.Font("Arial", 0, 11));

		jTextField18.setFont(new java.awt.Font("Arial", 0, 11));

		jTextField19.setFont(new java.awt.Font("Arial", 0, 11));

		jLabel25.setFont(new java.awt.Font("Arial", 0, 13));
		jLabel25.setText("Mostorista 4");

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanel1Layout.createSequentialGroup().addGap(91, 91, 91).addGroup(jPanel1Layout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addGroup(jPanel1Layout.createSequentialGroup()
										.addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 89,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 187,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
										.addComponent(jLabel16, javax.swing.GroupLayout.Alignment.LEADING,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(jPanel1Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 187,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 187,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, 187,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, 187,
														javax.swing.GroupLayout.PREFERRED_SIZE)))))
						.addGroup(jPanel1Layout.createSequentialGroup().addGap(91, 91, 91).addGroup(jPanel1Layout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 138,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout
										.createSequentialGroup()
										.addGroup(jPanel1Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 89,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 137,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, 187,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(81, 81, 81)
										.addGroup(jPanel1Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(jLabel24).addComponent(jLabel15,
														javax.swing.GroupLayout.PREFERRED_SIZE, 89,
														javax.swing.GroupLayout.PREFERRED_SIZE))))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, 187,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, 187,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, 187,
												javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addGroup(jPanel1Layout.createSequentialGroup().addGap(53, 53, 53).addComponent(jLabel1,
								javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGroup(jPanel1Layout.createSequentialGroup().addGap(43, 43, 43)
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 187,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 187,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(JBsalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 113,
												javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addGroup(jPanel1Layout.createSequentialGroup().addGap(74, 74, 74)
								.addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 89,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(321, 321, 321)
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 89,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 89,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGroup(jPanel1Layout.createSequentialGroup().addGap(10, 10, 10)
												.addGroup(jPanel1Layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(jPanel1Layout.createSequentialGroup()
																.addComponent(jLabel10)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(jTextField11,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 187,
																		javax.swing.GroupLayout.PREFERRED_SIZE))
														.addGroup(jPanel1Layout
																.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.TRAILING,
																		false)
																.addGroup(jPanel1Layout.createSequentialGroup()
																		.addComponent(jLabel23,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				89,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)
																		.addComponent(jTextField8,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				187,
																				javax.swing.GroupLayout.PREFERRED_SIZE))
																.addGroup(jPanel1Layout.createSequentialGroup()
																		.addComponent(jLabel22)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(jTextField10,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				187,
																				javax.swing.GroupLayout.PREFERRED_SIZE)))))))
						.addGroup(jPanel1Layout.createSequentialGroup().addGap(74, 74, 74).addGroup(jPanel1Layout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 114,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 89,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGroup(jPanel1Layout.createSequentialGroup().addGap(10, 10, 10)
										.addGroup(jPanel1Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 189,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 189,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 189,
														javax.swing.GroupLayout.PREFERRED_SIZE))))
								.addGap(100, 100, 100)
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 89,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 89,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGroup(jPanel1Layout.createSequentialGroup().addGap(10, 10, 10)
												.addGroup(jPanel1Layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(jTextField4,
																javax.swing.GroupLayout.PREFERRED_SIZE, 189,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jTextField5,
																javax.swing.GroupLayout.PREFERRED_SIZE, 189,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jTextField2,
																javax.swing.GroupLayout.PREFERRED_SIZE, 189,
																javax.swing.GroupLayout.PREFERRED_SIZE))))))
						.addContainerGap(279, Short.MAX_VALUE))
				.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanel1Layout.createSequentialGroup().addGap(53, 53, 53)
								.addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 191,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(869, Short.MAX_VALUE)))
				.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanel1Layout.createSequentialGroup().addGap(82, 82, 82)
								.addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 89,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(942, Short.MAX_VALUE))));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						jPanel1Layout.createSequentialGroup().addContainerGap()
								.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING,
												javax.swing.GroupLayout.PREFERRED_SIZE, 23,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 28,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 28,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 23,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 28,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 28,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(18, 18, 18)
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 23,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 28,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 28,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(65, 65, 65)
								.addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 23,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 23,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 25,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 23,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(
														jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 23,
														javax.swing.GroupLayout.PREFERRED_SIZE))
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addGroup(jPanel1Layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(jPanel1Layout
																.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.BASELINE)
																.addComponent(jLabel12,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 23,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addComponent(jTextField7,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 23,
																		javax.swing.GroupLayout.PREFERRED_SIZE))
														.addComponent(
																jTextField8, javax.swing.GroupLayout.Alignment.TRAILING,
																javax.swing.GroupLayout.PREFERRED_SIZE, 23,
																javax.swing.GroupLayout.PREFERRED_SIZE))
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
												.addGroup(jPanel1Layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE,
																23, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jTextField9,
																javax.swing.GroupLayout.PREFERRED_SIZE, 23,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE,
																23, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jTextField11,
																javax.swing.GroupLayout.PREFERRED_SIZE, 23,
																javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addGroup(jPanel1Layout.createSequentialGroup().addGap(29, 29, 29).addComponent(
												jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 23,
												javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addGap(18, 18, 18)
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 23,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 23,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 23,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, 23,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 23,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, 23,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 23,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, 23,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 23,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, 23,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13,
										Short.MAX_VALUE)
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 23,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, 23,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 23,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, 23,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(18, 18, 18)
								.addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 26,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(1, 1, 1)
								.addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 23,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(JBsalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 31,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap())
				.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanel1Layout.createSequentialGroup().addGap(269, 269, 269)
								.addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 36,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(333, Short.MAX_VALUE)))
				.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanel1Layout.createSequentialGroup().addGap(311, 311, 311)
								.addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 23,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(313, Short.MAX_VALUE))));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jPanel1,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE,
				javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE));

		pack();

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
		JBsalvar.addActionListener(observador);
	}

	class Observador implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try(Connection con = new ConexaoBD().conectar()){
				if (e.getSource() == JBsalvar) {
				//Exemplo para o gui
				EmpresaDAO eDao = new EmpresaDAO(con);
				Empresa e1 = new Empresa();
				
				//Pega todos os dados aqui e insere no objeto e1
				e1.setIdEmpresa(Integer.parseInt(JTextField1.getText()));
					
				//Inseri no banco Empresa
				eDao.inserir(e1);
					
				jTextField1.setText(" ");
				jTextField2.setText("");
				jTextField3.setText("");
				jTextField4.setText("");
				jTextField5.setText("");
				jTextField6.setText("");
				jTextField7.setText("");
				jTextField8.setText("");
				jTextField9.setText("");
				jTextField10.setText("");
				jTextField11.setText("");
				jTextField12.setText("");
				jTextField13.setText("");
				jTextField14.setText("");
				jTextField15.setText("");
				jTextField16.setText("");
				jTextField17.setText("");
				jTextField18.setText("");
				jTextField19.setText("");
					
				} else if (e.getSource() == pagInicial) {
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
					new ConsultarEmpresa1();
					dispose();
				} else if (e.getSource() == ajusteValor) {
					try {
						new AjusteValor();
						dispose();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				} else {
					new TelaLogin();
					dispose();
				}
			} catch (SQLException e1){
				e1.printStackTrace();	
			}
			
		}
	}
}
