import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class Checker
{
    public static void main(String[] args)
    {
        List<Character> chars = new ArrayList<>();
        List<String> strings = new ArrayList<>();
        Stack<Character> stack = new Stack<>();
        Stack<String> stackstr = new Stack<>();

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(new File("Test.xml")));

            int c;
            while ((c = reader.read()) != -1) { //создание коллекции чаров из входного файла
                chars.add((char) c);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        boolean flag2 = false;
        for (char ch:chars)
        {
            if (ch == '<') stack.push('<'); //проверка парности угловых скобок
            else if (ch == '>' && !stack.empty()) stack.pop();
            flag2 = stack.empty();
        }

        StringBuffer buffer = new StringBuffer();
        boolean flag = false;
        for (char ch:chars) //выделение тэгов из текста файла и создание коллекции стрингов
        {
            if (flag) {
                buffer.append(ch);
            }
            if (ch == '<')
            {
                flag = true;
                buffer.append('<');
            }
            else  if (ch == '>')
            {
                String str = buffer.toString();
                buffer.setLength(0);
                strings.add(str);
                buffer.setLength(0);
                flag = false;
            }
        }
        Iterator<String> itr = strings.listIterator();
        while (itr.hasNext())
        {
            String elem = itr.next(); //удаление строки с информацией о версии xml файла
            if (elem.startsWith("<?") && elem.endsWith("?>")) itr.remove();
        }
        int sum = 0;
        boolean flag1 = false;
        try {
            for (String s : strings) {
                if (s.charAt(1) != '/') stackstr.push(s);
                else if (s.charAt(1) == '/') {
                    String str = stackstr.peek(); //сравнение названий тэгов и проверка парности открывающего и закрывающего тэгов
                    int i = str.substring(1, str.length()).compareTo(s.substring(2, s.length()));
                    if (i == 0) stackstr.pop();
                    sum += Math.abs(i);
                    if (sum == 0) flag1 = true;
                    else flag1 = false;
                    //System.out.println(sum);
                    //System.out.println(flag1);
                }
            }
        }catch (StringIndexOutOfBoundsException ex) {flag1 = false;}
        if (flag2 && flag1) System.out.println("В проверяемом файле тэги расставленны правильно");
        else System.out.println("В проверяемом файле тэги расставленны не правильно");
    }
}


