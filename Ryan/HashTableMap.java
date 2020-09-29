// --== CS400 File Header Information ==--
// Name: Ryan Almizyed
// Email: almizyed@wisc.edu
// Team: MG
// TA: Harit Vishwarkama
// Lecturer: Florian Heimerl
// Notes to Grader: <optional extra notes>

import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * This class defines a HashTableMap that implements the MapADT.
 * 
 * @author Ryan Almizyed
 *
 * @param <KeyType>   - the variable type for the key
 * @param <ValueType> - the variable type for the value
 */
public class HashTableMap<KeyType, ValueType> implements MapADT<KeyType, ValueType>
{
  private int capacity; // Capacity of the HashTable, size of the array
  private int size; // number of key/value pairs in table
  private LinkedList<HashNode<KeyType, ValueType>>[] hashTable;
  private static final double LOAD_CAPACITY_THRESHOLD = 0.8;

  /**
   * Constructor for a HashTableMap
   * 
   * @param capacity - capacity of the HashTableMap
   */
  public HashTableMap(int capacity)
  {
    this.capacity = capacity;
    this.hashTable = new LinkedList[capacity];

  }

  
  /**
   * Default constructor for HashTableMap, default capacity of 10
   */
  public HashTableMap() // Default capacity = 10
  {
    this(10);
  }

  /**
   * Adds the new key/value pair to the HashTableMap
   * 
   * @param key   - the key we are adding
   * @param value - the value we are adding
   * @returns true if successfully added, false if key is duplicate
   */
  public boolean put(KeyType key, ValueType value)
  {
    // check if key is a duplicate
    if(this.containsKey(key))
      return false;
    // initialize key/value pair into node
    HashNode<KeyType, ValueType> node = new HashNode<KeyType, ValueType>(key, value);
    // insert node into hashTable
    hashInsert(this.hashTable, node);
    // increment size
    this.size++;
    // check load capacity, grow if needed
    if(this.isOverloaded())
      this.growTable();
    // successfully added to table, return true
    return true;
  }

  /**
   * Method to get the value for a corresponding key
   * 
   * @param key - the key to be searched for
   * @returns the value pair for that key
   * @throws NoNoSuchElementException if key is not in table
   */
  public ValueType get(KeyType key) throws NoSuchElementException
  {
    // determine hashIndex for this key
    int hashIndex = this.hash(key);
    // find the linkedList that corresponds to this hashIndex
    var testList = this.hashTable[hashIndex];
    if(this.hashTable[hashIndex] != null) // list exists
      // iterate through linkedList
      for (var testNode : testList)
        // check if matching key
        if(testNode.getKey().equals(key))
          // if match, return the value
          return testNode.getValue();
    throw new NoSuchElementException("This key does not exist in the hash table.");
  }

  /**
   * Method to get the number of key/value pairs
   * 
   * @returns size - the number of key/value pairs
   */
  public int size()
  {
    return this.size;
  }

  /**
   * Determines if the specified key is within the HashTable
   * 
   * @param key - the specified key to be searched for
   * @returns true if key is in the HashTable, false otherwise
   */
  public boolean containsKey(KeyType key)
  {
    // determine hashIndex for this key
    int hashIndex = hash(key);
    // find the linkedList that corresponds to this hashIndex
    var testList = this.hashTable[hashIndex];
    if(this.hashTable[hashIndex] != null) // list exists
      // iterate through linkedList
      for (var testNode : testList)
        // check if matching key
        if(testNode.getKey().equals(key))
          // if match, return true
          return true;
    // key not found, return false
    return false;
  }

  /**
   * Removes the specified key/value pair from the HashTable. Returns the value that was removed.
   * 
   * @param key - the key to search for
   * @returns the value of that key
   */
  public ValueType remove(KeyType key)
  {
    ValueType result = null;
    // determine hashIndex for this key
    int hashIndex = this.hash(key);
    // find the linkedList that corresponds to this hashIndex
    var testList = this.hashTable[hashIndex];
    if(this.hashTable[hashIndex] != null) // list exists
      // iterate through linkedList
      for (var testNode : testList)
        // check if matching key
        if(testNode.getKey().equals(key))
        {
          // if match, save the value, then remove the node
          result = testNode.getValue();
          testList.remove(testNode);
          this.size--;
        }

    return result;
  }

  /**
   * Clears the HashTable of all nodes
   */
  public void clear()
  {
    this.size = 0;
    this.hashTable = new LinkedList[capacity];
  }

  /**
   * Hash function, generates
   * 
   * @param key - the key value
   * @returns hashIndex - the table index for the corresponding key
   */
  private int hash(KeyType key)
  {
    int hashCode = key.hashCode();
    hashCode = Math.abs(hashCode);
    int hashIndex = hashCode % this.capacity;
    return hashIndex;
  }

  /**
   * Grows table by doubling the capacity and rehashing
   */
  private void growTable()
  {
    // double the capacity
    this.capacity = 2 * this.capacity;
    // declare new, larger hashTable
    LinkedList<HashNode<KeyType, ValueType>>[] newTable = new LinkedList[capacity];
    // save the old table as oldTable
    var oldTable = this.hashTable;
    // need to rehash each element of oldTable to newTable
    // iterate through array of lists
    for (var list : oldTable)
      // remove head of list until list is empty
      while (list != null && !list.isEmpty())
        // remove node, add to hash into newTable
        hashInsert(newTable, list.remove());

    // assign the newTable to the hashTable
    this.hashTable = newTable;
    
  }
  

  /**
   * Calculates the current load capacity and determines if we are overloaded
   * 
   * @returns true if load capacity >= threshold, false if otherwise
   */
  private boolean isOverloaded()
  {
    return (double) this.size / this.capacity >= LOAD_CAPACITY_THRESHOLD;
  }

  /**
   * Helper method to insert a node to a LinkedList array 'table' using a hash function
   * 
   * @param table - the table to add to
   * @param node  - the node to add
   */
  private void hashInsert(LinkedList<HashNode<KeyType, ValueType>>[] table,
      HashNode<KeyType, ValueType> node)
  {
    // determine hash index
    KeyType key = node.getKey();
    int hashIndex = hash(key);
    // determine whether a new linkedList needs to be created
    if(table[hashIndex] == null)
      table[hashIndex] = new LinkedList<>();
    // there is an existing linkedList, add to it
    table[hashIndex].add(0, node);
  }

}
