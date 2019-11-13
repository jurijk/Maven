import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//Программа изменяющая регистр слов и сохраняющая результат в новую коллекцию

public class StreamDemo2 {

    public static void main(String[] args) {

        ArrayList<String> myList = new ArrayList<>();

        myList.add ("string");
        myList.add ("string");
        myList.add ("string");
        myList.add ("string");
        myList.add ("string");
        myList.add ("string");
        myList.add ("string");

        Stream<String> UpperString = myList.stream().map(String::toUpperCase);

        List<String> list = UpperString.collect(Collectors.toList());

        for (String s : list)
            System.out.println(s);

    }
}
