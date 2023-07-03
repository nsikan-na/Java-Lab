import java.util.Scanner;

public class Main {

  public static void promptMenu() {
    System.out.println("\n1. Sold One Milk");
    System.out.println("2. Sold One Bread");
    System.out.println("3. Change price of Milk");
    System.out.println("4. Change price of Bread");
    System.out.println("5. Add Milk to Inventory");
    System.out.println("6. Add Bread to Inventory");
    System.out.println("7. See Inventory");
    System.out.println("8. Quit\n");
  }

  public static void main(String[] args) {
    try (Scanner scan = new Scanner(System.in)) {
      int num;
      boolean pass = false;
      StockItem milk = new StockItem("1 Gallon of Milk", 3.60, 15);
      StockItem bread = new StockItem("1 Loaf of Bread", 1.98, 30);

      while (!pass) {
        promptMenu();
        num = scan.nextInt();
        if (num == 8) {
          pass = true;
          System.out.println("Exited System");
        } else {
          if (num >= 1 && num <= 8) {
            switch (num) {
              case 1:
                {
                  milk.lowerQuantity(1);
                  System.out.println("Quantity of Milk: " + milk.getQuantity());
                  break;
                }
              case 2:
                {
                  bread.lowerQuantity(1);
                  System.out.println(
                    "Quantity of Bread: " + bread.getQuantity()
                  );
                  break;
                }
              case 3:
                {
                  System.out.println("What is the new price for Milk?");
                  double newPrice = scan.nextDouble();
                  milk.setPrice(newPrice);
                  System.out.println("Price for Milk: " + milk.getPrice());
                  break;
                }
              case 4:
                {
                  System.out.println("What is the new price for Bread?");
                  double newPrice = scan.nextDouble();
                  bread.setPrice(newPrice);
                  System.out.println("Price of Bread: " + bread.getPrice());
                  break;
                }
              case 5:
                {
                  System.out.println("How much milk did we get?");
                  int raiseByQuantity = scan.nextInt();
                  milk.raiseQuantity(raiseByQuantity);
                  System.out.println("Quantity of Milk: " + milk.getQuantity());
                  break;
                }
              case 6:
                {
                  System.out.println("How much bread did we get?");
                  int raiseByQuantity = scan.nextInt();
                  bread.raiseQuantity(raiseByQuantity);
                  System.out.println(
                    "Quantity of Bread: " + bread.getQuantity()
                  );
                  break;
                }
              case 7:
                {
                  System.out.println("\nMilk\n" + milk);
                  System.out.println("\nBread\n" + bread);
                  break;
                }
            }
          } else System.out.println("\nPlease enter a valid number");
        }
      }
    }
  }
}
