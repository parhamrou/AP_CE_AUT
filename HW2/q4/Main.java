import java.util.Random;

public class Main {
    public static void main(String[] args) {
        
        Random rand = new Random();
        GuessingGame guessingGame = new GuessingGame(rand.nextInt(100) + 1);
        guessingGame.gamePlay();
    }
}