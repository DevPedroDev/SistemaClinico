package Telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BD.ConexaoBD;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;

public class LoginAtendente extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomeAtendente;
	private JPasswordField txtSenhaAtendente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginAtendente frame = new LoginAtendente();
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
	public LoginAtendente() {
		setTitle("Atendente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 411, 302);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtNomeAtendente = new JTextField();
		txtNomeAtendente.setToolTipText("");
		txtNomeAtendente.setBounds(154, 97, 171, 20);
		contentPane.add(txtNomeAtendente);
		txtNomeAtendente.setColumns(10);
		
		txtSenhaAtendente = new JPasswordField();
		txtSenhaAtendente.setBounds(154, 153, 171, 20);
		contentPane.add(txtSenhaAtendente);
		
		JLabel lblNewLabel_1 = new JLabel("Login");
		lblNewLabel_1.setFont(new Font("Sylfaen", Font.BOLD, 17));
		lblNewLabel_1.setBounds(168, 67, 61, 29);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Senha");
		lblNewLabel_1_1.setFont(new Font("Sylfaen", Font.BOLD, 17));
		lblNewLabel_1_1.setBounds(168, 128, 61, 29);
		contentPane.add(lblNewLabel_1_1);
		
		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.setForeground(new Color(70, 130, 180));
		btnNewButton.setBackground(new Color(230, 230, 250));
		btnNewButton.setFont(new Font("Stencil", Font.PLAIN, 13));
		btnNewButton.setBounds(189, 184, 89, 33);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\pedro\\OneDrive\\\u00C1rea de Trabalho\\design\\user2.png"));
		lblNewLabel_2.setBounds(10, 57, 123, 137);
		contentPane.add(lblNewLabel_2);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(70, 130, 180));
		panel.setBounds(0, 0, 10, 263);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(70, 130, 180));
		panel_1.setBounds(0, 253, 395, 10);
		contentPane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(70, 130, 180));
		panel_2.setBounds(385, 0, 10, 263);
		contentPane.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(375, 0, -373, 10);
		contentPane.add(panel_3);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(70, 130, 180));
		panel_1_1.setBounds(0, 0, 395, 10);
		contentPane.add(panel_1_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\pedro\\OneDrive\\\u00C1rea de Trabalho\\design\\azul-bebe-tecidos-para-patchwork.jpg"));
		lblNewLabel.setBounds(0, 0, 395, 263);
		contentPane.add(lblNewLabel);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
				Connection conexao = ConexaoBD.createConnectionToMySQL();
				String sql = "select * from atendente where nome_atendente=? and senha_atendente=?";
				PreparedStatement stmt = conexao.prepareStatement(sql);
				stmt.setString(1, txtNomeAtendente.getText());
				stmt.setString(2, new String(txtSenhaAtendente.getPassword()));
				ResultSet rs = stmt.executeQuery();
				
				if(rs.next()) {
					JOptionPane.showMessageDialog(null, "Acesso Liberado");
					new CadPaciente().setVisible(true);
					dispose();
					} else {
					JOptionPane.showMessageDialog(null, "Acesso Negado");
					}
				
				stmt.close();
				conexao.close();
				} catch (Exception e1) {
					e1.printStackTrace();
					
				}
				
				
			}
		});
	}
}
