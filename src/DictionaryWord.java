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
 * Models a word stored in a dictionaryBST. Includes the word, its meaning, and its right and
 * left children.
 *
 * @author HunterAbraham
 */

public class DictionaryWord {
  private final String word; // word that represents the search key for this dictionary word
  private final String meaning;   // The meaning of the word that this dictionary node defines
  private DictionaryWord leftChild;  // The leftChild of the the current WebPageNode
  private DictionaryWord rightChild; // The rightChild of the the current WebPageNode


  /**
   * Dictionary word Constructor. Ensures that the meaning and word are not null and are not
   * length 0. If the arguments are valid, it assigns the values to the word and meaning instance
   * fields.
   *
   * @param word    The word being stored in the node
   * @param meaning The meaning of the word being stored in the node
   */
  public DictionaryWord(String word, String meaning) {
    if (word == null || meaning == null || meaning.equals("") || word.equals(""))
      throw new IllegalArgumentException("Error: Arguments can not be null");

    this.word = word;
    this.meaning = meaning;
  }


  /**
   * Getter for the left child of this node
   *
   * @return This node's left child
   */
  public DictionaryWord getLeftChild() {
    return leftChild;
  }

  /**
   * Setter for this node's left child
   *
   * @param leftChild this node's new left child
   */
  public void setLeftChild(DictionaryWord leftChild) {
    this.leftChild = leftChild;
  }

  /**
   * Getter for the right child of this node.
   *
   * @return this node's right child
   */
  public DictionaryWord getRightChild() {
    return rightChild;
  }

  /**
   * Getter for this node's right child.
   *
   * @param rightChild this node's right child
   */
  public void setRightChild(DictionaryWord rightChild) {
    this.rightChild = rightChild;
  }

  /**
   * Getter method for this node's word
   *
   * @return this node's word
   */
  public String getWord() {
    return word;
  }

  /**
   * Getter method for this node's meaning
   *
   * @return this word's meaning
   */
  public String getMeaning() {
    return meaning;
  }

  /**
   * Returns a String representation of this DictionaryWord.
   * This String should be formatted as follows. "<word>: <meaning>"
   * For instance, for a dictionaryWord that has the String "Awesome"
   * for the instance field word and the String "adj. Inspiring awe; dreaded."
   * as value for meaning field, the String representing that dictionaryWord is
   * "Awesome: adj. Inspiring awe; dreaded."
   *
   * @return The string representation of this node
   */
  public String toString() {
    String returnStr = word + ": ";
    returnStr = returnStr.concat(meaning);
    return returnStr;
  }

}
