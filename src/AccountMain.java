public class AccountMain {
    public static void main(String[] args) {
        System.out.println("Testing Account");
        try {
            Account testAcc1 = new Account("1", 1000);
            System.out.println("Depositing $12");
            System.out.println(testAcc1.getBalance());
            testAcc1.deposit(12);
            
            System.out.println(testAcc1.getBalance());
            System.out.println("Withdrawing $500");
            testAcc1.withdraw(500);
            System.out.println(testAcc1.getBalance());
            
            System.out.println("setting account number");
            System.out.println(testAcc1.getAccNumber());
            testAcc1.setAccNumber("12");
            System.out.println(testAcc1.getAccNumber());
            
            System.out.println("setting balance");
            testAcc1.setBalance(10000);
            System.out.println(testAcc1.getBalance());
            
            System.out.println(testAcc1.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        System.out.println("\ntesting special account");
        try {
            Account testAcc2 = new SpecialAccount("2", 2000);
            System.out.println("Depositing $12");
            System.out.println(testAcc2.getBalance());
            testAcc2.deposit(12);

            System.out.println(testAcc2.getBalance());
            System.out.println("Withdrawing $2500");
            testAcc2.withdraw(2500);
            System.out.println(testAcc2.getBalance());
            
            System.out.println("setting account number");
            System.out.println(testAcc2.getAccNumber());
            testAcc2.setAccNumber("12");
            System.out.println(testAcc2.getAccNumber());

            System.out.println("setting balance");
            testAcc2.setBalance(10000);
            System.out.println(testAcc2.getBalance());

            System.out.println(testAcc2.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
