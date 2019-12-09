public class CachTester
{
    public static void main(String[] args) throws InterruptedException {
        Amount amount = new Amount();
        MyThread ct1 = new MyThread(amount);
        MyThread ct2 = new MyThread(amount);
        ct1.setName(" Kate ");
        ct2.setName(" Jon ");
        ct1.start();
        ct2.start();

        try{
            ct1.join();
            ct2.join();
        } catch (InterruptedException ex) {
            System.out.println("Thread crash");
        }
    }
}

class Amount
{
    private int count = 100;
    private int cash;
    private int dep;

    public synchronized  void withdraw(int cash) {

        System.out.println( "Деньги снимает " + Thread.currentThread().getName());
        if(getBalance() >= count) {
            count -= cash;
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            System.out.println( "Тред после слип " + Thread.currentThread().getName() );
            System.out.println(" Баланс = " + getBalance());
        } else {
            System.out.println(" Денег недостаточно " + Thread.currentThread().getName() + " Баланс = " + getBalance());
        }
    }

    public synchronized  void add(int dep){
        System.out.println( "Деньги кладет " + Thread.currentThread().getName());
        count += dep;
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println("Тред после слип " + Thread.currentThread().getName());
        System.out.println(" Баланс = " + getBalance());
    }

    public int getBalance() {
        return count;
    }
}

class MyThread extends Thread
{
    private Amount amount;
    public MyThread(Amount amount) {
        this.amount = amount;
    }

    @Override
    public void run()
    {
        for(int i=0; i<5; i++) {
            amount.withdraw(10);
            if(amount.getBalance() < 0)
            {
                System.out.println("Денег нет");
            }
        }
        for(int i=0; i<5; i++){
            amount.add(5);
        }
    }
}
