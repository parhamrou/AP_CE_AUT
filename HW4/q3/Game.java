import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

public class Game {

    private ArrayList<Card> cards;
    private Player player1;
    private Player player2;

    // constructor
    public Game() {
        // creating and adding all the cards of the game
        Card lion = new Card("Lion", 150, 500, 1000, 900);
        Card bear = new Card("Bear", 130, 600, 900, 850);
        Card tiger = new Card("Tiger", 120, 650, 850, 850);
        Card vulture = new Card("Vulture", 100, 0, 600, 350);
        Card fox = new Card("Fox", 90, 0, 600, 350);
        Card elephant = new Card("Elephant", 50, 70, 500, 1200);
        Card wolf = new Card("Wolf", 0, 700, 700, 450);
        Card hog = new Card("Hog", 80, 0, 500, 1100);
        Card hippopotamus = new Card("Hippopotamus", 110, 0, 360, 1000);
        Card cow = new Card("Cow", 90, 100, 400, 750);
        Card rabbit = new Card("Rabbit", 80, 0, 350, 200);
        Card turtle = new Card("Turtle", 200, 0, 230, 350);

        cards = new ArrayList<>();
        cards.add(lion);
        cards.add(bear);
        cards.add(tiger);
        cards.add(vulture);
        cards.add(fox);
        cards.add(elephant);
        cards.add(wolf);
        cards.add(hog);
        cards.add(hippopotamus);
        cards.add(cow);
        cards.add(rabbit);
        cards.add(turtle);
    }

    public ArrayList<Card> getCards() {
        return cards;
    }
    /**
     * This method generates all 30 cards for each player in the beginning of the game.
     */
    private LinkedList<Card> initialRandomCards() {
        LinkedList<Card> cards = new LinkedList<>(); // LinkedList for all 30 cards of one player 
        int[] count = new int[12]; // number of cards of each animal
        Arrays.fill(count, 0); 
        Random random = new Random();
        int cardCounter = 0;
        while (cardCounter != 30) {
            int index = random.nextInt(12);
            if (count[index] < 6) {
                cards.add(this.cards.get(index)); // adding the card from source
                count[index]++; // adding to the number of cards of one animal
                cardCounter++; // adding to the number of all cards of player
            }   
        }
        return cards;
    }

    public void manageGame(boolean isRandom) {
        playerInitializer(isRandom); // setting players at first
        // setting 30 cards of each player at first 
        player1.setCards(initialRandomCards());
        player2.setCards(initialRandomCards());
        // pick 10 cards for each player
        player1.cardPicker();
        if (isRandom) {
            player2.cardPicker(isRandom); 
        } else {
            player2.cardPicker();
        }
        while (!isFinished()) {
            showCards(player1, player2);
            Attack(player1, player2);
            if (isFinished()) {
                break;
            }
            showCards(player2, player1);
            Attack(player2, player1);
        }
        System.out.println("The game is finished!");
    }   

    private void playerInitializer(boolean isRandom) {
        String name1;
        String name2;
        System.out.printf("Enter the name of player1: ");
        name1 = Main.input.nextLine();
        player1 = new Player(name1, false);
        if (isRandom == true) {
            name2 = "PC";
            player2 = new Player(name2, true);
        } else {
            System.out.printf("Enter the name of player2: ");
            name2 = Main.input.nextLine();
            player2 = new Player(name2, false);
        }
    }

    private boolean isFinished() {
        if (player1.getCardsNumber() == 0 && player2.getCardsNumber() == 0) {
            return true;
        }
        return false;
    }

    private void showCards(Player Attacker, Player defender) {
        System.out.format("%s's cards: \n", defender.getName());
        defender.showCards();
        System.out.println("\n\n\n\n");
        System.out.format("%s's cards: \n", Attacker.getName());
        Attacker.showCards();
    }

    private void Attack(Player attacker, Player defender) { // when the second player is not PC
        int totalKick = 0;
        ArrayList<Integer> attackerCards = new ArrayList<>(); // this arraylist holds the indexes of cards that we want to attack with
        System.out.printf("Enter the indexes of cards you want to attack with.\nWhen you're done, enter -1: ");
        int index = Main.input.nextInt();
        do {
            attackerCards.add(index - 1);
            if (attacker.getCards().get(index - 1).getHardKick() != 0 && attacker.getCards().get(index - 1).getNormalKick() != 0) {
                System.out.println("DO you want to attack with 1. Hard Kick   or   2. Normal kick? ");
                int choice = Main.input.nextInt();
                if (choice == 1) {
                    totalKick += attacker.getCards().get(index - 1).getHardKick();
                } else {

                    totalKick += attacker.getCards().get(index - 1).getNormalKick();
                }
            } else {

                if (attacker.getCards().get(index - 1).getHardKick() == 0) {
                    totalKick += attacker.getCards().get(index - 1).getNormalKick();
                } else {
                    totalKick += attacker.getCards().get(index - 1).getHardKick();
                }
            }
            index = Main.input.nextInt();
        } while (index != -1);
        double cost = totalKick / attackerCards.size();
        for (Integer number : attackerCards) {
            if (attacker.getCards().get(number).getEnergy() - cost <= 0) {
                // we must do something here
                return;
            }
        }
        for (Integer number : attackerCards) { // setting the new energy of each card
            attacker.getCards().get(number).setEnergy(attacker.getCards().get(number).getEnergy() - cost);
        }
        System.out.printf("Which card do you want to attack to:");
        index = Main.input.nextInt();
        defender.getCards().get(index - 1).setElixir(defender.getCards().get(index - 1).getElixir() - totalKick);
        if (defender.getCards().get(index - 1).getElixir() <= 0) {
            defender.removeCard(index);
            System.out.println("This card is dead!");
        }        
    }
}
