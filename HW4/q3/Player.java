import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

public class Player {
    
    private String name;
    private LinkedList<Card> cards;
    private boolean isPC;
    //constructor
    public Player(String name, boolean isPC) {
        this.name = name;
        cards = new LinkedList<>();
        this.isPC = isPC;
    }

    public LinkedList<Card> getCards() {
        return cards;
    }

    public void setCards(LinkedList<Card> cards) {
        this.cards = cards;
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
     * This method picks cards by the descion of player.
     */
    public void cardPicker() {
        int counter = 0;
        // showing al 30 cards
        for (Card card : cards) {
            System.out.printf("%d. %s     ", counter + 1, card.getName());
            counter++;
            if (counter % 5 == 0) {
                System.out.println();
            }
        }
        System.out.println("Enter the number of cards you want to keep in one row: ");
        for (int i = 0; i < 10; i++) {
            int index = Main.input.nextInt();
            cards.get(index - 1).setPicked(true);
        }
        Iterator iterator = cards.iterator();
        while (iterator.hasNext()) {
            Card card = (Card) iterator.next();
            if (!card.getPicked()) {
                iterator.remove();
            }
        } 
    }

    public void removeCard(int index) {
        cards.remove(index - 1);
    }
    public void showCards() {
        int index = 1;
        for (Card card : cards) {
            System.out.println(index + ". " + card);
            index++;
        }
    }
}
