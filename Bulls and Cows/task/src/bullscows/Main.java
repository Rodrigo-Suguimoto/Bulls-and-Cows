package bullscows;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        String secretCode = createTheSecretCode(length);

        if (secretCode.equals("Error")) {
            System.out.printf("Error: can't generate a secret number with a length of %d because there aren't enough unique digits.", length);
        } else {
            System.out.printf("The random secret number is %s", secretCode);
        }

//        String userGuess = scanner.nextLine();

//        printGrade(userGuess, secretCode);
    }
    public static String createTheSecretCode(int length) {
        if (length > 10) {
            return "Error";
        }

        StringBuilder secretCode = new StringBuilder();

        // First Digit can't be 0
        String firstDigit;
        do {
            firstDigit = createRandomDigit();
        } while (firstDigit.equals("0"));
        secretCode.append(firstDigit);

        while (secretCode.length() < length) {
            String randomDigit = createRandomDigit();
            if (secretCode.indexOf(randomDigit) == -1) {
                secretCode.append(randomDigit);
            }
        }

        return secretCode.toString();
    }

    public static String createRandomDigit() {
        int randomDigit = (int) (Math.random() * 10);
        return String.valueOf(randomDigit);
    }

    public static void printGrade(String userGuess, String secretCode) {
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

        if (bulls == 0 && cows == 0) {
            System.out.printf("Grade: None. The secret code is %s.", secretCode);
        } else {
            System.out.printf("Grade: %d bull(s) and %d cow(s). The secret code is %s.", bulls, cows, secretCode);
        }
    }
}
