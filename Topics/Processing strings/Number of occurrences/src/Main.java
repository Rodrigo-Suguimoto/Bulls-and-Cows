import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String pattern = scanner.nextLine();
        int lastIndex = 0;
        int count = 0;

        while (lastIndex != -1) {
            lastIndex = str.indexOf(pattern, lastIndex);

            if (lastIndex != -1) {
                count++;
                lastIndex += pattern.length();
            }
        }

        System.out.println(count);
    }
}