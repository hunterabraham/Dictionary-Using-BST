//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           DictionaryUsingBST
// Files:           Dictionary.java, DictionaryWord.java, DictionaryDriver.java
//                  DictionaryTests.java
// Course:          CS 300, Semester 2, 2019
//
// Author:          Hunter Abraham
// Email:           hjabraham@wisc.edu
// Lecturer's Name: Gary Dahl
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    (name of your pair programming partner)
// Partner Email:   (email address of your programming partner)
// Partner Lecturer's Name: (name of your partner's lecturer)
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   ___ Write-up states that pair programming is allowed for this assignment.
//   ___ We have both read and understand the course Pair Programming Policy.
//   ___ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here.  Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates,
// strangers, and others do.  If you received no outside help from either type
//  of source, then please explicitly indicate NONE.
//
// Persons:         (identify each person and describe their help in detail)
// Online Sources:  (identify each URL and describe their assistance in detail)
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

import java.util.ArrayList;

/**
 * Tests for the DictionaryBST and DictionaryWord classes.
 *
 * @author Hunter Abraham
 */
public class DictionaryTests {

  /**
   * Tests DictionaryBST's addWord(),and getAllWords() methods
   *
   * @return true if the tests pass, false otherwise
   */
  public static boolean testDictionaryBSTAddWordGetAllWords() {
    DictionaryBST dict = new DictionaryBST(); // Create new dictionary and add words to it
    dict.addWord("begone", "Greeting");
    dict.addWord("wild", "Elated");
    dict.addWord("never", "A connection of fibers");
    dict.addWord("allocate", "plane");
    dict.addWord("besmirched", "couch");
    // Create a test array with words properly sorted
    ArrayList<String> testList = new ArrayList<>();
    testList.add("allocate");
    testList.add("begone");
    testList.add("besmirched");
    testList.add("never");
    testList.add("wild");
    ArrayList<String> dictList = dict.getAllWords();
    // Check to see that the words in dictList are added properly
    for (int i = 0; i < testList.size(); i++) {
      if (!testList.get(i).equals(dictList.get(i))) { // if they aren't return false and print error
        System.out.println("ERROR: the values were added to the dictionary in the wrong order." +
            " Current value: " + dictList.get(i));
        return false;
      }
    }

    return true; // Otherwise, return true
  }

  /**
   * Tests DictionaryBST's size() method
   *
   * @return
   */
  public static boolean testDictionaryBSTSize() {
    DictionaryBST dict = new DictionaryBST(); // Create dictionary and add 4 words to it
    dict.addWord("binary", "two");
    dict.addWord("credit", "idk");
    dict.addWord("allocate", "give");
    dict.addWord("breach", "enter");

    if (dict.size() != 4) { // check that the size() method works properly
      System.out.println("Dictionary's size should be 4 but instead is: " + dict.size());
      return false;
    }

    return true; // return true if the test passes
  }

  /**
   * Tests DictionaryBST's height() method
   *
   * @return the height of the tree
   */
  public static boolean testDictionaryBSTHeight() {
    DictionaryBST dict = new DictionaryBST(); // Create a dictionary and add four elements to it
    dict.addWord("binary", "two");
    dict.addWord("credit", "idk");
    dict.addWord("allocate", "give");
    dict.addWord("breach", "enter");

    if (dict.height() != 3) { // If the height() method returns an incorrect height, return false
      System.out.println("Dictionary's height should be 3 but instead is: " + dict.height());
      return false;
    }
    return true; // If the height() method returns the correct height, return true
  }

  /**
   * tests the DictionaryBST's lookup() method
   *
   * @return true if the tests pass, false otherwise
   */
  public static boolean testDictionaryBSTLookup() {
    DictionaryBST dict = new DictionaryBST(); // Create a new dictionary an add words to it
    dict.addWord("binary", "two");
    dict.addWord("credit", "idk");
    dict.addWord("allocate", "give");
    dict.addWord("breach", "enter");

    // Check that the lookup() method returns the correct definitions. If they don't return false.
    if (!dict.lookup("binary").equals("two")) {
      System.out.println("ERROR: binary's definition is \"two\" but lookup() returned: "
          + dict.lookup("binary"));
      return false;
    }
    if (!dict.lookup("credit").equals("idk")) {
      System.out.println("ERROR: credit's definition is \"idk\" but lookup() returned: "
          + dict.lookup("credit"));
      return false;
    }
    if (!dict.lookup("allocate").equals("give")) {
      System.out.println("ERROR: allocate's definition is \"give\" but lookup() returned: "
          + dict.lookup("allocate"));
      return false;
    }
    if (!dict.lookup("breach").equals("enter")) {
      System.out.println("ERROR: breach's definition is \"enter\" but lookup() returned: "
          + dict.lookup("breach"));
      return false;
    }

    return true; // return true if the tests pass
  }

  /**
   * tests the DictionaryBST's isEmpty() method
   *
   * @return true if the tests pass, false otherwise
   */
  public static boolean testDictionaryBSTIsEmpty() {
    DictionaryBST dict = new DictionaryBST(); // create a new dictionary
    if (!dict.isEmpty()) { // if the dictionary is incorrectly considered not empty,
      System.out.println("ERROR: Dictionary should be empty but instead is size: " + dict.size());
      return false; // Print error and return false
    }
    dict.addWord("word", "word"); // Add a word to the dictionary
    if (dict.isEmpty()) { // If the dictionary is considered empty, return false and print error
      System.out.println("ERROR: Dictionary should be size one but instead is size: "
          + dict.size());
      return false;
    }
    return true; // return true if all tests pass
  }

  /**
   * Driver method for the DictionaryTests.java class
   *
   * @param args unused.
   */
  public static void main(String[] args) {
    System.out.println("testDictionaryBSTAddWordGetAllWords(): "
        + testDictionaryBSTAddWordGetAllWords());
    System.out.println("testDictionaryBSTSize(): " + testDictionaryBSTSize());
    System.out.println("testDictionaryBSTHeight(): " + testDictionaryBSTHeight());
    System.out.println("testDictionaryBSTLookup(): " + testDictionaryBSTLookup());
    System.out.println("testDictionaryBSTIsEmpty(): " + testDictionaryBSTIsEmpty());
  }
}
