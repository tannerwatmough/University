// Book2 represents a book. Used as the parent of a derived class to 
// demonstrate inheritance and the use of the super reference. 
public class Book {
  protected int pages;

  // Constructor: Sets up book with specified number of pages
  public Book(int numPages) {
    pages = numPages;
  }

  // Pages mutator
  public void setPages(int numPages) {
    pages = numPages;
  }

  // Pages accessor
  public int getPages() {
    return pages;
  }
}