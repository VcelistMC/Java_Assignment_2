/**
 * Account class for assignment 2
 * 
 * @author Peter Atef - 20190140
 * @since 20 Apr, 2021
 */
public class Account {
    protected int balance;
    protected String accountNumber;

    class InsufficientFundsException extends Exception {
        InsufficientFundsException(String s) {
            super(s);
        }
    }

    class ValueError extends Exception {
        ValueError(String s) {
            super(s);
        }
    }

    /**
     * Constructs a new Account object with an account number and 0 inital balance
     * 
     * @param accNum sets the account number for this account
     * @throws ValueError on invalid input
     * 
     */
    public Account(String accNum) throws Exception {
        if (accNum.isEmpty()) {
            throw new ValueError("Invalid account number");
        }
        this.balance = 0;
        this.accountNumber = accNum;
    }

    /**
     * Default Constructor
     */
    public Account() {
        this.balance = 0;
        this.accountNumber = "";
    }

    /**
     * Constructs a new Account object with an account number and inital balance
     * 
     * @param bal    Initial balance for the account
     * @param accNum sets the account number for this account
     * @throws ValueError on invalid input
     * 
     */
    public Account(String accNum, int bal) throws Exception {
        if (bal < 0) {
            throw new ValueError("Invalid balance");
        }
        if (accNum.isEmpty()) {
            throw new ValueError("Invalid account number");
        }
        this.balance = bal;
        this.accountNumber = accNum;
    }

    /**
     * Returns account's balance
     * 
     * @return int - The current account balance
     */
    public int getBalance() {
        return balance;
    }

    /**
     * Sets the account's balance
     * 
     * @param newBalance The new balance value that the account to be set to
     * 
     * @throws ValueError on negative amounts
     */
    public void setBalance(int newBalance) throws Exception {
        if (newBalance < 0) {
            throw new ValueError("New balance can't be less than 0");
        }
        balance = newBalance;
    }

    /**
     * Returns account's number
     * 
     * @return int - The current account number
     */
    public String getAccNumber() {
        return accountNumber;
    }

    /**
     * Sets the account's number
     * 
     * @param newAccNumber The new balance value that the account to be set to
     * 
     * @throws ValueError on negative account number
     */
    public void setAccNumber(String newAccNumber) throws Exception {
        if (newAccNumber.isEmpty()) {
            throw new ValueError("Invalid account number");
        }
        accountNumber = newAccNumber;
    }

    /**
     * Returns a string with the account information
     * 
     * @return the account info string
     */
    @Override
    public String toString() {
        String returnVal = "Account Information: \n" 
            + "\tAccount Number: " + accountNumber + "\n"
            + "\tAccount Balance: " + balance + "\n";
        return returnVal;
    }

    /**
     * Deposits an amount to the account
     * 
     * @param amount The amount to be deposited
     * @return The new amount after depositing
     * @throws ValueError on negative amounts
     */
    public int deposit(int amount) throws Exception {
        if (amount < 0) {
            throw new ValueError("Deposit amount can't be less than 0");
        }
        balance += amount;
        return balance;
    }

    /**
     * Withdraws an amount from the account
     * 
     * @param amount the amount to be withdrawed
     * @return The new amount after withdrawing
     * @throws ValueError                 on negative amount
     * @throws InsufficientFundsException if amount is less than the account balance
     */
    public int withdraw(int amount) throws Exception {
        if (amount < 0) {
            throw new ValueError("Amount can't be less than 0");
        }
        if ((balance - amount) < 0) {
            throw new InsufficientFundsException("Not enough balance to withdraw");
        }
        balance -= amount;
        return balance;
    }
}
