import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class Pet {
    public String name;
    public Pet() {}
    public String getName() {
        return name;
    }

    public static void main(String[] args) {
        //задание 1: отображение из домашних животных
        System.out.println("Exercise 1");
        Map<String, Pet> hashmap = new HashMap<>(); //создаем хеш-таблицу
        hashmap.put("Dog", new Dog());
        hashmap.put("Owl", new Owl());
        hashmap.put("Cat", new Cat());
        Set<Map.Entry<String, Pet>> set = hashmap.entrySet(); //сохраняем набор элементов
        System.out.println("HashMap is created: ");
        for (Map.Entry<String, Pet> me : set){
            System.out.print(me.getKey() + ": ");
            System.out.println(me.getValue().getName());
        }
        //задание 2: количество повторов
        System.out.println("\nExercise 2");
        final Random random = new Random(100);
        Map<Integer, Integer> hashMap = new HashMap<>(); //создаем новую хеш-таблицу
        for (int i = 0; i < 100; i++){
            int number = random.nextInt(10); // генерируем число от 0 до 10
            Integer frequency = hashMap.get(number); //считаем, сколько раз число было сгенерировано
            hashMap.put(number, frequency == null ? 1 : frequency + 1); //добавляем в хеш-таблицу количество повторений и само число
        }
        System.out.println(hashMap);
    }
}
