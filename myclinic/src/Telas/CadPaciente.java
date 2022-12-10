package Telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BD.ConexaoBD;
import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JProgressBar;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;

public class CadPaciente extends JFrame {

	private JPanel contentPane;
	private JTextField nomePaciente;
	private JTextField nascimentoPaciente;
	private JTextField telefonePaciente;
	private JTextField emailPaciente;
	private JTextField cpfPaciente;
	private JTextField idPaciente;
	private JTable jTableMedicos;
	private JTable tableMed;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadPaciente frame = new CadPaciente();
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
	public CadPaciente() {
		setTitle("Paciente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 490, 502);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setBounds(10, 75, 46, 14);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		contentPane.add(lblNewLabel);
		
		nomePaciente = new JTextField();
		nomePaciente.setBounds(53, 73, 145, 20);
		contentPane.add(nomePaciente);
		nomePaciente.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Cadastrar Pacientes");
		lblNewLabel_1.setBounds(126, 11, 210, 38);
		lblNewLabel_1.setFont(new Font("Sitka Small", Font.BOLD, 18));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNascimento = new JLabel("Nascimento:");
		lblNascimento.setBounds(208, 75, 73, 14);
		lblNascimento.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		contentPane.add(lblNascimento);
		
		nascimentoPaciente = new JTextField();
		nascimentoPaciente.setBounds(291, 73, 133, 20);
		nascimentoPaciente.setColumns(10);
		contentPane.add(nascimentoPaciente);
		
		JLabel lblNewLabel_2_1 = new JLabel("Telefone:");
		lblNewLabel_2_1.setBounds(10, 109, 63, 14);
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		contentPane.add(lblNewLabel_2_1);
		
		telefonePaciente = new JTextField();
		telefonePaciente.setBounds(73, 107, 175, 20);
		telefonePaciente.setColumns(10);
		contentPane.add(telefonePaciente);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Email:");
		lblNewLabel_2_1_1.setBounds(258, 109, 46, 14);
		lblNewLabel_2_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		contentPane.add(lblNewLabel_2_1_1);
		
		emailPaciente = new JTextField();
		emailPaciente.setBounds(301, 107, 123, 20);
		emailPaciente.setColumns(10);
		contentPane.add(emailPaciente);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("CPF:");
		lblNewLabel_2_1_1_1.setBounds(10, 144, 46, 14);
		lblNewLabel_2_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		contentPane.add(lblNewLabel_2_1_1_1);
		
		cpfPaciente = new JTextField();
		cpfPaciente.setBounds(53, 142, 195, 20);
		cpfPaciente.setColumns(10);
		contentPane.add(cpfPaciente);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(25, 201, 89, 23);
		contentPane.add(btnCadastrar);
		btnCadastrar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				try {
				Connection cadastrar = ConexaoBD.createConnectionToMySQL();
				String sql = "insert into paciente (nome_paciente, nasc_paciente, tel_paciente, email_paciente, cpf_paciente) value (?,?, ?, ?, ?)";
				PreparedStatement stmt = cadastrar.prepareStatement(sql);
				stmt.setString(1, nomePaciente.getText());
				stmt.setString(2, nascimentoPaciente.getText());
				stmt.setString(3, telefonePaciente.getText());
				stmt.setString(4, emailPaciente.getText());
				stmt.setString(5, cpfPaciente.getText());
				
				stmt.execute();
				stmt.close();
				cadastrar.close();
				JOptionPane.showMessageDialog(null, "Paciente cadastrado!");
				} catch (SQLException ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, "Não foi possível cadastrar");
				}
			
	
	}
});
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(124, 201, 89, 23);
		contentPane.add(btnBuscar);
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Connection buscar = ConexaoBD.createConnectionToMySQL();
					String sql = "select * from paciente where cpf_paciente=?";
					PreparedStatement stmt = buscar.prepareStatement(sql);
					stmt.setString(1, cpfPaciente.getText());
					ResultSet rs = stmt.executeQuery();
					
					while(rs.next()) {
						nomePaciente.setText(rs.getString("nome_paciente"));
						nascimentoPaciente.setText(rs.getString("nasc_paciente"));
						telefonePaciente.setText(rs.getString("tel_paciente"));
						emailPaciente.setText(rs.getString("email_paciente"));
						idPaciente.setText(rs.getString("id_paciente"));
					}
					rs.close();
					stmt.close();
					buscar.close();
					
				} catch (Exception e1) {
					e1.printStackTrace();
					
				}
			}
		});
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBounds(223, 201, 89, 23);
		contentPane.add(btnAtualizar);
