import java.io.FileNotFoundException;

public class UI<KeyType, ValueType>
{
  String temp[] = new String[2];
  HashTableMap htm = new HashTableMap();

  public UI(String filename) throws FileNotFoundException
  {
    FileInput fi = new FileInput(filename); //
    while (fi.hasNext())
    {
      temp = fi.getNext(); // going to the next line
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

  public boolean containsKey(KeyType key)
  {
    return htm.containsKey(key);
  }

}