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
import java.util.Scanner;


/**
 * Drives the dictionary application. Allows a user to create a dictionary using the binary search
 * tree
 *
 * @author Hunter Abraham
 */
public class DictionaryDriver {

  /**
   * Prompts the user with the command menu and captures their input
   *
   * @param scnr The scanner object to read the user's input
   * @return The user's input
   */
  private static String promptUser(Scanner scnr) {
    printMenu();
    return scnr.nextLine();
  }

  /**
   * Prints the dictionary's home menu
   */
  private static void printMenu() {
    String userCommands = "\n=========================== Dictionary ============================\n"
        + "Enter one of the following options:\n"
        + "[A <word> <meaning>] to add a new word and its definition in the dictionary\n"
        + "[L <word>] to search a word in the dictionary and display its definition\n"
        + "[G] to print all the words in the dictionary in sorted order\n"
        + "[S] to get the count of all words in the dictionary\n"
        + "[H] to get the height of this dictionary implemented as a binary search tree\n"
        + "[Q] to quit the program\n"
        + "======================================================================\n";
    System.out.println(userCommands);
    System.out.print("Please enter your command: ");
  }

  /**
   * Drives the dictionary application
   *
   * @param args unused.
   */
  public static void main(String[] args) {
    Scanner scnr = new Scanner(System.in); // Create scanner object
    DictionaryBST dict = new DictionaryBST(); // Create dictionary
    char quit = '\0'; // create quit char for user's input
    String command = ""; // create variable for user input
    while (true) { // While the user hasn't quit the program
      String definition = ""; // Declare variable for the the definition of an added word
      command = promptUser(scnr); // prompt the user for their command
      if (command == null || command.equals("")) {
        System.out.println("WARNING: Unrecognized command.");
        continue;
      }
      quit = command.trim().toLowerCase().charAt(0); // trim command and make it lowercase
      String[] commands = command.split(" "); // turn command into an array
      if (quit == 'a') { // if their command is to add a word,
        if (commands.length < 3) { // if command is not proper length, print error and restart loop
          System.out.println("WARNING: Syntax Error for [A <word> <meaning>] command line.");
          continue;
        }
        for (int i = 2; i < commands.length; i++) { // Otherwise, concatenate definition together
          definition += commands[i] + " ";
        }
        try { // try to add the word to the dictionary
          dict.addWord(commands[1], definition);
        } catch (IllegalArgumentException e) { // if the argument is illegal,
          System.out.println(e.getLocalizedMessage()); // print error message and continue
          continue;
        } catch (IllegalStateException e) { // print error message and continue
          System.out.println(e.getLocalizedMessage());
          continue;
        }
      } else if (quit == 'l') { // If the user wants to lookup a word
        if (commands.length != 2) { // make sure their command is the right length
          System.out.println("WARNING: Syntax Error"); // if it isn't print error message
          continue; // and restart loop
        }
        try { // try to print the word and the command
          System.out.println(commands[1] + ": " + dict.lookup(commands[1]));
        } catch (NoSuchElementException e) { // if the word can't be found, print error message
          System.out.println(e.getLocalizedMessage());
          continue;
        }
      } else if (quit == 'g') { // If the user wants to print the dictionary,
        if (dict.size() == 0) { // If the dictionary is empty, print error message
          System.out.println("Dictionary is empty.");
          continue; // restart loop
        }
        ArrayList<String> list = dict.getAllWords(); // Otherwise, get all dictionary words
        for (int i = 0; i < list.size() - 1; i++) // print all but the last word
          System.out.print(list.get(i) + ", ");

        System.out.print(list.get(list.size() - 1)); // print the last word
      } else if (quit == 's') { // if the user wants the size, print the tree's size
        System.out.println(dict.size());
      } else if (quit == 'h') { // if the user wants the tree's height, print the height
        System.out.println(dict.height());
        // if user wants to quit, print the end message and break the loop
      } else if (commands[0].equals("q") && commands.length == 1) {
        System.out.println("============================== END "
            + "===================================");
        break;
      } else { // If the command is unrecognized, print warning
        System.out.println("WARNING: Unrecognized command.");
      }
    }
  }
}
