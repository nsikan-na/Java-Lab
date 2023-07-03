class Account {

  private int accountNumber;
  private static int nextAccountNumber = 10001;
  private double accountBalance;

  Account() {
    accountBalance = 0;
    accountNumber = nextAccountNumber;
    nextAccountNumber++;
  }

  Account(int accountBalance) {
    this.accountBalance = accountBalance;
    accountNumber = nextAccountNumber;
    nextAccountNumber++;
  }

  public int getAccountNumber() {
    return accountNumber;
  }

  public double getAccountBalance() {
    return accountBalance;
  }

  public void setAccountBalance(double accountBalance) {
    this.accountBalance = accountBalance;
  }

  public void withdrawal(double amount) {
    this.accountBalance = accountBalance - amount;
  }

  public void deposit(double amount) {
    this.accountBalance = accountBalance + amount;
  }
}
