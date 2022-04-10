import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

public class Player {
    
    private String name;
    private LinkedList<Card> cards;
    private int repaireCount;
    private boolean isPC;

    //constructor
    public Player(String name, boolean isPC) {
        this.name = name;
        cards = new LinkedList<>();
        repaireCount = 0;
        this.isPC = isPC;
    }

    public LinkedList<Card> getCards() {
        return cards;
    }

    public void setCards(LinkedList<Card> cards) {
        this.cards = cards;
    }

    public boolean getIsPc() {
        return isPC;
    }

    /**
     * This method is for cheking if the player can repair one of his/her cards or not.
     * if the total number of repairs of player is fewer than three, he can.
     * @return 
     */
    public boolean canRepair() {
        for (Card card : cards) {
            if (!card.isFull()) {
                return true;
            }
        }
        return false;
    }

    public void setRepaireCount(int repaireCount) {
        this.repaireCount = repaireCount;
    }

    public int getRepaireCount() {
        return repaireCount;
    }
    
    public int getCardsNumber() {
        return cards.size();
    }

    public String getName() {
        return name;
    }
    /**
     * This method picks cards randomly when the second player
     * is PC.
     * @param isRandom
     */
    public void cardPicker(boolean isRandom) {
        Random random = new Random();
        int removedCounter = 0;
        while (removedCounter != 20) {
            int index = random.nextInt(this.cards.size());
            this.cards.remove(index);
            removedCounter++;
        }
    }

    /**
     * This method picks cards by the decision of the player when the player is not PC.
     */
    public void cardPicker() {
        int counter = 0;
        // showing al 30 cards
        for (Card card : cards) {
            System.out.printf("%d. %-5s     ", counter + 1, card.getName());
            counter++;
            if (counter % 5 == 0) {
                System.out.println();
            }
        }
        System.out.println(name + "! Enter the indexes of cards you want to keep in one row: ");
        for (int i = 0; i < 10; i++) {
            int index = Main.input.nextInt();
            this.cards.get(index - 1).setPicked(true);
        }
        int deletedCounter = 0; // counts the number of deleted cards
        Iterator iterator = this.cards.iterator();
        while (deletedCounter != 20 && iterator.hasNext()) {
            Card card = (Card) iterator.next();
            if (!card.getPicked()) {
                iterator.remove();
                deletedCounter++;
            }
        } 
    }

    /**
     * This method gets a index and removes it when the elixir of it is less than or equal to zero.
     * @param index 
     */
    public void removeCard(int index) {
        cards.remove(index);
    }

    /**
     * This method shows the cards when a player wants to attak to 
     * help him to choose his cards.
     */
    public void attackShowCards() {
        int index = 1;
        for (Card card : cards) {
            System.out.println(index + ". " + card);
            index++;
        }
    }

    /**
     * This method shows the cards of player's enemy to help him choose one of his cards to attack to.
     */
    public void defendShowCards() {
        int index = 0;
        for (Card card : cards) {
            System.out.format("%d. %s    %s\n", index + 1, card.getName(), String.format("Elixir: %.2f", card.getElixir()));
            index++;
        }
    }
}
