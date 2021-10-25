import java.lang.*;
public class Ball {
    private String color;
    private int radius;

    public Ball(String color, int radius) {
        this.radius = radius;
        this.color = color;
    }
    public Ball(int radius) {
        this.radius = radius;
        color = "white";
    }
    public Ball(String color) {
        this.color = color;
        radius = 0;
    }
    public Ball() {
        color = "black";
        radius = 1;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public int getRadius() {
        return radius;
    }
    public void setRadius(int radius) {
        this.radius = radius;
    }
    public String toString() {
        return color + " color" + ", radius = " + radius;
    }
}
