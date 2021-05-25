import java.util.ArrayList;

/**
 * Bank class for assignment 2
 * 
 * @author Mohamed Essam - 20190461
 * @since 20 Apr, 2021
 */
public class Bank {

    protected String name, phone, address;
    protected ArrayList<Account> accountList;
    protected ArrayList<Client> clientList;

    class InvalidDataInput extends Exception {
        InvalidDataInput(String s) {
            super(s);
        }
    }

    /**
     * Constructs a new Bank object with a Bank name, address and phone
     *
     * @param name    sets the name for this Bank
     * @param address sets the address for this Bank
     * @param phone   sets the phone for this Bank
     * 
     * @throws Bank.InvalidDataInput on invalid input
     */
    public Bank(String name, String address, String phone) throws Exception {
        if (name.isEmpty()) {
            throw new Bank.InvalidDataInput("Invalid bank name");
        }

        if (address.isEmpty()) {
            throw new Bank.InvalidDataInput("Invalid bank address");
        }
        if (phone.isEmpty()) {
            throw new Bank.InvalidDataInput("Invalid bank phone");
        }
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.accountList = new ArrayList<Account>();
        this.clientList = new ArrayList<Client>();
    }

    /**
     * Sets the client's name
     * 
     * @param name The name value for the bank to be set to
     * 
     */
    public void setName(String name) throws Exception {
        if (name.isEmpty()) {
            throw new Bank.InvalidDataInput("Invalid bank name");
        }
        this.name = name;
    }

    /**
     * Searches for a client with given name
     * 
     * @param name name of the client
     * @return int - index of current if found, -1 otherwise
     */
    public int search(String name) {
        int returnVal = -1;
        for (int i = 0; i < clientList.size(); i++) {
            if (clientList.get(i).getName().equals(name)) {
                returnVal = i;
                break;
            }
        }
        return returnVal;
    }

    /**
     * returns a client at given index
     * 
     * @param index index of client
     * @return client at index
     */
    public Client getClient(int index) {
        return clientList.get(index);
    }

    // /**
    // * Updates a client at current index
    // * @param index index of updating client
    // * @param client client to be updated with
    // */
    // public void updateClient(int index, Client client){
    // clientList.set(index, client);
    // }

    /**
     * Sets the bank's address
     * 
     * @param address The name value for the bank to be set to
     * 
     */
    public void setAddress(String address) throws Exception {
        if (address.isEmpty()) {
            throw new Bank.InvalidDataInput("Invalid bank address");
        }
        this.address = address;
    }

    /**
     * Sets the bank's phone
     * 
     * @param phone The name value for the bank to be set to
     * 
     */
    public void setPhone(String phone) throws Exception {
        if (phone.isEmpty()) {
            throw new Bank.InvalidDataInput("Invalid bank phone");
        }
        this.phone = phone;
    }

    /**
     * Returns Bank's name
     * 
     * @return String - the current client name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns Bank's address
     * 
     * @return String - the current client address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Returns Bank's phone
     * 
     * @return String - the current client phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Adds a new account to the account list
     * @param account the account to be added
     */
    private void addAccount(Account account) {
        accountList.add(account);
    }

    /**
     * adds a new client to the client list
     * @param client the client to be added
     */
    public void addClient(Client client) {
        clientList.add(client);
        Account clientAccount = client.getAccount();
        addAccount(clientAccount);
    }

    /**
     * display all existing clients and their accounts
     */
    public void displayAll() {
        for (int i = 0; i < clientList.size(); i++) {
            System.out.println(clientList.get(i).toString());
        }
    }

    /**
     * deletes a client
     * 
     * @param clientToRemove client object to remove
     */
    public void deleteClient(Client clientToRemove) {
        clientList.remove(clientToRemove);
        accountList.remove(clientToRemove.getAccount());
    }
}
