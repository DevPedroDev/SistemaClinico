package Telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BD.ConexaoBD;

import javax.swing.JButton;
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
import javax.swing.ImageIcon;

public class LoginMedico extends JFrame {

	private JPanel contentPane;
	private JTextField txtLoginMed;
	private JPasswordField txtSenhaMed;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginMedico frame = new LoginMedico();
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
	public LoginMedico() {
		setTitle("M\u00E9dico");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 429, 416);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\pedro\\OneDrive\\\u00C1rea de Trabalho\\design\\botao2.png"));
		btnNewButton.setBounds(177, 291, 46, 32);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
				Connection conexao = ConexaoBD.createConnectionToMySQL();
				String sql = "select * from medico where crm_medico=? and senha_medico=?";
				PreparedStatement stmt = conexao.prepareStatement(sql);
				stmt.setString(1, txtLoginMed.getText());
				stmt.setString(2, new String(txtSenhaMed.getPassword()));
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
		
		JLabel lblNewLabel_1 = new JLabel("CRM");
		lblNewLabel_1.setFont(new Font("Sylfaen", Font.BOLD, 17));
		lblNewLabel_1.setBounds(177, 158, 61, 23);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Senha");
		lblNewLabel_1_1.setFont(new Font("Sylfaen", Font.BOLD, 17));
		lblNewLabel_1_1.setBounds(177, 229, 61, 20);
		contentPane.add(lblNewLabel_1_1);
		
		txtLoginMed = new JTextField();
		txtLoginMed.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		txtLoginMed.setBounds(109, 188, 186, 20);
		contentPane.add(txtLoginMed);
		txtLoginMed.setColumns(10);
		
		txtSenhaMed = new JPasswordField();
		txtSenhaMed.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		txtSenhaMed.setBounds(109, 253, 186, 20);
		contentPane.add(txtSenhaMed);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\pedro\\OneDrive\\\u00C1rea de Trabalho\\design\\medico2.png"));
		lblNewLabel_2.setBounds(139, 14, 127, 133);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\pedro\\OneDrive\\\u00C1rea de Trabalho\\design\\fei.jpg"));
		lblNewLabel_3.setBounds(0, 0, 423, 377);
		contentPane.add(lblNewLabel_3);
	}

}
