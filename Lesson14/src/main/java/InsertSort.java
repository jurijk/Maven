
//сортировка массива методом вставки

public class InsertSort {


    public void sort(int[] mas)
    {
        int in = 0;
        int out = 0;
        int temp = 0;

        for (out=1; out<mas.length; out++)
        {
           temp = mas[out];
           in = out;
           while (in > 0 && mas[in-1] >= temp)//поиск места вставки значения сохраненного в temp
           {
              mas[in] = mas[in-1];
              --in;
           }
           mas[in] = temp;//вставка значения из temp на своё место
        }

    }


}
