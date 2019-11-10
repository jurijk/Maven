public interface CustomCollection {

    boolean add(String str);//метод с увеличением массива на 60%
    boolean addOne(String str);//метод с увеличением массива по одному элементу
    boolean addAll(Collect strColl);
    boolean delete (int index);
    boolean delete (String str);
    String get(int index);
    boolean contains(String str);
    boolean clear();
    int size();
    boolean trim();
    boolean compare(Collect coll);
}
