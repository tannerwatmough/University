/*
 * Name: Tanner Watmough
 * Student ID: 3554951
 * Date: August 17, 2022
 * 
 * Program Name: Book.java
 * Program Purpose: Creates book objects and allows you to retrieve and set attributes. 
 * Version 1.0
 */

/*
 * DOCUMENTATION
 */

/*
 * The main program creates Books and updates and retrieves book information on instance variables. 
 * 
 * <H2> Book </H2>
 * 
 * <H3> Purpose and Description </H3>
 * <P>
 * This program will construct books with or without parameters with one of the constructors, set the 
 * instance variables of title, isbnNumber, author, publisher, edition, and publicationYear. 
 * </P>
 * 
 * <P>Program was written using Java 8.</P>
 * <P>Change to the directory containing the source code</P>
 * <P>Compile:    javac Book.java</P>
 * <P>Run:        java Book</P>
 */

/*
 * <H2>Classes</H2>
 * <P>
 * public class Book is the main public class for the application. It is the only class.
 * </P>
 *
 * <H2>Book Methods</H2>
 *<P>
 * public static void main(String[] args) {<BR>
 * This method is used to execute the applicaiton.
 * This method exceutes Problem 2's Book class. It creates books with one of the constructors, book the default
 * constructor and one with all of the instance variables within a book object as parameters. It also calls the 
 * bookInfo() method and the updateInfo() method which sets or gets the target object's instance variables. 
 *</P>
 *<P>
 *  private Book() {<BR>
 * This is the default constructor for Book() which will initalize all instance variables to default values.
 *</P>
  *<P>
 * private Book(String titleArg, String isbnNumberArg, String authorArg, String publisherArg, int editionArg,
      int publicationYearArg) {<BR>
 * This is a constructor for Book() which will initalize all instance variables to the arguments given. 
 *</P>
  *<P>
 *  public String getTitle() {<BR>
 * This method will get the title instance variable from the target object and return it.
 *</P>
  *<P>
 * public void setTitle(String newTitle) {<BR>
 * This is a setter method for the title instance variable. It requires a paramter to replace the old value
 * with the paramater value. 
 *</P>
  *<P>
 *  public String getIsbnNumber() {<BR>
 * This method will get the ISBN Number instance variable from the target object and return it.
 *</P>
  *<P>
 * public void setIsbnNumber(String newIsbn) {<BR>
 * This is a setter method for the ISBN Number instance variable. It requires a paramter to replace the old value
 * with the paramater value. 
 *</P>
  *<P>
 *  public String getAuthor() {<BR>
 * This method will get the author instance variable from the target object and return it.
 *</P>
  *<P>
 * public void setAuthor(String newAuthor) {<BR>
 * This is a setter method for the author instance variable. It requires a paramter to replace the old value
 * with the paramater value. 
 *</P>
  *<P>
 *  public String getPublisher() {<BR>
 * This method will get the publisher instance variable from the target object and return it.
 *</P>
  *<P>
 * public void setPublisher(String newPublisher) {<BR>
 * This is a setter method for the publisher instance variable. It requires a paramter to replace the old value
 * with the paramater value. 
 *</P>
  *<P>
 *  public String getEdition() {<BR>
 * This method will get the edition instance variable from the target object and return it.
 *</P>
  *<P>
 * public void setEdition(int newEdition) {<BR>
 * This is a setter method for the edition instance variable. It requires a paramter to replace the old value
 * with the paramater value. 
 *</P>
  *<P>
 *  public String getPublisher() {<BR>
 * This method will get the publicationYear instance variable from the target object and return it.
 *</P>
  *<P>
 * public void setPublicationYear(int newPublicationYear) {<BR>
 * This is a setter method for the publicaionYear instance variable. It requires a paramter to replace the old value
 * with the paramater value. 
 *</P>
  *<P>
 * public void bookInfo() {<BR>
 * This method will use the getter methods to get all instance variables and display them to the standard output of the book objects.
 *</P>
  *<P>
 * public void updateInfo(String newTitle, String newIsbn, String newAuthor, String newPublisher, int newEdition,
      int newPublicationYear) {<BR>
 * This method will set all instance variables for the target object using the setter methods.
 *</P>
 */

