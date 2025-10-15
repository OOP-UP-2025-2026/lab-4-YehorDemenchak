package ua.opnu;

import ua.opnu.java.inheritance.account.BankingAccount;
import ua.opnu.java.inheritance.account.Credit;
import ua.opnu.java.inheritance.account.Debit;
import ua.opnu.java.inheritance.account.Startup;

public class MinMaxAccount extends BankingAccount {
    private int max;
    private int min;

    public MinMaxAccount(Startup s) {
        super(s);
        max = getBalance();
        min = getBalance();
    }

    @Override
    public void debit(Debit d) {
        super.debit(d);
        checkBalanceValue();
    }

    @Override
    public void credit(Credit c) {
        super.credit(c);
        checkBalanceValue();
    }

    public void checkBalanceValue() {
        if (getBalance() > max) {
            max = getBalance();
        }
        if (getBalance() < min) {
            min = getBalance();
        }
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }
}
