import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bank currentBank;
        Scanner input = new Scanner(System.in);
        ;

        while (true) {
            try {

                System.out.println("Enter Bank Information: ");

                System.out.println("Enter name: ");
                String bankName = input.nextLine();

                System.out.println("Enter phone: ");
                String bankPhone = input.nextLine();

                System.out.println("Enter address: ");
                String bankAddress = input.nextLine();
                currentBank = new Bank(bankName, bankAddress, bankPhone);
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        int choice = 0;
        do {
            try {
                System.out.println("1-Select Client\n2-Add new Client\n3-Display all clients\n4-exit");
                choice = Integer.parseInt(input.next());
                input.nextLine();
                switch (choice) {
                case 1: // search and select
                    System.out.println("Enter Client name");
                    String clientName = input.nextLine();
                    int index = currentBank.search(clientName);
                    if (index != -1) {
                        ClientHandler activeClient = new ClientHandler(currentBank.getClient(index));
                        activeClient.mainMenu();
                        // currentBank.updateClient(index, activeClient.getClient());
                    } else {
                        System.out.println("Client not found!!");
                    }
                    break;
                case 2: // create new client
                    Client newClient = ClientHandler.createClient();
                    currentBank.addClient(newClient);
                    break;
                case 3: // display all clients
                    currentBank.displayAll();
                    break;
                default:
                    break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (choice != 4);
    }
}

/**
 * A client handler class to separate client handling from the main funciton
 */
class ClientHandler {
    private Client currClient;
    Scanner input = new Scanner(System.in);

    /**
     * initializes the client handler with a client to start client-specific
     * operations
     * 
     * @param client
     */
    ClientHandler(Client client) {

        currClient = client;
    }

    /**
     * calls the tostring func, prints client info
     */
    public void getInfo() {
        System.out.println(currClient.toString());
    }

    /**
     * changes current client name
     */
    public void changeName() {
        System.out.println("Enter new name");
        String newName = input.nextLine();
        try {
            currClient.setName(newName);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * returns the current client object
     * 
     * @return Client
     */
    public Client getClient() {
        return currClient;
    }

    /**
     * changes current client national id
     */
    public void changeNationalID() {
        System.out.println("enter new National ID");
        String ID = input.nextLine();
        try {
            currClient.setNationalID(ID);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * changes current client Commercial id
     */
    public void changeCommercialID() {
        System.out.println("enter new Commercial ID");
        String ID = input.nextLine();
        try {
            currClient.setCommercialID(ID);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * changes current client address
     */
    public void changeAddress() {
        System.out.println("enter new address");
        String address = input.nextLine();
        try {
            currClient.setAddress(address);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * changes current client phone
     */
    public void changePhone() {
        System.out.println("Enter new phone");
        String phone = input.nextLine();
        try {
            currClient.setPhone(phone);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Withdraws money
     */
    public void depositMoney() {
        System.out.println("enter deposit amount");
        int amount = Integer.parseInt(input.next());
        ;
        input.nextLine();
        try {
            currClient.account.deposit(amount);
        } catch (Exception e) {
            System.out.println();
        }
    }

    /**
     * Deposits money
     */
    public void withdrawMoney() {
        System.out.println("enter withdraw amount");
        int withdraw = Integer.parseInt(input.next());
        ;
        input.nextLine();
        try {
            currClient.account.withdraw(withdraw);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * a static method to create a new client, is static because we don't need to
     * create a ClientHandler object to create a client but the create client
     * operation is still related to client handling, so i made a static method in
     * the client handler class
     * 
     * @return the new client
     */
    static Client createClient() {
        int initBal;
        Account account;
        int isCommercial, isSpecial;
        Scanner input = new Scanner(System.in);
        String name, ID, address, phone, accNumber;
        Client newClient;

        while (true) {
            try {
                System.out.println("Enter 0 for normal client, 1 for commercial client");
                isCommercial = Integer.parseInt(input.next());
                ;
                input.nextLine();

                System.out.println("Enter client name");
                name = input.nextLine();

                if (isCommercial == 1) {
                    System.out.println("Enter commercial id");
                    ID = input.nextLine();
                } else {
                    System.out.println("Enter national id, must be 14 in length");
                    ID = input.nextLine();
                }

                System.out.println("Enter client address");
                address = input.nextLine();

                System.out.println("Enter client phone");
                phone = input.nextLine();

                System.out.println("Enter 0 for normal account, 1 for special account");
                isSpecial = Integer.parseInt(input.next());
                ;
                input.nextLine();

                System.out.println("Enter Account number");
                accNumber = input.nextLine();

                System.out.println("Enter inital account balance");
                initBal = Integer.parseInt(input.next());
                ;
                input.nextLine();

                if (isSpecial == 1) {
                    account = new SpecialAccount(accNumber, initBal);
                } else {
                    account = new Account(accNumber, initBal);
                }

                if (isCommercial == 1) {
                    newClient = new CommercialClient(name, ID, address, phone, account);
                } else {
                    newClient = new Client(name, ID, address, phone, account);
                }

                // input.close();
                return newClient;

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * main client handler method, it's basically the main menu for a specific
     * client ya rab 5odny
     */
    public void mainMenu() {
        int choice;
        do {
            System.out.println(
                "1-Get client info\n2-change name\n3-change id\n4-change address\n5-change phone\n6-deposit money\n7-withdraw money\n8-exit");
            Scanner input = new Scanner(System.in);
            choice = Integer.parseInt(input.next());
            ;
            input.nextLine();
            switch (choice) {
            case 1:
                getInfo();
                break;
            case 2:
                changeName();
                break;
            case 3:
                if (currClient instanceof CommercialClient) {
                    changeCommercialID();
                } else {
                    changeNationalID();
                }
                break;
            case 4:
                changeAddress();
                break;
            case 5:
                changePhone();
                break;
            case 6:
                depositMoney();
                break;
            case 7:
                withdrawMoney();
                break;
            default:
                break;
            }
        } while (choice != 8);

    }

}
