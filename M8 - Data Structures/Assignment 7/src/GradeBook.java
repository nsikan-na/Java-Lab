import java.io.File;
import java.util.LinkedList;
import java.util.Scanner;

public class GradeBook {

  public LinkedList<Student> studentLinkedList = new LinkedList<>();

  GradeBook(String fileName) {
    try {
      File file = new File(fileName);
      Scanner scan = new Scanner(file);
      String fileData = "";

      while (scan.hasNextLine()) {
        fileData = scan.nextLine();
        studentLinkedList.add(new Student(fileData));
      }
      scan.close();
    } catch (Exception err) {
      System.out.println(err);
    }
  }

  public Student getStudent(String name) {
    int index = -1;
    for (int i = 0; i < studentLinkedList.size(); i++) {
      if (studentLinkedList.get(i).getName().equals(name)) {
        index = i;
        break;
      }
    }
    return studentLinkedList.get(index);
  }

  public void getStudentGrade(String name) {
    int index = -1;
    for (int i = 0; i < studentLinkedList.size(); i++) {
      if (studentLinkedList.get(i).getName().equals(name)) {
        index = i;
        break;
      }
    }
    System.out.println(studentLinkedList.get(index).getGrade());
  }

  public LinkedList<String> getAllStudentNames() {
    LinkedList<String> namesLinkedList = new LinkedList<>();
    for (int i = 0; i < studentLinkedList.size(); i++) {
      namesLinkedList.add(studentLinkedList.get(i).getName());
    }
    return namesLinkedList;
  }
}
