import java.util.Scanner;

class Package {
    double packageWeight;

    public Package(double weight) {
        packageWeight = weight;
    }

    public double getShippingCost() {
        double standardPrice = 5.0;
        if (packageWeight <= standardPrice) {
            return standardPrice;
        } else {
            int poundsAboveFive = (int) Math.ceil(packageWeight - standardPrice);
            return standardPrice + poundsAboveFive;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double weight = scanner.nextDouble();

        Package myPackage = new Package(weight);
        System.out.println(myPackage.getShippingCost());
    }
}