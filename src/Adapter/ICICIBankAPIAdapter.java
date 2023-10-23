package Adapter;

import Adapter.thirdparty.iciciBankAPI;

public class ICICIBankAPIAdapter implements BankAPIAdapter {
    private iciciBankAPI iciciBankAPI = new iciciBankAPI();

    @Override
    public double getBalance(String accountNumber) {
        return 0;
    }

    @Override
    public boolean sendMoney(String fromAccount, String toAccount, double amount) {
        return false;
    }
}
