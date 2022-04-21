import java.time.LocalDate;
import java.util.HashMap;

public class User extends GeneralUser {
    
    private boolean isVIP;
    private int downLoadCounter;
    private HashMap<Film, Integer> filmRates;

    public User(String userName, String password, LocalDate joinDate, boolean isVIP, Site siteManager) {
        super(userName, password, joinDate, siteManager);
        filmRates = new HashMap<>();
        this.isVIP = isVIP;
        if (!isVIP) {
            downLoadCounter = 0;
        }
    }


    /**
     * This method manages the choices of the user and calls the proper methods.
     */
    @Override
    public void manager() {
        Main.clear();
        userMenu();
        int choice = Site.scanner.nextInt();
        while (choice != 5) {
            switch (choice) {
                case 1:
                    showByGenre();
                    break;
                case 2:
                    download();
                    break;
                case 3:
                    upgrade();
                    break;
                case 4:
                    rate();
                    break;
            }
            Main.clear();
            userMenu();
            choice = Site.scanner.nextInt();
        } 
    }

    /**
     * This method is for upgrading one user to VIP.
     */
    private void upgrade() {
        if (isVIP) {
            System.out.println("This account is VIP already!");
            Site.scanner.nextLine();
            Main.pressEnter();
            return;
        }
        Site.scanner.nextLine();
        System.out.printf("> Code: ");
        String code = Site.scanner.nextLine();
        if (!code.equals("AUTAP")) {
            System.out.println("Wrong code!");
            Main.pressEnter();
            return;
        }
        isVIP = !isVIP;
        System.out.println("Now this account is upgraded to VIP!");
        Main.pressEnter();
    }

    /**
     * This method gets the name of one movie from the user
     * and if the movie exists and has the conditions, calls the download
     * method of the Film.
     */
    private void download() {
        Main.clear();
        if (getSiteManager().numberOfFilms() == 0) {
            System.out.println("There is no film in the list to download!");
            Site.scanner.nextLine();
            Main.pressEnter();
            return;
        }
        if (downLoadCounter == 5 && !isVIP) {
            System.out.println("You have used your 5 possible downloads.");
            System.out.println("To download more films, you can upgrade your account to VIP.");
            Main.pressEnter();
            Site.scanner.nextLine();
            return;
        }
        Site.scanner.nextLine();
        System.out.printf("> Movie name: ");
        String name = Site.scanner.nextLine();
        Film film = getSiteManager().searchFilm(name);
        if (film == null) {
            System.out.println("This film doesn't exist.");
            Main.pressEnter();
            return;
        }
        film.download();
        if (!isVIP) {
            downLoadCounter++;
        } 
    }

    private void rate() {
        Main.clear();
        if (getSiteManager().numberOfFilms() == 0) {
            System.out.println("There is no film in the list to vote!");
            Site.scanner.nextLine();
            Main.pressEnter();
            return;
        }
        Site.scanner.nextLine();
        System.out.printf("> Movie name: ");
        String name = Site.scanner.nextLine();
        Film film = getSiteManager().searchFilm(name);
        if (film == null) {
            System.out.println("This film doesn't exist.");
            Main.pressEnter();
            return;
        }
        if (filmRates.containsKey(film)) {
            System.out.println("You have rated this film before!");
            return;
        }
        System.out.printf("> Your rate from 1 to 5: ");
        int rate = Site.scanner.nextInt();
        while (!(rate > 0 && rate < 6)) {
            System.out.printf("Invalid input. Try again!\n> ");
            rate = Site.scanner.nextInt();
        }
        filmRates.put(film, rate);
        film.rate(rate);
        System.out.println("Your rate is sucesfully added.");
        Site.scanner.nextLine();
        Main.pressEnter();
    }
    /**
     * This method shows the user menu.
     */
    private void userMenu() {
        System.out.println("[1] List films by genre");
        System.out.println("[2] Download film");
        System.out.println("[3] Upgrade to VIP account");
        System.out.println("[4] Rate movie");
        System.out.println("[5] Sign out");
    }
}
