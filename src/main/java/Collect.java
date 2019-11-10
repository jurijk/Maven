
import java.util.Arrays;

public class Collect implements CustomCollection
{
    static int size = 16; //размер массива
    static int counter = 0; //количество элементов в массиве (коллекции)
    static String [] mas = new String[size];


    public boolean add(String string)   //метод добавляющий один элемент
    {
        for (int i = 0; i < mas.length; i++)
        {
            if (mas[i] == null) //поиск первой свободной ячейки в массиве

            {
                mas[i] = string;
                counter++;
                break;
            }
        }
        if (counter == mas.length - 1) //увеличение размера массива
        {
            size = (int) (size + (size * 0.6));
            String[] collectemp = Arrays.copyOf(mas, size);
            mas = collectemp;
        }
        return true;
    }

    public boolean addOne(String string)
    {
        for (int i = 0; i < mas.length; i++)
        {
            if (mas[i] == null) //поиск первой свободной ячейки в массиве

            {
                mas[i] = string;
                counter++;
                break;
            }
        }
        if (counter == mas.length - 1) //увеличение размера массива
        {
            size = size + 1;
            String[] collectemp = Arrays.copyOf(mas, size);
            mas = collectemp;
        }
        return true;
    }


    public boolean addAll(Collect strColl)
    {
        boolean flag = false;
        int size1 = this.size() + strColl.size();//количество элементов в новом массиве

        String[] collectemp = Arrays.copyOf(mas, size1); //создание массива требуемого размера
        mas = collectemp;

        for (int i = this.size(); i < mas.length; i++)
        {
            mas[i] = strColl.get(i - this.size());
            counter++;
            if (i == mas.length-1) flag = true;
        }

        return flag;
    }

    public String get(int index){ //метод получения элемента по индексу
        if (index < this.size())
        {
            if (mas[index] != null)
            {
                return mas[index];
            }
            else return null;
        }
        return null;
    }

    public boolean delete(int index){ //метод удаления элемента по индексу
        if (index < this.size())
        {
            if (mas[index] != null)
            {
                for (int i = index; i < mas.length - 1; i++)
                {
                    mas[i] = mas[i + 1];
                }
                counter--;
                return true;
            } else return false;
        }
        return false;
    }

    public boolean delete(String str)//метод удаления элемента по значению
    {
        boolean flag = false;
        int index = 0;// эта переменная указывает место в массиве где найдено совпадение
        for (int i = 0; i < counter; i++)
        {
            if (mas[i] == str)
            {
                flag = true;
                if (index == 0) index = 1;
                else index = i;
                counter--;
                break;
            }
        }
        if (flag )
        {
            for (int i = index - 1; i < mas.length - 1; i++)
            {
                mas[i] = mas[i + 1];
            }
        }
        return flag;
    }

    public int size() //метод получения размера коллекции
    {
        return counter;
    }

    public boolean clear(){  //метод очистки массива
        for (int i = 0; i < mas.length; i++){
            mas[i] = null;
            counter = 0;
        }
        return true;
    }

    public boolean trim(){ //метод обрезки массива под размер коллекции
        if (this.size() == mas.length) return true;
        else
        {
            String [] collectemp = Arrays.copyOf(mas, this.size());
            mas = collectemp;
        }
        return true;
    }

    public boolean contains(String str) //метод проверки наличия элемента
    {
        boolean flag = false;
        for (int i=0; i<counter; i++)
        {
            if (mas[i] == str)
            {
                flag = true;
                break;
            }
        }
        return flag;
    }

    public boolean compare(Collect coll)//метод сравнения двух коллекций
    {
        int count1=0;
        if (counter != coll.size())
        {
            for (int i = 0; i < counter; i++)
            {
                if (mas[i] == coll.get(i))
                {
                    count1++;
                }
            }
            if (counter == count1)
            {
                return true;
            }
            else return false;
        }
        return false;
    }

    public static void main(String[] args)
    {
        long time = System.nanoTime();
        Collect collect = new Collect();

        for (int i = 0; i < 10000; i++)
        {
            collect.add("string");
        }
        time = System.nanoTime() - time;
        System.out.printf("Elapsed 60 percent %,9.3f ms\n", time/1_000_000.0);

        long time1 = System.nanoTime();
        Collect collect1 = new Collect();

        for (int i = 0; i < 10000; i++)
        {
            collect1.addOne("string");
        }
        time1 = System.nanoTime() - time1;
        System.out.printf("Elapsed one %,9.3f ms\n", time1/1_000_000.0);
    }


}
