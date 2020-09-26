import java.util.Scanner;

/**
 * This is the driver for Dorminator program.  It provides the UI for user I/O and calls 
 * the other classes.
 * 
 * @author Ryan Almizyed
 */
public class DorminatorDriver
{

  public static void main(String[] args)
  {
    //Initialization:
    System.out.println("Hello, and welcome to The Dorminator 99th generation.");
    System.out.println("Input a dorm name to learn more about that dorm, or type 'exit' to exit.");
    //Populate dorm database from data file
    String fileName = "";
    //HashTableMap<String, String> database = new HashTableMap();
    //database.populate(fileName);
    Scanner scanner = new Scanner(System.in);
    
    //Main driver loop
    boolean exit = false;
    while(exit != true)
    {
      
      String userInput = scanner.nextLine();
      //exit condition
      if(userInput.toLowerCase().equals("exit"))
        break;
      
      //getValue(String key)   -gets the value for a corresponding key
      //boolean containsKey()   -checks if database contains the key
      //getAllKeys()    -print a list of all the keys in database
      //populate(File fileName) -populates the database with values from a file
      //
      
      
    }
    

  }

}
