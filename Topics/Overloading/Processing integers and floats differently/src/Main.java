import java.util.Scanner;

public class Main {

    public static int process(int value) {
        return value * value;
    }

    public static int process(float value) {
        return (int) Math.round(value);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read a line of input from the console
        String input = scanner.nextLine();

        try {
            Integer integerInput = Integer.parseInt(input);
            System.out.println(process(integerInput));
        } catch (NumberFormatException e) {
            Float floatInput = Float.parseFloat(input);
            System.out.println(process(floatInput));
        }
    }
}