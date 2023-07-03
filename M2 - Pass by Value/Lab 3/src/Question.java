public class Question {

  private String text;
  private String answer;
  private int difficulty;

  Question() {
    text = "";
    answer = "";
    difficulty = 1;
  }

  Question(String text, String answer, int difficulty) {
    this.text = text;
    this.answer = answer;
    this.difficulty = difficulty;
  }

  public String getText() {
    return text;
  }

  public String getAnswer() {
    return answer;
  }

  public int getDifficulty() {
    return difficulty;
  }

  public void setText(String newText) {
    text = newText;
  }

  public void setAnswer(String newAnswer) {
    answer = newAnswer;
  }

  public void setDifficulty(int newDifficulty) {
    difficulty = newDifficulty;
  }
}
