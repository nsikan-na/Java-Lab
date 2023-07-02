import java.util.LinkedList;

public class StatisticGradeBook extends GradeBook implements Runnable {

  @Override
  public void run() {
    LinkedList<String> studentNamesLinkedList = getAllStudentNames();
    int processStudents = 0;
    int[] markers = { 100, 200, 300, 400, 500, 600, 700, 800, 900 };
    for (int i = 0; i < studentNamesLinkedList.size(); i++) {
      studentLinkedList.get(i).calcQuizAverage();
      studentLinkedList.get(i).calcHwAverage();
      studentLinkedList.get(i).calcOverallAverage();
      processStudents++;
      for (int marker : markers) {
        if (marker == processStudents) {
          System.out.println("Calculating grades " + marker + " out of 1000");
        }
      }
    }
    System.out.println("All grades calculated");
  }

  StatisticGradeBook(String str) {
    super(str);
  }
}
