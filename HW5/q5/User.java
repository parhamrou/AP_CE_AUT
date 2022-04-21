import java.time.LocalDate;

public class User extends GeneralUser {
    
    private boolean isVIP;
    private int downLoadCounter;


    public User(String userName, String password, LocalDate joinDate, boolean isVIP, Site siteManager) {
        super(userName, password, joinDate, siteManager);
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
        while (choice != 4) {
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

    /**
     * This method shows the user menu.
     */
    private void userMenu() {
        System.out.println("[1] List films by genre");
        System.out.println("[2] Download film");
        System.out.println("[3] Upgrade to VIP account");
        System.out.println("[4] Sign out");
    }
}
