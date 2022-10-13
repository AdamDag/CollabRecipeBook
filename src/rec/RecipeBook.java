package rec;

import java.io.Serializable;
import java.util.ArrayList;

public class RecipeBook implements Serializable {
    
private static final long serialVersionUID = 1L;

  private ArrayList<Recipe> recipeBook;

  public RecipeBook() {
    this.recipeBook = new ArrayList<Recipe>(); 
  }    

  public ArrayList<Recipe> getRecipeBook() {
    return this.recipeBook;
  }

    public void setRecipeBook(ArrayList<Recipe> recBook) {
        this.recipeBook = recBook;
    }

    public void addRecipe(Recipe recipe) {
        this.recipeBook.add(recipe);
    }

    public void printRecipe(int index) {
        System.out.println(this.recipeBook.get(index).toString());
    }

    public void removeRecipe(Recipe recipe) {
        this.recipeBook.remove(recipe);
    }

    public void removeRecipe(int index) {
        this.recipeBook.remove(index);
    }
  public String toString(){
    String recipeBookString = "";
    for(int i = 0; i < this.recipeBook.size(); i++){
      recipeBookString += this.recipeBook.get(i).toString();
    }
    return recipeBookString;
  }
}