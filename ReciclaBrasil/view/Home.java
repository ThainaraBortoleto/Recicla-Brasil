import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;

public class Home extends JFrame{
	private JPanel contentPane;
	JMenuBar menuBar;
	JMenu menuColetor, menuEmpresa, menuAjustarValores, menuSair;
	JMenuItem cadastrarColetor, consultarColetor, cadastrarEmpresa, consultarEmpresa;
	JPanel panelBody, panelRodape;
	JLabel lblAluminio, lblPapelao, lblPlastico, lblVidro, lblTotalDeMaterial, lblIncio, lblPainelDeControle, lblAgenda, porcentagemAluminio, porcentagemPapelao, porcentagemPlastico, 
		porcentagemVidro, lblNoveHoras, lblDezHoras, lblOnzeHoras, lblDozeHoras, lblTrezeHoras, lblQuatorzeHoras, lblQuinzeHoras, lblDezesseisHoras, lblDezeseteHoras, lblDezoitoHoras, lblEmpresaX, 
			lblEmpresaY, lblEmpresaXy, lblEmpresaK, lblCopyRight, lblDesenvolvedores;
	
	public Home() {
		super("ReciclaBrasil");
		
		menuBar = new JMenuBar();
		menuBar.setBackground(Color.LIGHT_GRAY);
		setJMenuBar(menuBar);
		
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
		
		menuSair = new JMenu("Sair");
		menuBar.add(menuSair);
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panelBody = new JPanel();
		panelBody.setBackground(Color.WHITE);
		contentPane.add(panelBody, BorderLayout.CENTER);
		panelBody.setLayout(null);
		
		//Titulo
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
		
		//ProgressBar
		lblTotalDeMaterial = new JLabel("Total de Material");
		lblTotalDeMaterial.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		lblTotalDeMaterial.setBounds(457, 82, 186, 25);
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
		
		//Agenda
		lblAgenda = new JLabel("Agenda");
		lblAgenda.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		lblAgenda.setBounds(511, 322, 89, 34);
		panelBody.add(lblAgenda);
		
		lblNoveHoras = new JLabel("09:00");
		lblNoveHoras.setBounds(154, 369, 61, 16);
		panelBody.add(lblNoveHoras);
		
		lblDezHoras = new JLabel("10:00");
		lblDezHoras.setBounds(154, 400, 61, 16);
		panelBody.add(lblDezHoras);
		
		lblOnzeHoras = new JLabel("11:00");
		lblOnzeHoras.setBounds(154, 428, 61, 16);
		panelBody.add(lblOnzeHoras);
		
		lblDozeHoras = new JLabel("12:00");
		lblDozeHoras.setBounds(154, 456, 61, 16);
		panelBody.add(lblDozeHoras);
		
		lblTrezeHoras = new JLabel("13:00");
		lblTrezeHoras.setBounds(154, 486, 61, 16);
		panelBody.add(lblTrezeHoras);
		
		lblQuatorzeHoras = new JLabel("14:00");
		lblQuatorzeHoras.setBounds(154, 514, 61, 16);
		panelBody.add(lblQuatorzeHoras);
		
		lblQuinzeHoras = new JLabel("15:00");
		lblQuinzeHoras.setBounds(154, 542, 61, 16);
		panelBody.add(lblQuinzeHoras);
		
		lblDezesseisHoras = new JLabel("16:00");
		lblDezesseisHoras.setBounds(154, 570, 61, 16);
		panelBody.add(lblDezesseisHoras);
		
		lblDezeseteHoras = new JLabel("17:00");
		lblDezeseteHoras.setBounds(154, 598, 61, 16);
		panelBody.add(lblDezeseteHoras);
		
		lblDezoitoHoras = new JLabel("18:00");
		lblDezoitoHoras.setBounds(154, 626, 61, 16);
		panelBody.add(lblDezoitoHoras);
		
		lblEmpresaX = new JLabel("Empresa X");
		lblEmpresaX.setBounds(284, 369, 81, 16);
		panelBody.add(lblEmpresaX);
		
		lblEmpresaY = new JLabel("Empresa Y");
		lblEmpresaY.setBounds(284, 400, 70, 16);
		panelBody.add(lblEmpresaY);
		
		lblEmpresaXy = new JLabel("Empresa XY");
		lblEmpresaXy.setBounds(284, 456, 81, 16);
		panelBody.add(lblEmpresaXy);
		
		lblEmpresaK = new JLabel("Empresa K");
		lblEmpresaK.setBounds(284, 598, 81, 16);
		panelBody.add(lblEmpresaK);
		
		//Rodapé
		panelRodape = new JPanel();
		panelRodape.setBackground(Color.LIGHT_GRAY);
		contentPane.add(panelRodape, BorderLayout.SOUTH);
		
		lblCopyRight = new JLabel("© Copyright 2001-2017");
		lblCopyRight.setForeground(Color.WHITE);
		panelRodape.add(lblCopyRight);
		
		lblDesenvolvedores = new JLabel("André Gianfratti, Arthur Grigoletto, Guilherme Araújo, Raul Machado, Thainara Bortoleto");
		lblDesenvolvedores.setForeground(Color.WHITE);
		lblDesenvolvedores.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		panelRodape.add(lblDesenvolvedores);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1161, 808);
		setVisible(true);
		
		
	}
}