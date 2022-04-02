import java.util.Scanner;

public class Main {
    public final static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        int choice1;
        firstMenu();
        System.out.printf("\t\t\t\t\t");
        choice1 = input.nextInt();
        while (choice1 != 2) {
            if (choice1 == 1) { // New game
                Game.clearScreeen();
                secondMenu();
                System.out.printf("\t\t\t\t\t");
                int choice2 = input.nextInt();
                if (choice2 == 1) {
                    Game game = new Game(false);
                    game.manageGame();
                } else if (choice2 == 2) {
                    Game game = new Game(true);
                    game.manageGame();
                } else {
                    System.out.println("Invalid input!");
                }
            
            } else {
                System.out.println("Invalid input.");
                System.out.println("Press enter to back to menu!");
                input.nextLine();
            }
            firstMenu();
        }
    }

    public static void firstMenu() {
        System.out.println("\t\t\t\t\t1. New game");
        System.out.println("\t\t\t\t\t2. Exit");
    }

    public static void secondMenu() {
        System.out.println("\t\t\t\t\tDo you want to play with: 1. Your friend    2. PC");
    }
}