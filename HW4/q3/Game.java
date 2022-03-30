import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

public class Game {

    private ArrayList<Card> cards;
    private Player player1;
    private Player player2;
    private boolean isPC;
    private int roundCounter;

    // constructor
    public Game(boolean isPC) {
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

        this.isPC = isPC;
        this.roundCounter = 1;
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
                Card card = new Card(this.cards.get(index));
                cards.add(card); // adding the card from source
                count[index]++; // adding to the number of cards of one animal
                cardCounter++; // adding to the number of all cards of player
            }   
        }
        return cards;
    }

    public void manageGame() {
        playerInitializer(); // setting players at first
        // setting 30 cards of each player at first 
        player1.setCards(initialRandomCards());
        player2.setCards(initialRandomCards());
        // pick 10 cards for each player
        player1.cardPicker();
        if (isPC) {
            player2.cardPicker(isPC); 
        } else {
            player2.cardPicker();
        }
        while (!isFinished()) {
            showCards(player1, player2);
            action(player1, player2);
            if (isFinished()) { // cheking if the game is over or not
                endOfGamePrinter();
                break;
            }
            if (!isPC) {
            showCards(player2, player1);
            }
            action(player2, player1);
            roundCounter++;
        }
        endOfGamePrinter();
        System.out.println("The game is finished!");
    }   

    private void playerInitializer() {
        String name1;
        String name2;
        Main.input.nextLine();
        System.out.printf("Enter the name of player1: ");
        name1 = Main.input.nextLine();
        player1 = new Player(name1, false);

        if (isPC) {
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

    private void repaire(Player player) {
        Random random = new Random();
        int index;

        if (player.getIsPc()) {
            index = random.nextInt(player.getCardsNumber() + 1);
        } else {
            System.out.printf("Enter the index of card you want to repair its energy: ");
            index = Main.input.nextInt();
        }
        while (player.getCards().get(index - 1).isFull()) {
            if (player.getIsPc()) {
                index = random.nextInt(player.getCardsNumber() + 1);
            } else {
                System.out.printf("This card has full energy. Pick another card: ");
                index = Main.input.nextInt();
            }
        }
        player.getCards().get(index - 1).repair();
        System.out.println("The energy of this player is repaired!");
    }

    private void action(Player attacker, Player defender) {
        int choice;
        Random random = new Random();
        if (attacker.getRepaireCount() != 3 && roundCounter != 1) { // we nust check if is there any card for this or not?
            
            if (attacker.getIsPc()) {
                choice = random.nextInt(2) + 1;
            } else {
                System.out.println("Do you want to 1. repaire one of your card's enery   or   2. Attack? ");
                choice = Main.input.nextInt();
            }
            System.out.println("The choose is " + choice);
            if (choice == 1) {
                repaire(attacker);
                attacker.setRepaireCount(attacker.getRepaireCount() + 1);
            } else {
                while (true) {
                    if (attack(attacker, defender) == 1) {
                        break;
                    }
                    if (!attacker.getIsPc()) {
                        System.out.println("Your attack is failed. Try again!");
                    }
                }
            }   
        
        } else {
            while (true) {
                if (attack(attacker, defender) == 1) {
                    break;
                }
                if (!attacker.getIsPc()) {
                    System.out.println("Your attack is failed. Try again!");
                }
            }
        }
    }

    /**
     * This method is for attacking mode.
     * @param attacker The Player who wants to attack.
     * @param defender The player who has to defend
     * @param isPC // Boolean that we pass to the method to tell method that has to play random or not
     * @return 
     */
    private int attack(Player attacker, Player defender) {
        Random random = new Random();
        int totalKick = 0;
        ArrayList<Integer> attackerCards = new ArrayList<>();
        int attackerCardsCount; // the number of cards we want to attack with
        
        if (attacker.getIsPc()) {
            attackerCardsCount = random.nextInt(attacker.getCardsNumber()) + 1;
            System.out.println("The number of cards that you have been attacked with: " + attackerCardsCount);
        } else {
            System.out.printf("With how many cards do you want to attack with? ");
            attackerCardsCount = Main.input.nextInt();
        }

        for (int i = 0; i < attackerCardsCount; i++) { // adding n = attackerCardsCount cards to the arrayList
            int index;
            if (attacker.getIsPc()) {
                index = random.nextInt(attacker.getCardsNumber()) + 1;
            } else {
                System.out.format("Enter the index of card%d: ", i + 1);
                index = Main.input.nextInt();
            }
            while (attackerCards.contains(index)) { // repeat until the index is not in the list
                
                if (attacker.getIsPc()) {
                    index = random.nextInt(attacker.getCardsNumber()) + 1;    
                } else {
                    System.out.format("This card has been added before. Enter new number: ");
                    index = Main.input.nextInt();
                }
            }
            attackerCards.add(index);
            if (attacker.getCards().get(index - 1).getHardKick() != 0 && attacker.getCards().get(index - 1).getNormalKick() != 0) {
                int choice; // if the generated number is one, use hard Kick. else, use normal kick.
                
                if (attacker.getIsPc()) {
                    choice = random.nextInt(2) + 1;
                } else {
                    System.out.println("DO you want to attack with 1. Hard Kick   or   2. Normal kick? ");
                    choice = Main.input.nextInt();
                }

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

        }
        double cost = totalKick / attackerCards.size();
        for (Integer number : attackerCards) {
            if (attacker.getCards().get(number - 1).getCurrentEnergy() - cost <= 0) {
                return -1; // this attack is failed. we have to repeat the attack
            }
        }
        for (Integer number : attackerCards) { // setting the new energy of each card
            attacker.getCards().get(number - 1).setCurrentEnergy(attacker.getCards().get(number - 1).getCurrentEnergy() - cost);
        }
        int defenderCard;
        
        if (attacker.getIsPc()) {
            defenderCard = random.nextInt(defender.getCardsNumber()) + 1;
            System.out.println("The card number " + defenderCard + " has been attacked in your deck!");
        } else {
            System.out.printf("Which card do you want to attack to:");
            defenderCard = Main.input.nextInt();    
        }

        defender.getCards().get(defenderCard - 1).setElixir(defender.getCards().get(defenderCard - 1).getElixir() - totalKick);
        if (defender.getCards().get(defenderCard - 1).getElixir() <= 0) {
            defender.removeCard(defenderCard - 1);
            System.out.println("This card is dead!");
        }
        return 1; 
    }

    private void endOfGamePrinter() {
        if (player1.getCardsNumber() == 0) {
            System.out.format("%s wins. Congratulations :))\n", player2.getName());
            return;
        }
        System.out.format("%s wins. Congratulations :))\n", player1.getName());
    }
}
