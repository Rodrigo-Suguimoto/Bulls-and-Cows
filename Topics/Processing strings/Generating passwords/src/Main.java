import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] passwordRequirements = scanner.nextLine().split(" ");
        StringBuilder password = new StringBuilder();

        System.out.println(password.chars());
        int numberOfUppercaseLetters = Integer.parseInt(passwordRequirements[0]);
        addUppercaseLetters(password, numberOfUppercaseLetters);

        int numberOfLowercaseLetters = Integer.parseInt(passwordRequirements[1]);
        int j = 0;
        char lowercaseLetter = 'a';
        while (j < numberOfLowercaseLetters) {
            password.append(lowercaseLetter);
            lowercaseLetter++;
            j++;
        }

        int numberOfDigits = Integer.parseInt(passwordRequirements[2]);
        int k = 0;
        int digit = 1;
        while (k < numberOfDigits) {
            password.append(digit);
            digit++;
            k++;
        }

        int remainingCharacters = Integer.parseInt(passwordRequirements[3]) - password.length();
        if (remainingCharacters > 0) {
            addUppercaseLetters(password, remainingCharacters);
        }

        System.out.println(password);
    }

    public static void addUppercaseLetters(StringBuilder password, int numberOfUppercaseLetters) {
        int i = 0;
        char uppercaseLetter = 'A';
        while (i < numberOfUppercaseLetters) {
            if (uppercaseLetter == password.charAt(password.length() - 1)) {
                uppercaseLetter++;
            }

            password.append(uppercaseLetter);
            uppercaseLetter++;
            i++;
        }
    }
}