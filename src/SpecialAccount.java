/**
 * special account class for assignment 2, can overdraft with limit of -1000;
 * 
 * @author Peter Atef - 20190140
 * @since 20 Apr, 2021
 */
public class SpecialAccount extends Account {
    /**
     * Constructs a new SpecialAccount object with an account number and 0 inital
     * balance
     * 
     * @param accNum sets the account number for this account
     * @throws ValueError on invalid input
     * 
     */
    public SpecialAccount(String accNum) throws Exception {
        super(accNum); // super calls the constructor of the base class
    }

    /**
     * Constructs a new SpecialAccount object with an account number and inital
     * balance
     * 
     * @param bal    Initial balance for the account
     * @param accNum sets the account number for this account
     * @throws ValueError on invalid input
     * 
     */
    public SpecialAccount(String accNum, int bal) throws Exception {
        super(accNum, bal);
    }

    /**
     * Default Constructor
     */
    public SpecialAccount() {
        super();
    }

    /**
     * Sets the account's balance
     * 
     * @param newBalance The new balance value that the account to be set to
     * 
     * @throws ValueError on negative amounts
     */
    @Override
    public void setBalance(int newBalance) throws Exception {
        if (newBalance < -1000) {
            throw new ValueError("New balance can't be less than -1000");
        }
        balance = newBalance;
    }

    /**
     * Withdraws given amount from current account
     * 
     * @param amount The amount to be withdrawed
     * @return The new amount after withdrawing
     */
    @Override
    public int withdraw(int amount) throws Exception {
        if (balance - amount < -1000) {
            throw new ValueError("Not enough balance to withdraw");
        }
        balance -= amount;
        return balance;
    }
}
