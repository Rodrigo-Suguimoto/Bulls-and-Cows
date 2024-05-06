import java.util.Scanner;

class Shape {

    protected String shapeName;

    public Shape(String shapeName) {
        this.shapeName = shapeName;
    }

    public String getShapeName() {
        return this.shapeName;
    }

}

// Define the derived class Rectangle
class Rectangle extends Shape {

    protected int width;
    protected int height;


    public Rectangle(String shapeName, int width, int height) {
        super(shapeName);
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String shapeName = scanner.next();
        int width = scanner.nextInt();
        int height = scanner.nextInt();

        Rectangle rectangle = new Rectangle(shapeName, width, height);

        System.out.printf("Name: %s\n", rectangle.getShapeName());
        System.out.printf("Width: %d\n", rectangle.getWidth());
        System.out.printf("Height: %d\n", rectangle.getHeight());
    }
}