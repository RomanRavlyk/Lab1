import java.util.Scanner;

public class Converter {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter exchange value, like (600 UAH into USD or 500 USD from UAH): ");
        String str = scanner.nextLine();
        String wrds[] = str.split(" ");

        double amount1 = checknum(wrds);
        double convertedNumber1 = convert(wrds, amount1);

        System.out.println("Converted amount: " + convertedNumber1);

        String testStr = "600 UAH into CANUSD";
        String[] words = testStr.split(" ");

        double amount = checknum(words);
        double convertedNumber = convert(words, amount);

        System.out.println("Converted amount: " + convertedNumber);
    }

    public static double checknum(final String[] str) {
        StringBuilder number = new StringBuilder();

        for (String s : str) {
            if (isNumeric(s)) {
                number.append(s);
            }
        }

        return Double.parseDouble(number.toString());
    }

    public static boolean isNumeric(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static double convert(String[] str, double amount) {
        boolean hasUAH = false;
        boolean hasUSD = false;
        boolean hasCANUSD = false;
        boolean hasEUR = false;

        boolean convertingFrom = false;

        for (String s : str) {
            if (s.equalsIgnoreCase("UAH")) {
                hasUAH = true;
            } else if (s.equalsIgnoreCase("USD")) {
                hasUSD = true;
            } else if (s.equalsIgnoreCase("CANUSD")) {
                hasCANUSD = true;
            } else if (s.equalsIgnoreCase("EUR")) {
                hasEUR = true;
            } else if (s.equalsIgnoreCase("into")) {
                convertingFrom = true;
            }
        }

        if (hasUAH && hasUSD) {
            if (convertingFrom) {                   // UAH to USD
                amount = amount / 40;
                System.out.println("Conversion: UAH to USD");
            } else {                                // USD to UAH
                amount = amount * 40;
                System.out.println("Conversion: USD to UAH");
            }
        } else if (hasUAH && hasCANUSD) {
            if (convertingFrom) {                   // UAH to CANUSD
                amount = amount / 50;
                System.out.println("Conversion: UAH to CANUSD");
            } else {                                // CANUSD to UAH
                amount = amount * 50;
                System.out.println("Conversion: CANUSD to UAH");
            }
        } else if (hasUAH && hasEUR) {
            if (convertingFrom) {                   // UAH to EURO
                amount = amount / 45;
                System.out.println("Conversion: UAH to EUR");
            } else {                                // EURO to UAH
                amount = amount * 45;
                System.out.println("Conversion: EUR to UAH");
            }
        } else {
            System.out.println("Nothing to convert!");
        }

        return amount;
    }
}