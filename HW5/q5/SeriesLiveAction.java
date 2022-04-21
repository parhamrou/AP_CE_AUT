import java.util.ArrayList;

/**
 * This class is one of the film types that site can have. 
 */
public class SeriesLiveAction extends Film {
    
    private int numberOfSeasons;
    private int[] episodes;
    private Subtitle subtitle;


    public SeriesLiveAction(String name, String summary, Genre genre, String director, Age age, ArrayList<String> actors, int[] episodes) {
        super(name, summary, genre, director, age, actors);
        this.episodes = episodes;
    }

    /**
     * This method is overrided from the Film class and simulates downloading 
     * with printing the proper message after download.
     */
    @Override
    public void download() {
        System.out.println("> Do you want to download  1.Native longuage   2.Dubbed   3.Hardsub");
        int choice = Site.scanner.nextInt();
        while (!(choice > 0 && choice < 4)) {
            System.out.println("Invalid input. Try again!\n> ");
            choice = Site.scanner.nextInt();
        }
        switch (choice) {
            case 1:
                nativeDownLoad();
                break;
            case 2:
                dubbedDownLoad();
                break;
            case 3:
                hardsubDownLoad();
                break;
        }
    }

    private void nativeDownLoad() {
        System.out.println(getName() + " with native language is downloaded!");
        Main.pressEnter();
        Site.scanner.nextLine();
    }

    private void dubbedDownLoad() {
        System.out.println(getName() + " with dub is dowanloaded!");
        Main.pressEnter();
        Site.scanner.nextLine();
    }

    private void hardsubDownLoad() {
        System.out.println(getName() + "is downloaded with hardsub!");
        Main.pressEnter();
        Site.scanner.nextLine();
    }
}
