public class Main {

  public static String reverse(String str) {
    char[] charArr = str.toCharArray();
    char temp;
    for (int i = 0; i < (charArr.length / 2); i++) {
      temp = charArr[i];
      charArr[i] = charArr[charArr.length - i - 1];
      charArr[charArr.length - i - 1] = temp;
    }
    return new String(charArr);
  }

  public static String flip(String str) {
    char[] charArr = str.toCharArray();
    for (int i = 0; i < charArr.length; i++) {
      if (charArr[i] == 'v') charArr[i] = '^'; else charArr[i] = 'v';
    }
    return new String(charArr);
  }

  public static String paperFold(int num) {
    if (num == 1) return "v";
    return flip(reverse(paperFold(num - 1))) + "v" + paperFold(num - 1);
  }

  public static void main(String[] args) {
    System.out.println(reverse("Hello"));
    System.out.println(flip("^^^vvv"));
    for (int i = 1; i < 10; i++) {
      String fold_string = paperFold(i);
      System.out.println("For " + i + " folds we get: " + fold_string + "\n");
    }
  }
}
