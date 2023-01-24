//********************************************************************
//  MonetaryCoinDriver.java       Java Foundations
//
//  Solution to Programming Project 8.1 
//********************************************************************

public class MonetaryCoinDriver
{
   //-----------------------------------------------------------------
   //  Demonstrates the use of a MonetaryCoin derived from Coin.
   //-----------------------------------------------------------------
   public static void main (String[] args)
   {
      MonetaryCoin[] coins = new MonetaryCoin[7];

      coins[0] = new MonetaryCoin(1);
      coins[1] = new MonetaryCoin(5);
      coins[2] = new MonetaryCoin(10);
      coins[3] = new MonetaryCoin(25);
      coins[4] = new MonetaryCoin(50);
      coins[5] = new MonetaryCoin(100);
      coins[6] = new MonetaryCoin(100);

      // flip all of the coins
      for (MonetaryCoin coin : coins)
         coin.flip();

      // compute total value
      int sum = 0;
      for (MonetaryCoin coin : coins)
         sum += coin.getValue();

      // print the coins
      for (MonetaryCoin coin : coins)
         System.out.println (coin);

      System.out.println ("\nTotal Value: " + sum);
   }
}
