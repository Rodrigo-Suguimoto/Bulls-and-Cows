package bullscows;
import java.util.Scanner;

class SecretCode {

    private String secretCode;
    private final String symbols = "0123456789" + "abcdefghijklmnopqrstuvwxyz";

    public SecretCode(int length, int numberOfPossibleSymbols) {
        if (length > 36) {
            this.secretCode = "Error";
        }

        StringBuilder secretCode = new StringBuilder();

        while (secretCode.length() < length) {
            String randomDigit = createRandomDigit(numberOfPossibleSymbols);
            if (secretCode.indexOf(randomDigit) == -1) {
                secretCode.append(randomDigit);
            }
        }

        this.secretCode = secretCode.toString();
    }

    public String getSecretCode() {
        return this.secretCode;
    }

    private String createRandomDigit(int numberOfPossibleSymbols) {
        int randomIndex = (int) (numberOfPossibleSymbols * Math.random());
        char randomDigit = this.symbols.charAt(randomIndex);

        return String.valueOf(randomDigit);
    }

    public String getPossibleSymbols(int numberOfPossibleSymbols) {
        String possibleSymbols = this.symbols.substring(0, numberOfPossibleSymbols);
        String formattedResult = "";

        if (numberOfPossibleSymbols <= 10) {
            formattedResult = String.format("(0-%s)",
                    possibleSymbols.charAt(possibleSymbols.length() - 1));

            return formattedResult;
        } else {
            formattedResult = String.format("(0-10, a-%s)",
                    possibleSymbols.charAt(possibleSymbols.length() - 1)
                    );

            return formattedResult;
        }
    }

}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the length of the secret code:");
        int length = scanner.nextInt();
        System.out.println("Input the number of possible symbols in the code:");
        int numberOfPossibleSymbols = scanner.nextInt();

        SecretCode secretCodeObject = new SecretCode(length, numberOfPossibleSymbols);
        String secretCode = secretCodeObject.getSecretCode();
        String possibleSymbols = secretCodeObject.getPossibleSymbols(numberOfPossibleSymbols);
        System.out.printf("The secret code is prepared: %s %s.\n", "*".repeat(secretCode.length()), possibleSymbols);

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
