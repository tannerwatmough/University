// //********************************************************************
// // FourDArray.java Java Foundations
// //
// // Demonstrates the use of a two-dimensional array.
// //********************************************************************
// public class FourDArray {
// // -----------------------------------------------------------------
// // Creates a 4D array of integers, fills it with increasing
// // integer values, then prints them out.
// // -----------------------------------------------------------------
// public static void main(String[] args) {
// int[][][][] table = { { { { 0 }, { 1 }, { 2 } }, { { 0 }, { 1 }, { 2 } } },
// { { { 0 }, { 1 }, { 2 } } },
// { { { 0 }, { 1 }, { 2 } }, { { 0 }, { 1 }, { 2 } }, { { 0 }, { 1 }, { 2 } } }
// };
// // Load the table with values
// for (int state = 0; state < table.length; state++)
// for (int university = 0; university < table[state].length; university++)
// for (int college = 0; college < table[state[university]].length; college++)
// // table[row][col] just specifies the index you store the value
// table[row][col] = row * 10 + col;

// // Print the table
// for (int row = 0; row < table.length; row++) {
// for (int col = 0; col < table[row].length; col++)
// System.out.print(table[row][col] + "\t");
// System.out.println();
// }
// }
// }