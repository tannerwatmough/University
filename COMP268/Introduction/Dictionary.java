// Dictionary2 represents a dictionary, which is a book. 
// Demonstrates use of the super refernece.
public class Dictionary extends Book {
  private int definitions;

  // Constructor: Sets up dictionary with specified number of pages and
  // definitions.
  public Dictionary(int numPages, int numDefinitions) {
    super(numPages);
    definitions = numDefinitions;
  }

  // Computes a value using both local and inherited values
  public double computeRatio() {
    return definitions / (double) pages;
  }

  // Definitions mutator
  public void setDefinitions(int numDefinitions) {
    definitions = numDefinitions;
  }

  // Definitions accessor
  public int getDefinitions() {
    return definitions;
  }
}