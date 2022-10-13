package rec;

import java.io.IOException;
import java.util.Scanner;
import rec.Recipe;
import rec.RecipeResult;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class exploration extends Recipe{
	

	public exploration(String name, String description, String time, ArrayList<String> ingredients, ArrayList<String> steps) {
		super(name, description, time, ingredients, steps);
		// TODO Auto-generated constructor stub
	}
	/*
	public static void displayList ( ArrayList<Recipe> recipes ) {
		if (recipes.size()<=0) {
			System.out.println("The result is empty");
		}
		for (int i = recipes.size()-1; i >= 0; i-- ) {
			System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
			displayRecipe(recipes.get(i));
		}
	}
	*/
	
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
			ArrayList<String> ingredientsFound = source.get(i).getIngredients();
			int countMatch = 0;
			//check if any 2 words match
				for (int k = 0; k <= ingredientsFound.size()-1; k++) {
					if (target.equals(ingredientsFound.get(k))) {
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
	

	public static ArrayList<Recipe> browse ( ArrayList<Recipe> source ){
		ArrayList<Recipe> result = new ArrayList<Recipe>();
		for (int i = 0; i <= source.size()-1; i++) {
			//filter by requirement
			if (true) {
				result.add(source.get(i));
			}
		}
		//displayList(result);
		return result;
	}
	/*
	private static String recipeToString(Recipe recipe){
		String recipeString = "";
		recipeString += "Name:\n" + recipe.getName() + "\n";
		recipeString += "Description:\n" + recipe.getDescription() + "\n";
		recipeString += "Time:\n" + recipe.getTime() + "\n";
		recipeString += "Ingredients:\n";
	    for(int i = 0; i < recipe.getIngredients().length; i++){
	    	recipeString += recipe.getIngredients()[i] + "\n";
	    }
	    recipeString += "Steps:\n";
	    for(int i = 0; i < recipe.getSteps().length; i++){
	    	recipeString += recipe.getSteps()[i] + "\n";
	    }
	    return recipeString;
	}
	*/
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
		
		
		//ArrayList<RecipeResult> search = searchByName("name",firstThree);
		//ArrayList<RecipeResult> search = searchByIngredient("yogurt",firstThree);
		//ArrayList<Recipe> search = browse(firstThree);
		//displayList(search);
		//displayList(convertToRecipes(search));
		
		System.out.println(recipeToString(fruitSalad));
	}
}



