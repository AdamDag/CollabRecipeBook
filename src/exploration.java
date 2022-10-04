import java.io.IOException;
import java.util.Scanner;
import rec.Recipe;
import rec.RecipeResult;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class exploration extends Recipe{
	

	public exploration(String name, String description, String time, String[] ingredients, String[] steps) {
		super(name, description, time, ingredients, steps);
		// TODO Auto-generated constructor stub
	}
	
	//from App
	private static void displayRecipe(Recipe recipe){
	    System.out.println("Recipe name: " + recipe.getName());
	    System.out.println("Recipe description: " + recipe.getDescription());
	    System.out.println("Recipe time: " + recipe.getTime());
	    System.out.println("Recipe ingredients: ");
	    for(int i = 0; i < recipe.getIngredients().length; i++){
	        System.out.println(recipe.getIngredients()[i]);
	    }
	    System.out.println("Recipe steps: ");
	    for(int i = 0; i < recipe.getSteps().length; i++){
	        System.out.println(recipe.getSteps()[i]);
	    }
	}
	
	public static void displayList ( ArrayList<Recipe> recipes ) {
		for (int i = recipes.size()-1; i >= 0; i-- ) {
			System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
			displayRecipe(recipes.get(i));
		}
	}
	
	public static ArrayList<Recipe> convertToRecipes ( ArrayList<RecipeResult> results ) {
		ArrayList<Recipe> recipes = new ArrayList<Recipe>();
		for (int i = 0; i <= results.size()-1; i++ ) {
			Recipe next = results.get(i);
			recipes.add(new Recipe(next.getName(),next.getDescription(),next.getTime(),next.getIngredients(),next.getSteps()));
		}
		return recipes;
	}
	
	
	public static ArrayList<RecipeResult> searchByName ( String target, ArrayList<Recipe> source ){
		String[] targets = target.split(" ");
		ArrayList<RecipeResult> result = new ArrayList<RecipeResult>();
		for (int i = source.size()-1; i >= 0; i--) {
			//look for string matching in recipe name
			String[] nameFound = source.get(i).getName().split(" ");
			int countMatch = 0;
			//check if any 2 words match
			for (int j = 0; j <= targets.length-1; j++) {
				for (int k = 0; k <= nameFound.length-1; k++) {
					if (targets[j].equals(nameFound[k])) {
						countMatch ++;
					}
				}
			}
			if (countMatch > 0) {
				result.add(new RecipeResult(source.get(i),countMatch));
			}
		}
		// sort on # of matches
		Collections.sort(result);
		//displayList(result);
		return result;
	}
	
	public static ArrayList<RecipeResult> searchByIngredient ( String target, ArrayList<Recipe> source ){
		
		ArrayList<RecipeResult> result = new ArrayList<RecipeResult>();
		for (int i = source.size()-1; i >= 0; i--) {
			//look for string matching in recipe name
			String[] ingredientsFound = source.get(i).getIngredients();
			int countMatch = 0;
			//check if any 2 words match
				for (int k = 0; k <= ingredientsFound.length-1; k++) {
					if (target.equals(ingredientsFound[k])) {
						countMatch ++;
					}
				}
			if (countMatch > 0) {
				result.add(new RecipeResult(source.get(i),countMatch));
			}
		}
		// sort on # of matches
		Collections.sort(result);
		//displayList(result);
		return result;
	}
	

	public ArrayList<Recipe> browse ( String target, ArrayList<Recipe> source ){
		ArrayList<Recipe> result = new ArrayList<Recipe>();
		for (int i = 0; i < source.size()-1; i++) {
			//filter by requirement
			if (true) {
				result.add(source.get(i));
			}
		}
		//displayList(result);
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Recipe> firstThree = new ArrayList<Recipe>();
		
		String[] ingredientsA = {"ingredient1","ingredient2"};
		String[] stepsA = {"step1","step2"};
		Recipe recipeA = new Recipe("name", "description", "time", ingredientsA, stepsA);
		firstThree.add(recipeA);
		
		String[] ingredientsB = {"ingredient3","ingredient4"};
		String[] stepsB = {"step3","step4"};
		Recipe recipeB = new Recipe("n", "d", "t", ingredientsB, stepsB);
		firstThree.add(recipeB);
		
		String[] ingredientsSalad = {"apple","yogurt"};
		String[] stepsSalad = {"slice apple","add yogurt","stir"};
		Recipe fruitSalad = new Recipe("fruit salad", "sth delicious", "today", ingredientsSalad, stepsSalad);
		firstThree.add(fruitSalad);
		
		
		ArrayList<RecipeResult> search = searchByIngredient("yogurt",firstThree);
		displayList(convertToRecipes(search));
	}
}



