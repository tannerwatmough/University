public class MathRandom {

    public static void main(String[] args) {
        int randomNumber;
        int i;

        for (i = 0; i < 1; i++) {
            randomNumber = (int) (3 * Math.random());
            // Math.random() rounds all animals down, so even 2.99 will get rounded down to
            // 2.
            System.out.println(randomNumber + " ");
        }

        String computerMove;
        switch ((int) (3 * Math.random())) {
            case 0:
                computerMove = "Rock";
                break;
            case 1:
                computerMove = "Paper";
                break;
            default:
                computerMove = "Scissors";
                break;
        }
        System.out.println("The computer's move is " + computerMove);
        // (int)(3*Math.random()) can only be 0, 1, or 2 because of how Math.random()
        // rounds down.
    }
}
