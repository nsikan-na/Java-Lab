public class Saving extends Account {

  private static int numOfDep = 1;

  Saving(int accountBalance) {
    setAccountBalance(accountBalance);
  }

  @Override
  public void withdrawal(double amount) {
    if (getAccountBalance() - amount < 500) {
      System.out.println("Charging a fee of $10 because you are below $500");
      setAccountBalance(getAccountBalance() - 10);
    }
    setAccountBalance(getAccountBalance() - amount);
  }

  public void deposit(double amount) {
    System.out.println(
      "This is deposit number " + numOfDep + " to this account"
    );
    if (numOfDep > 5) {
      System.out.println("Charging a fee of $10");
      setAccountBalance(super.getAccountBalance() - 10);
    }
    setAccountBalance(getAccountBalance() + amount);

    numOfDep++;
  }

  public void addInterest() {
    double interest = getAccountBalance() * .015;
    System.out.println("Customer earned " + interest + " in interest");
    setAccountBalance(getAccountBalance() + interest);
  }
}
