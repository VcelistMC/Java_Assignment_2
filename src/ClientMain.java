public class ClientMain {
    public static void main(String []args){
        System.out.println("Testing Client");
        try {
            Account testAcc1 = new Account("1", 1000);
            Account newAcc1 = new Account("10", 500);
            Client testClient1 = new Client("Abdelrahman", "12345678910110", "Cairo",
                    "01111122222", testAcc1);

            System.out.println("Setting client name");
            System.out.println(testClient1.getName());
            testClient1.setName("Ahmed");
            System.out.println(testClient1.getName());

            System.out.println("Setting client national ID");
            System.out.println(testClient1.getNationalID());
            testClient1.setNationalID("11111111111111");
            System.out.println(testClient1.getNationalID());

            System.out.println("Setting client address");
            System.out.println(testClient1.getAddress());
            testClient1.setAddress("Giza");
            System.out.println(testClient1.getAddress());

            System.out.println("Setting client phone");
            System.out.println(testClient1.getPhone());
            testClient1.setPhone("01111111111");
            System.out.println(testClient1.getPhone());

            System.out.println("Setting client account");
            System.out.println(testClient1.getAccount());
            testClient1.setAccount(newAcc1);
            System.out.println(testClient1.getAccount());

            System.out.println(testClient1.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Testing Commercial Client");
        try{
            SpecialAccount testAcc2 = new SpecialAccount("2", 10000);
            SpecialAccount newAcc2 = new SpecialAccount("50", 15000);
            Client testClient2 = new CommercialClient("Omar", "22222222222222",
                    "Giza", "01234567890", testAcc2);
            System.out.println("Setting client name");
            System.out.println(testClient2.getName());
            testClient2.setName("Mohamed");
            System.out.println(testClient2.getName());

            System.out.println("Setting client national ID");
            System.out.println(testClient2.getNationalID());
            testClient2.setNationalID("11111111155555");
            System.out.println(testClient2.getNationalID());

            System.out.println("Setting client address");
            System.out.println(testClient2.getAddress());
            testClient2.setAddress("Sharm El-Sheikh");
            System.out.println(testClient2.getAddress());

            System.out.println("Setting client phone");
            System.out.println(testClient2.getPhone());
            testClient2.setPhone("06666661111");
            System.out.println(testClient2.getPhone());

            System.out.println("Setting client account");
            System.out.println(testClient2.getAccount());
            testClient2.setAccount(newAcc2);
            System.out.println(testClient2.getAccount());

            System.out.println("Setting commercial ID");
            System.out.println(((CommercialClient) testClient2).getCommercialID());
            ((CommercialClient) testClient2).setCommercialID("12345678912345");
            System.out.println(((CommercialClient) testClient2).getCommercialID());

            System.out.println(testClient2.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
