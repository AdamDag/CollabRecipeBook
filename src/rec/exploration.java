package rec;

import java.io.IOException;
import java.util.Scanner;
import rec.RecipeResult;
import rec.Recipe;
import rec.RecipeBook;
import rec.SerializationManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class exploration extends Recipe{
	public exploration(String name, String description, String time, ArrayList<String> ingredients,
			ArrayList<String> steps) {
		super(name, description, time, ingredients, steps);
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;
	
	private ArrayList<Recipe> source = SerializationManager.deserialize().getRecipeBook();
	
	
	public ArrayList<Recipe> convertToRecipes ( ArrayList<RecipeResult> results ) {
		ArrayList<Recipe> converted = new ArrayList<Recipe>();
		for (int i = 0; i <= results.size()-1; i++ ) {
			RecipeResult next = results.get(i);
			converted.add(new Recipe(next.getName(),next.getDescription(),next.getTime(),next.getIngredients(),next.getSteps()));
		}
		return converted;
	}
	
	
	public ArrayList<Recipe> searchByName ( String target ){
		String[] targets = target.split(" ");
		ArrayList<RecipeResult> result = new ArrayList<RecipeResult>();
		for (int i = this.source.size()-1; i >= 0; i--) {
			//look for string matching in recipe name
			String[] nameFound = this.source.get(i).getName().split(" ");
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
				result.add(new RecipeResult(this.source.get(i),countMatch));
			}
		}
		// sort on # of matches
		Collections.sort(result);
		//displayList(result);
		return convertToRecipes(result);
	}
	
	
	
	
	public ArrayList<Recipe> searchByIngredient ( String target ){
		
		ArrayList<RecipeResult> result = new ArrayList<RecipeResult>();
		for (int i = this.source.size()-1; i >= 0; i--) {
			//look for string matching in recipe name
			ArrayList<String> ingredientsFound = this.source.get(i).getIngredients();
			int countMatch = 0;
			//check if any 2 words match
				for (int k = 0; k <= ingredientsFound.size()-1; k++) {
					if (target.equals(ingredientsFound.get(k))) {
						countMatch ++;
					}
				}
			if (countMatch > 0) {
				result.add(new RecipeResult(this.source.get(i),countMatch));
			}
		}
		// sort on # of matches
		Collections.sort(result);
		//displayList(result);
		return convertToRecipes(result);
	}
	
	
	

	public ArrayList<Recipe> browse ( ){
		ArrayList<Recipe> result = new ArrayList<Recipe>();
		for (int i = this.source.size()-1; i >= 0; i--) {
			//filter by requirement
			if (true) {
				result.add(this.source.get(i));
			}
		}
		//displayList(result);
		return result;
	}

	
	
	
	/*
	public String recipeToString(Recipe recipe){
		String recipeString = "";
		recipeString += "Name:\n" + recipe.getName() + "\n";
		recipeString += "Description:\n" + recipe.getDescription() + "\n";
		recipeString += "Time:\n" + recipe.getTime() + "\n";
		recipeString += "Ingredients:\n";
	    for(int i = 0; i < recipe.getIngredients().size(); i++){
	    	recipeString += recipe.getIngredients().get(i) + "\n";
	    }
	    recipeString += "Steps:\n";
	    for(int i = 0; i < recipe.getSteps().size(); i++){
	    	recipeString += recipe.getSteps().get(i) + "\n";
	    }
	    return recipeString;
	}
	*/
	
}



