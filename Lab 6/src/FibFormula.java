import java.lang.Math;

public class FibFormula implements FindFib {

  public int calculateFib(int num) {
    return (int) (
      (
        Math.pow(((1 + Math.sqrt(5)) / 2), num) -
        Math.pow(((1 - Math.sqrt(5)) / 2), num)
      ) /
      Math.sqrt(5)
    );
  }
}
