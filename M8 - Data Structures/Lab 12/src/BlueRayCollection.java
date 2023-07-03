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
    if (head == null) {
      head = temp;
    } else {
      Node node = head;
      while (node.next != null) {
        node = node.next;
      }
      node.next = temp;
    }
  }

  public void show_all() {
    Node temp = head;

    while (temp != null) {
      System.out.println(temp.data.toString());
      temp = temp.next;
    }
  }
}
