import java.util.Scanner;

public class ParseStr {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter an expression: ");
        String expression = scanner.nextLine();
        System.out.println("Result: " + ParseCalc(expression));

        System.out.println("Result: " + ParseCalc("9 - 4"));
        scanner.close();
    }

    public static int ParseCalc(final String str) {
        String fnum = " ";
        String secnum = " ";
        char operator = ' ';
        boolean issec = false;
        int res = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            switch (ch) {
                case '+':
                    operator = '+';
                    issec = true;
                    break;
                case '-':
                    operator = '-';
                    issec = true;
                    break;
                case '*':
                    operator = '*';
                    issec = true;
                    break;
                case '/':
                    operator = '/';
                    issec = true;
                    break;
                default:
                    if (issec) {
                        secnum += ch;
                    } else {
                        fnum += ch;
                    }
            }
        }


        int num1 = Integer.parseInt(fnum.trim());
        int num2 = Integer.parseInt(secnum.trim());

        switch (operator) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num1 - num2;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                if (num2 != 0) {
                    res = num1 / num2;
                } else {
                    System.out.println("Division by zero!");
                }
                break;
        }
        return res;
    }
}
