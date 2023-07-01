import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    BlueRayCollection blueRayCollection = new BlueRayCollection();
    int num = -1;
    while (num != 0) {
      System.out.println("0. Quit");
      System.out.println("1. Add BlueRay to collection");
      System.out.println("2. See collection");
      num = Integer.parseInt(scan.nextLine());
      switch (num) {
        case 0:
          {
            break;
          }
        case 1:
          {
            System.out.println("What is the title?");
            String title = scan.nextLine();
            System.out.println("What is the director?");
            String director = scan.nextLine();
            System.out.println("What is the year of release?");
            int yearOfRelease = Integer.parseInt(scan.nextLine());
            System.out.println("What is the cost?");
            double cost = Double.parseDouble(scan.nextLine());
            blueRayCollection.add(title, director, yearOfRelease, cost);
            break;
          }
        case 2:
          {
            blueRayCollection.show_all();
            break;
          }
      }
    }
  }
}
