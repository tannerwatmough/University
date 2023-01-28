import java.util.*;

class DiceGame {
  public static void main(String[] args) {
    int compThrow, userThrow = 0, compWins = 0, playerWins = 0;
    boolean run = true, valid = false;

    Scanner scan = new Scanner(System.in);
    Random rand = new Random();

    while (run) {
      compThrow = (rand.nextInt(6) + 1) + (rand.nextInt(6) + 1);
      System.out.println("The Computer tosses: " + compThrow);
      // 11-sided die because the range will be 2-12 for both dice. You will add
      // one to the 11-sided die result.
      while (!valid) {
        System.out.println("Toss 1 eleven-sided die, or 2 six-sided dice" +
            "(enter 1 or 2)?");
        userThrow = scan.nextInt();
        // Ensures user enters 1 or 2 for the value.
        if (userThrow == 1 || userThrow == 2) {
          valid = true;
        }
      }

      // Checks user option and throws 1 or 2 die depending.
      if (userThrow == 1) {
        userThrow = rand.nextInt(11) + 2; // Adds 2 so it's 0-12 instead of 0-10
        System.out.println("You throw 1 die and get: " + userThrow);
      } else {
        userThrow = (rand.nextInt(6) + 1) + (rand.nextInt(6) + 1);
        System.out.println("You throw 2 dice and get: " + userThrow);
      }

      // Determines winner and increments their wins.
      if (userThrow > compThrow) {
        System.out.println("You win the round!");
        playerWins++;
      } else {
        System.out.println("You lose the round!");
        compWins++;
      }

      System.out.println("Score: computer " + compWins + ", player " + playerWins);
      valid = false; // Otherwise infinite loop time baby.
      System.out.println();

      // Checks win condition if either player has 10 wins and exits program
      if (compWins == 10 || playerWins == 10) {
        if (compWins == 10) {
          System.out.println("The computer has won. Goodbye.");
        } else {
          System.out.println("You've won!");
        }
        run = false;
      }
    }

    scan.close();
  }
}

/*
 * import java.util.*;
 * 
 * class DiceChoiceGame
 * {
 * public static void main ( String[] args )
 * {
 * // Declare and Initialize
 * final int endScore=10;
 * Scanner scan = new Scanner( System.in );
 * Random rand = new Random();
 * int playerScore=0, compScore=0;
 * int playerToss, compToss;
 * 
 * // Play Rounds until one player reaches ending score
 * while ( playerScore<endScore && compScore<endScore )
 * {
 * // Computer's Toss
 * compToss = rand.nextInt(6)+1 + rand.nextInt(6)+1 ;
 * System.out.println("The Computer tosses: " + compToss);
 * 
 * // Player's Toss
 * System.out.
 * print("Toss 1 eleven-sided die, or 2 six-sided dice (enter 1 or 2)? ");
 * String numDice = scan.nextLine();
 * 
 * if ( numDice.equals("1") )
 * {
 * playerToss = rand.nextInt(11)+2 ;
 * System.out.println("You throw 1 die and get: " + playerToss );
 * }
 * else
 * {
 * playerToss = rand.nextInt(6)+1 + rand.nextInt(6)+1 ;
 * System.out.println("You throw 2 dice and get: " + playerToss );
 * }
 * 
 * // Determine Winner of Round and Adjust Scores
 * if ( playerToss>compToss )
 * {
 * playerScore = playerScore+1;
 * System.out.println("You win the round!");
 * }
 * else
 * {
 * compScore = compScore+1;
 * System.out.println("You loose the round!");
 * }
 * System.out.println("Score: computer " + compScore + ", you " + playerScore +
 * "\n");
 * }
 * 
 * // Determine Winner of the Game
 * System.out.println("Final Score: computer " + compScore + ", you " +
 * playerScore);
 * 
 * if ( compScore > playerScore )
 * System.out.println("The Computer Wins!");
 * else
 * System.out.println("You Win the Game!");
 * 
 * }
 * }
 */