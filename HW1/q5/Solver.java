public class Solver {

    public static void calculate(float a, float b, float c) {
        float delta = (b * b) - (4 * a * c);
        if (delta < 0) {
            System.out.printf("Roots are not real");
        } else if (delta == 0.0) {
            float root1 = -b / (2 * a);
            System.out.printf("%.2f", root1);
        } else {
            float root1 = (float) (-b + Math.sqrt(delta)) / (2 * a);
            float root2 = (float) (-b - Math.sqrt(delta)) / (2 * a);
            System.out.printf("%.2f\n%.2f", root1, root2);
        }
    }
}
