import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String flavor = scanner.next();

        System.out.println(DonutStore.sellDonut(flavor));
    }
}

class Donut {

    String flavor;
    double price;

    public Donut(String flavor) {
        this.flavor = flavor;

        double chocolatePrice = 1.5;
        double vanillaPrice = 1.0;
        double defaultPrice = 0.0;

        switch (this.flavor) {
            case "chocolate":
                this.price = chocolatePrice;
                break;
            case "vanilla":
                this.price = vanillaPrice;
                break;
            default:
                this.price = defaultPrice;
                break;
        }
    }

    public double getPrice() {
        return this.price;
    }
}

class DonutStore {

    public static double sellDonut(String flavor) {
        Donut donut = new Donut(flavor);
        return donut.getPrice();
    }

}