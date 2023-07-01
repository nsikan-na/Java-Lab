public class Main {

  public static String repeatNTimes(String word, int num) {
    if (num == 1) return word + "\n";
    if (num == 0) return "";
    return repeatNTimes(word, num - 1) + word;
  }

  //   public static boolean isReverse(String word1, String word2) {}

  public static void main(String[] args) {
    System.out.print(
      repeatNTimes("I must study recursion until it makes sense", 100)
    );
  }
}
