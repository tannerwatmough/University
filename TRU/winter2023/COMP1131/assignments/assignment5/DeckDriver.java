/* ===========================================================================
 * DeckDriver.java
 * 
 * Tanner Watmough T00712721
 * COMP 1131 Assignment 5 Question 2
 * 
 * This is a simple driver for the RandomArray class. It creates a RandomArray
 * object based on the user's desired array size and populates the array with
 * random numbers from 0 to the array's size. It then prints out the values of
 * the array, averageValue(), maxValue(), and minValue() methods to the output. 
 * ===========================================================================
 */

public class DeckDriver {
  public static void main(String[] args) {

    // Calls constructor to create new deck of cards
    DeckOfCards deck = new DeckOfCards();

    // Outputs populated deck (non-shuffled)
    System.out.println(deck);
    // Shuffles deck
    deck.shuffle();

    // Deals each card in the deck, outputting the dealt card and the cards left
    for (int i = 0; i < DeckOfCards.CARD_COUNT; i++) {
      deck.deal();
      // This monstrosity of a statement checks if the card contains a diamond
      // AND one of the following rank values: 8, 12 (Queen), 3, or 7. These
      // values made the output to the console ununiform. This fixes it.
      // Note: This normalization DOES work even for shuffled decks.
      if (deck.getLastDealt().getSuitText().contains("Diamonds")
          && (deck.getLastDealt().getRank() == 8
              || deck.getLastDealt().getRank() == 12
              || deck.getLastDealt().getRank() == 3
              || deck.getLastDealt().getRank() == 7)) {
        System.out.print("Dealt: " + deck.getLastDealt() + "\t");
      } else {
        System.out.print("Dealt: " + deck.getLastDealt() + "\t\t");
      }
      System.out.println("Cards left: " + deck.cardsLeft());
    }
  }
}
