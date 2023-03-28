/* ===========================================================================
 * CardDriver.java
 * 
 * Tanner Watmough T00712721
 * COMP 1131 Assignment 4 Question 2
 * 
 * This is a simple driver for the Card class. It creates five random and five
 * set Card objects that represent playing cards. It then outputs the valeus to
 * the console. 
 * ===========================================================================
 */

public class CardDriver {
  public static void main(String[] args) {
    // Constructs cards with default constructor with random values.
    Card card1 = new Card();
    Card card2 = new Card();
    Card card3 = new Card();
    Card card4 = new Card();
    Card card5 = new Card();

    // Output random constructed cards. Uses the toString method.
    System.out.println(card1);
    System.out.println(card2);
    System.out.println(card3);
    System.out.println(card4);
    System.out.println(card5);

    // Constructs new cards with passed parameters
    Card card6 = new Card(1, 1);
    Card card7 = new Card(13, 4);
    Card card8 = new Card(6, 2);
    Card card9 = new Card(0, -1);
    Card card10 = new Card(15, 5);

    // Output parameter constructed cards. Uses the toString method.
    System.out.println(card6);
    System.out.println(card7);
    System.out.println(card8);
    System.out.println(card9);
    System.out.println(card10);

    // =====================================================================
    // Testing. Disabled for normal operation.
    // ======================================================================

    // // Print all values in deck
    // Card.printAllValues();

    // // Get Rank as int
    // System.out.println(card6.getRank());

    // // Get Rank as text
    // System.out.println(card6.getRankText());

    // // Set Rank with int
    // card6.setRank(4);
    // System.out.println(card6.getRank());

    // // Set Rank with text
    // card6.setRankText("queen");
    // System.out.println(card6.getRankText());

    // // Get Suit as int
    // System.out.println(card6.getSuit());

    // // Get Suit as text
    // System.out.println(card6.getSuitText());

    // // Set Suit with int
    // card6.setSuit(3);
    // System.out.println(card6.getSuit());

    // // Set Suit with text
    // card6.setSuitText("hearts");
    // System.out.println(card6.getSuitText());
  }
}