package Telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JScrollBar;
import javax.swing.JToggleButton;
import javax.swing.JCheckBox;
import javax.swing.JSeparator;
import javax.swing.JProgressBar;
import javax.swing.JTree;
import javax.swing.JEditorPane;
import javax.swing.JRadioButton;

public class Niks extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Niks frame = new Niks();
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
	public Niks() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 478, 310);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Digite seu nome");
		lblNewLabel.setBounds(28, 32, 103, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(122, 29, 312, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(196, 60, 55, 20);
		contentPane.add(spinner);
		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setBounds(141, 60, 48, 20);
		contentPane.add(spinner_2);
		
		JLabel lblNewLabel_1 = new JLabel("Data de Nascimento");
		lblNewLabel_1.setBounds(25, 63, 118, 14);
		contentPane.add(lblNewLabel_1);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(257, 60, 65, 20);
		contentPane.add(spinner_1);
		
		JToggleButton tglbtnNewToggleButton = new JToggleButton("Enviar");
		tglbtnNewToggleButton.setBounds(173, 237, 121, 23);
		contentPane.add(tglbtnNewToggleButton);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Autorizo o uso dos meus dados");
		chckbxNewCheckBox.setBounds(230, 192, 204, 23);
		contentPane.add(chckbxNewCheckBox);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(25, 152, 26, 14);
		contentPane.add(lblCpf);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(49, 149, 172, 20);
		contentPane.add(textField_1);
		
		JLabel lblNmeroDoCarto = new JLabel("N\u00FAmero do cart\u00E3o");
		lblNmeroDoCarto.setBounds(25, 95, 86, 14);
		contentPane.add(lblNmeroDoCarto);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(122, 92, 288, 20);
		contentPane.add(textField_2);
		
		JLabel lblCcv = new JLabel("CCV");
		lblCcv.setBounds(25, 120, 26, 14);
		contentPane.add(lblCcv);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(49, 118, 48, 20);
		contentPane.add(textField_3);
		
		JLabel lblDataDeValidade = new JLabel("Data de Validade");
		lblDataDeValidade.setBounds(107, 120, 95, 14);
		contentPane.add(lblDataDeValidade);
		
		JSpinner spinner_2_1 = new JSpinner();
		spinner_2_1.setBounds(200, 118, 48, 20);
		contentPane.add(spinner_2_1);
		
		JSpinner spinner_3 = new JSpinner();
		spinner_3.setBounds(254, 118, 40, 20);
		contentPane.add(spinner_3);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Cr\u00E9dito");
		rdbtnNewRadioButton.setBounds(369, 119, 87, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnDbito = new JRadioButton("D\u00E9bito");
		rdbtnDbito.setBounds(369, 144, 87, 23);
		contentPane.add(rdbtnDbito);
		
		JLabel lblNewLabel_2 = new JLabel("Modalidade");
		lblNewLabel_2.setBounds(304, 123, 82, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblRg = new JLabel("RG");
		lblRg.setBounds(232, 152, 19, 14);
		contentPane.add(lblRg);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(251, 149, 101, 20);
		contentPane.add(textField_4);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Maior de Idade");
		chckbxNewCheckBox_1.setBounds(328, 60, 128, 23);
		contentPane.add(chckbxNewCheckBox_1);
		
		JCheckBox chckbxLiEEstou = new JCheckBox("Li e estou ciente dos termos");
		chckbxLiEEstou.setBounds(49, 192, 202, 23);
		contentPane.add(chckbxLiEEstou);
	}
}
