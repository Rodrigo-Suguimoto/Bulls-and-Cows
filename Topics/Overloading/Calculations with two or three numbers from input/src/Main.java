import java.util.*;

public class Main {
    public static int calculate(int value1, int value2) {
        return value1 * value2;
    }

    public static int calculate(int value1, int value2, int value3) {
        return (value1 + value2) * value3;
    }

    public static void processInputAndCallFunctions() {
        Scanner scn = new Scanner(System.in);
        String inputString = scn.nextLine();
        String[] strArr = inputString.split(" ");
        int[] intArr = new int[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            intArr[i] = Integer.parseInt(strArr[i]);
        }

        // Call the appropriate function depending on the number of integers in the input
        if (intArr.length == 2) {
            System.out.println(calculate(intArr[0], intArr[1]));
        } else if (intArr.length == 3) {
            System.out.println(calculate(intArr[0], intArr[1], intArr[2]));
        }
    }

    public static void main(String[] args) {
        processInputAndCallFunctions();
    }
}