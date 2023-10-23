package Adapter;

public class Client {
    public static void main(String[] args) {
        String userInput = "ICICI";
        // factory
        // BankAdapteraFactory
//        BankAPIAdapter bankAPI = BankAdapteraFactory.getFactory("ICICI");
        BankAPIAdapter bankAPI = new ICICIBankAPIAdapter();
        PhonePe accountObj = new PhonePe(bankAPI);



    }
}