btnAtualizar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				try {
				Connection atualizar = ConexaoBD.createConnectionToMySQL();
				String sql = "update paciente set nome_paciente=?, nasc_paciente=?, tel_paciente=?, email_paciente=?, cpf_paciente=?   where id_paciente=?";
				
				PreparedStatement stmt = atualizar.prepareStatement(sql);
				stmt.setString(1, nomePaciente.getText());
				stmt.setString(2, nascimentoPaciente.getText());
				stmt.setString(3, telefonePaciente.getText());
				stmt.setString(4, emailPaciente.getText());
				stmt.setString(5, cpfPaciente.getText());
				stmt.setString(6, idPaciente.getText());
				
				
				
				stmt.execute();
				stmt.close();
				atualizar.close();
				JOptionPane.showMessageDialog(null, "Paciente Atualizado!");
				} catch (SQLException ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, "Não foi possível atualizar");
				}
			
	
	}
});
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.setBounds(322, 201, 89, 23);
		contentPane.add(btnDeletar);
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection deletar = ConexaoBD.createConnectionToMySQL();
					String sql = "delete from paciente where id_paciente=?";
					PreparedStatement stmt = deletar.prepareStatement(sql);
					stmt.setString(1, idPaciente.getText());
					
				  int resposta;
				  resposta = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja deletar o paciente");
				  
				  if(resposta == JOptionPane.YES_OPTION) {
					  	stmt.execute();
						stmt.close();
						deletar.close();
						JOptionPane.showMessageDialog(null, "Paciente deletado com Sucesso!");
					  
				  } else {
					  System.exit(0);
				  }
				  
				  
						
					
					
						
						
				
				
			} catch (Exception e1) {
			e1.printStackTrace();
		}
				
			}
		});
		
		
			
			
		
		
		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("ID:");
		lblNewLabel_2_1_1_1_1.setBounds(268, 144, 46, 14);
		lblNewLabel_2_1_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		contentPane.add(lblNewLabel_2_1_1_1_1);
		
		idPaciente = new JTextField();
		idPaciente.setBounds(291, 142, 86, 20);
		contentPane.add(idPaciente);
		idPaciente.setColumns(10);
		
		JScrollPane aa = new JScrollPane();
		aa.setBounds(10, 245, 454, 151);
		contentPane.add(aa);
		
		tableMed = new JTable();
		tableMed.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
				"ID",
				"Nome",
				"Nascimento",
				"Telefone",
				"Email",
				"CPF"
			}
		));
		aa.setViewportView(tableMed);
		
		JLabel lblNewLabel_1_1 = new JLabel("Cadastrar Consulta");
		lblNewLabel_1_1.setFont(new Font("Sitka Small", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(20, 407, 210, 38);
		contentPane.add(lblNewLabel_1_1);
		
		JButton btnCliqueAqui = new JButton("Clique aqui");
		btnCliqueAqui.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new Consulta().setVisible(true);
				dispose();
			}
		});
		btnCliqueAqui.setBounds(240, 406, 108, 38);
		contentPane.add(btnCliqueAqui);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\pedro\\OneDrive\\\u00C1rea de Trabalho\\design\\azul-bebe-tecidos-para-patchwork.jpg"));
		lblNewLabel_2.setBounds(0, 0, 474, 463);
		contentPane.add(lblNewLabel_2);
		
		
		
		try {
			
			
			 Connection conn = ConexaoBD.createConnectionToMySQL();
			 String sql = "SELECT * FROM paciente";
			 PreparedStatement stmt = (PreparedStatement)conn.prepareStatement(sql);
			 stmt.execute();
			 
			 ResultSet rs = stmt.executeQuery(sql);
			
			 
			 DefaultTableModel model = (DefaultTableModel) tableMed.getModel();
			 model.setNumRows(0);
			
			 
			 
			 
			 while(rs.next()) {
				 
				 model.addRow(new Object[]
						 {
								 
						 rs.getString("id_paciente"),
						 rs.getString("nome_paciente"),
						 rs.getString("nasc_paciente"),
						 rs.getString("tel_paciente"),
						 rs.getString("email_paciente"),
						 rs.getString("cpf_paciente")
						 
						 
						 
						 });
				
			 }
			 
			 conn.close();
			 stmt.close();
			 
			
			
		} catch(Exception e) {
			System.out.println("o erro foi " +e);
		}
		
		
		
		
		
		      
		
		
	
		}
}
