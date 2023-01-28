import java.util.Random;

class DiceTest {
  public static void main(String[] args) {
    int sum = 0;
    // numberInstances hold the number of times values 2-12 have been rolled.
    int[] numberInstances = new int[11], rolls = new int[100000];

    Random rand = new Random();

    // Adds a random integer between 2 and 12 to rolls[]
    // 2 is lowest because two die can only get 2 so the one die is normalized
    for (int i = 0; i < 100000; i++) {
      rolls[i] = rand.nextInt(11) + 2;
      switch (rolls[i]) {
        // stores rolls 2-12 into numberInstances array to count occurrences.
        case 2:
          numberInstances[0]++;
          break;
        case 3:
          numberInstances[1]++;
          break;
        case 4:
          numberInstances[2]++;
          break;
        case 5:
          numberInstances[3]++;
          break;
        case 6:
          numberInstances[4]++;
          break;
        case 7:
          numberInstances[5]++;
          break;
        case 8:
          numberInstances[6]++;
          break;
        case 9:
          numberInstances[7]++;
          break;
        case 10:
          numberInstances[8]++;
          break;
        case 11:
          numberInstances[9]++;
          break;
        case 12:
          numberInstances[10]++;
          break;
      }
    }

    // Prints out number of occurrences for each di(c)e throw.
    for (int i = 0; i < 11; i++) {
      System.out.println("# of times " + (i + 2) + " was rolled: " + numberInstances[i]);
      // Confirms 10,000 rolls were stored and resets the numberInstances array.
      sum += numberInstances[i];
      numberInstances[i] = 0;
    }

    System.out.println();
    System.out.println(sum);
    System.out.println();

    // Two die thrown, stores sum in rolls array.
    for (int i = 0; i < 100000; i++) {
      rolls[i] = (rand.nextInt(6) + 1) + (rand.nextInt(6) + 1);
      switch (rolls[i]) {
        case 2:
          numberInstances[0]++;
          break;
        case 3:
          numberInstances[1]++;
          break;
        case 4:
          numberInstances[2]++;
          break;
        case 5:
          numberInstances[3]++;
          break;
        case 6:
          numberInstances[4]++;
          break;
        case 7:
          numberInstances[5]++;
          break;
        case 8:
          numberInstances[6]++;
          break;
        case 9:
          numberInstances[7]++;
          break;
        case 10:
          numberInstances[8]++;
          break;
        case 11:
          numberInstances[9]++;
          break;
        case 12:
          numberInstances[10]++;
          break;
      }

    }

    // Reset sum to not add second run to first.
    sum = 0;

    for (int i = 0; i < 11; i++) {
      System.out.println("# of times " + (i + 2) + " was rolled: " + numberInstances[i]);
      sum += numberInstances[i];
    }

    System.out.println();
    System.out.println(sum);
  }
}