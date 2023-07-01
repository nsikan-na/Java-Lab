import java.util.Scanner;

// Lab 8B
public class Main {

  public static String repeatNTimes(String word, int num) {
    if (num == 1) return word;
    if (num == 0) return "";
    return repeatNTimes(word, num - 1) + word + '\n';
  }

  public static boolean isReverse(String word1, String word2) {
    if (word1.length() != word2.length()) return false;
    if (word1.length() == 0 && word2.length() == 0) {
      return true;
    }
    if (word1.charAt(0) != word2.charAt(word2.length() - 1)) return false;
    return isReverse(
      word1.substring(1),
      word2.substring(0, word2.length() - 1)
    );
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.print(
      repeatNTimes("I must study recursion until it makes sense", 100)
    );
    System.out.println("\nEnter the first string");
    String word1 = scan.nextLine();
    System.out.println("Enter the second string");
    String word2 = scan.nextLine();
    if (isReverse(word1, word2)) {
      System.out.println(word1 + " is the reverse of " + word2);
    } else {
      System.out.println(word1 + " is not the reverse of " + word2);
    }
  }
}
