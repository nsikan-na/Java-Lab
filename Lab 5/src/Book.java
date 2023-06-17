public class Book extends Item {

  private int isbnNumber;
  private String author;

  Book() {
    author = "";
    isbnNumber = 0;
    setTitle("");
  }

  Book(int isbnNumber, String author, String title) {
    this.isbnNumber = isbnNumber;
    this.author = author;
    setTitle(title);
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public int getIsbnNumber() {
    return isbnNumber;
  }

  public void setIsbnNumber(int isbnNumber) {
    this.isbnNumber = isbnNumber;
  }

  @Override
  public String getListing() {
    return (
      "Book Name - " +
      getTitle() +
      "\nAuthor - " +
      author +
      "\nISBN # - " +
      isbnNumber
    );
  }
}
