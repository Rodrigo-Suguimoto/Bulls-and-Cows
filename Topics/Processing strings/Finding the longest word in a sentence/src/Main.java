import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sentence = scanner.nextLine();
        String[] arrayOfStrings = sentence.split(" ");
        String longestWord = "";

        for (String word : arrayOfStrings) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }

        System.out.println(longestWord);
    }
}