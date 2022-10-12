package rec;

import java.io.Serializable;
//Query for name, time, amount of ingredients and amount of steps
//Use for loops to query for each ingredient and step, store both in arrays (arraylists?)
import java.util.ArrayList;

public class Recipe implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private String description;
    private String time;
    private ArrayList<String> ingredients;
    private ArrayList<String> steps;

    public Recipe(String name, String description, String time, ArrayList<String> ingredients, ArrayList<String> steps){
        this.name = name;
        this.description = description;
        this.time = time;
        this.ingredients = ingredients;
        this.steps = steps;
    }
    public String getName(){
        return this.name;
    }
    public String getDescription(){
        return this.description;
    }
    public String getTime(){
        return this.time;
    }
    public ArrayList<String> getIngredients(){
        return this.ingredients;
    }

    public ArrayList<String> getSteps(){
        return this.steps;
    }

    public void setName(){
        this.name = name;
    }
    public void setDescription(){
        this.description = description;
    }
    public void setTime(){
        this.name = time;
    }
    public void setIngredients(){
        this.ingredients = ingredients;
    }

    public void setSteps(){
        this.steps = steps;
    }
public String toString(){
    String recipeString = "";
    return recipeString += "Recipe name: " + this.name + " Description: " + this.description + " Time: " + this.time + " Ingredients: " + this.ingredients + " Steps: " + this.steps;

}
}