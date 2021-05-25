/**
 * commercial client class for assignment 2
 * 
 * @author Abdelrahman Ali - 20190314
 * @since 20 Apr, 2021
 */

public class CommercialClient extends Client {

    protected String commercialID;

    class InvalidCommercialID extends Exception {
        InvalidCommercialID(String s) {
            super(s);
        }
    }

    /**
     * Constructs a new Commercial Client object with a client name, national ID,
     * address, phone and Account
     * 
     * @param name         sets the name for this commercial client
     * @param commercialID sets the commercial ID for this commercial client
     * @param address      sets the address for this commercial client
     * @param phone        sets the phone for this commercial client
     * @param account      sets the account for this commercial client
     * @throws InvalidCommercialID on invalid input
     * 
     */
    public CommercialClient(String name, String commercialID, String address, String phone, Account account) throws Exception {
        super(name, "00000000000000", address, phone, account);
        if (commercialID.isEmpty()) {
            throw new CommercialClient.InvalidCommercialID("Invalid commercial ID");
        }
        this.commercialID = commercialID;
    }

    /**
     * Default Constructor
     */
    public CommercialClient() {
        super();
        this.commercialID = "";
    }

    /**
     * Sets the commercila client's commercial ID
     * 
     * @param commercialID The name value for the client to be set to
     * 
     */
    @Override
    public void setCommercialID(String commercialID) throws Exception {
        if (commercialID.isEmpty()) {
            throw new CommercialClient.InvalidCommercialID("Invalid client national ID");
        }
        this.commercialID = commercialID;
    }

    /**
     * Returns commercial client's commercial ID
     * 
     * @return String - the current commercial client commercial ID
     */
    @Override
    public String getCommercialID() {
        return commercialID;
    }

    /**
     * Returns a string with the client information
     * 
     * @return the commercial client info string
     */
    @Override
    public String toString() {
        String returnVal = "Client Information: \n" 
            + "\tClient name: " + name + "\n" 
            + "\tCommercial ID: "+ commercialID + "\n" 
            + "\tClient adedress: " + address + "\n" 
            + "\tClient phone: " + phone + "\n"
            + account.toString() + "\n";
        return (returnVal);
    }

}
