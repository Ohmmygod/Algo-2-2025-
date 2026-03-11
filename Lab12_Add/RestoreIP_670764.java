import java.util.*;

public class RestoreIP_670764 {

    static String input;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an input: ");
        input = sc.nextLine();

        backtrack(0, 0, "");
        sc.close();
    }

    static void backtrack(int index, int segment, String current) {

        if (segment == 4 && index == input.length()) {
            System.out.println(current.substring(0, current.length() - 1));
            return;
        }

        if (segment == 4 || index == input.length()) {
            return;
        }

        for (int len = 1; len <= 3; len++) {
            if (index + len > input.length()) break;
            String part = input.substring(index, index + len);
            if (isValid(part))
                backtrack(index + len, segment + 1, current + part + ".");
        }
    }

    static boolean isValid(String part) {

        if (part.length() > 1 && part.charAt(0) == '0')
            return false;

        int num = Integer.parseInt(part);
        return num >= 0 && num <= 255;
    }
}