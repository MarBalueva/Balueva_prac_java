import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class ArrayToList{
    public static <T> void array_to_list(T[] massive, List<T> list){ //конвертация массива в список
        for (T element: massive) //добавляем каждый элемент массива в список
            list.add(element);
    }

    public static <T> void print(List<T> list){ //вывод списка в консоль
        for (T element: list)
            System.out.println(element);
    }

    public static void main(String[] args) {
        //задание 1 (конвертация массива строк/чисел в список)
        System.out.println("Задание 1");
        List<Integer> list_int = new ArrayList<>(); //список, хранящий числа
        List<String> list_str = new ArrayList<>(); //список, хранящий строки
        Integer[] mass_int = new Integer[10]; //массив чисел
        String[] mass_str = new String[10]; //массив строк
        final Random rand_number = new Random();
        for (int i = 0; i < 10; i++){ //заполнение массивов
            mass_int[i] = rand_number.nextInt(100);
            mass_str[i] = "Строка_" + rand_number.nextInt(100);
        }
        array_to_list(mass_int, list_int); //преобразование массивов в список
        array_to_list(mass_str, list_str);
        System.out.println("Массив чисел, преобразованный в список:");
        print(list_int); //вывод списка
        System.out.println("Массив строк, преобразованный в список:");
        print(list_str);
    }
}

class ArrayForEveryType{
    public Object[] elements; //массив, хранящий значения любых типов
    public int size; //количество элементов массива

    public ArrayForEveryType(){ //конструктор
        elements = new Object[10]; //выделение памяти под 10 элементов
        size = 0;
    }

    public void add_to_array(Object element){ //добавить элемент в массив
        if (size < elements.length){ //если в массиве есть место
            elements[size] = element; //добавляем новый элемент
        }
        size++; //увеличиваем количество элементов
    }

    public Object get(int index){ //вернуть элемент массива по индексу
        if (index >= size) //если индекс за границами массива
            throw new IndexOutOfBoundsException("Индекс: " + index + ", Текущий размер массива: " + size); //вызываем исключение
        return (Object)elements[index]; //возвращаем нужный элемент
    }

    public static void main(String[] args) {
        //задания 2-3
        System.out.println("Задания 2-3:");
        ArrayForEveryType obj_int = new ArrayForEveryType(); //объект, хранящий массив типа integer
        ArrayForEveryType obj_str = new ArrayForEveryType(); //объект, хранящий массив типа string
        ArrayForEveryType obj_flo = new ArrayForEveryType(); //объект, хранящий массив типа double
        final Random rand_number = new Random();
        for (int i = 0; i < 10; i++){ //заполнение массивов каждого объекта
            obj_int.add_to_array(rand_number.nextInt(100));
            obj_flo.add_to_array(rand_number.nextFloat());
            obj_str.add_to_array("Строка_" + rand_number.nextInt(100));
        }
        System.out.println("Элемент с индексом 3 в массиве строк: " + obj_str.get(3));
        System.out.println("Элемент с индексом 0 в массиве целых чисел: " + obj_int.get(0));
        System.out.println("Элемент с индексом 9 в массиве чисел с плавающей точкой: " + obj_flo.get(9));
    }
}

public class Solution{
    /*public static <T> void new_array_list(ArrayList<T> array_list){

    }

    public static <T> void new_hash_map(){

    }*/

    public static void catalog_to_list(){
        File catalog = new File("D://проги джава//практика 13"); //переменная для каталога
        List list_cat = new ArrayList<>(); //список-каталог
        if (catalog.isDirectory()) { //если выбранная папка существует
            for (File item : catalog.listFiles()) //проход по ее содержимому
                list_cat.add(item); //добавляем в список
        }
        System.out.println("Список-содержание каталога:");
        for (int i = 0; i < 5; i++) //вывод первых 5ти элементов
            System.out.println(list_cat.get(i));
    }

    public static void main(String[] args) {
        //задания 4-5
        System.out.println("Задание 4:");
        catalog_to_list();
    }
}
