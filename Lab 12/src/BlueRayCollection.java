public class BlueRayCollection {

  private Node head = null;

  public void add(
    String title,
    String director,
    int yearOfRelease,
    double cost
  ) {
    Node temp = new Node();
    temp.data = new BlueRayDisk(title, director, yearOfRelease, cost);
    temp.next = head;
    head = temp;
  }

  public void show_all() {
    Node temp = head;
    while (temp != null) {
      System.out.println(temp.data.toString());
      temp = temp.next;
    }
  }
}
