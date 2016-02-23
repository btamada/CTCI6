import java.util.Scanner;

public class ExcelSheetColumnNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(titleToNumber(sc.nextLine()));
    }

    // A -> 1
    // Z -> 26
    // AA -> 27
    // AB -> 28
    // ...
    static int titleToNumber(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            result = result * 26 + (s.charAt(i) - 'A' + 1);
        }
        return result;
    }

}
