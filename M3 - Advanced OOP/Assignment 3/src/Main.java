import java.util.ArrayList;
import java.util.Scanner;

public class Main {

  public static void menu(ArrayList<Customer> customers) {
    Scanner scan = new Scanner(System.in);
    int num = 0;
    while (num != 6) {
      System.out.println("\n1. Take test for new license");
      System.out.println("2. Renew existing license");
      System.out.println("3. Move from out of state");
      System.out.println("4. Answer citation/suspended license");
      System.out.println("5. See current queue");
      System.out.println("6. Quit\n");
      num = Integer.parseInt(scan.nextLine());
      switch (num) {
        case 1:
          {
            System.out.println("What is your name?");
            String name = scan.nextLine();
            System.out.println("What is your date of birth?");
            String dateOfBirth = scan.nextLine();
            customers.add(new NewTest(name, dateOfBirth));
            break;
          }
        case 2:
          {
            System.out.println("What is your name?");
            String name = scan.nextLine();
            customers.add(new Renew(name));
            break;
          }
        case 3:
          {
            System.out.println("What is your name?");
            String name = scan.nextLine();
            System.out.println("What state did you move from?");
            String state = scan.nextLine();
            customers.add(new Move(name, state));
            break;
          }
        case 4:
          {
            System.out.println("What is your name?");
            String name = scan.nextLine();
            System.out.println("What violation did you commit?");
            String violation = scan.nextLine();
            customers.add(new Suspended(name, violation));
            break;
          }
        case 5:
          {
            for (Customer customer : customers) {
              System.out.println(customer.getCustomerInfo());
            }
            break;
          }
      }
    }
  }

  public static void main(String[] args) {
    ArrayList<Customer> customers = new ArrayList<Customer>();

    menu(customers);
  }
}
