import java.util.Scanner;

public class NumberTriplet {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            int number = scanner.nextInt();

            if (number < 7 || number == 9) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
                if (number % 3 == 0) {
                    System.out.println(1 + " " + 4 + " " + (number - 5));
                } else if (number % 3 == 1) {
                    System.out.println(1 + " " + 2 + " " + (number - 3));
                } else {
                    System.out.println(2 + " " + 3 + " " + (number - 5));
                }
            }
        }

        scanner.close();
    }
}
