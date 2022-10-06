import java.io.*;
import java.util.*;

public class RecipeRetrieval {

    public static ArrayList<Recipes> RecipesLoad(){
        ArrayList<Recipes> list = new ArrayList<Recipes>();
        ArrayList<String> recipelist = new ArrayList<String>();

        String fn = "recipes.txt";
        String line = null;

        try{
            FileReader fr = new FileReader(fn);
			BufferedReader br = new BufferedReader(fr);
			
			while((line = br.readLine()) != null) {
				recipelist.add(line);
			}

            for(int i=0; i < recipelist.size(); i++){
                String now = recipelist.get(i);
                String [] fix = now.split("|");
                String Name = fix[0];
                String Description = fix[1];
                String Time = fix[2];
                String Ingredients = fix[3];
                String Steps = fix[4];
                

                Recipes curr = new Recipes(Name, Description, Ingredients, Steps);
                list .add(curr);

            }

        }
        catch(FileNotFoundException ex){
            System.out.println("'" + fn + "' not found");
        }
        catch (IOException ex) {
            System.out.println("Error reading '" + fn + "'");
        }

        return list;

    }

    public boolean RecipeSearch(ArrayList<Recipes> list, String Name){
        boolean yes = false;

        for(int i = 0; i < list.size(); i++){
            Recipes curr = list.get(i);
            if (curr.getName().equals(Name)){
                yes = true;
                break;
            }
        }
        if(yes){
            return true;
        }
        else{
            return false;
        }
    }

    public void DisplayRecipes(ArrayList<Recipes> list){
        for(int i = 0; i < list.size(); i++){
            Recipes curr = list.get(i);
            curr.DisplayRecipes(curr);
        }
    }

    public void RecipeRetrievalMenu(Scanner in, ArrayList<Recipes> list){
        while(true){
            System.out.println("************* Recipe Retrieval *************");
            System.out.println("1. Search for a recipe");
            System.out.println("2. View all Recipes");
            System.out.println("3. Exit");
            System.out.print("Type 1, 2, or 3: ");
            int option = in.nextInt();
            in.nextLine();
            System.out.println();

            if (option != 1 && option != 2 && option != 3) {
                System.out.println("Try again");
                System.out.println();
            } else {
                // if 1, search for recipe
                if (option == 1) {
                    System.out.print("Recipe Name: ");
                    String Name = in.nextLine();
                    boolean found = RecipeSearch(list, Name);
                    if (found) {
                        System.out.println("Recipe was found!");
                    } else {
                        System.out.println("Error: Recipe not found");
                    }

                // if 2, show all recipes
                } else if (option == 2) {
                    displayAllRecipes(list);
                    System.out.println();

                // if 3, exit recipe retrieval menu
                } else {
                    System.out.println("Recipe Retrieval Menu Exited");
                    break;
                }
            }
            System.out.println();
        }
        return;
    }

}
