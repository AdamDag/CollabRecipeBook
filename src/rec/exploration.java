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

public class exploration{
	public exploration() {
		// TODO Auto-generated constructor stub
	}
	
	
	public static ArrayList<Recipe> convertToRecipes ( ArrayList<RecipeResult> results ) {
		ArrayList<Recipe> converted = new ArrayList<Recipe>();
		for (int i = 0; i <= results.size()-1; i++ ) {
			RecipeResult next = results.get(i);
			converted.add(new Recipe(next.getName(),next.getDescription(),next.getTime(),next.getIngredients(),next.getSteps()));
		}
		return converted;
	}
	
	
	public static ArrayList<Recipe> searchByName ( String target ){
		ArrayList<Recipe> source = SerializationManager.deserialize().getRecipeBook();
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
		return convertToRecipes(result);
	}
	
	
	
	
	public static ArrayList<Recipe> searchByIngredient ( String target ){
		ArrayList<Recipe> source = SerializationManager.deserialize().getRecipeBook();
		ArrayList<RecipeResult> result = new ArrayList<RecipeResult>();
		for (int i = source.size()-1; i >= 0; i--) {
			//look at ingredients in this recipe
			ArrayList<String> ingredientsFound = source.get(i).getIngredients();
			int countMatch = 0;
				//check for every word in the ingredient element
				for (int k = 0; k <= ingredientsFound.size()-1; k++) {
					//split string
					String[] ingredients = ingredientsFound.get(k).split(" ");
					//check if any 2 words match
					for (int j = 0; j <= ingredients.length-1; j++) {
						if (ingredients[j].equals(target)) {
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
		return convertToRecipes(result);
	}
	
	
	

	public static ArrayList<Recipe> browse ( ){
		ArrayList<Recipe> source = SerializationManager.deserialize().getRecipeBook();
		ArrayList<Recipe> result = new ArrayList<Recipe>();
		for (int i = source.size()-1; i >= 0; i--) {
			//filter by requirement
			if (true) {
				result.add(source.get(i));
			}
		}
		//displayList(result);
		return result;
	}

	
}



