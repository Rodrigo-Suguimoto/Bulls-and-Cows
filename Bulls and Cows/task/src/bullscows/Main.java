package bullscows;
import java.util.Random;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, enter the secret code's length:");
        int length = scanner.nextInt();
        String secretCode = createTheSecretCode(length);
        System.out.println(secretCode);

        if (secretCode.equals("Error")) {
            System.out.printf("Error: can't generate a secret number with a length of %d because there aren't enough unique digits.", length);
        } else {
            System.out.println("Okay, let's start a game!");
            tryUserGuesses(scanner, secretCode);
        }
    }

    public static void tryUserGuesses(Scanner scanner, String secretCode) {
        int turn = 1;
        String guess = scanner.nextLine();
        boolean isGuessRight = false;

        do {
            System.out.printf("Turn %d:", turn);
            System.out.println();
            guess = scanner.nextLine();
            isGuessRight = checkUserGuess(guess, secretCode);
            turn++;
        } while(!isGuessRight);

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
        Random random = new Random();
        int randomDigit = random.nextInt(10);
        return String.valueOf(randomDigit);
    }

    public static boolean checkUserGuess(String userGuess, String secretCode) {
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

        String bullOrBulls = bulls > 1 ? "bulls" : "bull";
        String cowOrCows = cows > 1 ? "cows" : "cow";

        if (bulls == secretCode.length()) {
            System.out.printf("Grade: %d %s", bulls, bullOrBulls);
            System.out.println(); // Blank line
            System.out.println("Congratulations! You guessed the secret code.");
            return true;
        } else {
            System.out.printf("Grade: %d %s and %d %s", bulls, bullOrBulls, cows, cowOrCows);
            System.out.println(); // Blank line
            return false;
        }
    }
}
