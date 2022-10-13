package rec;

import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;
import java.util.ArrayList;
import rec.*;

public class DisplayManager implements Serializable {   
    //create arraylist for storage
    RecipeBook recipeBook = new RecipeBook();
    SerializationManager ser = new SerializationManager();
    
    
    public void mainMenu() throws Exception{
        System.out.println("Main Menu");
        System.out.println("===================");
        System.out.println("1. Create a recipe");
        System.out.println("2. Search for a recipe");
        System.out.println("3. Exit");
        System.out.println("4. Test");
        Scanner menuSc = new Scanner(System.in);
        int choice = menuSc.nextInt();
        if(choice == 1){
            System.out.print("\033[H\033[2J"); 
            Recipe recipe = recipeQuery();
            //displayRecipe(recipe);
            //storeRec(recipe);
            recipeBook.addRecipe(recipe);
            SerializationManager.serialize(recipeBook);
            //printAllRecipes();
            //System.out.println(recipe.getSteps().toString());
        }
        else if(choice == 2){
            System.out.print("\033[H\033[2J");
            System.out.println("1. Search by Name");
            System.out.println("2. Search by Ingredient");
            System.out.println("3. Search by Time");
            System.out.println("4. Exit");
            
           
    
    
        }
        else if(choice == 3){
            //storage.readRec();
            System.out.print("\033[H\033[2J"); 
            System.out.println("Quitting...");
            System.exit(0);
        }
        else if(choice == 4){
            //storage.readRec();
            System.out.print(SerializationManager.deserialize());
           //recipeBook.printRecipe(0);
           System.out.println("Test 13");
            //System.out.println("Quitting...");
            //System.exit(0);
        }
    
    }
    
    private Recipe recipeQuery(){
        System.out.println("Enter the recipe name: ");
        Scanner scanner = new Scanner(System.in);
        String recipeName = scanner.nextLine();
        System.out.println("Enter the recipe description: ");
        String recipeDescription = scanner.nextLine();
        System.out.println("Enter the recipe time to cook: ");
        String recipeTime = scanner.nextLine();
        System.out.println("Enter the number of recipe ingredients: ");
        int recipeIngredients = scanner.nextInt();
        scanner.nextLine();
        //create an array of Strings to store the ingredients
        ArrayList<String> ingredients = new ArrayList<String>();
         for(int i = 0; i < recipeIngredients; i++){
            System.out.println("Enter the ingredient name: ");
            String ingredientName = scanner.nextLine();
            System.out.println("Enter the ingredient quantity: ");
            String ingredientQuantity = scanner.nextLine();
            System.out.println("Enter the ingredient unit: ");
            String ingredientUnit = scanner.nextLine();
    
            ingredients.add(ingredientName + " " + ingredientQuantity + " " + ingredientUnit);
    
         }
    
        System.out.println("Enter the number of recipe steps: ");
        int recipeSteps = scanner.nextInt();
        scanner.nextLine();
        //create an array of Strings to store the steps
        ArrayList <String> steps = new ArrayList<String>();
        for(int i = 0; i < recipeSteps; i++){
            
            String stepNumber = "Step " + (i + 1) + ": ";
            System.out.println("Enter the step description: ");
            String stepDescription = scanner.nextLine();
            steps.add(stepNumber + " " + stepDescription);
        }
    
        Recipe recipe = new Recipe(recipeName, recipeDescription, recipeTime, ingredients, steps);
    
        return recipe;
    
    }
    /* 
    private void displayRecipe(Recipe recipe){
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
*/
    private void printAllRecipes(){
        //for(int i = 0; i < recipeBook.size(); i++){
         //   displayRecipe(recipeBook.get(i));
      //  }
    }
/* 
    public void run() throws IOException{
        Recipe recipe = recipeQuery();
        displayRecipe(recipe);
    }
    */
}