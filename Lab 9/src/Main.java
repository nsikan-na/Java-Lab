import java.util.Scanner;

public class Main {

  private static int convertToSeconds(String str) throws InvalidTimeException {
    String[] strArr = str.split(":", 3);
    if (strArr.length != 3) throw new InvalidTimeException(
      "Enter a valid time"
    );
    int hours = Integer.parseInt(strArr[0]);
    int minutes = Integer.parseInt(strArr[1]);
    int seconds = Integer.parseInt(strArr[2]);
    if (hours < 0) {
      throw new InvalidTimeException("Hours must be greater than 0");
    }
    if (hours > 23) {
      throw new InvalidTimeException("Hours must be less than 24");
    }
    if (minutes < 0) {
      throw new InvalidTimeException("Minutes must be greater than 0");
    }
    if (minutes > 59) {
      throw new InvalidTimeException("Minutes must be less than 60");
    }
    if (seconds < 0) {
      throw new InvalidTimeException("Seconds must be greater than 0");
    }
    if (seconds > 59) {
      throw new InvalidTimeException("Seconds must be less than 60");
    }

    return ((hours * 60 * 60) + (minutes * 60) + (seconds));
  }

  public static void main(String[] args) {
    try {
      Scanner scanner = new Scanner(System.in);
      System.out.println("Enter time 1 in 24hr format as follows (HH:MM:SS)");
      int str1ToSeconds = convertToSeconds(scanner.nextLine());
      System.out.println("Enter time 2 in 24hr format as follows (HH:MM:SS)");
      int str2ToSeconds = convertToSeconds(scanner.nextLine());
      System.out.println(
        "Difference in seconds: " + Math.abs(str1ToSeconds - str2ToSeconds)
      );
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}
