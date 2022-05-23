import com.sun.source.tree.SynchronizedTree;

import java.util.Random;

public class Account implements Runnable, accountOperations{
    private double bilance;
    private final int accountNumber;
    private theBank bank;

    public Account(int accountNumber, double bilance, theBank bank){
        this.accountNumber = accountNumber;
        this.bilance = bilance;
        this.bank = bank;
    }

    public double getBilance() {
        return bilance;
    }

    public void setBilance(double bilance) {
        this.bilance = bilance;
    }

    @Override
    public void income(double in) {
        bilance = bilance + in;
    }

    @Override
    public void outcome(double out) {
        bilance=bilance-out;
    }

    @Override
    public void run() {
        Random random = new Random();
        while(true) {
            double amount = random.nextInt(200) + random.nextInt(100)/100;
            bank.transfer(accountNumber, random.nextInt(100), amount);
        }
    }
}
