import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    try {
      StatisticGradeBook statisticGradeBook = new StatisticGradeBook(
              "Assignment7-Spreadsheet.csv"
      );
      Scanner scan = new Scanner(System.in);
      Thread myThread = new Thread(statisticGradeBook);
      myThread.start();
      System.out.println("What student would you like to see grades for");
      String name = scan.nextLine();
      statisticGradeBook.getStudentGrade(name);
      scan.close();
    } catch (Exception err) {
      System.out.println(err);
    }
  }
}
