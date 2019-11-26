import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Game
{


    public static void main(String[] args) throws IOException
    {
        int [][]mas =  {{0,0,0,0},
                        {0,2,0,1},
                        {0,1,2,0},
                        {0,0,1,2}};
        int countHum = 0;
        int countBot = 0;
        int winWin = 0;

            System.out.println("Выберете количество раундов");
            Scanner scanner = new Scanner(System.in);
            int game = scanner.nextInt();

            for (int i = 0; i < game; i++)
            {
                System.out.println("Сделайте выбор");
                System.out.println("1 - Камень, 2 - Ножницы, 3 - Бумага, 0 = exit");

                Scanner scanner1 = new Scanner(System.in);
                int human = scanner1.nextInt();

                if(human==0 ) {
                    scanner1.close();
                    scanner.close();
                    System.out.println("Игра прервана пользователем");
                    break;
                } else if (human < 0 || human > 3) {
                    scanner1.close();
                    scanner.close();
                    System.out.println("Введено не верное значение");
                    break;
                } else {
                    double bot = Math.random();
                    int botInt;

                    if (bot > 0 && bot <= 0.333333) botInt = 1;//Камень
                    else if (bot > 0.333333 && bot <= 0.666666) botInt = 2;//Ножницы
                    else botInt = 3;//Бумага
                    System.out.println("Ход компьютера " + botInt);

                    int res = mas[botInt][human];
                    if (res == 2) {
                        winWin++;
                    } else if (res == 1) {
                        countHum++;
                    } else {
                        countBot++;
                    }
                }
            }
            File myFile = new File("MyFile.txt");
            FileWriter fw = new FileWriter( myFile, true );
            System.out.println("Ничьих " + winWin);
            System.out.println("Количество Ваших побед " + countHum);
            System.out.println("Количество побед компьютера " + countBot);
            fw.write("Количество Ваших побед " + countHum+"\n" + "Количество побед компьютера " + countBot+"\n");

                if (countBot == countHum){
                    System.out.println("Ничья в общем зачете");
                    fw.write("Ничья в общем зачете\n");
                } else if (countBot > countHum) {
                    System.out.println("Выиграл компьютер");
                    fw.write("Выиграл компьютер\n");
                } else { System.out.println("Выиграли Вы");
                fw.write("Выиграли Вы\n");
                }
                fw.close();
        scanner.close();
    }
}
