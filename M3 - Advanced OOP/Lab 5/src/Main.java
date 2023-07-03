import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int num = 0;
    Item[] items = new Item[5];
    String itemType;

    while (num < 5) {
        System.out.println("Please enter B for Book or P for Periodical");
        itemType = scanner.nextLine();

      switch (itemType) {
        case "B":
          {
            System.out.println("Please enter the name of the Book");
            String name = scanner.nextLine();
            System.out.println("Please enter the author of the Book");
            String author = scanner.nextLine();
            System.out.println("Please enter the ISBN of the Book");
            int isbn = Integer.parseInt(scanner.nextLine());
            Book book = new Book(isbn, author, name);
            items[num] = book;
            break;
          }
        case "P":
          {
            System.out.println("Please enter the name of the Periodical");
            String name = scanner.nextLine();
            System.out.println("Please enter the issue number");
            int isbn = Integer.parseInt(scanner.nextLine());
            Periodical periodical = new Periodical(isbn, name);
            items[num] = periodical;
            break;
          }
      }
      num++;
    }
    System.out.println("\nYour Items\n");
    for (int i = 0; i < items.length; i++) {
      System.out.println(items[i].getListing() + '\n');
    }
  }
}
