public class Periodical extends Item {

  private int issueNum;

  Periodical() {
    this.issueNum = 0;
    setTitle("");
  }

  Periodical(int issueNum, String title) {
    this.issueNum = issueNum;
    setTitle(title);
  }

  public int getIssueNum() {
    return issueNum;
  }

  public void setIssueNum(int issueNum) {
    this.issueNum = issueNum;
  }

  @Override
  String getListing() {
    return "Periodical Title " + getTitle() + "\nIssue # - " + issueNum;
  }
}
