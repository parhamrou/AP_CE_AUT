import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int Q, N;
        Q = input.nextInt();
        N = input.nextInt();
        Cinema cinema = new Cinema(N);
        int l, r, x;

        for (int i = 0; i < Q; i++) {
            l = input.nextInt();
            r = input.nextInt();
            x = input.nextInt();
            if (!(r > 0) || !(r < 11) || !(l > 0) || !(l < 11) || !(x > 0) || !(x < N + 1)) {
                System.out.println("false");
                continue;
            }
            if (cinema.checkChairs(l, r, x) == true) {
                cinema.occupyChairs(l, r, x);
                System.out.println("true");
            } else {
                System.out.println("false");
            }
        }
    }
}
