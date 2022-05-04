import java.time.LocalDate;

/**
 * This abstract class is the super class of classes "User" and "Admin".
 * It holds the common fields and methods.
 */
public abstract class GeneralUser {

    private String userName;
    private String password;
    private LocalDate joinDate;
    private Site siteManager;

    public GeneralUser(String userName, String password, LocalDate joinDate, Site siteManager) {
        this.userName = userName;
        this.password = password;
        this.joinDate = joinDate;
        this.siteManager = siteManager;
    }

    /**
     * This method is for managing the object and 
     * calling the proper methods for each type of
     * general users. It is implemented in two subclasses.
     */
    public abstract void manager();
    
    public String getPassword() {
        return password;
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public String getUserName() {
        return userName;
    }
    
    public Site getSiteManager() {
        return siteManager;
    }

    /**
     * This method gets a genre from the user and calls the listByGenre method in the
     * Site class. 
     */
    public void showByGenre() {
        Main.clear();
        if (getSiteManager().numberOfFilms() == 0) {
            System.out.println("There is no film in the list!");
            Site.scanner.nextLine();
            Main.pressEnter();
            return;
        }
        System.out.printf("Genre:  -Documentry  -Action  -Drama  -Comedy  -Adventure\n");
        System.out.printf("If you want to show all films, type NONE\n> ");
        Site.scanner.nextLine();
        String choice = Site.scanner.nextLine();
        if (choice.equalsIgnoreCase("NONE")) {
            getSiteManager().listByGenre(null);
            return;
        }
        Genre genre = Genre.genreChoice(choice);
        getSiteManager().listByGenre(genre);
    }
}