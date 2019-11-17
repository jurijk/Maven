public class InterpolSearch

    //Метод выполняющий интерполяционный поиск
{
    public int interpolSearch(int[] sortMas, int find)
    {
        if (sortMas.length == 0) return -1;//проверка, что размер массива больше нуля

        int mid = 0;//индекс разделения массива
        int start = 0;
        int end = sortMas.length - 1;

        System.out.print("Индекс элемента   ");
        for (int i=0; i< sortMas.length; i++)
        {
            System.out.printf("%3d", i);
        }
            System.out.println();

        System.out.print("Значение элемента ");
        for (int i=0;i< sortMas.length; i++)
        {
            System.out.printf("%3d",sortMas[i] );
        }
        System.out.println();
        System.out.println("Искомый элемент " + find);


        if (sortMas[start] == find) return start;//искомое число совпадает с первым элементом массива
        if (sortMas[end] == find) return end;//искомое число совпадает с последним элементом массива

        while (sortMas[start] <= find && sortMas[end] >= find)
        {
            mid = start + ((find - sortMas[start]) * (end - start)) / (sortMas[end] - sortMas[start]);
            System.out.println("mid= " + mid);

            if (sortMas[mid] < find)
            {
                start = mid + 1;
                System.out.println("start= " + start);
            }
            else if (sortMas[mid] > find)
            {
                end = mid - 1;
                System.out.println("end= " + end);
            }
            else return mid;

        }
        return -1; // число не найдено
    }

}


