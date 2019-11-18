import java.util.*;

//Расчет среднего арифметического заданного количества чисел

public class StreamDemo1 {

    public static void main(String[] args) {

        ArrayList<Integer> myList = new ArrayList<>();

        myList.add (1);
        myList.add (2);
        myList.add (3);
        myList.add (4);
        myList.add (5);
        myList.add (6);
        myList.add (7);

        int sum = myList.stream().reduce(0, (a, b) -> a + b);
        System.out.println("Сумма всех элементов =  " + sum);

        long count = myList.stream().count();
        System.out.println("Количество элементов =  " + count);

        System.out.println("Среднее арифметическое =  " + sum / count);

        OptionalDouble averege = myList.stream()
                                        .mapToDouble(a->a)
                                        .average();
        System.out.println("Среднее арифметическое =  " + averege.getAsDouble());
    }
}
