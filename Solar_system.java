import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solar_system {
    public static void main(java.lang.String[] args) {
        String mercury = new String("Меркурий"); //названия планет солнечной системы
        String venus = new String("Венера");
        String earth = new String("Земля");
        String mars = new String("Марс");
        String jupiter = new String("Юпитер");
        String saturn = new String("Сатурн");
        String uranus = new String("Уран");
        String neptune = new String("Нептун");

        List<String> solarSystemV1 = Collections.unmodifiableList(new ArrayList<>(Arrays.asList(mercury, venus, earth))); //немодифицированный список планет
        ArrayList<String> solarSystemV2 = new ArrayList<>(Arrays.asList(mars, jupiter)); //список планет
        System.out.println("Первый список (немодифицированный): " + solarSystemV1); //вывод первого списка(немодифицируемого)
        System.out.println("Второй список: " + solarSystemV2); //вывод второго списка

        //функция добавления элементов в список
        solarSystemV2.add(saturn); //добавление Сатурна во второй список
        solarSystemV2.add(uranus); //добавление Урана во второй список
        solarSystemV2.add(neptune); //добавление Нептуна во второй список
        System.out.println("Второй список после добавления новых планет: " + solarSystemV2); //вывод обновленного второго списка

        //функция удаления элемента из списка
        solarSystemV2.remove(neptune); //удаляем Нептун из второго списка
        System.out.println("Второй список после удаления планеты: " + solarSystemV2); //вывод обновленного второго списка

        //функция изменения элемента в списке
        solarSystemV2.set(3, "Уран 2"); //в вызове указываем индекс элемента и его новое значение
        System.out.println("Второй список после изменения планеты: " + solarSystemV2); //вывод обновленного второго списка

        //перемешивание списка
        Collections.shuffle(solarSystemV2);
        System.out.println("Второй список после перемещивания: " + solarSystemV2); //вывод обновленного второго списка

        //выбор случайной планеты
        SecureRandom random = new SecureRandom(); //объект для использования функции рандома
        String random_planet = solarSystemV2.get(random.nextInt(solarSystemV2.size())); //выбор планеты из списка по рандомному индексу
        System.out.println("Случайная планета из второго списка: " + random_planet); //вывод выбранной планеты

        //показ индекса элемента
        System.out.println("Индекс планеты Марс во втором списке: " + solarSystemV2.indexOf(mars)); //выводим индекс планеты Марс

        //проверка наличия элемента в списке
        System.out.println("Проверка наличия планеты Марс в первом списке: " + solarSystemV1.contains(mars)); //проверяем, есть ли Марс в первом списке

        //дополнительные методы
        //сортировка списка
        Collections.sort(solarSystemV2); //в классе Collections доступен метод sort - сортировка списка
        System.out.println("Второй список после сортировки: " + solarSystemV2); //вывод обновленного второго списка

        //поменять элементы списка местами
        Collections.swap(solarSystemV2, 0, 2); //в классе Collections доступен метод swap, который меняет элементы списка местами
        //при вызове указывается список и индексы элементов, которые необходимо поменять
        System.out.println("Второй список после обмена элементов с индексами 0 и 2: " + solarSystemV2); //вывод обновленного второго списка

        //проверить, есть ли совпадающие элементы у двух списков
        //в классе Collections доступен метод disjoint, в качестве аргументов которому подаются два списка
        //метод вернет значение true, если в списках нет совпадающих элементов, и false, если они есть
        if (Collections.disjoint(solarSystemV1, solarSystemV2) == true)
            System.out.println("У первого и второго списков нет совпадающих элементов");
        else
            System.out.println("У первого и второго списков есть совпадающие элементы");
    }
}
