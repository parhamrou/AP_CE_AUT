import java.util.Arrays;
import java.util.Scanner;


public class Main {
	
	private static int rec1x1, rec1x2, rec1y1, rec1y2;
	private static int rec2x1, rec2x2, rec2y1, rec2y2;

	public static void main(String[] argv) {
		
		CorRec1();
		CorRec2();

		if ((rec1x1 > Math.max(rec2x1, rec2x2) && rec1x2 > Math.max(rec2x1, rec2x2)) || 
			(rec1x1 < Math.min(rec2x1, rec2x2) && rec1x2 < Math.min(rec2x1, rec2x2))) {
				
			System.out.println("False");
			
		} else if ((rec1y1 > Math.max(rec2y1, rec2y2) && rec1y2 > Math.max(rec2y1, rec2y2)) || 
			(rec1y1 < Math.min(rec2y1, rec2y2) && rec1y2 < Math.min(rec2y1, rec2y2))) {
				
			System.out.println("False");
			
		} else {
			System.out.println("True");

			int[] arrayX = {rec1x1, rec1x2, rec2x1, rec2x2};
			int[] arrayY = {rec1y1, rec1y2, rec2y1, rec2y2};
			Arrays.sort(arrayX);
			Arrays.sort(arrayY);
			int result = Math.abs((arrayX[1] - arrayX[2]) * (arrayY[1] - arrayY[2]));
			System.out.println(result);
		}
	}

	public static void CorRec1() {
		Scanner input = new Scanner(System.in);

		for (int i = 0; i < 4; i++) {
			String string = input.next();
			String[] array = string.split(",");
			if(i == 0) {
				rec1x1 = Integer.parseInt(array[0]);
				rec1y1 = Integer.parseInt(array[1]);
			} else {
				int xTemp = Integer.parseInt(array[0]);
				int yTemp = Integer.parseInt(array[1]);
				if (xTemp != rec1x1) {
					rec1x2 = xTemp;
				}
				if (yTemp != rec1y1) {
					rec1y2 = yTemp;
				}
			}
		}
	}
	public static void CorRec2() {
		Scanner input = new Scanner(System.in);

		for (int i = 0; i < 4; i++) {
			String string = input.next();
			String[] array = string.split(",");
			if(i == 0) {
				rec2x1 = Integer.parseInt(array[0]);
				rec2y1 = Integer.parseInt(array[1]);
			} else {
				int xTemp = Integer.parseInt(array[0]);
				int yTemp = Integer.parseInt(array[1]);
				if (xTemp != rec2x1) {
					rec2x2 = xTemp;
				}
				if (yTemp != rec2y1) {
					rec2y2 = yTemp;
				}
			}
		}
	}
}