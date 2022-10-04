package rec;
//Query for name, time, amount of ingredients and amount of steps
//Use for loops to query for each ingredient and step, store both in arrays (arraylists?)

public class Recipe {
    private String name;
    private String description;
    private String time;
    private String[] ingredients;
    private String[] steps;

    public Recipe(String name, String description, String time, String[] ingredients, String[] steps){
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
    public String[] getIngredients(){
        return this.ingredients;
    }

    public String[] getSteps(){
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
/* 
    public String toString(){

    }*/
}