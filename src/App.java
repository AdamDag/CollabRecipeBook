import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import rec.Recipe;

class DisplayManager{
//create arraylist for storage
ArrayList<Recipe> recipeBook = new ArrayList<>();

public void storeRec(Recipe recipe){
    //store recipe objects in an arraylist
    

}

public void mainMenu(){
    System.out.println("Main Menu");
    System.out.println("===================");
    System.out.println("1. Create a recipe");
    System.out.println("2. Search for a recipe");
    System.out.println("3. Exit");
    Scanner menuSc = new Scanner(System.in);
    int choice = menuSc.nextInt();
    if(choice == 1){
        System.out.print("\033[H\033[2J"); 
        Recipe recipe = recipeQuery();
        displayRecipe(recipe);
    }
    else if(choice == 2){
        System.out.print("\033[H\033[2J");
        System.out.println("1. Search by Name");
        System.out.println("2. Search by Ingredient");
        System.out.println("3. Search by Time");
        System.out.println("4. Exit");
       


    }
    else if(choice == 3){
        System.out.print("\033[H\033[2J"); 
        System.out.println("Quitting...");
        System.exit(0);
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
    String[] ingredients = new String[recipeIngredients];
     for(int i = 0; i < recipeIngredients; i++){
        System.out.println("Enter the ingredient name: ");
        String ingredientName = scanner.nextLine();
        System.out.println("Enter the ingredient quantity: ");
        String ingredientQuantity = scanner.nextLine();
        System.out.println("Enter the ingredient unit: ");
        String ingredientUnit = scanner.nextLine();

        ingredients[i] = ingredientName + " " + ingredientQuantity + " " + ingredientUnit;

     }

    System.out.println("Enter the number of recipe steps: ");
    int recipeSteps = scanner.nextInt();
    scanner.nextLine();
    //create an array of Strings to store the steps
    String[] steps = new String[recipeSteps];
    for(int i = 0; i < recipeSteps; i++){
        
        String stepNumber = "Step " + (i + 1) + ": ";
        System.out.println("Enter the step description: ");
        String stepDescription = scanner.nextLine();
        steps[i] = stepNumber + " " + stepDescription;
    }

    Recipe recipe = new Recipe(recipeName, recipeDescription, recipeTime, ingredients, steps);

    return recipe;

}
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

public void run() throws IOException{
    Recipe recipe = recipeQuery();
    displayRecipe(recipe);
}

}

public class App{
    public static void main(String[] args) throws Exception {
        DisplayManager displayManager = new DisplayManager();
        displayManager.mainMenu();

    }
}
