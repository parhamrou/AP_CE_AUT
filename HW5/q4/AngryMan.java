import java.util.ArrayList;

public class AngryMan extends Character{

    // constructor
    public AngryMan() {
        super(75, 20, 1, "Angry Man");
    }

    @Override
    public void action(Game game) {
        int index = 0;
        ArrayList<Character> characters = game.getActiveUsers(this);
        System.out.println("Which character do you want to damage? ");
        for (Character character : characters) {
                System.out.println(index + 1 + ". " + character.getName());
                index++;
        }
        int choice = Main.scanner.nextInt();
        while (true) {
            boolean condition = true;
            while (true) {
                if (choice > 0 && choice <= characters.size()) {
                    if (characters.get(choice - 1) instanceof StrongMan) {
                        StrongMan strongMan = (StrongMan) characters.get(choice - 1);
                        if (strongMan.isSafe()) {
                            System.out.println("This character is safe this round. Try again!");
                            condition = false;
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }
                } else {
                    if (condition == true) {
                        System.out.println("Invalid input. try again!");
                    } 
                }
                choice = Main.scanner.nextInt();  
            }
            if (Math.abs(characters.get(choice - 1).getDistancePassed() - this.getDistancePassed()) < 10) {
                characters.get(choice - 1).reduceElixir(50);
                System.out.printf("The angry man damaged %s!\n", characters.get(choice - 1).getName());
                this.useAbility();
                break;
            }
            System.out.println("This character is so far from you! choose another character.");
            choice = Main.scanner.nextInt();
        }
    }
}
