import java.util.Scanner;

public class Microwave {
  public static void main(String[] args) {
    String userInput = "", secondsString;
    int seconds, minutes, time;

    Scanner scan = new Scanner(System.in);

    while (userInput.length() < 1) {
      System.out.print("Please enter cook time: ");
      userInput = scan.nextLine();
    }

    time = Integer.parseInt(userInput);
    // Takes both seconds places if time is two digits, only first place if
    // one digit. So a entered value of '3' won't cause an error.
    if (time > 9) {
      secondsString = userInput.substring(userInput.length() - 2);
    } else {
      secondsString = userInput.substring(userInput.length() - 1);
    }
    // Strings to int instead of scan.nextInt() so I can get the seconds place
    // for testing purposes.
    seconds = Integer.parseInt(secondsString);

    // Tests for input under 100, as 100 is treated as 1 minute, not 100 seconds
    if (time < 100) {
      // Assignment asks to do 0:99
      if (seconds < 10) {
        // Need to add an extra 0 to times under 10 seconds
        System.out.println("Your time: " + "0:0" + time);
      } else {
        System.out.println("Your time: " + "0:" + time);
      }

      // This converts seconds over 60 to minute:seconds instead
      seconds %= 60;
      minutes = seconds / 60;

      if (seconds < 10) {
        // Add extra 0 to seconds under 10.
        System.out.println("Your time is: " + minutes + ":0" + seconds);
      } else {
        System.out.println("Your time: " + minutes + ":" + seconds);
      }
    } else { // For values over 100
      // Since the seconds > 60 can be considered as additional seconds without
      // changing the minutes value, we can divide by 100, which is how time
      // is supposed to work for microwaves. i.e. 1500 being 15 minutes, not
      // 1500 seconds / 60 seconds. 1575 is just 15 minutes and 75 seconds.
      minutes = time / 100;
      if (seconds < 10) {
        System.out.println("Your time is: " + minutes + ":0" + seconds);
      } else {
        System.out.println("Your time is: " + minutes + ":" + seconds);
      }
      // This option, if the seconds are greater than 60, will convert seconds
      // over 60 into additional minutes so the seconds place is always less
      // than 60.
      if (seconds > 60) {
        minutes += seconds / 60;
        seconds %= 60;
        if (seconds < 10) {
          System.out.println("Your time is: " + minutes + ":0" + seconds);
        } else {
          System.out.println("Your time is: " + minutes + ":" + seconds);
        }
      }
    }

    scan.close();
  }
}