import java.time.LocalDate;
import java.util.ArrayList;

public class Admin extends GeneralUser {
    
    
    public Admin(String userName, String password, LocalDate joinDate, Site siteManager) {
        super(userName, password, joinDate, siteManager);
    }

    /**
     * This method is for managing the chocies of the user
     * and calling the proper methods.
     */
    @Override
    public void manager() {
        Main.clear();
        adminMenu();
        int choice = Site.scanner.nextInt();
        while (!(choice > 0 && choice < 5)) {
            System.out.printf("Invalid input. Try again!\n> ");
            choice = Site.scanner.nextInt();
        }
        while (choice != 4) {
            switch (choice) {
                case 1:
                    addMovie();
                    break;
    
                case 2:
                    removeMovie();
                    break;
    
                case 3:
                    showByGenre();
                    break;
            }
            Main.clear();
            adminMenu();
            choice = Site.scanner.nextInt();
        }
    }

    /**
     * This method gets all the information of a movie from the admin, 
     * creates a object from one of the "Film" subclasses and calls the addFilm 
     * method in the Site class.
     */
    private void addMovie() {
        Site.scanner.nextLine();
        Main.clear();
        System.out.printf("> Name: ");
        String name = Site.scanner.nextLine();
        System.out.printf("Genre:   -Documentry  -Action  -Drama  -Comedy  -Adventure\n> ");
        String input = Site.scanner.nextLine();
        Genre genre = Genre.genreChoice(input);
        System.out.printf("> Write a summary for this film: ");
        String summary = Site.scanner.nextLine();
        System.out.printf("> Director: ");
        String director = Site.scanner.nextLine();
        System.out.printf("> Age category:  -A  -B  -C  -D\n> ");
        input = Site.scanner.nextLine();
        Age age = Age.ageChoice(input);
        System.out.println("> Enter the names of the cast of the Movie in seperate lines. When you finished, enter -1 ");
        ArrayList<String> cast = new ArrayList<>();
        System.out.printf("> ");
        String castName = Site.scanner.nextLine();
        while (!castName.equals("-1")) {
            cast.add(castName);
            System.out.printf("> ");
            castName = Site.scanner.nextLine();
        }
        System.out.println("Your film is:  1.Animation   2.LiveAction ");
        int choice = Site.scanner.nextInt();
        while (!(choice > 0 && choice < 3)) {
            System.out.println("Invalid input. Try again!\n> ");
            choice = Site.scanner.nextInt();
        }
        System.out.println("Your film is:   1. Movie   2.Series");
        int choice2 = Site.scanner.nextInt();
        while (!(choice > 0 && choice < 3)) {
            System.out.println("Invalid input. Try again!\n> ");
            choice = Site.scanner.nextInt();
        }
        if (choice2 == 1) {
            Site.scanner.nextLine();
            System.out.printf("> Length: ");
            String length = Site.scanner.nextLine();
            if (choice == 1) {
                getSiteManager().addFilm(new MovieAnimation(name, summary, genre, director, age, cast, length));
            } else {
                getSiteManager().addFilm(new MovieLiveAction(name, summary, genre, director, age, cast, length));
            }
        } else {
            System.out.printf("> Number of seasons: ");
            int seasons = Site.scanner.nextInt();
            int[] episodes = new int[seasons];
            for (int i = 0; i < seasons; i++) {
                System.out.printf("> number of episdoes of season %d: ", i + 1);
                episodes[i] = Site.scanner.nextInt();
            }
            Site.scanner.nextLine();
            if (choice == 1) {
                getSiteManager().addFilm(new SeriesAnimation(name, summary, genre, director, age, cast, episodes));
            } else {
                getSiteManager().addFilm(new SeriesLiveAction(name, summary, genre, director, age, cast, episodes));
            }
        }
        System.out.println("The movie is succesfully added.");
        Main.pressEnter();
    }

    /**
     * This method gets the name of one 
     * movie from the user and if it exists, 
     * calls the deleteFilm method in the 
     * Site class.
     */
    private void removeMovie() {
        Main.clear();
        if (getSiteManager().numberOfFilms() == 0) {
            System.out.println("There is no movie in the list to remove!");
            Site.scanner.nextLine();
            Main.pressEnter();
            return;
        }
        System.out.printf("> Name of the movie: ");
        String name = Site.scanner.nextLine();
        getSiteManager().deleteFilm(name);
    }

    /**
     * This method shows the admin menu.
     */
    private void adminMenu() {
        System.out.println("[1] Add film");
        System.out.println("[2] Delete film");
        System.out.println("[3] List films by genre");
        System.out.println("[4] Sign out");
        System.out.printf("> ");
    }
}
