package rec;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import rec.*;

public class Create extends JFrame implements Serializable{
	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblNewLabel_1;
	private JTextField textField_1;
	private JLabel lblNewLabel_2;
	private JTextArea textField_2;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JButton btnNewButton_10;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Create frame = new Create();
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
	public Create() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 655);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Recipe Name:");
		lblNewLabel.setBounds(32, 30, 109, 38);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(112, 35, 360, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Ingridients:");
		lblNewLabel_1.setBounds(32, 169, 109, 29);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(112, 169, 360, 46);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Steps:");
		lblNewLabel_2.setBounds(32, 226, 109, 29);
		contentPane.add(lblNewLabel_2);
		
		textField_2 = new JTextArea();
		textField_2.setBounds(112, 226, 466, 318);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		btnNewButton_1 = new JButton("HOME");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Cover().setVisible(true);
				Create.this.dispose();
			}
		});
		btnNewButton_1.setBounds(380, 586, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("Description:");
		lblNewLabel_3.setBounds(32, 64, 69, 14);
		contentPane.add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(112, 70, 360, 57);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Cook time:");
		lblNewLabel_4.setBounds(32, 136, 69, 14);
		contentPane.add(lblNewLabel_4);
		
		textField_4 = new JTextField();
		textField_4.setBounds(112, 138, 109, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RecipeBook recipeBook = SerializationManager.deserialize();
			    SerializationManager ser = new SerializationManager();
				String name = textField.getText();
				String Description = textField_3.getText();
				String ingridients = textField_1.getText();
				String steps = textField_2.getText();
				steps = steps.replaceAll("\\n", "");
				String recipeTime = textField_4.getText();
				
				Recipe recipe = recipeQuery(name, Description, recipeTime, ingridients, steps);
				recipeBook.addRecipe(recipe);
	            SerializationManager.serialize(recipeBook);
	            
	            new Cover().setVisible(true);
				Create.this.dispose();
				//* Store into Data Base*//
			}
		});
		btnNewButton.setBounds(143, 586, 89, 23);
		contentPane.add(btnNewButton);
	}
	
	public Create(Recipe recipe) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 655);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Recipe Name:");
		lblNewLabel.setBounds(32, 30, 109, 38);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField(recipe.getName());
		textField.setBounds(101, 30, 360, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Ingredients:");
		lblNewLabel_1.setBounds(32, 169, 109, 29);
		contentPane.add(lblNewLabel_1);
		
		String str2 = ""; 
        for (int i = 0; i < recipe.getIngredients().size(); i++) {
            str2 += recipe.getIngredients().get(i);
            str2 += ", ";
        }
		
		textField_1 = new JTextField(str2);
		textField_1.setBounds(101, 169, 360, 46);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Steps:");
		lblNewLabel_2.setBounds(32, 226, 109, 29);
		contentPane.add(lblNewLabel_2);
		recipe.getSteps();
		
		//Show steps one by one instead of all at once
		btnNewButton_10 = new JButton("NEXT");
		btnNewButton_10.setBounds(14, 250, 80, 23);
		contentPane.add(btnNewButton_10);
		
		String str = recipe.getSteps().get(0);
		textField_2 = new JTextArea(str);
		textField_2.setBounds(101, 226, 466, 318);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		for (int i = 1; i < recipe.getSteps().size(); i++) {
			final int final_i = i;
			btnNewButton_10.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String str = recipe.getSteps().get(final_i);
						textField_2 = new JTextArea(str);
						textField_2.setBounds(101, 226, 466, 318);
						contentPane.add(textField_2);
						textField_2.setColumns(10);
				}
			});
		}
		
		
		btnNewButton_1 = new JButton("HOME");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Cover().setVisible(true);
				Create.this.dispose();
			}
		});
		btnNewButton_1.setBounds(380, 586, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("Description:");
		lblNewLabel_3.setBounds(32, 64, 69, 14);
		contentPane.add(lblNewLabel_3);
		
		textField_3 = new JTextField(recipe.getDescription());
		textField_3.setBounds(101, 68, 360, 57);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Cook time:");
		lblNewLabel_4.setBounds(32, 136, 69, 14);
		contentPane.add(lblNewLabel_4);
		
		textField_4 = new JTextField(recipe.getTime());
		textField_4.setBounds(101, 138, 109, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
	}
	
	private Recipe recipeQuery(String recipeName, String recipeDescription, String recipeTime, String RecipeIngredients, String RecipeSteps){
        
        //create an array of Strings to store the ingredients
        ArrayList<String> ingredients = new ArrayList<String>(
        		Arrays.asList(RecipeIngredients.split(",")));
  
        //create an array of Strings to store the steps
        ArrayList <String> steps = new ArrayList<String>(
        		Arrays.asList(RecipeSteps.split(",")));
    
        Recipe recipe = new Recipe(recipeName, recipeDescription, recipeTime, ingredients, steps);
    
        return recipe;
    
    }
}