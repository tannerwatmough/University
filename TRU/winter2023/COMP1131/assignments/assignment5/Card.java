/* ===========================================================================
 * Card.java
 * 
 * Tanner Watmough T00712721
 * COMP 1131 Assignment 4 Question 2
 * 
 * This file defines the Card class including the constructors, getter and 
 * setter methods for the suit and rank (along with their String equivalents).
 * 
 * toString()
 * It also includes a toString method for more informative output when using
 * System.out.print on the object. 
 * 
 * printAllValues()
 * There is also a method used to iterate through all possible value 
 * combinations to ensure all value combinations are working. 
 * ===========================================================================
 */

public class Card {

  // Instance variables
  private int rank = 1, suit = 1;

  // Default constructor. Creates a card with random rank and suit.
  public Card() {
    rank = (int) (Math.random() * 13 + 1);
    suit = (int) (Math.random() * 4 + 1);
  }

  // Constructor that sets rank and suit based on passed parameters
  public Card(int rank, int suit) {
    // Ensures passed rank value is in valid range.
    if (rank > 0 && rank < 14) {
      this.rank = rank;
    } else {
      // Gives error if invalid value used. Creates object with default values.
      System.out.print("Rank out of range. Accepted rank: 1-13. ");
      System.out.println("Object created with default rank. (Ace)");
    }

    // Ensures passed suit value is in valid range.
    if (suit > 0 && suit < 5) {
      this.suit = suit;
    } else {
      // Gives error if invalid, creates object with default values
      // (prev. initiated values)
      System.out.print("Suit out of range. Accepted suit: 1-4. ");
      System.out.println("Object created with default suit. (Clubs)");
    }
  }

  // Gets rank as an integer value. 1-13.
  public int getRank() {
    return rank;
  }

  // Set rank with integer value between 1-13. Will not set for values outside.
  public void setRank(int rank) {
    if (rank > 0 && rank < 14) {
      this.rank = rank;
    }
  }

  // Get rank text using switch corresponding to integer value.
  public String getRankText() {
    String str = "";

    switch (rank) {
      case 1:
        str = "Ace";
        break;
      case 2:
        str = "Two";
        break;
      case 3:
        str = "Three";
        break;
      case 4:
        str = "Four";
        break;
      case 5:
        str = "Five";
        break;
      case 6:
        str = "Six";
        break;
      case 7:
        str = "Seven";
        break;
      case 8:
        str = "Eight";
        break;
      case 9:
        str = "Nine";
        break;
      case 10:
        str = "Ten";
        break;
      case 11:
        str = "Jack";
        break;
      case 12:
        str = "Queen";
        break;
      case 13:
        str = "King";
        break;
      default:
        break;
    }

    return str;

  }

  // Set rank based on text. Accepts any case and single letter for face cards.
  public void setRankText(String str) {
    str = str.toLowerCase();

    if (str.equals("king") || str.equals("k")) {
      rank = 13;
    } else if (str.equals("queen") || str.equals("q")) {
      rank = 12;
    } else if (str.equals("jack") || str.equals("j")) {
      rank = 11;
    }
    // You could use an OR argument for doing numeric values as strings but
    // I felt it was redundant with the setRank based on an integer value.
    else if (str.equals("ten")) {
      rank = 10;
    } else if (str.equals("nine")) {
      rank = 9;
    } else if (str.equals("eight")) {
      rank = 8;
    } else if (str.equals("seven")) {
      rank = 7;
    } else if (str.equals("six")) {
      rank = 6;
    } else if (str.equals("five")) {
      rank = 5;
    } else if (str.equals("four")) {
      rank = 4;
    } else if (str.equals("three")) {
      rank = 3;
    } else if (str.equals("two")) {
      rank = 2;
    } else if (str.equals("ace") || str.equals("a")) {
      rank = 1;
    } else {
      System.out.println("Invalid value.");
    }
  }

  // Get Suit value as an integer
  public int getSuit() {
    return suit;
  }

  // Set Suit value with an integer. Accepts values 1-4.
  public void setSuit(int suit) {
    if (suit > 0 && suit < 5) {
      this.suit = suit;
    }
  }

  // Get Suit value as a String.
  public String getSuitText() {
    String str = "";

    switch (suit) {
      case 1:
        str += "Clubs";
        break;
      case 2:
        str += "Spades";
        break;
      case 3:
        str += "Diamonds";
        break;
      case 4:
        str += "Hearts";
        break;
      default:
        break;
    }

    return str;
  }

  // Set Suit Text with first letter, singular, or plural with any case.
  public void setSuitText(String str) {
    str = str.toLowerCase();

    if (str.equals("c") || str.equals("clubs") || str.equals("club")) {
      suit = 1;
    } else if (str.equals("s") || str.equals("spades") || str.equals("spade")) {
      suit = 2;
    } else if (str.equals("d") || str.equals("diamonds") || str.equals("diamond")) {
      suit = 3;
    } else if (str.equals("h") || str.equals("hearts") || str.equals("heart")) {
      suit = 4;
    } else {
      System.out.println("Invalid value.");
    }
  }

  // toString method for nicely formatted and useful output.
  public String toString() {
    String str = "";

    // Get rank int value and convert to text
    switch (rank) {
      case 1:
        str += "Ace";
        break;
      case 2:
        str += "Two";
        break;
      case 3:
        str += "Three";
        break;
      case 4:
        str += "Four";
        break;
      case 5:
        str += "Five";
        break;
      case 6:
        str += "Six";
        break;
      case 7:
        str += "Seven";
        break;
      case 8:
        str += "Eight";
        break;
      case 9:
        str += "Nine";
        break;
      case 10:
        str += "Ten";
        break;
      case 11:
        str += "Jack";
        break;
      case 12:
        str += "Queen";
        break;
      case 13:
        str += "King";
        break;
      default:
        break;
    }

    // Used to nicely concatenate rank to suit.
    str += " of ";

    // Get suit int value and convert to text.
    switch (suit) {
      case 1:
        str += "Clubs";
        break;
      case 2:
        str += "Spades";
        break;
      case 3:
        str += "Diamonds";
        break;
      case 4:
        str += "Hearts";
        break;
      default:
        break;
    }

    return str;
  }

  // This is used to ensure all ranks and suits display properly
  public static void printAllValues() {
    for (int i = 1; i < 14; i++) {
      for (int j = 1; j < 5; j++) {
        Card card = new Card(i, j);
        System.out.println(card);
      }
    }
  }
}