/*
 * 
 * <H2>Test Plan</H2>
 * 
 * <H3>Problem 2</H3>
 * <P>
 * 1. Run the application.
 * EXPECTED:
 *  three book objects are created with two constructors with differeing instance variables. The various getter
 *  methods are used in a single method class bookInfo() which displays all the book attribtues for the three books. 
 *  The updateInfo() method is then used on book1 to set the instance variables to another book. 
 * </P>
 * <P>
 * 2. Good data cases:
 * EXPECTED:
 *  book1 = new Book(); creates a new book object that has empty strings for the first four instance variables,
 *  1 for edition, and 9999 for publicationYear. 
 *  book2 = new Book("Fellowship of the Ring", "978-0007136599", "J. R. R. Tolkien", "George Allen & Unwin", 1,
        1954); creates a new book object that contains the instance variables of The Fellowship of the Ring 
        by J. R. R. Tolkien.
 * ACTUAL:
 *  book1 is created and can have getter and setter methods used on it. 
 *  book2 is created with the parameters as the corresponding instance variables using the correct constructor. 
 * </P>
 * <P>
 * 3. Bad data cases:
 * EXPECTED:
 *   Creating a book() with only some parameters will crash the program with actual and formal argument list
 *   differing in length. 
 * ACTUAL:
 *   The new book is created by attempting to call the incomplete book with book.bookInfo(); will crash the program
 *   with a actual and formal argument list differing in length constructor error. 
 * </P>
 */

// CODE

public class Book {

  private String title, isbnNumber, author, publisher;
  private int edition, publicationYear;

  private Book() {
    title = "";
    isbnNumber = "";
    author = "";
    publisher = "";
    edition = 1;
    publicationYear = 9999;
  } // end of default constructor

  private Book(String titleArg, String isbnNumberArg, String authorArg, String publisherArg, int editionArg,
      int publicationYearArg) {
    title = titleArg;
    isbnNumber = isbnNumberArg;
    author = authorArg;
    publisher = publisherArg;
    edition = editionArg;
    publicationYear = publicationYearArg;
  } // end of parameterized constuctor with all required instance variables.

  public String getTitle() {
    return title;
  } // getter method for title

  public void setTitle(String newTitle) {
    title = newTitle;
  } // setter method for title

  public String getIsbnNumber() {
    return isbnNumber;
  } // getter method for ISBN number

  public void setIsbnNumber(String newIsbn) {
    isbnNumber = newIsbn;
  } // setter method for ISBN number

  public String getAuthor() {
    return author;
  } // getter method for author

  public void setAuthor(String newAuthor) {
    author = newAuthor;
  } // setter method for author

  public String getPublisher() {
    return publisher;
  } // getter method for publisher

  public void setPublisher(String newPublisher) {
    publisher = newPublisher;
  } // setter method for publisher

  public int getEdition() {
    return edition;
  } // getter method for edition

  public void setEdition(int newEdition) {
    edition = newEdition;
  } // setter method for edition

  public int getPublicationYear() {
    return publicationYear;
  } // getter method for publication year.

  public void setPublicationYear(int newPublicationYear) {
    publicationYear = newPublicationYear;
  } // setter method for publication year.

  public void bookInfo() {
    title = getTitle();
    isbnNumber = getIsbnNumber();
    author = getAuthor();
    publisher = getPublisher();
    edition = getEdition();
    publicationYear = getPublicationYear();
    System.out.println("Title: " + title);
    System.out.println("ISBN #: " + isbnNumber);
    System.out.println("Author: " + author);
    System.out.println("Publisher: " + publisher);
    System.out.println("Edition: " + edition);
    System.out.println("Publication Year: " + publicationYear);
    System.out.println();
  } // bookInfo gets all of the info and outputs it to the terminal on a book
    // object.

  public void updateInfo(String newTitle, String newIsbn, String newAuthor, String newPublisher, int newEdition,
      int newPublicationYear) {
    setTitle(newTitle);
    setIsbnNumber(newIsbn);
    setAuthor(newAuthor);
    setPublisher(newPublisher);
    setEdition(newEdition);
    setPublicationYear(newPublicationYear);
  } // updateInfo will set all instance variables of an object with one method.
    // Requires all of the parameters to work.

  public static void main(String[] args) {

    Book book1 = new Book();
    Book book2 = new Book("Fellowship of the Ring", "978-0007136599", "J. R. R. Tolkien", "George Allen & Unwin", 1,
        1954);
    Book book3 = new Book("Portrait of an Unknown Woman", "978-00628355338", "Daniel Silva", "Harper", 1, 2022);

    book1.bookInfo();
    book2.bookInfo();
    book3.bookInfo();

    book1.updateInfo("The Viral Underclass", "978-1250796639", "Steven W. Thrasher", "Celadon Books", 1, 2022);

    book1.bookInfo();

  } // end of main

} // end of public class Book