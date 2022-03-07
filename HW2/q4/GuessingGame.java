import java.util.Random;
import java.util.Scanner;


public class GuessingGame {
    private int number;

    public GuessingGame(int number) {
        this.number = number;
    }

    public void gamePlay() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter a number between 1 and 100:");

        for (int i = 0; i < 7; i++) {
            int guess = input.nextInt();
            if (guess == number) { // user guessed the number correctly
                System.out.println("You guessed the number!");
                return;
            } else if (guess < number) {
                System.out.println("Your guess is too low.");
            } else {
                System.out.println("Your guess is too high.");
            } 
        }
        //user didn't guess the number
        System.out.println("You have used up all your guesses.");
        return;
    }
}
