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
import java.util.NoSuchElementException;


/**
 * Models a dictionary using a binary search tree.
 *
 * @author Hunter Abraham
 */
public class DictionaryBST implements Dictionary {


  /**
   * Creates an empty DictionaryBST
   */
  public DictionaryBST() {
  }

  private DictionaryWord root; // The first element in the BST

  /**
   * Determines if this BST is empty.
   *
   * @return true if the tree is empty, false otherwise
   */
  public boolean isEmpty() {
    return size() == 0;
  }


  /**
   * Adds this word definition (word and the provided meaning) to the dictionary
   *
   * @param word    the word to be added
   * @param meaning the meaning of the word to be added
   * @return true if the word was added successfully, false otherwise
   * @throws IllegalArgumentException if either word or meaning is null or an empty String
   * @throws IllegalStateException    if the word is already in the dictionary
   */
  public boolean addWord(String word, String meaning) {
    // If the arguments would cause an error, throw an exception
    if (word == null || meaning == null || meaning.equals("") || word.equals(""))
      throw new IllegalArgumentException("ERROR: Arguments can not be null or empty Strings");

    if (this.root == null) { // if the root is null, make the new word the head node
      root = new DictionaryWord(word, meaning);
      return true;
    }

    return addWordHelper(new DictionaryWord(word, meaning), root); // Otherwise, call addWordHelper()
  }

  /**
   * Searches for a word's definition in the dictionary
   *
   * @param s the word the user is looking up
   * @return the word's definition
   * @throws NoSuchElementException if the word isn't found in the dictionary
   */
  public String lookup(String s) {
    return lookupHelper(s, this.root);
  }

  /**
   * Finds the number of nodes currently in this BST
   *
   * @return the number of nodes in this BST
   */
  public int size() {
    return sizeHelper(root);
  }

  /**
   * Computes and returns the height of this dictionaryBST, as the number of nodes
   * from root to the deepest leaf DictionaryWord node.
   *
   * @return the height of this Binary Search Tree counting the number of DictionaryWord nodes
   */
  public int height() {
    return heightHelper(root);
  }

  /**
   * Returns all the words within this dictionary sorted from A to Z
   *
   * @return an ArrayList that contains all the words within this dictionary sorted in
   * the ascendant order
   */
  public ArrayList<String> getAllWords() {
    return getAllWordsHelper(root);
  }

  /**
   * Recursive helper method to add newWord in the subtree rooted at node
   *
   * @param newWordNode a new DictionaryWord to be added to this dictionaryBST
   * @param current     the current DictionaryWord that is the root of the subtree where
   *                    newWord will be inserted
   * @return true if the newWordNode is successfully added to this dictionary, false otherwise
   * @throws IllegalStateException if word is already in the dictionary
   */
  private static boolean addWordHelper(DictionaryWord newWordNode,
                                       DictionaryWord current) {
    int comparison =
        newWordNode.getWord().compareToIgnoreCase(current.getWord()); // Compare the two word
    if (comparison == 0) // no duplicates allowed
      throw new IllegalStateException(
          "Error: Duplicate nodes are not allowed in this Dictionary.");

    if (comparison < 0) { // If the new word is left of the current word,
      if (current.getLeftChild() != null) // if the current word's left child isn't null
        addWordHelper(newWordNode, current.getLeftChild()); // Recurse through the left side
      else // If the left child is null,
        current.setLeftChild(newWordNode); // Set the left child of the current node to the new word
    } else { // If the new word is right of the current word,
      if (current.getRightChild() != null) { // If the right node isn't null,
        addWordHelper(newWordNode, current.getRightChild()); // Recurse through the right branch
      } else { // If the right node is null,
        current.setRightChild(newWordNode); // Set the right node to the newWordNode
      }
    }
    return true; // return true if the added word is successful
  }


  /**
   * Recursive helper method to lookup a word s in the subtree rooted at current
   *
   * @param s       String that represents a word
   * @param current pointer to the current DictionaryWord within this dictionary
   * @return the meaning of the word s if it is present in this dictionary
   * @throws NoSuchElementException if s is not found in this dictionary
   */
  private static String lookupHelper(String s, DictionaryWord current) {

    if (s.equalsIgnoreCase(current.getWord())) // If the current node matches the string,
      return current.getMeaning(); // Return its meaning

    // if the current word is right of the desired word
    if (current.getWord().compareToIgnoreCase(s) > 0) {
      if (current.getLeftChild() == null) // If the left child is null,
        // Throw exception, because the word can't be found
        throw new NoSuchElementException(
            "Error: " + s + " could not be found.");
      else // Otherwise,
        return lookupHelper(s, current.getLeftChild()); // Lookup the left child
    } else { // Otherwise, look down right branch
      if (current.getRightChild() == null) // If the right child is null, throw an exception
        throw new NoSuchElementException(
            "Error: " + s + " could not be found."); // Because the word can't be found
      else // If the right child isn't null,
        return lookupHelper(s, current.getRightChild()); // Recurse through right branch
    }

  }


  /**
   * Recursive helper method that returns the number of dictionary words stored in
   * the subtree rooted at current
   *
   * @param current current DictionaryWord within this dictionaryBST
   * @return the size of the subtree rooted at current
   */
  private static int sizeHelper(DictionaryWord current) {
    int count = 1;             //Node itself should be counted
    if (current == null) // if root is null, return 0
      return 0;
    else { // Otherwise,
      count += sizeHelper(current.getLeftChild()); // Count left side of the tree
      count += sizeHelper(current.getRightChild()); // Count right side of the tree
      return count; // Return the count of both sides
    }
  }


  /**
   * Recursive helper method that computes the height of the subtree rooted at current
   *
   * @param current pointer to the current DictionaryWord within this DictionaryBST
   * @return height of the subtree rooted at current counting the number of
   * DictionaryWord nodes from the current node to the deepest leaf in the subtree
   * rooted at current
   */
  private static int heightHelper(DictionaryWord current) {
    if (current == null) // If the root is null, return 0
      return 0;

    int leftHeight = heightHelper(current
        .getLeftChild()); // Recurse to find height of the left branch
    int rightHeight = heightHelper(current
        .getRightChild()); // Recurse to find height of the right branch
    // Return 1 plus either the height of the left branch or right branch,
    // depending on which one is greater
    return 1 + Math.max(leftHeight, rightHeight);
  }


  /**
   * Recursive Helper method that returns a list of all the words stored in
   * the subtree rooted at current
   *
   * @param current pointer to the current DictionaryWord within this dictionaryBST
   * @return an ArrayList of all the words stored in the subtree rooted at current
   */
  private static ArrayList<String> getAllWordsHelper(DictionaryWord current) {
    ArrayList<String> wordList = new ArrayList<>(); // Initialize ArrayList

    if (current != null) { // If node isn't null
      wordList.addAll(getAllWordsHelper(current.getLeftChild()));  // Recurse down left side
      wordList.add(current.getWord()); // Add word
      wordList.addAll(getAllWordsHelper(current.getRightChild())); // Recurse down right side
    }

    return wordList; // Return the ArrayList
  }


}
