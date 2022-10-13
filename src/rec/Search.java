package rec;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Search extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

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
		setBounds(100, 100, 600, 651);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Rearch Recipe Name:");
		lblNewLabel.setBounds(32, 36, 133, 38);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(175, 45, 373, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String search = textField.getText();
				//* Search in Storage Class *//
				//* Return String A of Name, String B of Ingredients, String C of Steps*//
				String A = "A";
				String B = "B";
				String C = "C";
				new Search(A,B,C).setVisible(true);
				Search.this.dispose();
				
			}
		});
		btnNewButton.setBounds(253, 559, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("HOME");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Cover().setVisible(true);
				Search.this.dispose();
			}
		});
		btnNewButton_1.setBounds(472, 559, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("Ingridients:");
		lblNewLabel_1.setBounds(32, 103, 133, 29);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(175, 107, 373, 29);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Steps:");
		lblNewLabel_2.setBounds(32, 167, 133, 29);
		contentPane.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(175, 171, 373, 359);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
	}
	
	public Search(String A, String B, String C) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 651);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Rearched Recipe Name:");
		lblNewLabel.setBounds(32, 36, 133, 38);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField(A);
		textField.setBounds(175, 45, 373, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String search = textField.getText();
				
			}
		});
		btnNewButton.setBounds(253, 559, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("HOME");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Cover().setVisible(true);
				Search.this.dispose();
			}
		});
		btnNewButton_1.setBounds(472, 559, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("Ingridients:");
		lblNewLabel_1.setBounds(32, 103, 133, 29);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField(B);
		textField_1.setBounds(175, 107, 373, 29);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Steps:");
		lblNewLabel_2.setBounds(32, 167, 133, 29);
		contentPane.add(lblNewLabel_2);
		
		textField_2 = new JTextField(C);
		textField_2.setBounds(175, 171, 373, 359);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
	}

}
