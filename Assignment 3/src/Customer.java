public abstract class Customer {

  private char letter;
  private int number;
  private static int nextANumber = 1;
  private static int nextBNumber = 1;
  private static int nextCNumber = 1;
  private static int nextDNumber = 1;

  Customer() {
    letter = 'X';
    number = 0;
  }

  Customer(char letter) {
    this.letter = letter;
    switch (letter) {
      case 'A':
        {
          this.number = nextANumber;
          nextANumber++;
          break;
        }
      case 'B':
        {
          this.number = nextBNumber;
          nextBNumber++;
          break;
        }
      case 'C':
        {
          this.number = nextCNumber;
          nextCNumber++;
          break;
        }
      case 'D':
        {
          this.number = nextDNumber;
          nextDNumber++;
          break;
        }
    }
  }

  protected String getTicketNumber() {
    return "" + letter + number;
  }

  abstract String getCustomerInfo();
}
