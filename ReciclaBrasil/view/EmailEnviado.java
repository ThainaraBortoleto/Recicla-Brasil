package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EmailEnviado extends JFrame {

	private JPanel contentPane;
	private JButton btnEnvar;
	private Observador observador;
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmailEnviado frame = new EmailEnviado();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public EmailEnviado() {
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
		lblReciclaBrasil.setBounds(303, 88, 138, 38);
		lblReciclaBrasil.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		panel.add(lblReciclaBrasil);

		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(
				"C:\\Users\\thain\\Documents\\ProjetoPI\\ReciclaBrasil\\ReciclaBrasil\\view\\ReciclaImagem.png"));
		label_1.setBounds(441, 74, 59, 58);
		panel.add(label_1);

		JLabel lblEmail = new JLabel("Email enviado com sucesso!!");
		lblEmail.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblEmail.setBounds(253, 196, 257, 31);
		panel.add(lblEmail);

		btnEnvar = new JButton("OK");
		btnEnvar.setBackground(Color.GREEN);
		btnEnvar.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnEnvar.setBounds(656, 406, 89, 23);
		panel.add(btnEnvar);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(
				"C:\\Users\\thain\\Documents\\ProjetoPI\\ReciclaBrasil\\ReciclaBrasil\\view\\green-nature-vector-backgrounds-powerpoint.jpg"));
		label.setBounds(0, 0, 781, 458);
		panel.add(label);
		
		//observador
		observador = new Observador();
		btnEnvar.addActionListener(observador);
	}
	
	class Observador implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == btnEnvar) {
				new TelaLogin();
				dispose();
			}
		}
	}
}
