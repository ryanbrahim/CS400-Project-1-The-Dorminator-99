// --== CS400 File Header Information ==--
// Name: Neil Bhuatada
// Email: ??
// Team: MG
// Role: Front-end developer
// TA: Harit Vishwarkama
// Lecturer: Florian Heimerl
// Notes to Grader: <optional extra notes> 

//Complete P1

import java.io.FileNotFoundException;

public class UI <KeyType, ValueType>
{
	String temp[] = new String[2];
	HashTableMap htm = new HashTableMap();
	String filename;
	
	public UI(String filename) throws FileNotFoundException
	{
	    this.filename = filename;
		  FileInput fi = new FileInput(this.filename);
			while(fi.hasNext())
			{
				temp = fi.getNext(); //going to the next line
				htm.put(temp[0], temp[1]);
			}
	}
	
	public void getAllKeys()
	{
    try 
    {
      FileInput fi = new FileInput(this.filename);
      while(fi.hasNext())
      {
        temp = fi.getNext(); //going to the next line
        
        System.out.println(temp[0]);
      }
    }
    catch (FileNotFoundException e)
    {
      System.out.println(this.filename + " not found");
      e.printStackTrace();
    }
	}
	
	public ValueType getValue(KeyType key)
  {
	  ValueType returned = (ValueType)htm.get(key);
	  return (ValueType)returned;
  }
	
  public boolean containsKey(KeyType key) 
  {
      boolean check = htm.containsKey(key);
      return check; 
  }

}
