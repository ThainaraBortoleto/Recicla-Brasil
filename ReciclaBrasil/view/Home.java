import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Home extends JFrame{
	private JLabel lblLogo, lblTeste2;
	
	public Home() {
		super("Home");
		
		Container caixa = getContentPane();
		caixa.setBackground(new Color(247, 249, 255));
		caixa.setLayout(new BorderLayout());
		
		lblLogo = new JLabel("ReciclaBrasil");
		lblTeste2 = new JLabel("ReciclaBrasil");
		lblLogo.setForeground(new Color(255, 255, 255));
		lblTeste2.setForeground(Color.white);
		
		Font fontTitulo = new Font("Roboto", Font.BOLD, 20);
		Font fontSubTitulo = new Font("Roboto", Font.ITALIC, 14);
		lblLogo.setFont(fontTitulo);
		lblTeste2.setFont(fontTitulo);
		
		JPanel painelNorte = new JPanel(new FlowLayout());
		painelNorte.setBackground(new Color(0, 153, 204));
		painelNorte.add(lblLogo);
		
		JPanel painelOeste = new JPanel();
		painelOeste.setBackground(new Color(38, 38, 38));
		painelOeste.add(lblTeste2);
		
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
}