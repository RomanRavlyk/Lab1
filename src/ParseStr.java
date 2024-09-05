
public class ParseStr {

    public static void main(String[] args) {
        System.out.println();
    }

    public static int ParseCalc(final String[] str) {
        String fnum = " ";
        String secnum = " ";
        boolean issec = false;
        for (int i = 0; i < str.length; i++) {
            switch(str[i]){
                case " ":
                    i++;
                case "+":
                    i++;
                    issec = true;
                case "-":
                    i++;
                    issec = true;
                case "/":
                    i++;
                    issec = true;
                case "*":
                    i++;
                    issec = true;
                default:
                    if (issec){
                        secnum = secnum + str[i];
                    }
                    else {
                        fnum = fnum + str[i];
                    }
            }
        }
    }
}
