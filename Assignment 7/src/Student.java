public class Student {

  private int[] quizArr = new int[10];
  private int[] homeworkArr = new int[10];
  private int midtermGrade;
  private int finalExamGrade;
  private double quizAverage;
  private double homeworkAverage;
  private double overallAverage;
  private String name;
  private int id;

  Student(String str) {
    String[] data = str.split(",");
    this.name = data[0];
    this.id = Integer.parseInt(data[1]);
    for (int i = 0; i < 10; i++) {
      this.quizArr[i] = Integer.parseInt(data[i + 2]);
    }
    for (int i = 0; i < 10; i++) {
      this.homeworkArr[i] = Integer.parseInt(data[i + 12]);
    }
    this.midtermGrade = Integer.parseInt(data[22]);
    this.finalExamGrade = Integer.parseInt(data[23]);
  }

  public String getName() {
    return name;
  }

  public int getId() {
    return id;
  }

  public void calcQuizAverage() {
    int lowest = quizArr[0];
    for (int i = 0; i < quizArr.length; i++) {
      if (quizArr[i] < lowest) {
        lowest = quizArr[i];
      }
    }
    int[] newQuizArr = new int[quizArr.length - 1];
    int total = 0;
    for (int quiz : newQuizArr) {
      total += quiz;
    }

    quizAverage = total / quizArr.length;
  }

  public void calcHwAverage() {
    int lowest = homeworkArr[0];
    for (int i = 0; i < homeworkArr.length; i++) {
      if (homeworkArr[i] < lowest) {
        lowest = homeworkArr[i];
      }
    }
    int[] newHomeworkArr = new int[homeworkArr.length - 1];
    int total = 0;
    for (int hw : newHomeworkArr) {
      total += hw;
    }

    homeworkAverage = total / homeworkArr.length;
  }

  public void calcOverallAverage() {
    overallAverage =
      (quizAverage * .4) +
      (homeworkAverage * .1) +
      (midtermGrade * .2) +
      (finalExamGrade * .3);
  }

  public String getGrade() {
    String str = "";

    for (int i = 0; i < quizArr.length; i++) {
      str += "\nQuiz " + i + ": " + quizArr[i];
    }
    str += "\nQuiz Avg: " + quizAverage;
    for (int i = 0; i < homeworkArr.length; i++) {
      str += "\nHw " + i + ": " + homeworkArr[i];
    }
    str += "\nHw Avg: " + homeworkAverage;
    str += "\nMidterm: " + midtermGrade;
    str += "\nFinal Exam: " + finalExamGrade;
    str += "\nOverall Average: " + overallAverage;
    return str;
  }
}
