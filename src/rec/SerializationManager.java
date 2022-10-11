package rec;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

//serialize and store the recipe objects from the creation class in a csv file
public final class SerializationManager {
    public static String dataFilename = "recipeBook.ser";
  
    public static void serialize(Recipe recipe) {
      try {
        FileOutputStream file = new FileOutputStream(dataFilename);
        ObjectOutputStream dataOutput = new ObjectOutputStream(file);
        dataOutput.writeObject(recipe);
        dataOutput.close();
        file.close();
      } catch (IOException exception) {
        System.out.println("IOException was caught!");
      }
    }
  
    public static Recipe deserialize() {
      try {
        FileInputStream file = new FileInputStream(dataFilename);
        ObjectInputStream dataInput = new ObjectInputStream(file);
        Recipe retrievedRecipes = (Recipe)dataInput.readObject();
        dataInput.close();
        file.close();

        //INSERT CODE TO PLUG RETRIEVED RECIPES INTO RECIPE BOOK ARRAYLIST HERE




        //Recipe.setCount(retrievedRecipes.getRecipes().size());
        //return retrievedAccountsData;
      } catch (IOException exception) {
        System.out.println("IOException was caught!");
      } catch (ClassNotFoundException exception) {
        System.out.println("Unhandled class exception was caught!");
      }
      
      return new Recipe();
    }
  }