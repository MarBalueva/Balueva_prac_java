public class Square extends Rectangle{
    public Square() {
    }

    public Square(double side){
        length = side;
        width = side;
    }

    public Square(double side, String color, boolean filled){
        length = side;
        this.color = color;
        this.filled = filled;
    }

    public double getSide(){
        return length;
    }

    public void setSide(double side){
        this.length = side;
    }

    @Override
    public void setLength(double length) {
        super.setLength(length);
    }

    @Override
    public void setWidth(double width) {
        super.setWidth(width);
    }

    @Override
    public String toString(){
        return "Shape: square, side: " + this.length;
    }
}
