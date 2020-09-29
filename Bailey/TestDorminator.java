
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;

// --== CS400 File Header Information ==--
// Name: Bailey Hurlburt
// Email: bhurlburt@wisc.edu
// Team: MG
// Role: Test Engineer
// TA: Harit
// Lecturer: Gary Dahl
// Notes to Grader: <optional extra notes>

/* 
 * This class tests the applications outside of the HashTableMap Implementation
 */
public class TestDorminator {
  
  public static void main(String args[]) {
    
    if(testDormInfo()) {
      System.out.println("Dorm Info Test Passed");
    }
    else {
      System.out.println("Dorm Info Test Failed");
    }
    if(testRemove()) {
      System.out.println("Remove Test Passed");
    }
    else {
      System.out.println("Remove Test Failed");
    }
    if(testClear()) {
      System.out.println("Clear Test Passed");
    }
    else {
      System.out.println("Clear Test Failed");
    }
    if(testResize()) {
      System.out.println("Resize Test Passed");
    }
    else {
      System.out.println("Resize Test Failed");
    }
    if(testPut()) {
      System.out.println("Put Test Passed");
    }
    else {
      System.out.println("Put Test Failed");
    }
    if(testContainsKey()) {
      System.out.println("ContainsKey Test Passed");
    }
    else {
      System.out.println("ContainsKey Test Failed");
    }
  }
  
  public static boolean testDormInfo() {
    //test the UI class, in creating a database with the given filename
    try {
      
      UI<String, String> database = new UI<String, String>("dorms.txt");
      
      String command = "wittenburg";
      if(database.containsKey(command)) {
        return false;
      }
      
      String command2 = "cole";
      if(!(database.containsKey(command2))) {
        return false;
      }
      
      String command3 = "smith";
      String description = database.getValue(command3);
      if(!(description.equals("walk in closets in room"))) {
        return false;
      }
      
      String command4 = "cole";
      String description2 = database.getValue(command4);
      if(!(description2.equals("surrounded by nature, close to lake"))) {
        return false;
      }
      
    }
    catch(FileNotFoundException e) {
      System.out.println("The inputted file was not found in current directory.");
      return false;
    }
    
    return true;
  }
  
  public static boolean testRemove() {
    
    // Create HashTableMap object to test
    HashTableMap test3 = new HashTableMap(6);
    
    // test "put" and check if "size" works as intended
    test3.put(15, 90856);
    test3.put("acoolkey", 23456);
    test3.remove(15);
    test3.remove(3567);
    
    if (test3.size() != 1) {
      return false;
    }
    
    return true;
  }

  public static boolean testClear() {

    // Create HashTableMap object to test
    HashTableMap test4 = new HashTableMap(15);
    
    // test "put" and check if "clear" works as intended
    test4.put(15, 90856);
    test4.put("ogg", 23456);
    test4.put("socooltest", "oppa");
    test4.clear();
    
    if (test4.size() != 0) {
      return false;
    }
    
    return true;
  }

  public static boolean testResize() {

    // Create HashTableMap object to test
    HashTableMap test5 = new HashTableMap(2);
    
    // test "put" and check if "rehashing" correctly doubles table and doesn't affect size
    test5.put(15, 90856);
    test5.put("yipyip", "oppa");
    
    if (test5.size() != 2) {
      return false;
    }
    return true;
  }
  public static boolean testPut() {

    // Create HashTableMap object to test
    HashTableMap test1 = new HashTableMap(4);

    try {
      // test "put" on strings and "get" to recieve correct output
      test1.put("dorm1", "521541234");
      test1.put("dorm2", "wow so cool!");

      if (test1.get("dorm1") != "521541234") {
        return false;
      }
      if (test1.get("dorm2") != "wow so cool!") {
        return false;
      }

    } catch (NoSuchElementException e) {
      System.out.println("That key is not in the table");
      return false;
    }

    return true;
  }

  public static boolean testContainsKey() {
    
    // Create HashTableMap object to test
    HashTableMap test2 = new HashTableMap(8);
    
    // test "put" and check if "containsKey" works as intended
    test2.put(15, 90856);
    test2.put("acoolkey", 23456);
    
    if (!test2.containsKey(15)) {
      return false;
    }
    if (!test2.containsKey("acoolkey")) {
      return false;
    }
    
    return true;
  }
  
}
