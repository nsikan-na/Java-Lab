import java.io.File;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    try {
      Scanner scan = new Scanner(System.in);

      System.out.println("Please enter the first file name");
      String file1 = scan.nextLine();

      System.out.println("Please enter the second file name");
      String file2 = scan.nextLine();

      File myFile1 = new File(file1);
      File myFile2 = new File(file2);

      Scanner file1Scan = new Scanner(myFile1);
      Scanner file2Scan = new Scanner(myFile2);

      String line1 = "";
      String line2 = "";

      int line1Count = 1;
      int line2Count = 1;
      while (file1Scan.hasNextLine() && file2Scan.hasNextLine()) {
        line1 = file1Scan.nextLine();
        line2 = file2Scan.nextLine();
        if (!line1.equals(line2)) {
          System.out.println("\nLine " + line1Count);
          System.out.println("< " + line1);
          System.out.println("> " + line2);
        }
        if (file1Scan.hasNextLine()) {
          line1Count++;
        }
        if (file2Scan.hasNextLine()) {
          line2Count++;
        }
      }
      if (line1Count != line2Count) {
        System.out.println("\nFiles have a different number of lines\n");
      }
      scan.close();
      file1Scan.close();
      file2Scan.close();
    } catch (Exception err) {
      System.out.println(err);
    }
  }
}
