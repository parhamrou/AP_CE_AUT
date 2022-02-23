import java.util.Scanner;

public class Main {
	public static void main(String[] argv) {
		Scanner input = new Scanner(System.in);

		String binary = input.nextLine();
		char[] array = binary.toCharArray();
		int oneCounter = 0;

		for (int i = 0; i < array.length; i++) {
			if (array[i] == '1') {
				oneCounter++;
			}
		}

		if (oneCounter == 0) {
			System.out.println((2 + factiroal(array.length - 3)) / (factiroal(2) * factiroal(array.length - 3)));
		
		} else if (oneCounter % 3 != 0) {
			System.out.println(0);
		
		} else {
			int twoPow = 0;
			int counter = 0;
			Boolean condition = false;
			for (int i = 0; i < array.length; i++) {
				if (array[i] == '1') {
					if (counter != oneCounter - 1) {
					condition = true;
					counter++;
					} else {
					condition = false;
					}

				} else {
					if (condition == true) {
						twoPow++;	
					}
				}
			}
			System.out.println((int) Math.pow(2, twoPow));
		}
	}
	public static int factiroal(int number) {
		int result = 1;
		for (int i = 1; i < number + 1; i++) {
			result *= i;
		}

		return result;
	}
}
