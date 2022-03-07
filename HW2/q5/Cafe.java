
public class Cafe {

    private Client[] admins;
    private Client[] clients;
    private Drink[] drinks;
    private int adminsNumber = 0; // counts admins
    private int clientsNumber = 0; // counts clients

    // constructor
    public Cafe() {

        admins = new Client[20];
        clients = new Client[20];
        drinks = new Drink[5];
        drinks[0] = new Drink("tea", 45000);
        drinks[1] = new Drink("Milk", 38000);
        drinks[2] = new Drink("Coffee", 99990);
        drinks[3] = new Drink("Shake", 81000);
        drinks[4] = new Drink("Watermelon juice", 16000);
    
    }


    public void addClient(Client newClient) {

        // if newClient is admin, we add it to admins array
        if (newClient.getIsAdmin()) {
            admins[adminsNumber] = newClient;
            adminsNumber++;
            // if newClient is client, we add it to clients array 
        } else {
            clients[clientsNumber] = newClient;
            clientsNumber++;
        }
    }


    public Client checkForOrder(int id) {
        if (getClient(id) != null) {
            return getClient(id);
        } else if (getAdmin(id) != null) {
            return getAdmin(id);
        } else {
            return null;
        }
    }
    public Client getClient(int id) {
        for (int i = 0; i < clientsNumber; i++) {
            if (id == clients[i].getId()) {
                return clients[i];
            }
        }
        
        return null;
    }

    public Client getAdmin(int id) {
        for (int i = 0; i < adminsNumber; i++) {
            if (id == admins[i].getId()) {
                return admins[i];
            }
        }
        
        return null;
    }

    public void printDrinks() {
        for (int i = 0; i < drinks.length; i++) {
            System.out.println(i + 1 + "- " + drinks[i].getName() + " " + drinks[i].getPrice());
        }
    }

    public String getDrinkName(int index) {
        return drinks[index - 1].getName();
    }

    public double getDrinkPrice(int index) {
        return drinks[index - 1].getPrice();
    }

    public void showActiveUsers() {
        for (int i = 0; i < adminsNumber; i++) {
            if (admins[i].getOrderCounter() != 0) {
                admins[i].showInfo();
            }
        }
        for (int i = 0; i < clientsNumber; i++) {
            if (clients[i].getOrderCounter() != 0) {
                clients[i].showInfo();
            }
        }

        System.out.println("0- Exit");
    }
}
