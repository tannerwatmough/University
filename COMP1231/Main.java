public class Main {
  public static void main(String[] args) {
    encode();
  }

  public static void encode() {
    String secret = "I got a big booty";
    String encode2 = "";
    String encode3 = "";

    for (int i = 0; i < secret.length(); i++) {
      // System.out.println("Char " + i + " is " + secret.charAt(i));
      // System.out.println(secret.charAt(i) + 0);
      if (secret.charAt(i) == 32) {
        encode2 = encode2 + (char) 225;
      } else {
        encode2 = encode2 + (char) (secret.charAt(i) + 5);
      }
      System.out.println(encode2);
    }

    for (int i = 0; i < encode2.length(); i++) {
      if (encode2.charAt(i) == 225) {
        encode3 = encode3 + (char) 32;
      } else {
        encode3 = encode3 + (char) (encode2.charAt(i) - 5);
      }
      System.out.println(encode3);
    }
  }
}
