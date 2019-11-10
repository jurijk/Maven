import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;



public class testCollect
{

    //тест времени выполнения метода который увеличивает массив на одну ячейку при добавлении элемента
    @Test
    @Timeout(value = 85, unit = TimeUnit.MILLISECONDS)

    public void testTimeOne()
    {
        Collect collect1 = new Collect();

        for (int i = 0; i < 10000; i++)
        {
            collect1.addOne("string");
        }
    }

    //тест времени выполнения метода который увеличивает массив на 60% при добавлении элемента
    @Test
    @Timeout(value = 40, unit = TimeUnit.MILLISECONDS)

    public void testTime60()
    {
        Collect collect = new Collect();

        for (int i = 0; i < 10000; i++)
        {
            collect.add("string");
        }
    }

    //тест добавления элемента в коллекцию
    @Test
    public void positiveTimeOne()
    {
        Collect collect = new Collect();
        Assertions.assertTrue(collect.addOne("string"));
    }

    //тест добавления элемента в коллекцию
    @Test
    public void positiveTime60()
    {
        Collect collect = new Collect();
        Assertions.assertTrue(collect.add("string"));
    }

    //тест успешного удаления элемента
    @Test
    public void positiveDell()
    {
        Collect collect = new Collect();
        for (int i = 0; i < 10; i++)
        {
            collect.add("string");
        }
        Assertions.assertTrue(collect.delete(5));
    }

    //тест удаления элемента, когда индекс выходит за размер коллекции
    @Test
    public void negativeDellSize()
    {
        Collect collect = new Collect();
        for (int i = 0; i < 10; i++)
        {
            collect.add("string");
        }
        Assertions.assertFalse(collect.delete(20));
    }

    //тест удаления элемента равного Null
    @Test
    public void negativeDellNull()
    {
        Collect collect = new Collect();
        for (int i = 0; i < 10; i++)
        {
            collect.add(null);
        }
        Assertions.assertFalse(collect.delete(5));
    }

    //тест удаления элемента
    @Test
    public void positiveDelStr()
    {
        Collect collect = new Collect();

        collect.add("strin");
        collect.add("strin");
        collect.add("strin");
        collect.add("strin");
        collect.add("string");

        Assertions.assertTrue(collect.delete("string"));
    }

    //тест удаления элемента, когда элемент не найден
    @Test
    public void negativeDelStr()
    {
        Collect collect = new Collect();

        collect.add("strin");
        collect.add("strin");
        collect.add("strin");
        collect.add("strin");
        collect.add("strin");

        Assertions.assertFalse(collect.delete("string"));
    }

    //тест метода Get
    @Test
    public void positiveGet()
    {
        Collect collect = new Collect();

        collect.add("st");
        collect.add("str");
        collect.add("strin");
        collect.add("string");
        collect.add("ing");

        Assertions.assertEquals(collect.get(3), "string");
    }

    //тест метода Get
    @Test
    public void negativeGet()
    {
        Collect collect = new Collect();

        collect.add("st");
        collect.add("str");
        collect.add("strin");
        collect.add("string");
        collect.add("ing");

        Assertions.assertNull(collect.get(10));
    }

    @Test
    public void testSize()
    {
        Collect collect = new Collect();
        for (int i = 0; i < 10; i++)
        {
            collect.add("string");
        }

        Assertions.assertEquals(collect.size(), 10);
    }

    @Test
    public void testClear()
    {
        Collect collect = new Collect();
        for (int i = 0; i < 10; i++)
        {
            collect.add("string");
        }

        Assertions.assertTrue(collect.clear());
    }

    //тест метода, в случае когда массив равен размеру коллекции
    @Test
    public void testTrim()
    {
        Collect collect = new Collect();
        for (int i = 0; i < 16; i++)
        {
            collect.add("string");
        }

        Assertions.assertTrue(collect.trim());
    }

    //тест метода, в случае когда массив больше размера коллекции
    @Test
    public void testTrim1()
    {
        Collect collect = new Collect();
        for (int i = 0; i < 10; i++)
        {
            collect.add("string");
        }

        Assertions.assertTrue(collect.trim());
    }

    //тест метода contains(позитивный)
    @Test
    public void positiveContain()
    {
        Collect collect = new Collect();

        collect.add("strin");
        collect.add("strin");
        collect.add("strin");
        collect.add("strin");
        collect.add("string");

        Assertions.assertTrue(collect.contains("string"));
    }

    //тест метода contains(позитивный)
    @Test
    public void negativeContain()
    {
        Collect collect = new Collect();

        collect.add("strin");
        collect.add("strin");
        collect.add("strin");
        collect.add("strin");
        collect.add("strin");

        Assertions.assertFalse(collect.contains("string"));
    }

}
