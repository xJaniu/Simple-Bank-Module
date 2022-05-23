import java.util.Random;

public class main {

    public static void main(String[] args) throws InterruptedException {

        theBank bank = new theBank(100);

        for(int i = 0; i<100;i++){
            Thread thread = new Thread(new Account(i,1000, bank));
            thread.start();
        }



    }
}
