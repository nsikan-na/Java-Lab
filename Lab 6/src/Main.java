import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    FibFormula fibFormula = new FibFormula();
    FibIteration fibIteration = new FibIteration();
    System.out.println("Enter a number");
    Integer num = Integer.parseInt(scan.nextLine());
    System.out.println(fibFormula.calculateFib(num));
    System.out.println(fibIteration.calculateFib(num));
  }
}
