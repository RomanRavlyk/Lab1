
public class InttoBinary {

    public static void main(String[] args) {
        String result = convert(1289);
        System.out.println(result);

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
