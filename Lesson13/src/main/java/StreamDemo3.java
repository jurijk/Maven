import java.util.ArrayList;
import java.util.stream.Stream;

//Программа, которая выбирает слова из коллекции начинающиеся
// со строчной буквы и имеющие длинну в 4 буквы

public class StreamDemo3 {

    public static void main(String[] args){

        ArrayList<String> myList = new ArrayList<>();

        myList.add ("st");
        myList.add ("String");
        myList.add ("stri");
        myList.add ("string");
        myList.add ("stri");
        myList.add ("String");
        myList.add ("string");
        myList.add ("Stri");
        myList.add ("string");
        myList.add ("str");

        Stream<String> filterStream = myList.stream().filter(str -> str.length() ==  4)
                .filter(str -> Character.isLowerCase(str.charAt(0)));
        filterStream.forEach(str ->  System.out.println(str + " "));

    }
}
