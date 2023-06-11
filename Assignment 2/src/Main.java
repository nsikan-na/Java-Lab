import java.util.ArrayList;
import java.util.Scanner;

public class Main {

  static Scanner scan = new Scanner(System.in);

  private static void mainPrompt() {
    System.out.println("1. Add Lot to Auction");
    System.out.println("2. Start bidding on next Lot");
    System.out.println("3. Bid on current Lot");
    System.out.println("4. Mark current Lot Sold");
    System.out.println("5. Exit\n");
  }

  private static Lot getNextLot(ArrayList<Lot> arr) {
    if (arr.size() >= 1) {
      Lot temp = arr.get(0);
      arr.remove(0);
      return temp;
    } else return new Lot();
  }

  private static void addItem(ArrayList<Lot> arr) {
    System.out.println("What is the description of this item?");
    String description = scan.nextLine();
    System.out.println("What is the starting bid of this item?");
    int startingBid = Integer.parseInt(scan.nextLine());
    System.out.println("What is the bid increment of this item?");
    int bidIncrement = Integer.parseInt(scan.nextLine());

    arr.add(new Lot(description, startingBid, bidIncrement));
  }

  private static void bid(Lot lot) {
    int bid = 0;
    System.out.println("How much would you like to bid?");
    System.out.println("Minimum bid is " + lot.nextBid());
    bid = Integer.parseInt(scan.nextLine());
    while (bid < lot.nextBid()) {
      System.out.println("This bid is too low! Please enter a valid bid");
      System.out.println("Minimum bid is " + lot.nextBid());
      bid = Integer.parseInt(scan.nextLine());
    }
    lot.setCurrentBid(bid);
  }

  private static void mainMenu(ArrayList<Lot> lotsArr) {
    Lot currentLot = null;
    int num = 0;
    // System.out.println("\nWe are not currently bidding\n");
    // mainPrompt();
    // num = Integer.parseInt(scan.nextLine());
    while (num != 5) {
      if (num < 1 || num > 5) {
        System.out.println("Please enter a valid number");
      } else {
        if (
          currentLot == null ||
          currentLot.getDescription().equals("Unknown Item")
        ) {
          System.out.println("\nWe are not currently bidding\n");
        } else {
          System.out.println(currentLot);
        }
        mainPrompt();
        num = Integer.parseInt(scan.nextLine());

        if (num == 1) {
          addItem(lotsArr);
        }
        if (num == 2) {
          if (lotsArr.size() == 0) {
            System.out.println("There is nothing to bid on, add an item first");
          } else {
            if (currentLot != null && currentLot.getSold() != true) {
              System.out.println(
                "You must mark the current lot as sold before bringing up the next Lot"
              );
            } else {
              currentLot = getNextLot(lotsArr);
            }
          }
        }
        if (num == 3) {
          if (
            currentLot == null ||
            currentLot.getDescription().equals("Unknown Item") ||
            currentLot.getSold() == true
          ) {
            System.out.println("You must first bring a Lot up for bidding");
          } else {
            bid(currentLot);
          }
        }
        if (num == 4) {
          if (
            currentLot == null ||
            currentLot.getDescription().equals("Unknown Item") ||
            currentLot.getSold() == true
          ) {
            System.out.println("You must first bring a Lot up for Bidding");
          } else {
            currentLot.markSold();
          }
        }
      }
    }
  }

  public static void main(String[] args) {
    ArrayList<Lot> auction = new ArrayList<>();
    mainMenu(auction);
  }
}
