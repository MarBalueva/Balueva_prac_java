import java.lang.*;
public class Test {
    public static void main(String[] args) {
        Books b1 = new Books("Prestuplenie i nakazanie", "Dostoevskiy F.M.");
        Books b2 = new Books("Anna Karenina");
        Books b3 = new Books();
        b2.setAuthor("Tolstoy L.N.");
        System.out.println("class Books:");
        System.out.println(b1.toString());
        System.out.println(b2.toString());
        System.out.println(b3.toString());

        Ball ba1 = new Ball("blue", 10);
        Ball ba2 = new Ball("red");
        Ball ba3 = new Ball();
        ba2.setRadius(12);
        System.out.println("class Ball:");
        System.out.println(ba1.toString());
        System.out.println(ba2.toString());
        System.out.println(ba3.toString());
    }
}
