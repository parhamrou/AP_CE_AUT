import java.util.Scanner;

public class Main {
	public static void main(String[] argv) {
		Scanner input = new Scanner(System.in);

		String string = input.nextLine();
		char[] array = string.toCharArray();

		String words = input.nextLine();
		String[] wordsArray = words.split(" ");

		// if number of char's is not equal to number of words
		if (wordsArray.length != array.length) {
			System.out.println("False");
			return;
		}

		Boolean condition = true;
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] == array[j]) {
					if (!wordsArray[i].equals(wordsArray[j])) {
						condition = false;
						break;
					} 
				} else {
					if (wordsArray[i].equals(wordsArray[j])) {
						condition = false;
					break;	
					}
				}
			}
			if (condition == false) {
				break;
			}
		}

		if (condition == false) {
			System.out.println("False");
		} else {
			System.out.println("True");
		}
	}
}
