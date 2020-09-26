import java.util.Scanner;

/**
 * This is the driver for Dorminator program. It provides the UI for user I/O and calls the other
 * classes.
 * 
 * @author Ryan Almizyed
 */
public class DorminatorDriver
{
  
  private static final String[] userCommands = {"exit", "help", "dorms"};

  public static void main(String[] args)
  {
    // Initialization:
    System.out.println("Hello, and welcome to The Dorminator 99th generation.");
    System.out.println("Input a dorm name to learn more about that dorm, 'help' for commands, " 
    + "or type 'exit' to exit.");
    // Populate dorm database from data file
    String fileName = "";
    UI<String, String> database = new UI(fileName);
    database.populate(fileName);
    System.out.println("Possible dorm names are:");
    database.getAllKeys();

    Scanner scanner = new Scanner(System.in);

    // Main driver loop
    while (true)
    {
      // get user's command
      String userInput = scanner.nextLine().toLowerCase().trim();

      // exit command
      if(userInput.equals("exit"))
        break;
      
      //help command
      if(userInput.equals("help"))
        printUserCommands();
      
      //valid dorm name
      if(database.containsKey(userInput))
      {
        
      }
      
      //invalid dorm name
      else
      {
        System.out.println("The dorm name you entered is invalid. To see a list of dorm names, " 
        + " use  'help' ");
      }

      // getValue(String key) -gets the value for a corresponding key
      // boolean containsKey() -checks if database contains the key
      // getAllKeys() -print a list of all the keys in database
    }

    // closing program
    scanner.close();
    System.out.println("Thank you for using The Dorminator, have a nice day!");


  }

  /**
   * Method to print out all of the possible commands the user can call
   */
  private static void printUserCommands()
  {
    for(String command : userCommands)
      System.out.print("'" + command + "' ");
    System.out.println();
  }
}
