import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * This class is for creating and managing one site. 
 * It holds the list of films and the users.
 */
public class Site {
    
    public static final Scanner scanner = new Scanner(System.in);

    ArrayList<GeneralUser> users;
    ArrayList<Film> films;

    public Site() {
        users = new ArrayList<>();
        films = new ArrayList<>();
    }

    /**
     * This method manages the site and calls the proper methods 
     * based on the user's choices.
     */
    public void manager() {
        int choice;
        Main.clear();
        FirstMenu();
        choice = scanner.nextInt();
        while (choice != 3) {
            switch (choice) {
                case 1:
                    generalSignUp();
                    break;
                
                case 2:
                    generalSignIn();
                    break;

                default:
                    System.out.println("Invalid input. Try again!");
                    break;
            }
            Main.clear();
            FirstMenu();
            choice = scanner.nextInt();
        }

    }

    /**
     * This method is for signing in for both the 
     * admin and user. it gets the username and password from
     * the user and if the user exists in the list of the site, 
     * calls the action manager method of each type.
     */
    private void generalSignIn() {
        Main.clear();
        secondMenu();
        int choice = scanner.nextInt();
        while (!(choice > 0 && choice < 4)) {
            System.out.println("Invalid input. Try again!\n> ");
            choice = Site.scanner.nextInt();
        }
        if (choice == 3) {
            return;
        }
        Site.scanner.nextLine();
        Main.clear();
        System.out.printf("> Username: ");
        String username = scanner.nextLine();
        System.out.printf("> Password: ");
        String password = scanner.nextLine();
        LocalDate joinDate = LocalDate.now();
        GeneralUser generalUser = searchUser(username, password);
        if (generalUser == null) {
            System.out.println("This user doesn't exist. You have to sign up first.");
            Main.pressEnter();
            return;
        }
        if (choice == 1 && generalUser instanceof Admin) {
            System.out.println("Your'e a user and you can't login as admin!");
            Main.pressEnter();
            return;
        }
        if (choice == 2 && generalUser instanceof User) {
            System.out.println("You're an admin and can't login as user!");
            Main.pressEnter();
            return;
        } 
        generalUser.manager();
    }

    /**
     * This method is for signing up for both admin and user.
     * It gets the information from the user and creates one object 
     * from the proper class and adds it to the list of the users of the class.
     */
    private void generalSignUp() {
        int choice;
        Main.clear();
        secondMenu();
        choice = scanner.nextInt();
        while (!(choice > 0 && choice < 4)) {
            System.out.println("Invalid input. Try again!\n> ");
            choice = Site.scanner.nextInt();
        }
        if (choice == 3) {
            return;
        }
        Site.scanner.nextLine();
        Main.clear();
        System.out.printf("> Username: ");
        String userName = scanner.nextLine();
        System.out.printf("> Password: ");
        String password = scanner.nextLine();
        LocalDate joinDate = LocalDate.now();
        if (choice == 1) {
            System.out.printf("Do you want to be a VIP user? 1.YES  2.NO\n> ");
            int isVIP = scanner.nextInt();
            while (!(isVIP > 0 && isVIP < 3)) {
                System.out.println("Invalid input. Try again!\n> ");
                isVIP = Site.scanner.nextInt();
            }
            if (isVIP == 1) {
                users.add(new User(userName, password, joinDate, true, this));
                System.out.println("The user is succesfully added!");
                Main.pressEnter();
                Site.scanner.nextLine();
                return;
            } else {
                users.add(new User(userName, password, joinDate, false, this));
                System.out.println("The user is succesfully added!");
                Main.pressEnter();
                Site.scanner.nextLine();
                return;
            }
        } else {
            users.add(new Admin(userName, password, joinDate, this));
            System.out.println("The admin is succesfully added!");
            Main.pressEnter();
            return;
        } 
    }

    /**
     * This method gets on Film object as paramether and 
     * adds it to the list of the films in the site.
     * @param film
     */
    public void addFilm(Film film) {
        films.add(film);
    }

    /**
     * This method gets the name of one movie and if the
     * movie exists in the list of the films, deletes it.
     * @param name
     */
    public void deleteFilm(String name) {
        Film film = searchFilm(name);
        if (film == null) {
            System.out.println("The movie is not in the list.");
            Main.pressEnter();
            return;
        }
        films.remove(film);
        System.out.println("The movie is removed.");
        Main.pressEnter();
    }

    /**
     * This method shows the first menu of the site to the users.
     */
    private void FirstMenu() {
        System.out.println("[1] Sign up");
        System.out.println("[2] Sign in");
        System.out.println("[3] Exit");
        System.out.printf("> ");
    }

    private void secondMenu() {
        System.out.println("[1] As user");
        System.out.println("[2] As admin");
        System.out.println("[3] Exit");
        System.out.printf("> ");
    }

    private GeneralUser searchUser(String username, String password) {
        for (GeneralUser generalUser : users) {
            if (generalUser.getUserName().equals(username) && generalUser.getPassword().equals(password)) {
                return generalUser;
            }
        }
        return null;
    }

    public Film searchFilm(String name) {
        for (Film film : films) {
            if (film.getName().equals(name)) {
                return film;
            }
        }
        return null;
    }

    public void listByGenre(Genre genre) {
        Main.clear();
        if (films.size() == 0) {
            System.out.println("There is no film in the list.");
            Main.pressEnter();
            return;
        }
        if (genre == null) {
            for (Film film : films) {
                System.out.print(film);
            }
            Main.pressEnter();
            return;
        }
        int counter = 0;
        for (Film film : films) {
            if (film.getGenre().equals(genre)) {
                System.out.print(film);
                counter++;
            }
        }
        if (counter == 0) {
            System.out.println("There is no film in the list with this genre.");
        }
        Main.pressEnter();
    }

    public int numberOfFilms() {
        return films.size();
    }
}
