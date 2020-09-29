// --== CS400 File Header Information ==--
// Name: Ryan Almizyed
// Email: almizyed@wisc.edu
// Team: MG
// Role: Front-end developer
// TA: Harit Vishwarkama
// Lecturer: Florian Heimerl
// Notes to Grader: <optional extra notes>

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
  private static final String fileName = "dorms.txt";    //file to read data from
  //Class variables
  private static UI<String, String> database = null;

  /**
   * The main method for the program. Contains the initialization and main command loop.
   * @param args
   * @throws FileNotFoundException if invalid filename is given
   */
  public static void main(String[] args) throws FileNotFoundException
  {
    // Initialization:
    database = new UI<String, String>(fileName);
    Scanner scanner = new Scanner(System.in);
    
    //Begin
    System.out.println("Hello, and welcome to The Dorminator 99th generation.");
    System.out.println("Type a dorm name to learn more about that dorm, 'help' for commands, " 
    + "or type 'exit' to exit.\n");
    //System.out.println("Possible dorm names are:");
    printAllDorms();

    // Main command loop
    while (true)
    {
      System.out.println("\n-------------------------");
      System.out.print("Please enter a command / dorm name: ");
      // get user's command
      String command = scanner.nextLine().toLowerCase().trim();

      // exit command
      if(command.equals("exit"))
        break;
      
      //help command
      else if(command.equals("help"))
        printUserCommands();
      
      //dorms command
      else if(command.equals("dorms"))
        printAllDorms();
      
      //valid dorm name
      else if(database.containsKey(command))
        printDormInfo(command);
      
      //invalid dorm name
      else
        System.out.println("The dorm name you entered is invalid. Type 'dorms' to see possible "
            + "dorms, or 'help' to get a list of commands.");
    }

    // closing program
    scanner.close();
    System.out.println("Thank you for using The Dorminator, have a nice day!");


  }

  /**
   * Helper method to print out the information for a particular dorm
   * 
   * @param dorm - the string name of the dorm
   */
  private static void printDormInfo(String dorm)
  {
    System.out.println(database.getValue(dorm));
  }
  
  /**
   * Helper method to print out all of the dorm names
   */
  private static void printAllDorms()
  {
    System.out.println("The possible dorms are:");
    database.getAllKeys();
  }
  
  /**
   * Helper method to print out all of the possible commands the user can call
   */
  private static void printUserCommands()
  {
    for(String command : userCommands)
      System.out.print("'" + command + "' ");
    System.out.println();
  }
}
