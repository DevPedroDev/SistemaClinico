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
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class CadAtendente extends JFrame {

	private JPanel contentPane;
	private JTextField nomeAtendente;
	private JPasswordField senhaAtendente;
	private JTextField idAtendente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadAtendente frame = new CadAtendente();
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
	public CadAtendente() {
		setTitle("Atendente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Atendente");
		lblNewLabel.setForeground(new Color(25, 25, 112));
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
		lblNewLabel.setBounds(189, 33, 117, 21);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(131, 87, 59, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Senha:");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel_1_1.setBounds(131, 112, 59, 14);
		contentPane.add(lblNewLabel_1_1);
		
		nomeAtendente = new JTextField();
		nomeAtendente.setBounds(189, 86, 135, 20);
		contentPane.add(nomeAtendente);
		nomeAtendente.setColumns(10);
		
		senhaAtendente = new JPasswordField();
		senhaAtendente.setBounds(189, 111, 135, 20);
		contentPane.add(senhaAtendente);
		
		JButton Cadastrar = new JButton("Cadastrar");
		Cadastrar.setBackground(new Color(25, 25, 112));
		Cadastrar.setForeground(new Color(240, 248, 255));
		Cadastrar.setBounds(20, 185, 99, 23);
		contentPane.add(Cadastrar);
		
		Cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				Connection cadastrar = ConexaoBD.createConnectionToMySQL();
				String sql = "insert into atendente (nome_atendente, senha_atendente) value (?,?)";
				PreparedStatement stmt = cadastrar.prepareStatement(sql);
				stmt.setString(1, nomeAtendente.getText());
				stmt.setString(2, senhaAtendente.getText());
				
				stmt.execute();
				stmt.close();
				cadastrar.close();
				JOptionPane.showMessageDialog(null, "Atendente cadastrado!");
				} catch (SQLException ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, "Não foi possível cadastrar");
				}
			
		}
	});
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBackground(new Color(25, 25, 112));
		btnBuscar.setForeground(new Color(245, 255, 250));
		btnBuscar.setBounds(324, 185, 89, 23);
		contentPane.add(btnBuscar);
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Connection buscar = ConexaoBD.createConnectionToMySQL();
					String sql = "select * from atendente where nome_atendente=?";
					PreparedStatement stmt = buscar.prepareStatement(sql);
					stmt.setString(1, nomeAtendente.getText());
					ResultSet rs = stmt.executeQuery();
					
					while(rs.next()) {
						nomeAtendente.setText(rs.getString("nome_atendente"));
						senhaAtendente.setText(rs.getString("senha_atendente"));
						idAtendente.setText(rs.getString("id_atendente"));
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
		btnAtualizar.setBackground(new Color(25, 25, 112));
		btnAtualizar.setForeground(new Color(245, 245, 245));
		btnAtualizar.setBounds(131, 185, 89, 23);
		contentPane.add(btnAtualizar);
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Connection cadastrar = ConexaoBD.createConnectionToMySQL();
					String sql = "update atendente set nome_atendente=?, senha_atendente=? where id_atendente=?";
					PreparedStatement stmt = cadastrar.prepareStatement(sql);
					stmt.setString(1, nomeAtendente.getText());
					stmt.setString(2, senhaAtendente.getText());
					stmt.setString(3, idAtendente.getText());
					
					stmt.execute();
					stmt.close();
					cadastrar.close();
					JOptionPane.showMessageDialog(null, "Atendente atualizado!");
					} catch (SQLException ex) {
						ex.printStackTrace();
						JOptionPane.showMessageDialog(null, "Não foi possível atualizar");
					}
				
			}
		});
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.setBackground(new Color(25, 25, 112));
		btnDeletar.setForeground(new Color(245, 255, 250));
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection deletar = ConexaoBD.createConnectionToMySQL();
					String sql = "delete from atendente where id_atendente=?";
					PreparedStatement stmt = deletar.prepareStatement(sql);
					stmt.setString(1, idAtendente.getText());
					int resposta;
					  resposta = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja deletar o atendente?");
					  
					  if(resposta == JOptionPane.YES_OPTION) {
						  	stmt.execute();
							stmt.close();
							deletar.close();
							JOptionPane.showMessageDialog(null, "Atendente deletado com Sucesso!");
						  
					  } else {
						  System.exit(0);
					  }
				
				
			} catch (Exception e1) {
			e1.printStackTrace();
		}
				
			}
		});
		btnDeletar.setBounds(230, 185, 89, 23);
		contentPane.add(btnDeletar);
		
		JLabel lblNewLabel_2 = new JLabel("ID:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(156, 137, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		idAtendente = new JTextField();
		idAtendente.setBounds(189, 137, 135, 20);
		contentPane.add(idAtendente);
		idAtendente.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\pedro\\OneDrive\\\u00C1rea de Trabalho\\design\\cadastro2.png"));
		lblNewLabel_3.setBounds(10, 54, 126, 120);
		contentPane.add(lblNewLabel_3);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int resposta;
				resposta = JOptionPane.showConfirmDialog(null, "Tem certeza de que deseja voltar para a pagina anterior?");
				
				if(resposta == JOptionPane.YES_OPTION) {
					 new Cad().setVisible(true);
				}
			}
		});
		btnVoltar.setForeground(new Color(245, 255, 250));
		btnVoltar.setBackground(new Color(25, 25, 112));
		btnVoltar.setBounds(176, 219, 89, 23);
		contentPane.add(btnVoltar);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\pedro\\OneDrive\\\u00C1rea de Trabalho\\design\\azul-bebe-tecidos-para-patchwork.jpg"));
		lblNewLabel_4.setBounds(0, -26, 434, 300);
		contentPane.add(lblNewLabel_4);
	}
}
