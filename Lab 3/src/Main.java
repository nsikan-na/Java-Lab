import java.util.Scanner;

public class Main {

  public static void promptMenu() {
    System.out.println("\nWhat would you like to do?");
    System.out.println("1. Add a question from the quiz.");
    System.out.println("2. Remove a question from the quiz.");
    System.out.println("3. Modify a question in the quiz.");
    System.out.println("4. Take the quiz.");
    System.out.println("5. Quit");
  }

  public static void main(String[] args) {
    try (Scanner scan = new Scanner(System.in)) {
      Quiz quiz = new Quiz();
      int num = 0;
      while (num != 5) {
        promptMenu();
        num = Integer.parseInt(scan.nextLine());
        if (num < 1 || num > 5) {
          System.out.println("\nPlease enter a valid number");
        } else {
          switch (num) {
            case 1:
              {
                quiz.addQuestion();
                break;
              }
            case 2:
              {
                quiz.removeQuestion();
                break;
              }
            case 3:
              {
                quiz.modifyQuestion();
                break;
              }
            case 4:
              {
                quiz.giveQuiz();
                break;
              }
          }
        }
      }
    }
  }
}
