// --== CS400 File Header Information ==--
// Name: Ryan Almizyed
// Email: almizyed@wisc.edu
// Team: MG
// TA: Harit Vishwarkama
// Lecturer: Florian Heimerl
// Notes to Grader: <optional extra notes>

/**
 * A HashNode is a node for a linkedList that holds the key, value, and pointer
 * 
 * @author Ryan Almizyed
 *
 */
public class HashNode<KeyType, ValueType>
{
  private KeyType key;
  private ValueType value;

  /**
   * The constructor for a HashNode object
   * 
   * @param key   - the key to be assigned
   * @param value - the value to be assigned
   */
  public HashNode(KeyType key, ValueType value)
  {
    this.key = key;
    this.value = value;
  }

  /**
   * Getter method for the key
   * 
   * @returns the node's key
   */
  public KeyType getKey()
  {
    return this.key;
  }

  /**
   * Getter method for the value
   * 
   * @returns the node's value
   */
  public ValueType getValue()
  {
    return this.value;
  }
}
