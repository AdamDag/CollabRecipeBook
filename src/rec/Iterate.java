package rec;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.*;

public class Iterate extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Iterate frame = new Iterate();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * Import information from storage class and display on screen
	 */
	public Iterate() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 602, 655);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		//* Take list from database*//
		//*Can Add scrolling if there's many items*//
		ArrayList <Recipe> everything = exploration.browse();
		JList list = new JList(everything.toArray());
		list.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				if (list.getSelectedValue() != null) {
					int INDEX = list.getSelectedIndex();
			        // Jump to another page that shows to stuff
					new Create(everything.get(INDEX)).setVisible(true);
					Iterate.this.dispose();
					
			      }
			}
		  });
		list.setBounds(10, 21, 570, 508);
		contentPane.add(list);
		
		JButton btnNewButton = new JButton("HOME");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Cover().setVisible(true);
				Iterate.this.dispose();
			}
		});
		btnNewButton.setBounds(248, 566, 89, 23);
		contentPane.add(btnNewButton);
	}
}
