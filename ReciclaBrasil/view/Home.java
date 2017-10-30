import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Home extends JFrame{
	private JPanel painelNorte, painelNorteOeste, painelOeste, painelOesteNorte, painelOesteCentro, painelOesteSul, painelCentro, painelCentroNorte;
	private JLabel lblLogo, lblNomeUsuario, lblIconePerfil, lblInicio, lblPainelDeControle;
	private JButton buscarButton, cadastrarColetorButton, consultarColetorButton, cadastrarEmpresaButton, consultarEmpresaButton, alterarPrecosButton;
	private ImageIcon perfilIcon, buscarIcon;
	private Font fontTitulo, fontSubTitulo;
	
	public Home() {
		super("Home");
		
		Container caixa = getContentPane();
		caixa.setBackground(new Color(247, 249, 255));
		caixa.setLayout(new BorderLayout());
		
		lblLogo = new JLabel("ReciclaBrasil");
		lblNomeUsuario = new JLabel("Nome usuário");
		lblLogo.setForeground(new Color(255, 255, 255));
		lblNomeUsuario.setForeground(Color.white);
		
		//Fontes
		fontTitulo = new Font("Roboto", Font.BOLD, 20);
		fontSubTitulo = new Font("Roboto", Font.ITALIC, 14);
		lblLogo.setFont(fontTitulo);
		lblNomeUsuario.setFont(fontSubTitulo);
		
		//Painel Norte
		painelNorte = new JPanel(new BorderLayout());
		painelNorteOeste = new JPanel(new FlowLayout());
		painelNorte.setBackground(new Color(0, 153, 204));
		painelNorteOeste.setBackground(new Color(0, 143, 204));
		painelNorteOeste.add(lblLogo);
		painelNorte.add(painelNorteOeste, BorderLayout.WEST);
		
		//Painel Oeste
		painelOeste = new JPanel(new BorderLayout());
		
		//Icone, nome de perfil
		painelOesteNorte = new JPanel(new GridLayout(2,2));
		painelOeste.setBackground(new Color(38, 38, 38));
		painelOesteNorte.setBackground(new Color(38, 38, 38));
		perfilIcon = criarImageIcon("../img/female-icon.png", "Icone Perfil");
		redimencionar(perfilIcon);
		lblIconePerfil.setIcon(perfilIcon);
		JTextField pesquisar = new JTextField("Pesquisar...");
		buscarButton = new JButton("Buscar");
		painelOesteNorte.add(lblIconePerfil);
		painelOesteNorte.add(lblNomeUsuario);
		painelOesteNorte.add(pesquisar);
		painelOesteNorte.add(buscarButton);
		
		//Coletor e Empresa
		painelOesteCentro = new JPanel(new GridLayout(6,1));
		painelOesteCentro.setBackground(new Color(38, 38, 38));
		cadastrarColetorButton = new JButton("Cadastrar Coletor");
		consultarColetorButton = new JButton("Consultar Coletor");
		cadastrarEmpresaButton = new JButton("Cadastrar Empresa");
		consultarEmpresaButton = new JButton("Consultar Empresa");
		painelOesteCentro.add(cadastrarColetorButton);
		painelOesteCentro.add(consultarColetorButton);
		painelOesteCentro.add(cadastrarEmpresaButton);
		painelOesteCentro.add(consultarEmpresaButton);
		
		//alterar preços
		painelOesteSul = new JPanel(new GridLayout(1,1));
		painelOesteSul.setBackground(new Color(38, 38, 38));
		alterarPrecosButton = new JButton("Ajustar Valores do dia");
		painelOesteSul.add(alterarPrecosButton);
		
		painelOeste.add(painelOesteNorte, BorderLayout.NORTH);
		painelOeste.add(painelOesteCentro, BorderLayout.CENTER);
		painelOeste.add(painelOesteSul, BorderLayout.SOUTH);
		
		//Painel Centro
		painelCentro = new JPanel(new BorderLayout());
		painelCentroNorte = new JPanel(new BorderLayout());
		lblInicio = new JLabel("Início");
		lblInicio.setFont(fontTitulo);
		lblPainelDeControle = new JLabel("Painel de Controle");
		lblPainelDeControle.setFont(fontSubTitulo);
		lblPainelDeControle.setForeground(Color.GRAY);
		painelCentroNorte.add(lblInicio, BorderLayout.WEST);
		painelCentroNorte.add(lblPainelDeControle, BorderLayout.CENTER);
		
		painelCentro.add(painelCentroNorte, BorderLayout.NORTH);
		
		//Painel Geral
		caixa.add(painelNorte, BorderLayout.NORTH);
		caixa.add(painelOeste, BorderLayout.WEST);
		caixa.add(painelCentro, BorderLayout.CENTER);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1266, 529);
		setVisible(true);
		
		
	}

	public ImageIcon criarImageIcon(String caminho, String descricao) {
		java.net.URL imgURL = getClass().getResource(caminho);
		if (imgURL != null) {
			return new ImageIcon(imgURL, descricao);
		} else {
			System.err.println("Não foi possível carregar o arquivo de imagem: " + caminho);
			return null;
		}
	}
	
	public void redimencionar(ImageIcon icone) {
		lblIconePerfil = new JLabel();
		lblIconePerfil.setBounds(10, 11, 50, 50);
		Image img = icone.getImage();
		Image newImg = img.getScaledInstance(lblIconePerfil.getWidth(), lblIconePerfil.getHeight(), Image.SCALE_SMOOTH);
		this.perfilIcon = new ImageIcon(newImg);
	}
}