import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class theBank {

    private final int maxAccounts;
    private Account[] accounts = new Account[100];

    public theBank(int maxAccounts) {
        this.maxAccounts = maxAccounts;

        for(int i = 0; i<maxAccounts; i++){
            accounts[i] = new Account(i,1000, this);
        }
    }

    public int getAllBalance(){
        int balance = 0;
        for(int i = 0;i<maxAccounts;i++){
            balance+=accounts[i].getBilance();
        }
        return balance;
    }

    public synchronized void transfer(int from, int to, double amount){

        while(accounts[from].getBilance()<amount) {
            try {
                wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        if(accounts[from].getBilance()>amount){
            accounts[from].outcome(amount);
            accounts[to].income(amount);
            System.out.println("Ilosc pieniedzy na wszystkich kontach: " + getAllBalance());
        }

        notifyAll();

    }

}
