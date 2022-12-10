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
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class Consulta extends JFrame {

	private JPanel contentPane;
	private JTextField txtConsulta;
	private JTextField idConsulta;
	private JTextField cpf_user;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Consulta frame = new Consulta();
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
	public Consulta() {
		setTitle("Consulta");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 410);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cadastrar Consulta");
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.PLAIN, 19));
		lblNewLabel.setBounds(124, 23, 194, 46);
		contentPane.add(lblNewLabel);
		
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\pedro\\OneDrive\\\u00C1rea de Trabalho\\design\\consulta.png"));
		lblNewLabel_1.setBounds(23, 80, 134, 126);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("ID:");
		lblNewLabel_2.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(333, 304, 32, 20);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Data Consulta:");
		lblNewLabel_2_1.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(184, 106, 94, 26);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Prontuario:");
		lblNewLabel_2_2.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		lblNewLabel_2_2.setBounds(237, 175, 80, 27);
		contentPane.add(lblNewLabel_2_2);
		
		txtConsulta = new JTextField();
		txtConsulta.setBounds(270, 106, 118, 20);
		contentPane.add(txtConsulta);
		txtConsulta.setColumns(10);
		
		idConsulta = new JTextField();
		idConsulta.setColumns(10);
		idConsulta.setBounds(355, 301, 46, 20);
		contentPane.add(idConsulta);
		
		JTextArea txtProntuario = new JTextArea();
		txtProntuario.setBounds(237, 205, 164, 88);
		contentPane.add(txtProntuario);
		
		JButton Cadastrar = new JButton("Cadastrar");
		Cadastrar.setBounds(33, 324, 94, 23);
		contentPane.add(Cadastrar);
		
		Cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				Connection cadastrar = ConexaoBD.createConnectionToMySQL();
				String sql = "insert into consulta (data_consulta, prontuario_consulta, cpf_paciente) value (?,?, ?)";
				PreparedStatement stmt = cadastrar.prepareStatement(sql);
				stmt.setString(1, txtConsulta.getText());
				stmt.setString(2, txtProntuario.getText());
				stmt.setString(3, cpf_user.getText());
				
				stmt.execute();
				stmt.close();
				cadastrar.close();
				JOptionPane.showMessageDialog(null, "Prontuário Cadastrado!");
				} catch (SQLException ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, "Não foi possível cadastrar");
				}
			
		}
	});
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(135, 324, 89, 23);
		contentPane.add(btnBuscar);
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Connection buscar = ConexaoBD.createConnectionToMySQL();
					String sql = "select * from consulta  where cpf_paciente=?";
					PreparedStatement stmt = buscar.prepareStatement(sql);
					stmt.setString(1, cpf_user.getText());
					ResultSet rs = stmt.executeQuery();
					
					while(rs.next()) {
						idConsulta.setText(rs.getString("id_consulta"));
						txtConsulta.setText(rs.getString("data_consulta"));
						txtProntuario.setText(rs.getString("prontuario_consulta"));
						cpf_user.setText(rs.getString("cpf_paciente"));
						
					}
					rs.close();
					stmt.close();
					buscar.close();
					
				} catch (Exception e1) {
					e1.printStackTrace();
					
				}
				
				
				
			}
			
		});
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setBounds(234, 324, 89, 23);
		contentPane.add(btnAlterar);
		
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Connection cadastrar = ConexaoBD.createConnectionToMySQL();
					String sql = "update consulta set data_consulta=?, prontuario_consulta=? where cpf_paciente=?";
					PreparedStatement stmt = cadastrar.prepareStatement(sql);
					stmt.setString(1, txtConsulta.getText());
					stmt.setString(2, txtProntuario.getText());
					stmt.setString(3, cpf_user.getText());
					
					stmt.execute();
					stmt.close();
					cadastrar.close();
					JOptionPane.showMessageDialog(null, "Prontuario atualizado!");
					} catch (SQLException ex) {
						ex.printStackTrace();
						JOptionPane.showMessageDialog(null, "Não foi possível atualizar");
					}
				
			}
		});
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.setBounds(333, 324, 89, 23);
		contentPane.add(btnDeletar);
		btnDeletar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				Connection deletar = ConexaoBD.createConnectionToMySQL();
				String sql = "delete from consulta where cpf_paciente=?";
				PreparedStatement stmt = deletar.prepareStatement(sql);
				stmt.setString(1, cpf_user.getText());
				int resposta;
				  resposta = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja deletar o prontuário?");
				  
				  if(resposta == JOptionPane.YES_OPTION) {
					  	stmt.execute();
						stmt.close();
						deletar.close();
						JOptionPane.showMessageDialog(null, "Prontuario Deletado com Sucesso!");
					  
				  } else {
					  System.exit(0);
				  }
			
			
		} catch (Exception e1) {
		e1.printStackTrace();
	}
			
		}
	});
		
		JLabel lblNewLabel_2_3 = new JLabel("CPF:");
		lblNewLabel_2_3.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		lblNewLabel_2_3.setBounds(34, 236, 46, 20);
		contentPane.add(lblNewLabel_2_3);
		
		cpf_user = new JTextField();
		cpf_user.setBounds(68, 233, 86, 20);
		contentPane.add(cpf_user);
		cpf_user.setColumns(10);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int resposta;
				resposta = JOptionPane.showConfirmDialog(null, "Tem certeza de que deseja voltar para a pagina anterior?");
				
				if(resposta == JOptionPane.YES_OPTION) {
					 new CadPaciente().setVisible(true);
				}
			
				
				
			}
		});
		btnVoltar.setBounds(328, 22, 89, 23);
		contentPane.add(btnVoltar);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\pedro\\OneDrive\\\u00C1rea de Trabalho\\design\\azul-bebe-tecidos-para-patchwork.jpg"));
		lblNewLabel_3.setBounds(0, 0, 434, 371);
		contentPane.add(lblNewLabel_3);
	}
}
