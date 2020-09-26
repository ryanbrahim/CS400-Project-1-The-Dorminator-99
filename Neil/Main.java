import java.io.File;
import java.io.FileNotFoundException;  
import java.util.Scanner;
import java.util.Arrays;

class FileInput 
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
      arr[0] = arr[0].trim();
      arr[1] = arr[1].trim();
      //System.out.println(Arrays.toString(arr));
      
      return arr;
    }
    
  

  

}
class UI <KeyType, ValueType>
{
	String temp[] = new String[2];
	HashTableMap htm = new HashTableMap();
	public UI(String filename) throws FileNotFoundException
	{
		 FileInput fi = new FileInput(filename); //
			while(fi.hasNext())
			{
				temp = fi.getNext(); //going to the next line
				
			htm.put(temp[0], temp[1]);
			
			}
		
	}
	public void getAllKeys()
	{  
		htm.getAllKeys();
	}
public ValueType getValue(KeyType key)
{
 
 ValueType returned = (ValueType) htm.get(key);
 return (ValueType) returned;
	

}


}
public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		UI ui = new UI("MG.txt"); //Population 
		ui.getAllKeys();
	    ui.getValue("Bla bla");
	    

	}

}
