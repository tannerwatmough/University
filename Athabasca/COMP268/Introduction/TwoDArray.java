public class TwoDArray {

    public static void main(String[] args) {
        int[][] A;
        A = new int[5][7];

        int row, col;

        for (row = 0; row < 5; row++) {
            for (col = 0; col < 7; col++) {
                System.out.printf("%7d", A[row][col]);
            }

            System.out.println();
        }
    }
}
