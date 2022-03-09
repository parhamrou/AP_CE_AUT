import java.util.Scanner;

public class InputHandler {
    
    private MenuHandler menu;
    private Cafe cafe;
    private Client client;
    private int idGenerator = 1;

    public InputHandler() {
        menu = new MenuHandler();
        cafe = new Cafe();
    }

    public void registerClient() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter your name and your role : ");
        String name = input.next();
        String role = input.next();

        if (role.equals("admin")) {
            Client client = new Client(name, idGenerator, true);
            welcomeMessage(idGenerator, name);
            idGenerator++;
            cafe.addClient(client);
            return;

        } else if (role.equals("client")) {
            Client client = new Client(name, idGenerator, false);
            welcomeMessage(idGenerator, name);
            idGenerator++;
            cafe.addClient(client);
            return;

        }
        
        // if role is not valid 
        System.out.println("Your role is not valid! please try again.");
        return;
    } 


    public void signInClient() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your ID : ");
        int id = input.nextInt();

        // cheking if this client has signed up before or not
        if (cafe.checkForOrder(id) == null) {
            System.out.println("You didn't signup before! please back to menu and signup first.");
            return;
        }
        // set current client to searched client
        client = cafe.checkForOrder(id);
        int choice;
        do {
            menu.printClientMenu();
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    cafe.printDrinks();
                    int index = input.nextInt();
                    addOrder(index);        
                    break;

                case 2:
                    client.printOrders();
                    index = input.nextInt();
                    cancelOrder(index);
                    break;

                case 3:
                    //log out
                    client = null;
                    break;
                default: 
                    System.out.println("Invalid input!");
                    break;

            }
        } while (choice != 3);
    }


    public void signInAdmin() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter your ID : ");
        int id = input.nextInt();
        
        // cheking if this client has signedup before or not
        if (cafe.getAdmin(id) == null) {
            System.out.println("You didn't signup before! please back to menu and signup first.");
            return;
        }
        // set current client to searched client
        client = cafe.getAdmin(id);
        showClientsList();
        int choice = input.nextInt();
        if (choice == 0) {
            return;
        }
        System.out.println("Invalid input!");
    }


    public void cancelOrder(int index) {
        if (index == client.getOrderCounter() + 1) {
            // client has choiced exit option
            return;
        }
        if (index > client.getOrderCounter() + 1 || index < 0) {
            // invalid input
            System.out.println("Your input is invalid!");
            return;
        }
        Drink drink = client.getOrder(index);
        client.cancelOrder(drink);
    }
    public void addOrder(int index) {
        if (index < 0 || index > 5) {
            // invalid input
            System.out.println("Invalid input!");
            return;
        }
        Drink drink = new Drink(cafe.getDrinkName(index), cafe.getDrinkPrice(index));
        client.orderDrink(drink);
    }

    public void showToMenu(String[] targetMenu) {

    }

    public void showClientsList() {
        cafe.showActiveUsers();

    }

    public void run() {
        Scanner input = new Scanner(System.in);
        int choice;

        do {
            menu.printFirstMenu();
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    registerClient();
                    break;

                case 2:
                    signInClient();
                    break;

                case 3:
                    signInAdmin();

                    break;

                case 4:
                    break;

                default:
                    System.out.println("Invalid input! try again!");
                    break;
    
            }
        } while (choice != 4);
    }

    public void welcomeMessage(int id, String name) {
        System.out.println("welcome " + name + " jaan" + "\nYour ID is : " + id);
    }
}
