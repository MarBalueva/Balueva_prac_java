import java.util.Random;

public class Cat extends  Pet{
    public Cat() {
        final Random random = new Random();
        this.name = "cat_" + String.valueOf(random.nextInt(100) + 1);
    }
}
