import java.util.Scanner;

public class StrNumber {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String str = scanner.nextLine();


        String teststr = "kkdddddooooeeeewww";

        char[] chars;

        chars = str.toCharArray();

//        chars = teststr.toCharArray();



        boolean[] arr = new boolean[256];

        for (char ch : chars) {
            if (!arr[ch]) {
                SymbolNum chr = new SymbolNum(ch);
                System.out.println(chr.getSymbol() + "-" + chr.countchars(chars));
                arr[ch] = true;
            }
        }

    }

    public static class SymbolNum {
        private final char symbol;
        private int number = 0;

        public SymbolNum(char symbol) {
            this.symbol = symbol;
        }

        public char getSymbol() {
            return symbol;
        }

        public int getNumber() {
            return number;
        }

        public int countchars(char[] chars) {
            for (char cha : chars) {
                if (cha == symbol) {
                    number++;
                }
            }
            return number;
        }
    }
}
