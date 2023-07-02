import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    try {
      StatisticGradeBook statisticGradeBook = new StatisticGradeBook(
        "Assignment7-Spreadsheet.csv"
      );
      Scanner scan = new Scanner(System.in);
      Thread myThread = new Thread();
      myThread.start();
      System.out.println("Please enter a students name");
      String name = scan.nextLine();
      statisticGradeBook.getStudentGrade(name);
      scan.close();
    } catch (Exception err) {
      System.out.println(err);
    }
  }
}
