public class Checking extends Account {

  Checking(int accountBalance) {
    setAccountBalance(accountBalance);
  }

  @Override
  public void withdrawal(double amount) {
    if (getAccountBalance() - amount < 0) {
      System.out.println(
        "Charging an overdraft fee of $20 because account is below $0"
      );
      setAccountBalance(getAccountBalance() - 20);
    }
    setAccountBalance(getAccountBalance() - amount);
  }
}
