package Telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Window;

import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.ImageIcon;

public class Login extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 479, 408);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(100, 149, 237));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JCheckBox medico = new JCheckBox("M\u00E9dico");
		medico.setForeground(new Color(100, 149, 237));
		medico.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		medico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
			}
		});
		medico.setBounds(94, 175, 97, 23);
		contentPane.add(medico);
		
		JCheckBox paciente = new JCheckBox("Atendente");
		paciente.setForeground(new Color(100, 149, 237));
		paciente.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		paciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		paciente.setBounds(295, 175, 112, 23);
		contentPane.add(paciente);
		
		
		
		JButton btnNewButton_1 = new JButton("Sair");
		btnNewButton_1.setBackground(new Color(95, 158, 160));
		btnNewButton_1.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sair();
				
			}
		});
		btnNewButton_1.setBounds(198, 285, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton login = new JButton("Entrar");
		login.setBackground(new Color(95, 158, 160));
		login.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(medico.isSelected()) {
					JOptionPane.showMessageDialog(null, "Bem vindo a tela de médicos");
					new LoginMedico().setVisible(true);
					dispose();
				} 
				
				if(paciente.isSelected()) {
					
					JOptionPane.showMessageDialog(null, "Bem vindo a tela de atendentes");
					new LoginAtendente().setVisible(true);
					dispose();
				} 
				
				

			}
		});
		login.setBounds(198, 238, 89, 36);
		contentPane.add(login);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(95, 158, 160));
		panel.setForeground(new Color(100, 149, 237));
		panel.setBounds(0, 0, 10, 369);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(95, 158, 160));
		panel_1.setBounds(0, 0, 463, 10);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\pedro\\OneDrive\\\u00C1rea de Trabalho\\design\\login2.png"));
		lblNewLabel.setBounds(183, 21, 132, 132);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\pedro\\OneDrive\\\u00C1rea de Trabalho\\design\\azul-bebe-tecidos-para-patchwork.jpg"));
		lblNewLabel_1.setBounds(0, 0, 463, 369);
		contentPane.add(lblNewLabel_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(medico.isSelected()) {
					
					
				} 
			}
		});
	}
	
	public void Sair() {
		System.exit(0);
	}
}
