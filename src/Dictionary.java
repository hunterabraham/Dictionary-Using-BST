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

/**
 * Interface defining a dictionary
 *
 * @author Gary Dahl, Hunter Abraham
 */

public interface Dictionary {


  /**
   * checks whether the dictionary is empty or not
   * @return true if the dictionary is empty, false otherwise
   */
  public boolean isEmpty();

  /**
   * adds this word definition (word and the provided meaning) to the dictionary
   * Returns true if the word was successfully added to this dictionary
   * Returns false if the word was already in the dictionary
   * @param word the word to be stored in this node
   * @param meaning the meaning of the word
   *
   * @throws IllegalArgumentException if either word or meaning is null or an empty
   * @return true if word was successfully added to this DictionaryBST, false otherwise
   */
  public boolean addWord(String word, String meaning);


  /**
   * Looks up a word's meaning in this dictionary
   *
   * @param s the word the user is looking up
   * @return the meaning of the word s if it is present in this dictionary
   * @throws java.util.NoSuchElementException if the word s was not found in this dictionary
   */
  public String lookup(String s);


  /**
   * Finds the size of this dictionary
   *
   * @return the number of nodes in this dictionary
   */
  public int size();
}
