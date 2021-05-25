/**
 * Client class for assignment 2
 * 
 * @author Abdelrahman Ali - 20190314
 * @since 20 Apr, 2021
 */

public class Client {

    protected String name;
    protected String nationalID;
    protected String address;
    protected String phone;
    protected Account account;

    class InvalidDataInput extends Exception {
        InvalidDataInput(String s) {
            super(s);
        }
    }

    class UnauthorizedOperation extends Exception {
        UnauthorizedOperation(String s) {
            super(s);
        }
    }

    /**
     * Constructs a new Client object with a client name, national ID, address,
     * phone and Account
     * 
     * @param name       sets the name for this client
     * @param nationalID sets the national ID for this client
     * @param address    sets the address for this client
     * @param phone      sets the phone for this client
     * @param account    sets the account for this client
     * @throws InvalidDataInput on invalid input
     * 
     */
    public Client(String name, String nationalID, String address, String phone, Account account) throws Exception {
        if (name.isEmpty()) {
            throw new Client.InvalidDataInput("Invalid client name");
        }
        if (nationalID.isEmpty() || nationalID.length() != 14) {
            throw new Client.InvalidDataInput("Invalid client national ID");
        }
        if (address.isEmpty()) {
            throw new Client.InvalidDataInput("Invalid client address");
        }
        if (phone.isEmpty()) {
            throw new Client.InvalidDataInput("Invalid client phone");
        }
        this.name = name;
        this.nationalID = nationalID;
        this.address = address;
        this.phone = phone;
        this.account = account;
    }

    /**
     * Default Constructor
     */
    public Client() {
        this.name = "";
        this.nationalID = "";
        this.address = "";
        this.phone = "";
        this.account = new Account();
    }

    /**
     * Sets the client's name
     * 
     * @param name The name value for the client to be set to
     * 
     */
    public void setName(String name) throws Exception {
        if (name.isEmpty()) {
            throw new Client.InvalidDataInput("Invalid client name");
        }
        this.name = name;
    }

    /**
     * Sets the client's national ID
     * 
     * @param nationalID The nationalID value for the client to be set to
     * 
     */
    public void setNationalID(String nationalID) throws Exception {
        if (nationalID.isEmpty() || nationalID.length() != 14) {
            throw new Client.InvalidDataInput("Invalid client national ID");
        }
        this.nationalID = nationalID;
    }

    public void setCommercialID(String commercialID) throws Exception {
        throw new UnauthorizedOperation("Method not supported for this client type");
    }

    public String getCommercialID() throws Exception {
        throw new UnauthorizedOperation("Method not supported for this client type");
    }

    /**
     * Sets the client's address
     * 
     * @param address The address value for the client to be set to
     * 
     */
    public void setAddress(String address) throws Exception {
        if (address.isEmpty()) {
            throw new Client.InvalidDataInput("Invalid client address");
        }
        this.address = address;
    }

    /**
     * Sets the client's phone
     * 
     * @param phone The name value for the client to be set to
     * 
     */
    public void setPhone(String phone) throws Exception {
        if (phone.isEmpty()) {
            throw new Client.InvalidDataInput("Invalid client phone");
        }
        this.phone = phone;
    }

    /**
     * Sets the client's account
     * 
     * @param account The name value for the client to be set to
     * 
     */
    public void setAccount(Account account) {
        this.account = account;
    }

    /**
     * Returns client's name
     * 
     * @return String - the current client name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns client's national ID
     * 
     * @return String - the current client national ID
     */
    public String getNationalID() {
        return nationalID;
    }

    /**
     * Returns client's address
     * 
     * @return String - the current client address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Returns client's phone
     * 
     * @return String - the current client phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Returns client's account
     * 
     * @return Account - the current client account
     */
    public Account getAccount() {
        return account;
    }

    /**
     * Returns a string with the client information
     * 
     * @return the client info string
     */
    @Override
    public String toString() {
        String returnVal = "Client Information: \n" 
            + "\tClient name: " + name + "\n" 
            + "\tClient national ID: " + nationalID + "\n" 
            + "\tClient adedress: " + address + "\n" 
            + "\tClient phone: " + phone + "\n"
            + account.toString() + "\n";
        return returnVal;
    }

}
