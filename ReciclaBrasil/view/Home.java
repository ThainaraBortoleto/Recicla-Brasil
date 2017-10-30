import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Home extends JFrame{
	private JLabel lblLogo, lblNomeUsuario, lblIcone;
	private ImageIcon icone;
	
	public Home() {
		super("Home");
		
		Container caixa = getContentPane();
		caixa.setBackground(new Color(247, 249, 255));
		caixa.setLayout(new BorderLayout());
		
		lblLogo = new JLabel("ReciclaBrasil");
		lblNomeUsuario = new JLabel("Nome usuário");
		lblLogo.setForeground(new Color(255, 255, 255));
		lblNomeUsuario.setForeground(Color.white);
		
		Font fontTitulo = new Font("Roboto", Font.BOLD, 20);
		Font fontSubTitulo = new Font("Roboto", Font.ITALIC, 14);
		lblLogo.setFont(fontTitulo);
		lblNomeUsuario.setFont(fontSubTitulo);
		
		JPanel painelNorte = new JPanel(new BorderLayout());
		JPanel painelNorteOeste = new JPanel(new FlowLayout());
		painelNorte.setBackground(new Color(0, 153, 204));
		painelNorteOeste.setBackground(new Color(0, 143, 204));
		painelNorteOeste.add(lblLogo);
		painelNorte.add(painelNorteOeste, BorderLayout.WEST);
		
		JPanel painelOeste = new JPanel(new BorderLayout());
		JPanel painelOesteNorte = new JPanel(new FlowLayout());
		painelOeste.setBackground(new Color(38, 38, 38));
		painelOesteNorte.setBackground(new Color(38, 38, 38));
		icone = criarImageIcon("../img/female-icon.png", "Icone Perfil");
		redimencionar(icone);
		lblIcone.setIcon(icone);
		painelOesteNorte.add(lblIcone);
		painelOesteNorte.add(lblNomeUsuario);
		
		painelOeste.add(painelOesteNorte, BorderLayout.NORTH);
		
		JPanel painelCentro = new JPanel(new BorderLayout());
		JPanel painelCentroNorte = new JPanel(new BorderLayout());
		JLabel lblInicio = new JLabel("Início");
		lblInicio.setFont(fontTitulo);
		JLabel lblPainelDeControle = new JLabel("Painel de Controle");
		lblPainelDeControle.setFont(fontSubTitulo);
		lblPainelDeControle.setForeground(Color.GRAY);
		painelCentroNorte.add(lblInicio, BorderLayout.WEST);
		painelCentroNorte.add(lblPainelDeControle, BorderLayout.CENTER);
		
		painelCentro.add(painelCentroNorte, BorderLayout.NORTH);
		
		
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
		lblIcone = new JLabel();
		lblIcone.setBounds(10, 11, 50, 50);
		Image img = icone.getImage();
		Image newImg = img.getScaledInstance(lblIcone.getWidth(), lblIcone.getHeight(), Image.SCALE_SMOOTH);
		this.icone = new ImageIcon(newImg);
	}
}