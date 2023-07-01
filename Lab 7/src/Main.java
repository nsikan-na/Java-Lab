import java.util.Scanner;

public class Main {

  public static void mainPrompt() {
    System.out.println("0. Exit");
    System.out.println("1. Addition");
    System.out.println("2. Subtraction");
    System.out.println("3. Multiplication");
    System.out.println("4. Division");
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    boolean pass = false;

    while (!pass) {
      mainPrompt();

      System.out.println("Please choose an option");
      Integer option = Integer.parseInt(scan.nextLine());
      if (option == 0) {
        pass = true;
      } else {
        System.out.println("Enter the first number");
        Integer num1 = Integer.parseInt(scan.nextLine());
        System.out.println("Enter the second number");
        Integer num2 = Integer.parseInt(scan.nextLine());
        Calculator calculator = new Calculator();
        float answer = 0;
        switch (option) {
          case 1:
            {
              answer = calculator.add(num1, num2);
              break;
            }
          case 2:
            {
              answer = calculator.subtract(num1, num2);
              break;
            }
          case 3:
            {
              answer = calculator.multiply(num1, num2);
              break;
            }
          case 4:
            {
              answer = calculator.divide(num1, num2);
              break;
            }
        }
        System.out.println("\n" + answer + "\n");
      }
    }
  }
}
