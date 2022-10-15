package rec;
import java.awt.EventQueue;
import rec.Create;
import rec.Iterate;
import rec.Search;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import java.awt.Color;

public class Cover extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cover frame = new Cover();
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
	public Cover() {
		setTitle("Ramsey Recipe Book");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 596, 610);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome to Ramsey Recipe Book!");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(41, 11, 518, 70);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Choose Your Action");
		lblNewLabel_1.setBounds(41, 233, 118, 51);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Create New Recipe");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Create().setVisible(true);
				Cover.this.dispose();
			}
		});
		btnNewButton.setBounds(41, 324, 152, 36);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Search By Name");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Search().setVisible(true);
				Cover.this.dispose();
			}
		});
		btnNewButton_1.setBounds(203, 324, 195, 36);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Iterate Reciepes");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Iterate().setVisible(true);
				Cover.this.dispose();
			}
		});
		btnNewButton_2.setBounds(408, 324, 151, 36);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("EXIT!");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_3.setBounds(226, 500, 152, 23);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setForeground(Color.BLUE);
		lblNewLabel_2.setBackground(Color.BLUE);
		lblNewLabel_2.setBounds(10, 67, 564, 181);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton_4 = new JButton("Search By Ingridient");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Search(2).setVisible(true);
				Cover.this.dispose();
			}
		});
		btnNewButton_4.setBounds(203, 387, 195, 36);
		contentPane.add(btnNewButton_4);
	}
}
