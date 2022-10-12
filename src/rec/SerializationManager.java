package rec;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import rec.Recipe;
import rec.RecipeBook;

//serialize and store the recipe objects from the creation class in a csv file
public final class SerializationManager {
    public static String dataFilename = "recipeBook.ser";
    RecipeBook recipeBook = new RecipeBook();
  
    public static void serialize(RecipeBook recipeBook) {
      try {
       // System.out.println("Test 1");
        FileOutputStream file = new FileOutputStream(dataFilename);
       // System.out.println("Test 2");
        ObjectOutputStream dataOutput = new ObjectOutputStream(file);
      //  System.out.println("Test 3");
        // IO error occurs here
        dataOutput.writeObject(recipeBook);
      //  System.out.println("Test 4");
        dataOutput.close();
      //  System.out.println("Test 5");
        file.close();
      //  System.out.println("Test 6");
      } catch (IOException exception) {
        System.out.println("IOException was caught!");
      }
    }
  
    public static RecipeBook deserialize() {
      RecipeBook recipeBook = null;
      try {

       // System.out.println("Test 7");
        FileInputStream file = new FileInputStream(dataFilename); //open file
        //System.out.println("Test 8");
        ObjectInputStream dataInput = new ObjectInputStream(file); //read file
        //System.out.println("Test 9");
        //IO error occurs here
        recipeBook = (RecipeBook)dataInput.readObject(); //cast to RecipeBook
       // System.out.println("Test 10");
        dataInput.close(); //close object
       // System.out.println("Test 11");
        file.close(); //close file
       // System.out.println("Test 12");

        //System.out.println(recipeBook);

        return recipeBook;
      } catch (IOException exception) {
        System.out.println("IOException was caught!");
        System.out.println(exception);
      } catch (ClassNotFoundException exception) {
        System.out.println("Unhandled class exception was caught!");
      }
      return recipeBook;
    }
  }