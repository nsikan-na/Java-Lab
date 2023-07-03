import java.util.ArrayList;
import java.util.Scanner;

public class Quiz {

  private Scanner scan = new Scanner(System.in);
  private ArrayList<Question> arrayOfQuestions = new ArrayList<Question>();

  Quiz() {}

  private int getQuestionInt() {
    for (int i = 0; i < arrayOfQuestions.size(); i++) {
      System.out.println(i + ". " + arrayOfQuestions.get(i).getText());
    }
    int num = Integer.parseInt(scan.nextLine());
    return num;
  }

  public void addQuestion() {
    System.out.println("\nWhat is the question Text?");
    String text = scan.nextLine();
    System.out.println("What is the answer?");
    String answer = scan.nextLine();
    System.out.println("How Difficult (1-3)?");
    int difficulty = Integer.parseInt(scan.nextLine());
    arrayOfQuestions.add(new Question(text, answer, difficulty));
  }

  public void removeQuestion() {
    System.out.println("\nChoose the question to remove?");
    int questionInt = getQuestionInt();
    arrayOfQuestions.remove(questionInt);
  }

  public void modifyQuestion() {
    System.out.println("\nChoose the question to modify?");
    int questionInt = getQuestionInt();
    System.out.println("What is the question Text?");
    String text = scan.nextLine();
    System.out.println("What is the answer?");
    String answer = scan.nextLine();
    System.out.println("How Difficult (1-3)?");
    int difficulty = Integer.parseInt(scan.nextLine());
    arrayOfQuestions.set(questionInt, new Question(text, answer, difficulty));
  }

  public void giveQuiz() {
    System.out.println("\nQuiz");
    int correctAnswers = 0;
    for (int i = 0; i < arrayOfQuestions.size(); i++) {
      System.out.println(i + 1 + ". " + arrayOfQuestions.get(i).getText());
      String answer = scan.nextLine();
      if (answer.equals(arrayOfQuestions.get(i).getAnswer())) {
        System.out.println("Correct");
        correctAnswers++;
      } else System.out.println("Incorrect");
    }
    System.out.println(
      "You got " + correctAnswers + " out of " + arrayOfQuestions.size()
    );
  }
}
