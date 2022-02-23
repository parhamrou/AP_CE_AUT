import java.util.Scanner;

public class Main {

	public static void main(String[] argv) {
		Scanner input = new Scanner(System.in);

		String number = input.nextLine();
		char[] array = number.toCharArray();
		Boolean flag = false;
		int i;
		for (i = array.length - 1; i > 0; i--) {
			if (array[i-1] < array[i]) {
				flag = true;
				break;
			}
		}

		if (flag == false) {
			System.out.println(-1);
		} else {
			int index = 0;
			int bigger = 10;
			int j;
			for (j = i; j < array.length; j++) {
				if (array[j] > array[i - 1] && Character.getNumericValue(array[j]) < bigger) {
					bigger = array[j];
					index = j;
				}	
			}

			swap(array, index, i - 1);
			sort(array, i);

			System.out.println(Integer.parseInt(new String(array)));
		}
	}
	public static void swap(char[] array, int index1, int index2) {
		
		char temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	
	}

	public static void sort(char[] array, int index) {
		
		for (int i = index; i < array.length - 1; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] < array[i])
					swap(array, j, i);
			}
		}
	}
}
