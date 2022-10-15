package rec;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JList;
import javax.swing.JButton;

public class result extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public result(ArrayList <Recipe> searched) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 635, 604);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList list = new JList(searched.toArray());
		list.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				if (list.getSelectedValue() != null) {
					int INDEX = list.getSelectedIndex();
			        // Jump to another page that shows to stuff
					new Create(searched.get(INDEX)).setVisible(true);
					result.this.dispose();
					
			      }
			}
		  });
		list.setBounds(21, 22, 578, 471);
		contentPane.add(list);
		
		JButton btnNewButton = new JButton("HOME");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Cover().setVisible(true);
				result.this.dispose();
			}
		});
		btnNewButton.setBounds(274, 535, 89, 23);
		contentPane.add(btnNewButton);
	}
}
