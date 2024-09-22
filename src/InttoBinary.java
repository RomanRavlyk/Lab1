import java.util.Scanner;


public class InttoBinary {

    public static void main(final String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a number: ");
        final int num = scanner.nextInt();
        System.out.println("Your binary num: " + convert(num));

        String result = convert(1289);
        System.out.println("Your binary num: " + result);

        scanner.close();
    }

    public static String convert(int number) {

        String binarynum = "";

        while (number != 0) {
            int last = number % 2;
            number = number / 2;
            binarynum = last + binarynum;
        }

        return binarynum;
    }
}
