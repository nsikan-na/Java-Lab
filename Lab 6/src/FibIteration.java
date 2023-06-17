public class FibIteration implements FindFib {

  public int calculateFib(int num) {

    int fib = 0;
    int fibSub1 = 1;
    int fibSub2 = 0;

    if (num <= 1) {
      return num;
    }
    for (int i = 2; i <= num; i++) {
      fib = fibSub1 + fibSub2;
      fibSub2 = fibSub1;
      fibSub1 = fib;
    }
    return fib;
  }
}
