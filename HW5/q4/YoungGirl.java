import java.util.ArrayList;

public class YoungGirl extends Character{

    // constructor
    public YoungGirl() {
        super(75, 25, 1, "Young Girl");
    }

    @Override
    public void action(Game game) {
        System.out.println("Which card do you want to damage? ");
        ArrayList<Character> characters = game.getActiveUsers(this);
        int index = 0;
        for (Character character : characters) {
            System.out.println(index + 1 + ". " + character.getName());
            index++;
        }
        int choice = Main.scanner.nextInt();
        while (true) {
            boolean temp = true;
            if (choice > 0 && choice <= characters.size()) {
                if (characters.get(choice - 1) instanceof StrongMan) {
                    StrongMan strongMan = (StrongMan) characters.get(choice - 1);
                    if (strongMan.isSafe()) {
                        System.out.println("This character is safe this round. Try Again!");
                        temp = false;
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }
            if (temp) {
                System.out.println("Invalid input. Try Again!");
            }
            choice = Main.scanner.nextInt();
        }
        characters.get(choice - 1).reduceElixir(25);
        System.out.printf("Young girl damaged %s!\n", characters.get(choice - 1).getName());
        this.useAbility();
    }
}
