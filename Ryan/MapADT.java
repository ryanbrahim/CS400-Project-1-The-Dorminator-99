// --== CS400 File Header Information ==--
// Name: Ryan Almizyed
// Email: almizyed@wisc.edu
// Team: MG
// TA: Harit Vishwarkama
// Lecturer: Florian Heimerl
// Notes to Grader: <optional extra notes>

import java.util.NoSuchElementException;

public interface MapADT<KeyType, ValueType>
{

  public boolean put(KeyType key, ValueType value);
  public ValueType get(KeyType key) throws NoSuchElementException;
  public int size();
  public boolean containsKey(KeyType key);
  public ValueType remove(KeyType key);
  public void clear();

}
