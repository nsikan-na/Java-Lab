import java.util.Scanner;

public class Main {

    public static void mainPrompt() {
        System.out.println("1. Withdraw from Checking");
        System.out.println("2. Withdraw from Savings");
        System.out.println("3. Deposit to Checking");
        System.out.println("4. Deposit to Saving");
        System.out.println("5. Balance of Checking");
        System.out.println("6. Balance of Saving");
        System.out.println("7. Award Interest to Saving now");
        System.out.println("8. Quit");
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = 0;
        Checking checking = new Checking(0);
        Saving saving = new Saving(0);
        while (num != 8) {
            mainPrompt();
            num = Integer.parseInt(scan.nextLine());
            if (num < 1 || num > 8) {
                num = 0;
                break;
            }
            switch (num) {
                case 1: {
                    System.out.println(
                            "How much would you like to withdrawal from your checking account?"
                    );
                    double amt = Integer.parseInt(scan.nextLine());
                    checking.withdrawal(amt);
                    break;
                }
                case 2: {
                    System.out.println(
                            "How much would you like to withdrawal from your saving account?"
                    );
                    double amt = Integer.parseInt(scan.nextLine());
                    saving.withdrawal(amt);
                    break;
                }
                case 3: {
                    System.out.println(
                            "How much would you like to deposit to your checking account?"
                    );
                    double amt = Integer.parseInt(scan.nextLine());
                    checking.deposit(amt);
                    break;
                }
                case 4: {
                    System.out.println(
                            "How much would you like to deposit to your saving account?"
                    );
                    double amt = Integer.parseInt(scan.nextLine());
                    saving.deposit(amt);
                    break;
                }
                case 5: {
                    System.out.println(
                            "Your balance for checking " +
                                    checking.getAccountNumber() +
                                    " is " +
                                    checking.getAccountBalance()
                    );

                    break;
                }
                case 6: {
                    System.out.println(
                            "Your balance for saving " +
                                    saving.getAccountNumber() +
                                    " is " +
                                    saving.getAccountBalance()
                    );

                    break;
                }
                case 7: {
                    saving.addInterest();
                }
            }
        }
    }
}
