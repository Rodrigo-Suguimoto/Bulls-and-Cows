package bullscows;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String secretCode = createTheSecretCode();
        Scanner scanner = new Scanner(System.in);
        String userGuess = scanner.nextLine();
        int bulls = 0;
        int cows = 0;

        for (int i = 0; i < userGuess.length(); i++) {
            char digit = userGuess.charAt(i);

            if (secretCode.indexOf(digit, i) == i) {
                bulls++;
            } else if (secretCode.indexOf(digit) != -1) {
                cows++;
            }
        }

        printGrade(bulls, cows, secretCode);
    }

    public static String createTheSecretCode() {
        String firstDigit = createRandomDigit();
        String secondDigit = createRandomDigit();
        String thirdDigit = createRandomDigit();
        String fourthDigit = createRandomDigit();

        return firstDigit + secondDigit + thirdDigit + fourthDigit;
    }

    public static String createRandomDigit() {
        int randomDigit = (int) (Math.random() * 10);
        return String.valueOf(randomDigit);
    }

    public static void printGrade(int bulls, int cows, String secretCode) {
        if (bulls == 0 && cows == 0) {
            System.out.printf("Grade: None. The secret code is %s.", secretCode);
        } else {
            System.out.printf("Grade: %d bull(s) and %d cow(s). The secret code is %s.", bulls, cows, secretCode);
        }
    }
}
