public class Main {

  private static String reverseString(String originalString) {
    char[] stringCharAsArr = originalString.toCharArray();
    for (int i = 0; i < (originalString.length() / 2); i++) {
      char temp = stringCharAsArr[i];
      stringCharAsArr[i] = stringCharAsArr[stringCharAsArr.length - i - 1];
      stringCharAsArr[stringCharAsArr.length - i - 1] = temp;
    }
    return new String(stringCharAsArr);
  }

  private static String paperFold(int x) {
    return null;
  }

  public static void main(String[] args) {
    // for (int i = 1; i < 10; i++) {
    //   String fold_string = paperFold(i);
    //   System.out.println("For " + i + " folds we get: " + fold_string + "\n");
    // }
    System.out.println(reverseString("Hello"));
  }
}
