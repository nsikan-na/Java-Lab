import java.util.Scanner;

// Lab 8A
public class Main {

  public static int recursive_multiply(int num1, int num2) {
    if (num1 == 0 || num2 == 0) return 0;

    return recursive_multiply(num1, num2 - 1) + num1;
  }

  public static int recursive_division(int num1, int num2) {
    if (num2 == 0) return -1;
    if (num1 == num2) return 1;
    if (num2 > num1) return 0;
    int count = 0;
    while (num1 >= num2) {
      num1 -= num2;
      count++;
    }
    return count;
  }

  public static int recursive_mod(int num1, int num2) {
    if (num2 == 0) return -1;
    if (num1 < num2) return num1;
    return recursive_mod(num1 - num2, num2);
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int option = -1;
    while (option != 0) {
      System.out.println("Choose from the following:");
      System.out.println("0. Quit");
      System.out.println("1. Multiply 2 numbers");
      System.out.println("2. Div 2 numbers");
      System.out.println("3. Mod 2 numbers");
      option = Integer.parseInt(scan.nextLine());
      if (option == 0) break;
      System.out.println("Enter first number");
      int num1 = Integer.parseInt(scan.nextLine());
      System.out.println("Enter second number");
      int num2 = Integer.parseInt(scan.nextLine());
      switch (option) {
        case 1:
          {
            System.out.println("Answer: " + recursive_multiply(num1, num2));
            break;
          }
        case 2:
          {
            System.out.println("Answer: " + recursive_division(num1, num2));
            break;
          }
        case 3:
          {
            System.out.println("Answer: " + recursive_mod(num1, num2));
            break;
          }
      }
    }
  }
}
