class Q1 {
    int data;
    boolean valueSet = false;

    synchronized int get() {//синхронизированный метод get() в составе синхронизируемой очереди
        while ( !valueSet )
            try {
                wait();
            } catch ( InterruptedException е ) {
                System.out.println ("Исключение типа InterruptedException перехвачено ");
            }

        System.out.println("Пoлyчeнo : " + data);
        valueSet = false;
        notify ();
        return data;
    }
    synchronized void put(int n) {//синхронизированный метод putc() в составе синхронизируемой очереди
        while (valueSet)
            try {
                wait();
            } catch ( InterruptedException е ) {
                System.out.println ("Исключение типа InterruptedException перехвачено ");
            }
        this.data = n;
        valueSet = true;
        System.out.println("Oтпpaвлeнo : " + n);
        notify ();
    }
}

class Producer1 implements Runnable{ //В этом классе создаются элементы очереди. Класс работает в отдельном потоке
    Q1 q1;//создание ссылки на объект класса Q1
    Producer1 (Q1 q){
        this.q1 = q;//создание анонимного объекта класса Producer
        new Thread(this).start();//запуск анонимного потока иполнения
    }
    public void run() {
        int i = 0;
        while (true) { //в бесконечном цикле экземпляру q1 из класса Q1 с помощью метода put() присваивается значение инкремента i++
            this.q1.put (i++);
        }
    }
}

class Consumer1 implements Runnable{ //В этом классе принимаются элементы очереди. Класс работает в отдельном потоке
    Q1 q2;//создание ссылки на объект класса Q1
    Consumer1 (Q1 q){
        this.q2 = q;//создание анонимного объекта класса Consumer
        Thread th1 = new Thread (this);//создание потокового объекта th1 на основе объекта класса Consumer
        th1.start();//запуск  потока иполнения
    }
    public void run () {
        while (true) { //в бесконечном цикле в поле data экземпляра q2 записывается текущее значение инкремента i++ с помощью метода get()
            this.q2.get();
        }
    }
}

public class PCFixed {

    public static void main(String[] args) {
        Q1 q = new Q1 ();//создание объекта класса Q
        new Producer1 (q);
        new Consumer1 (q);
    }

}