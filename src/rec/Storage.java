package rec;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.io.FileNotFoundException;
import rec.DisplayManager;

//serialize and store the recipe objects from the creation class in a csv file
public class Storage {

    private void read() throws Exception {
        File file = new File("src/rec/recipes.csv");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        while ((st = br.readLine()) != null) {
            System.out.println(st);
        }
    }

    public void writeRec(Recipe recipe) throws Exception {
        //filewriter adds a recipe to the csv file
        FileWriter writer = new FileWriter("src/rec/recipes.csv");
        List<Recipe> recipeListData = new ArrayList<>();
        writer.write("Recipe Name: " + recipe.getName() + ", Recipe Description: " + recipe.getDescription() + ", Recipe Time: " + recipe.getTime() + ", Recipe Ingredients: " + recipe.getIngredients() + ", Recipe Steps: " + recipe.getSteps());
        //writer.write(recipe.getDescription());
        //writer.write(recipe.getTime());
        //writer.write(recipe.getIngredients().toString());
        //writer.write(recipe.getSteps().toString());
        //System.out.println(recipe.getSteps().toString());
        writer.close();
    }
    //BufferedReader reader = new BufferedReader(new FileReader("/..../recipes.csv"));       
    //FileWriter writer = new FileWriter(new File("/.../recipes.csv"));
}