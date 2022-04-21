import java.util.ArrayList;
import java.util.Random;

/**
 * This class is for managing the game. 
 * It holds the list of the charater and calls the proper methods.
 */
public class Game {
    Random random = new Random();
    private int roundCounter;
    private ArrayList<Character> characters;

    // constructor
    public Game() {
        roundCounter = 1;
        characters = new ArrayList<>();
        characterInit();
    }

    /**
     * This is the main method of this class. It calls the
     * proper methods and manages the game until it finishes.
     */
    public void gamemanager() {
        clearScreen();
        System.out.println("Welcome to the game!");
        System.out.println("Press enter to start...");
        Main.scanner.nextLine();
        clearScreen();
        while (!isFinished()) {
            System.out.println("Round " + roundCounter);
            showDistances();
            System.out.println("Press enter to turn on the green light...");
            Main.scanner.nextLine();
            clearScreen();
            oneRound();
            clearScreen();
            showAlives();
            System.out.println("The characters who passed 200m: ");
            showCrossed();
            System.out.println("Press Enter to go to the next round...");
            Main.scanner.nextLine();
            clearScreen();
        }
        System.out.println("The game is over!");
        System.out.println("Winners: ");
        showCrossed();
    }

    /**
     * This method if for creating the characters at the first of the game.
     */
    private void characterInit() {
        characters.add(new Oldman());
        characters.add(new StrongMan());
        characters.add(new YoungGirl());
        characters.add(new CleverMan());
        characters.add(new AngryMan());
    }

    /**
     * This method checks if the game if over or not and return a boolean value.
     * @return if the game is finished returns true and else, false.
     */
    private boolean isFinished() {
        if (roundCounter == 10) {
            return true;
        }
        for (Character character : characters) {
            if (character.isActive()) {
                return false;
            }
        }
        return true;
    }

    /**
     * This method is for doing the functions and calling the 
     * proper methods at each round. It moves the characters and
     * then checks if the choosed character can use his her ability or
     * not. If he/she can, it calls the action method of the character.
     */
    private void oneRound() {
        for (Character character : characters) {
            character.move();
        }
        System.out.println("Characters are moved!");
        System.out.println("Now the Red light is on!");
        Character character = randomChoose();
        if (character instanceof StrongMan) { // cheking if the character is StrongMan or not
            StrongMan strongMan = (StrongMan) character;
            if (!strongMan.isSafe()) {
                character.reduceElixir(25);
            } else {
                System.out.println("Strong Man was attacked by the robot but was in safe mode!");
            }
        } else {
            character.reduceElixir(25); 
            System.out.println(character.getName() + " is is attacked by the robot!");
        }
        character = randomChoose();
        System.out.println(character.getName() + " is choosed randomly by the game!");
        int choice;
        if (character.canUseAbility()) {
                while (true) {
                    System.out.println("Do you want to use your ability this round? 1.YES  2.NO");
                    choice = Main.scanner.nextInt();
                    if (choice == 1 || choice == 2) {
                        break;
                    }
                    System.out.println("Invalid input!"); 
                }
                if (choice == 1) {
                    character.action(this);
                }
                System.out.println("Press Enter to show the lists...");
                Main.scanner.nextLine();
                Main.scanner.nextLine();
            } else {
                System.out.println("This character can't use ability this round!");
                System.out.println("Press Enter to show the lists...");
                Main.scanner.nextLine();
            }
            roundCounter++;
    }

    /**
     * This method chooses one active card randomly and returns it.
     * @return The card that is chosen.
     */
    private Character randomChoose() {
        int index = random.nextInt(characters.size());
        while (!characters.get(index).isActive()) {
            index = random.nextInt(characters.size());
        }
        return characters.get(index);
    }

    public ArrayList<Character> getActiveUsers() {
        ArrayList<Character> characters = new ArrayList<>();
        for (Character character : this.characters) {
            if (character.isActive()) {
                characters.add(character);
            }
        }
        return characters;
    }

    /**
     * This method returns a arrayList of the active charcters in the game.
     * @param character
     * @return
     */
    public ArrayList<Character> getActiveUsers(Character character) {
        ArrayList<Character> characters = new ArrayList<>();
        for (Character character2 : this.characters) {
            if (character2.isActive() && character2 != character) {
                characters.add(character2);
            }
        }
        return characters;
    }

    /**
     * This method shows the alive characters at the end of each round.
     */
    private void showAlives() {
        System.out.println("Alive characters: ");
        int index = 1;
        for (Character character : characters) {
            if (character.isAlive()) {
                System.out.println(index + ". " + character.getName());
                index++;
            }
        }
        if (index == 1) {
            System.out.println("NONE!");
        }
    }

    /**
     * This method shows all the character which passed the 200 meters at the end of each round.
     */
    private void showCrossed() {
        int index = 1;
        for (Character character : characters) {
            if (character.getDistancePassed() >= 200) {
                System.out.println(index + ". " + character.getName());
                index++;
            }
        }
        if (index == 1) {
            System.out.println("NONE!");
        }
    }

    /**
     * This method shows that each character passed how many meters at the end of
     * each round.
     */
    private void showDistances() {
        System.out.println("Covered distance by the characters: ");
        for (Character character : characters) {
            System.out.println("-" + character.getName() + ": " + character.getDistancePassed());
        }
    }

    /**
     * This method is for cleaning the console.
     */
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }
}
