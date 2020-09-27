import java.io.File;
import java.io.FileNotFoundException;  
import java.util.Scanner;
import java.util.Arrays;

public class FileInput 
{
    File f;
    Scanner sc;
    String delim = ":";
    
    public FileInput(String filename) throws FileNotFoundException
    {
      f = new File(filename);
      if(!f.exists())
      {
        throw new FileNotFoundException();
      }
      sc = new Scanner(f);
    }
    
    public boolean hasNext()
    {
      boolean b =  sc.hasNextLine();
      return b;
    }
    
    /**
     * Used to get lines from a text file 
     * @return the string array of the line with the key at index 0
     *         and the value at index 1
     */
    public String[] getNext()
    {
      String line =  sc.nextLine();   //Get line from file
      line = line.trim();
      
      String[] arr = line.split(delim); //Make String array, split by ":"
      arr[0] = arr[0].trim().toLowerCase();
      arr[1] = arr[1].trim().toLowerCase();
      //System.out.println(Arrays.toString(arr));
      
      return arr;
    }
    
  

  

}
