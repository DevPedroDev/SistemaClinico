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
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import java.awt.Color;

public class CadMedico extends JFrame {

	private JPanel contentPane;
	private JTextField med_cad;
	private JTextField crm_med;
	private JLabel lblCadastroMdico;
	private JButton btnNewButton;
	private JButton btnBuscar;
	private JButton btnAtualizar;
	private JButton btnDeletar;
	private JPasswordField senhamed;
	private JLabel lblNewLabel_3;
	private JTextField id_med;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadMedico frame = new CadMedico();
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
	public CadMedico() {
		setTitle("Medico");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 440, 308);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CRM:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel.setBounds(36, 72, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(36, 97, 59, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Senha:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(36, 122, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		med_cad = new JTextField();
		med_cad.setBounds(89, 96, 135, 20);
		contentPane.add(med_cad);
		med_cad.setColumns(10);
		
		crm_med = new JTextField();
		crm_med.setColumns(10);
		crm_med.setBounds(89, 71, 135, 20);
		contentPane.add(crm_med);
		
		lblCadastroMdico = new JLabel("M\u00E9dico");
		lblCadastroMdico.setForeground(new Color(25, 25, 112));
		lblCadastroMdico.setFont(new Font("Segoe UI Black", Font.PLAIN, 18));
		lblCadastroMdico.setBounds(283, 25, 113, 14);
		contentPane.add(lblCadastroMdico);
		
		btnNewButton = new JButton("Cadastrar");
		btnNewButton.setBackground(new Color(25, 25, 112));
		btnNewButton.setForeground(new Color(245, 255, 250));
		btnNewButton.addActionListener(new ActionListener() {
			
					public void actionPerformed(ActionEvent e) {
						try {
						Connection cadastrar = ConexaoBD.createConnectionToMySQL();
						String sql = "insert into medico (crm_medico, nome_medico, senha_medico) value (?,?, ?)";
						PreparedStatement stmt = cadastrar.prepareStatement(sql);
						stmt.setString(1, crm_med.getText());
						stmt.setString(2, med_cad.getText());
						stmt.setString(3, senhamed.getText());
						
						stmt.execute();
						stmt.close();
						cadastrar.close();
						JOptionPane.showMessageDialog(null, "Medico cadastrado!");
						} catch (SQLException ex) {
							ex.printStackTrace();
							JOptionPane.showMessageDialog(null, "Não foi possível cadastrar");
						}
					
			
			}
		});
		btnNewButton.setBounds(10, 196, 113, 23);
		contentPane.add(btnNewButton);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setForeground(new Color(245, 255, 250));
		btnBuscar.setBackground(new Color(25, 25, 112));
		btnBuscar.setBounds(133, 196, 89, 23);
		contentPane.add(btnBuscar);
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Connection buscar = ConexaoBD.createConnectionToMySQL();
					String sql = "select * from medico where nome_medico=?";
					PreparedStatement stmt = buscar.prepareStatement(sql);
					stmt.setString(1, med_cad.getText());
					ResultSet rs = stmt.executeQuery();
					
					while(rs.next()) {
						crm_med.setText(rs.getString("crm_medico"));
						med_cad.setText(rs.getString("nome_medico"));
						senhamed.setText(rs.getString("senha_medico"));
						id_med.setText(rs.getString("id_medico"));
					}
					rs.close();
					stmt.close();
					buscar.close();
					
				} catch (Exception e1) {
					e1.printStackTrace();
					
				}
			}
		});
				
		
		btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBackground(new Color(25, 25, 112));
		btnAtualizar.setForeground(new Color(245, 255, 250));
		btnAtualizar.setBounds(232, 196, 89, 23);
		contentPane.add(btnAtualizar);
		btnAtualizar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				try {
				Connection atualizar = ConexaoBD.createConnectionToMySQL();
				String sql = "update medico set crm_medico=?, nome_medico=?, senha_medico=?   where id_medico=?";
				
				PreparedStatement stmt = atualizar.prepareStatement(sql);
				stmt.setString(1, crm_med.getText());
				stmt.setString(2, med_cad.getText());
				stmt.setString(3, senhamed.getText());
				stmt.setString(4, id_med.getText());
				
				
				
				stmt.execute();
				stmt.close();
				atualizar.close();
				JOptionPane.showMessageDialog(null, "Medico Atualizado!");
				} catch (SQLException ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, "Não foi possível atualizar");
				}
			
	
	}
});
		
		
		btnDeletar = new JButton("Deletar");
		btnDeletar.setBackground(new Color(25, 25, 112));
		btnDeletar.setForeground(new Color(245, 255, 250));
		btnDeletar.setBounds(325, 196, 89, 23);
		contentPane.add(btnDeletar);
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection deletar = ConexaoBD.createConnectionToMySQL();
					String sql = "delete from medico where id_medico=?";
					PreparedStatement stmt = deletar.prepareStatement(sql);
					stmt.setString(1, id_med.getText());
					int resposta;
					  resposta = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja deletar o Médico?");
					  
					  if(resposta == JOptionPane.YES_OPTION) {
						  	stmt.execute();
							stmt.close();
							deletar.close();
							JOptionPane.showMessageDialog(null, "Medico deletado com Sucesso!");
						  
					  } else {
						  System.exit(0);
					  }
				
				
			} catch (Exception e1) {
			e1.printStackTrace();
		}
				
			}
		});
		
		senhamed = new JPasswordField();
		senhamed.setBounds(89, 122, 135, 20);
		contentPane.add(senhamed);
		
		lblNewLabel_3 = new JLabel("ID:");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel_3.setBounds(60, 154, 22, 14);
		contentPane.add(lblNewLabel_3);
		
		id_med = new JTextField();
		id_med.setBounds(89, 153, 34, 20);
		contentPane.add(id_med);
		id_med.setColumns(10);
		
		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\pedro\\OneDrive\\\u00C1rea de Trabalho\\design\\medico (1).png"));
		lblNewLabel_4.setBounds(259, 50, 135, 135);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\pedro\\OneDrive\\\u00C1rea de Trabalho\\design\\azul-bebe-tecidos-para-patchwork.jpg"));
		lblNewLabel_5.setBounds(0, 0, 424, 269);
		contentPane.add(lblNewLabel_5);
			}
		}


		
