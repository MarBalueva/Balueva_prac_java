import java.util.Random;

public class Owl extends Pet{
    public Owl() {
        final Random random = new Random();
        this.name = "owl_" + String.valueOf(random.nextInt(100) + 1);
    }
}
