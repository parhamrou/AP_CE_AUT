import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String str = input.nextLine();
        String[] array = str.split("\\+");
        float a = Float.parseFloat(splitter(array[0], 'x'));
        float b = Float.parseFloat(splitter(array[1], 'x'));
        float c = Float.parseFloat(splitter(array[2], ')'));
        Solver.calculate(a, b, c);

    }   
    public static String splitter(String str1, char token) {
        String number = "";
        int index = 1;
        while(str1.charAt(index) != token){
            number += str1.charAt(index);
            index++;
        }
        return number;
    }

}