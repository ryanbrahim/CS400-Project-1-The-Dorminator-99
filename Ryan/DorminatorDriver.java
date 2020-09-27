import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This is the driver for Dorminator program. It provides the UI for user I/O and calls the other
 * classes.
 * 
 * @author Ryan Almizyed
 */
public class DorminatorDriver
{
  //Constants
  private static final String[] userCommands = {"exit", "help", "dorms"};   //possible commands
  private static final String fileName = "testData";    //file to read data from

  public static void main(String[] args) throws FileNotFoundException
  {
    // Initialization:
    // Populate dorm database from data file
    UI<String, String> database = new UI<String, String>(fileName);;
    
    
    System.out.println("Hello, and welcome to The Dorminator 99th generation.");
    System.out.println("Input a dorm name to learn more about that dorm, 'help' for commands, " 
    + "or type 'exit' to exit.");
    
    System.out.println("Possible dorm names are:");
    database.getAllKeys();

    Scanner scanner = new Scanner(System.in);

    // Main command loop
    while (true)
    {
      // get user's command
      String command = scanner.nextLine().toLowerCase().trim();

      // exit command
      if(command.equals("exit"))
        break;
      
      //help command
      else if(command.equals("help"))
        printUserCommands();
      
      //valid dorm name
      else if(database.containsKey(command))
      {
        System.out.println(database.getValue(command));
      }
      
      //invalid dorm name
      else
        System.out.println("The dorm name you entered is invalid. To see a list of dorm names, " 
        + " use  'help' ");
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
