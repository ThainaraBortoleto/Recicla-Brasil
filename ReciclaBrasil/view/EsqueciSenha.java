package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class EsqueciSenha extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private Observador observador;
	private JButton btnEnviar;
	private JButton btnCancelar;

	
	public EsqueciSenha() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 810, 514);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 11, 774, 453);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblReciclaBrasil = new JLabel("Recicla Brasil");
		lblReciclaBrasil.setBounds(300, 94, 138, 38);
		lblReciclaBrasil.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		panel.add(lblReciclaBrasil);

		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(
				"C:\\Users\\thain\\Documents\\ProjetoPI\\ReciclaBrasil\\ReciclaBrasil\\view\\ReciclaImagem.png"));
		label_1.setBounds(430, 74, 59, 58);
		panel.add(label_1);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblEmail.setBounds(169, 205, 46, 14);
		panel.add(lblEmail);

		textField = new JTextField();
		textField.setBounds(230, 199, 287, 29);
		panel.add(textField);
		textField.setColumns(10);

		JLabel lblUmEmailSer = new JLabel("Um email será enviado para redefinir sua senha!");
		lblUmEmailSer.setBounds(258, 169, 346, 23);
		panel.add(lblUmEmailSer);

		btnEnviar = new JButton("Enviar");
		btnEnviar.setBackground(Color.GREEN);
		btnEnviar.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnEnviar.setBounds(655, 406, 89, 23);
		panel.add(btnEnviar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(Color.ORANGE);
		btnCancelar.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnCancelar.setBounds(22, 406, 89, 23);
		panel.add(btnCancelar);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(
				"C:\\Users\\thain\\Documents\\ProjetoPI\\ReciclaBrasil\\ReciclaBrasil\\view\\green-nature-vector-backgrounds-powerpoint.jpg"));
		label.setBounds(0, 0, 781, 458);
		panel.add(label);
		
		//observador
		observador = new Observador();
		btnEnviar.addActionListener(observador);
		btnCancelar.addActionListener(observador);
	}
	
	class Observador implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == btnEnviar) {
				EmailEnviado msg = new EmailEnviado();
				msg.setVisible(true);
				dispose();
			} else {
				new TelaLogin();
				dispose();
			}
		}
	}
}
