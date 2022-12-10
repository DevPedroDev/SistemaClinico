package Telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JTextField;

public class Cad extends JFrame {

	private JPanel painel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cad frame = new Cad();
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
	public Cad() {
		setTitle("Tela");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 428);
		painel = new JPanel();
		painel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(painel);
		painel.setLayout(null);
		
		
		
		JCheckBox atendente = new JCheckBox("Atendente");
		atendente.setForeground(SystemColor.textHighlight);
		atendente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		atendente.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		atendente.setBounds(45, 223, 123, 23);
		painel.add(atendente);
		
		
		JCheckBox med = new JCheckBox(" M\u00E9dico");
		med.setBackground(UIManager.getColor("CheckBox.interiorBackground"));
		med.setForeground(SystemColor.textHighlight);
		med.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		med.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		med.setBounds(270, 223, 123, 23);
		painel.add(med);
		
		JLabel lblNewLabel = new JLabel("CADASTRAR");
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.PLAIN, 21));
		lblNewLabel.setBounds(147, 173, 130, 32);
		painel.add(lblNewLabel);
		
		JButton Cadastrar = new JButton("Cadastrar");
		Cadastrar.setBackground(SystemColor.activeCaption);
		Cadastrar.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		Cadastrar.setBounds(141, 274, 151, 40);
		painel.add(Cadastrar);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\pedro\\OneDrive\\\u00C1rea de Trabalho\\design\\login2.png"));
		lblNewLabel_2.setBounds(159, 24, 141, 123);
		painel.add(lblNewLabel_2);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(100, 149, 237));
		panel.setForeground(Color.WHITE);
		panel.setBounds(0, 0, 4, 389);
		painel.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(100, 149, 237));
		panel_1.setBounds(0, 0, 434, 10);
		painel.add(panel_1);
		
		JButton btnNewButton = new JButton("Voltar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int resposta;
				resposta = JOptionPane.showConfirmDialog(null, "Deseja voltar para a tela anterior?");
					 
					 
						if(resposta == JOptionPane.YES_OPTION) {
							new LoginAdm().setVisible(true);
						}
			}
		});
		btnNewButton.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.setBounds(172, 325, 89, 29);
		painel.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\pedro\\OneDrive\\\u00C1rea de Trabalho\\design\\azul-bebe-tecidos-para-patchwork.jpg"));
		lblNewLabel_1.setBounds(0, 0, 434, 389);
		painel.add(lblNewLabel_1);
		Cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(med.isSelected()) {
					
					JOptionPane.showMessageDialog(null, "Bem vindo a tela de cadastrar médicos");
					new CadMedico().setVisible(true);
					dispose();
				}
				if(atendente.isSelected()) {
					JOptionPane.showMessageDialog(null, "Bem vindo a tela de cadastrar atendentes");
					new CadAtendente().setVisible(true);
					dispose();
				} 
				else {
					JOptionPane.showMessageDialog(null, "Escolha uma das opções", "Avisa ao usuário", JOptionPane.ERROR_MESSAGE);
				}
				
			}
			
		});
		
		
	}
}
