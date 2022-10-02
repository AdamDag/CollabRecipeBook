import java.io.IOException;
import java.util.Scanner;
import rec.Recipe;

class DisplayManager{

private Recipe recipeQuery(){
    System.out.println("Enter the recipe name: ");
    Scanner scanner = new Scanner(System.in);
    String recipeName = scanner.next();
    System.out.println("Enter the recipe description: ");
    String recipeDescription = scanner.next();
    System.out.println("Enter the recipe time to cook: ");
    String recipeTime = scanner.next();
    System.out.println("Enter the number of recipe ingredients: ");
    int recipeIngredients = scanner.nextInt();
    //create an array of Strings to store the ingredients
    String[] ingredients = new String[recipeIngredients];
     for(int i = 0; i < recipeIngredients; i++){
        System.out.println("Enter the ingredient name: ");
        String ingredientName = scanner.next();
        System.out.println("Enter the ingredient quantity: ");
        String ingredientQuantity = scanner.next();
        System.out.println("Enter the ingredient unit: ");
        String ingredientUnit = scanner.next();

        ingredients[i] = ingredientName + " " + ingredientQuantity + " " + ingredientUnit;

     }

    System.out.println("Enter the number of recipe steps: ");
    int recipeSteps = scanner.nextInt();
    //create an array of Strings to store the steps
    String[] steps = new String[recipeSteps];
    for(int i = 0; i < recipeSteps; i++){
        
        String stepNumber = "Step " + (i + 1) + ": ";
        System.out.println("Enter the step description: ");
        String stepDescription = scanner.next();
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
        displayManager.run();

    }
}
