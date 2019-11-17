public class TestSearch
{
    public static void main(String[] args)
    {
        int[] mas = new int[]{55,55,55,22,21,66,88,88,44,12,77,92,92,33,45,47,62,45,67,32,39,39,80,14,11,80,91,20,20,70};
        //int[] mas= new int[]{10,11,11,12,12,22,22,24,34,34,36,36,36,41,42,50,50,61,62,63,69,74,79,80,82,81,82,85,90,91};


        InterpolSearch testSearch = new InterpolSearch();
        InsertSort testSort = new InsertSort();
        testSort.sort(mas);//сортировка массива

        int index = testSearch.interpolSearch(mas, 39);

        System.out.println("Индекс искомого элемента = " + index);



    }
}
