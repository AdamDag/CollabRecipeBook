package rec;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Search extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Search frame = new Search();
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
	public Search() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 586, 631);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Rearch Recipe Name:");
		lblNewLabel.setBounds(34, 170, 133, 38);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(161, 175, 373, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String search = textField.getText();
				ArrayList<Recipe> searched = exploration.searchByName(search);
				new result(searched).setVisible(true);
				Search.this.dispose();
				
			}
		});
		btnNewButton.setBounds(258, 379, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("HOME");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Cover().setVisible(true);
				Search.this.dispose();
			}
		});
		btnNewButton_1.setBounds(475, 379, 89, 23);
		contentPane.add(btnNewButton_1);
	}
	
	public Search(int integer) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 586, 631);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Rearch Ingredient Name:");
		lblNewLabel.setBounds(34, 170, 133, 38);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(161, 175, 373, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String search = textField.getText();
				ArrayList<Recipe> searched = exploration.searchByIngredient(search);
				new result(searched).setVisible(true);
				Search.this.dispose();
				
			}
		});
		btnNewButton.setBounds(258, 379, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("HOME");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Cover().setVisible(true);
				Search.this.dispose();
			}
		});
		btnNewButton_1.setBounds(475, 379, 89, 23);
		contentPane.add(btnNewButton_1);
	}

}
