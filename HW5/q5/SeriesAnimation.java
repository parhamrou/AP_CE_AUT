import java.util.ArrayList;


/**
 * This class if one of the Film types that we can have in the site.
 * It implements the Animation interface and overrides its isAppropiate method.
 */
public class SeriesAnimation extends Film implements Animation{
    
    private int numberOfSeasons;
    private int[] episodes;


    public SeriesAnimation(String name, String summary, Genre genre, String director, Age age, ArrayList<String> actors, int[] episodes) {
        super(name, summary, genre, director, age, actors);
        this.episodes = episodes;
    }

    /**
     * This method is overrided from the Animation interface and checks 
     * if one user can download the animation based on his age or not.
     */
    @Override
    public boolean isAppropiate(int number) {
        switch (getAge()) {
            case A:
                if (number < 5) {
                    return true;
                }
            case B:
                if (number > 10 && number < 15) {
                    return true;
                }
            case C:
                if (number >= 15 && number < 18) {
                    return true;
                }
            case D:
                if (number >= 18) {
                    return true;
                }
        }
        return false;
    }

     /**
     * This method is overrided from the Film class and simulates downloading 
     * with printing the proper message after download.
     */
    @Override
    public void download() {
        System.out.printf("> Your age: ");
        int age = Site.scanner.nextInt();
        if (!isAppropiate(age)) {
            System.out.println("This film is not good for your age.");
            Site.scanner.nextLine();
            Main.pressEnter();
            return;
        }
        System.out.println(getName() + " is downloaded!");
        Site.scanner.nextLine();
        Main.pressEnter();
    }

}
