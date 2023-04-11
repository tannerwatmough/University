
/*
 * ===========================================================================
 * DeckOfCards.java
 * 
 * Tanner Watmough T00712721
 * COMP 1131 Assignment 5 Question 2
 * 
 * This file defines the DeckOfCards class including the constructor, shuffle(),
 * deal(), cardLeft(), and toString(). Uses the Card class.
 * 
 * DeckOfCards()
 * This creates a complete standard deck of 52 playing cards (no Jokers). This
 * can be changed by modifying the CARD_COUNT constant but not during runtime. 
 * 
 * shuffle()
 * Randomizes the Card object order in the array. Assumes a full deck.
 * 
 * deal()
 * Outputs and removes a card from array.
 * 
 * getLastDealt()
 * Returns the last dealt card value.
 * 
 * cardsLeft()
 * Returns how many cards are left in deck after deals.
 * 
 * toString()
 * Converts deck information into useful String output.
 * 
 * ===========================================================================
 */
import java.util.Random;

public class DeckOfCards {
  // CARD_COUNT can be changed for in one place for more or less cards.
  public final static int CARD_COUNT = 52;
  private int cardsLeft = CARD_COUNT;
  // Creates two object arrays for both the deck and the dealt cards.
  private Card[] deck, dealt = new Card[CARD_COUNT];

  // Constructor for Deck
  public DeckOfCards() {
    deck = new Card[CARD_COUNT];
    int count = 0;

    // Generates all 13 cards for each suit.
    for (int suit = 1; suit < 5; suit++) {
      for (int rank = 1; rank < 14; rank++) {
        deck[count] = new Card(rank, suit);
        count++;
      }
    }
  }

  // Shuffles the deck
  public void shuffle() {
    // Will reset cardsLeft and the deck but only if cards have been dealt.
    if (cardsLeft != CARD_COUNT) {
      cardsLeft = CARD_COUNT;
      deck = dealt;
    }

    Random rand = new Random();

    // This switches a random index of the deck with the first deck position
    // and then puts the value in the first spot in the random index position.
    // Basically it just switches the card's positions.
    for (int i = 0; i < deck.length; i++) {
      int randIndex = rand.nextInt(deck.length);
      Card temp = deck[randIndex];
      deck[randIndex] = deck[i];
      deck[i] = temp;
    }
  }

  // Deal a card from the deck
  public void deal() {
    // If cardsLeft reaches 0, it will call the shuffle() method.
    if (cardsLeft <= 0) {
      shuffle();
    }
    // If there's a full deck, it will copy the playing deck to a dealt deck.
    // This keeps track of the position using cardsLeft, since the deck gets
    // smaller and would be an index out of range without the copied dealt deck.
    if (cardsLeft == CARD_COUNT) {
      for (int card = 0; card < deck.length; card++) {
        dealt[card] = deck[card];
      }
    }

    // Create a temporary new deck that is one card smaller
    Card[] temp = new Card[deck.length - 1];

    // Copies the deck over to the temporary deck except for the last card.
    for (int card = 0; card < deck.length - 1; card++) {
      temp[card] = deck[card];
    }

    // Sets the deck to the temproary deck, garbage collecting the old deck
    // array. temp and deck are technically aliases but as soon as the deal()
    // finishes, it is garbage collected since the object is local to deal.
    // (I think).
    deck = temp;

    // Since a card is dealt, decrement.
    cardsLeft--;
  }

  // Getter for the last dealt card
  public Card getLastDealt() {
    // Only if there has been a dealt card will it work. With how the shuffle
    // works, it will correspond to the cardsLeft index of the dealt deck.
    if (cardsLeft != CARD_COUNT) {
      return dealt[cardsLeft];
    }
    return null;
  }

  // Returns how many cards are left in the deck
  public int cardsLeft() {
    return cardsLeft;
  }

  // Formats deck output to print nicely
  public String toString() {
    String result = "";
    int indexCount = 0;
    final int COL_COUNT = 2;
    int maxRows = (deck.length / COL_COUNT);
    int valuesLeft = deck.length;

    // Done so decks not divisible by COL_COUNT get an extra row to print to.
    if (deck.length % COL_COUNT != 0) {
      maxRows++;
    }

    // Prints out the card (uses Card object toString()) COL_COUNT per line.
    for (int rows = 0; rows < maxRows; rows++) {
      // Prevent index error for last row
      if (valuesLeft > COL_COUNT) {
        for (int cols = 0; cols < COL_COUNT; cols++) {
          valuesLeft--;
          // This checks if the suit is Diamonds because it messes up the output
          // (its too long so the tabs act weird). Note, this does not normalize
          // shuffled output, but it doesn't really need too. The normalized
          // output was more for ease of reading for testing the program as
          // required by the assignment. In normal cases, single cards per line
          // would be fine.
          if (deck[indexCount].getSuitText().contains("Diamonds") &&
              !deck[indexCount].getRankText().contains("Ace")) {
            result += deck[indexCount] + "\t";
          } else {
            result += deck[indexCount] + "\t\t";
          }
          indexCount++;
        }
      } else {
        // valuesLeft will always be COL_COUNT or less so last row prints right.
        for (int cols = 0; cols < valuesLeft; cols++) {
          if (deck[indexCount].getSuitText().contains("Diamonds") &&
              !deck[indexCount].getRankText().contains("Ace")) {
            result += deck[indexCount] + "\t";
          } else {
            result += deck[indexCount] + "\t\t";
          }
          indexCount++;
        }
      }
      // Starts a new row line for deck values.
      result += "\n";
    }

    return result;
  }
}