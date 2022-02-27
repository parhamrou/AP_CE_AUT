import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        ArrayList<String> strings = new ArrayList<>();
        int number = input.nextInt();
        for (int i = 0; i < Math.ceil((double) number / 2) + 1; i++) {
            String binary = "";
            for (int j = 0; j < i; j++) {
                binary += '1';
            }
            for (int j = 0; j < number - i; j++) {
                binary += '0';
            }
            recursive(binary, "", strings);  
        }
        for (int i = 0; i < strings.size(); i++) {
            System.out.print(strings.get(i));
            if (i != strings.size() - 1) {
                System.out.print(", ");
            }
        }
    }

    static void recursive(String str1, String ans, ArrayList<String> strings)
    {
        if (str1.length() == 0) {
            boolean condition = true;
            for (int i = 0; i < ans.length(); i++) {
                if (i != (ans.length() - 1) && ans.charAt(i) == '1' && ans.charAt(i + 1)  == '1') {
                    condition = false;
                    return;
                }
            }
            if (!strings.contains(ans)) {
                strings.add(ans);
                return;
            }
        }

        for (int i = 0; i < str1.length(); i++) {
            char ch = str1.charAt(i);
            String ros = str1.substring(0, i) + str1.substring(i + 1);
            recursive(ros, ans + ch, strings);
        }
    }
}