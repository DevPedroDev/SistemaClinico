package Telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BD.ConexaoBD;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.SystemColor;

public class LoginAdm extends JFrame {

	private JPanel contentPane;
	private JTextField txtLoginAdm;
	private JPasswordField txtSenhaAdm;
	private JLabel lblSenha;
	private JLabel lblNewLabel_1;
	private JButton btnNewButton;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginAdm frame = new LoginAdm();
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
	public LoginAdm() {
		setTitle("ADM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 457, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtLoginAdm = new JTextField();
		txtLoginAdm.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		txtLoginAdm.setBounds(122, 219, 191, 20);
		contentPane.add(txtLoginAdm);
		txtLoginAdm.setColumns(10);
		
		txtSenhaAdm = new JPasswordField();
		txtSenhaAdm.setFont(new Font("Sitka Subheading", Font.PLAIN, 14));
		txtSenhaAdm.setBounds(122, 250, 191, 20);
		contentPane.add(txtSenhaAdm);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		lblNewLabel.setBounds(66, 222, 46, 20);
		contentPane.add(lblNewLabel);
		
		lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		lblSenha.setBounds(66, 255, 52, 16);
		contentPane.add(lblSenha);
		
		lblNewLabel_1 = new JLabel("ADMIN");
		lblNewLabel_1.setFont(new Font("Showcard Gothic", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(184, 165, 81, 43);
		contentPane.add(lblNewLabel_1);
		
		btnNewButton = new JButton("Entrar");
		btnNewButton.setFont(new Font("Stencil", Font.PLAIN, 13));
		btnNewButton.setBounds(176, 284, 89, 30);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\pedro\\OneDrive\\\u00C1rea de Trabalho\\design\\adm.png"));
		lblNewLabel_2.setBounds(155, 0, 128, 173);
		contentPane.add(lblNewLabel_2);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setForeground(SystemColor.activeCaption);
		panel.setBounds(0, 0, 10, 421);
		contentPane.add(panel);
		
		panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.activeCaption);
		panel_1.setBounds(0, 411, 441, 10);
		contentPane.add(panel_1);
		
		panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.activeCaption);
		panel_2.setBounds(431, 0, 10, 421);
		contentPane.add(panel_2);
		
		panel_3 = new JPanel();
		panel_3.setBackground(SystemColor.activeCaption);
		panel_3.setBounds(0, 0, 431, 10);
		contentPane.add(panel_3);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
				Connection conexao = ConexaoBD.createConnectionToMySQL();
				String sql = "select * from admin where login_admin=? and senha_admin=?";
				PreparedStatement stmt = conexao.prepareStatement(sql);
				stmt.setString(1, txtLoginAdm.getText());
				stmt.setString(2, new String(txtSenhaAdm.getPassword()));
				ResultSet rs = stmt.executeQuery();
				
				if(rs.next()) {
					JOptionPane.showMessageDialog(null, "Acesso Liberado");
					new Cad().setVisible(true);
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
