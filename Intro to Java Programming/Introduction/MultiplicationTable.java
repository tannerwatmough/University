public class MultiplicationTable {

    public static void main(String[] args) {

        int N;
        int rowNumber;

        for (rowNumber = 1; rowNumber <= 12; rowNumber++) {
            for (N = 1; N <= 12; N++) {
                System.out.printf("%4d", N * rowNumber);
            }
            System.out.println();
        }
    }
}
