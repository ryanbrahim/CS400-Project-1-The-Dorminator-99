// --== CS400 File Header Information ==--
// Name: Prannav Arora
// Email: parora9@wisc.edu
// Team: MG
// Role: Data Wrangler
// TA: Harit Vishwarkama
// Lecturer: Gary Dahl
// Notes to Grader: FileInput.java made by Prannav Arora (Data Wrangler)


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This class can be used by backend developers to get data conveniently
 * 
 * @author Prannav Arora (parora9@wisc.edu)
 *
 */
public class FileInput {
  File f; // File we want data from
  Scanner sc; // Scanner used to get data from file
  String delim = ":"; // The token that splits a line into a key and a value

  /**
   * The constructor
   * 
   * @param filename - path of the file
   * @throws FileNotFoundException if path is invalid, or no file is found
   */
  public FileInput(String filename) throws FileNotFoundException {
    f = new File(filename);
    if (!f.exists()) {
      throw new FileNotFoundException();
    }
    sc = new Scanner(f);
  }

  /**
   * Checks to see if the scanner has more information
   * 
   * @return true if more lines in file to obtain, false otherwise
   */
  public boolean hasNext() {
    boolean b = sc.hasNextLine();
    return b;
  }

  /**
   * Gets a line from the text file, in a nice key/value pair format
   * 
   * @return the string array of the line: [key, value]
   */
  public String[] getNext() {
    String line = sc.nextLine(); // Get line from file
    line = line.trim();

    String[] arr = line.split(delim); // Make String array, split by ":"
    arr[0] = arr[0].trim();
    arr[1] = arr[1].trim();

    return arr;
  }

}
