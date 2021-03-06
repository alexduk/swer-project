package edu.bu.domain;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Admin extends JFrame {
	public static ArrayList<Administrator> admins = new ArrayList<Administrator>();
	private JPanel contentPane;
	public static JTextField textField;
	private JPasswordField textField_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new AddAdmin();

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin frame = new Admin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public Admin() throws IOException {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\josep\\swer-project\\SWERProject\\users.png"));
		setTitle("Log in");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 125, 275, 200);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("Username :");
		label.setForeground(new Color(255, 255, 255));
		label.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(10, 27, 104, 31);
		contentPane.add(label);

		JLabel label_1 = new JLabel("Password :");
		label_1.setForeground(new Color(255, 255, 255));
		label_1.setBackground(new Color(248, 248, 255));
		label_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(10, 64, 104, 31);
		contentPane.add(label_1);

		textField = new JTextField();
		textField.setBackground(new Color(0, 0, 255));
		textField.setForeground(new Color(255, 255, 255));
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textField.setColumns(10);
		textField.setBounds(114, 27, 124, 26);
		contentPane.add(textField);

		textField_1 = new JPasswordField();
		textField_1.setBackground(new Color(0, 0, 255));
		textField_1.setForeground(new Color(255, 255, 255));
		textField_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textField_1.setColumns(10);
		textField_1.setBounds(114, 67, 124, 26);
		contentPane.add(textField_1);
		admins.add(new Administrator("alex","alex"));
		admins.addAll(AddAdmin.admins2);
		
		JButton btnLogIn = new JButton("Log in");
		btnLogIn.setBackground(Color.WHITE);
		btnLogIn.setForeground(Color.BLUE);
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (textField.getText().isEmpty() || textField_1.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please fill all the blanks!", "Error", getState());
				}
				Administrator p = Valid(admins, textField, textField_1);
				if (!textField.getText().isEmpty() && !textField_1.getText().isEmpty()) {
					if (p == null) {
						JOptionPane.showMessageDialog(null, "Please enter valid Username and Password!", "Error",
								getState());
					} else {
						dispose();	
						new ChooseAdd().setVisible(true);
					}
				}
			}

		});
		btnLogIn.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnLogIn.setBounds(20, 107, 218, 38);
		contentPane.add(btnLogIn);

	}

	private Administrator Valid(ArrayList<Administrator> admins, JTextField textField, JPasswordField textField_1) {
		for (Administrator p : admins) {
			if (p != null) {
				if ((textField.getText().equals(p.username)) && (textField_1.getText().equals(p.password))) {
					return p;
				}
			}
		}
		return null;
	}
}
