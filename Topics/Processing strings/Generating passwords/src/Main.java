import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] passwordRequirements = scanner.nextLine().split(" ");
        StringBuilder password = new StringBuilder();

        int numberOfUppercaseLetters = Integer.parseInt(passwordRequirements[0]);
        addUppercaseLetters(password, numberOfUppercaseLetters);

        int numberOfLowercaseLetters = Integer.parseInt(passwordRequirements[1]);
        int j = 0;
        char lowercaseLetter = 'a';
        while (j < numberOfLowercaseLetters) {
            password.append(lowercaseLetter);

            if (lowercaseLetter == 'z') {
                lowercaseLetter = 'a';
            } else {
                lowercaseLetter++;
            }

            j++;
        }

        int numberOfDigits = Integer.parseInt(passwordRequirements[2]);
        int k = 0;
        int digit = 0;
        while (k < numberOfDigits) {
            password.append(digit);

            if (digit == 9) {
                digit = 0;
            } else {
                digit++;
            }
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
        char lastCharacterOfPassword = ' ';
        while (i < numberOfUppercaseLetters) {
            if (password.length() > 0) {
                lastCharacterOfPassword = password.charAt(password.length() - 1);
            }

            if (lastCharacterOfPassword == uppercaseLetter) {
                uppercaseLetter++;
                password.append(uppercaseLetter);
            } else {
                password.append(uppercaseLetter);
            }

            if (uppercaseLetter == 'Z') {
                uppercaseLetter = 'A';
            } else {
                uppercaseLetter++;
            }
            i++;
        }
    }
}