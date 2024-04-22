
class Box {

    double height;
    double width;
    double length;

    boolean test;

    public double getVolume() {
        return this.length * this.width * this.height;
    }

    public boolean getTest() {
        return this.test;
    }
}

public class Main {
    public static void main(String[] args) {
        Box myBox = new Box();
        System.out.println(myBox.getTest());
    }
}