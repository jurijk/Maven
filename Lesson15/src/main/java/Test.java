import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Test
{
    public static void main(String[] args)
    {
        System.out.println("Введите число:");
        Scanner scan = new Scanner(System.in);
        String num = scan.nextLine();

        char[] str = String.valueOf(num).toCharArray();

        List<Number> numbers = new LinkedList<>();
        for (char ch : str)
        {
            if (Character.isDigit(ch))
            {
                switch (ch) {
                    case '0':
                        numbers.add(new Zero());
                        break;
                    case '1':
                        numbers.add(new One());
                        break;
                    case '2':
                        numbers.add(new Two());
                        break;
                    case '3':
                        numbers.add(new Three());
                        break;
                    case '4':
                        numbers.add(new Four());
                        break;
                    case '5':
                        numbers.add(new Five());
                        break;
                    case '6':
                        numbers.add(new Six());
                        break;
                    case '7':
                        numbers.add(new Seven());
                        break;
                    case '8':
                        numbers.add(new Eight());
                        break;
                    case '9':
                        numbers.add(new Nine());
                        break;
                }
            }else System.out.println("Это не число");
        }

        for (Number n:numbers)
        {
            n.str1();
        }
        System.out.println();

        for (Number n:numbers)
        {
            n.str2();
        }
        System.out.println();

        for (Number n:numbers)
        {
            n.str3();
        }
        System.out.println();

        for (Number n:numbers)
        {
            n.str4();
        }
        System.out.println();

        for (Number n:numbers)
        {
            n.str5();
        }
        System.out.println();

        for (Number n:numbers)
        {
            n.str6();
        }
        System.out.println();


        for (Number n:numbers)
        {
            n.str7();
        }
        System.out.println();

    }
}
