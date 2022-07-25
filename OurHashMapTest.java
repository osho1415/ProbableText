/**
 * A Unit test for OurHashMap<K,V>
 * 
 * There is also an @Test to show how to read Alice and it can be found
 * 
 * @author Rick Mercer and Osho Sharma
 */
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class OurHashMapTest {

  @Test
  public void testGenericity() { 
    OurMap<String, Integer> one = new OurHashMap<String, Integer>();
    assertEquals(0, one.size()); // size() only works accidentally
    OurMap<Integer, String> another = new OurHashMap<Integer, String>();
    assertEquals(0, another.size()); // size() only works accidentally
  }
  
  @Test
  public void testContainKeyAndPut() { 
	  
	  OurMap<String, Integer> one = new OurHashMap<>();
	  
	  assertFalse(one.containsKey("Eleven"));
	  
	  assertNull(one.put("First", 1)); 
	  assertEquals(1, one.size());
	  
	  assertTrue(one.containsKey("First")); 
	  assertNull(one.put("Second", 2)); 
	  assertNull(one.put("Third", 3));
	  assertFalse(one.containsKey("Fourth")); 
	  assertTrue(one.containsKey("Third")); 
	  
	  assertEquals(2, one.put("Second", 21)); 
	  assertEquals(21, one.put("Second", 22)); 
	  assertEquals(3, one.size()); 
	  
  }
  
  @Test 
  public void testGet() { 
	  OurMap<String, Integer> one = new OurHashMap<>();
	  assertNull(one.get("First"));
	  
	  assertNull(one.put("First", 1)); 
	  assertNull(one.put("Second", 2)); 
	  assertNull(one.put("Third", 3));
	  
	  assertEquals(1, one.get("First"));
	  assertEquals(2, one.put("Second", 21)); 
	  assertEquals(21, one.put("Second", 22)); 
	  
	  assertNull(one.get("Fourth")); 
	  assertEquals(22, one.get("Second")); 
	  
  }
  @Test 
  public void testKeySet() { 
	  OurMap<String, Integer> one = new OurHashMap<>();
	  assertNull(one.put("First", 1)); 
	  assertNull(one.put("Second", 2)); 
	  assertNull(one.put("Third", 3));
	  assertNull(one.put("A", 1)); 
	  assertNull(one.put("B", 2)); 
	  assertNull(one.put("C", 3));
	  assertNull(one.put("F", 1)); 
	  assertNull(one.put("S", 2)); 
	  assertNull(one.put("Th", 3));
	  assertNull(one.put("Fit", 1)); 
	  assertNull(one.put("Se", 2)); 
	  assertNull(one.put("Thi", 3));
	  System.out.println(one.keySet()); 
  }

  @Test
  public void testFileRead() {
    Scanner inputFile = null;
    try {
      inputFile = new Scanner(new File("Alice"));
    } catch (FileNotFoundException e) {
      System.out.println("Alice not found");
    }
    StringBuffer theText = new StringBuffer();
    String line = inputFile.nextLine();
    theText.append(line);
    theText.append(" "); 
    theText.append(inputFile.nextLine());
    theText.append(" "); 
    theText.append(inputFile.nextLine());
    theText.append(" "); 
       // Verify the first three lines match the book in the file named "Alice"
    System.out.println(theText);
  }
  
  @Test 
  public void testGetBookAsAString() { 
	  ProbableTextWithMap aMap = new ProbableTextWithMap("Alice", 3); 
	  System.out.println(aMap.getBookAsString()); 
  }
  
  @Test 
  public void testRandomNGramAndBuildMap() { 
	  ProbableTextWithMap aMap = new ProbableTextWithMap("Alice", 12);
	 /* String nGram = aMap.getRandomNGram(); 
	  System.out.println(nGram); 
	  assertTrue(aMap.theMap.containsKey(nGram));
	  System.out.println( aMap.theMap.get(nGram)); 
	 */
	  
	  System.out.println(aMap.theMap.keySet());
  }
  
  /*
  @Test 
  public void testMain() { 
	  ProbableTextWithMap aMap = new ProbableTextWithMap("Alice", 12);
	  String faultyNGram = aMap.printRandom(130);
	  System.out.println(); 
	  System.out.println(faultyNGram); 
	  //int faultyIndex = aMap.theMap.hashCode(faultyNGram); 
	  assertTrue(aMap.theMap.containsKey(faultyNGram)); 
	  System.out.println(aMap.theMap.get(faultyNGram)); 
  }
*/
  
}
