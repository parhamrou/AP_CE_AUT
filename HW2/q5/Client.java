
public class Client {

    private String name;
    private int id;
    private Drink[] orders;
    private int orderCounter = 0;
    private boolean isAdmin;
    // constructor
    public Client(String name, int id, boolean isAdmin) {
        this.name = name;
        this.id = id;
        this.orders = new Drink[10];
        this.isAdmin = isAdmin;
    }

    public int getId() {
        return id;
    }

    public boolean getIsAdmin() {
        return isAdmin;
    }

    public void orderDrink(Drink newOrder) {
        orders[orderCounter] = newOrder;
        orderCounter++;
    }

    public void cancelOrder(Drink targetOrder) {
        int index;
        // finding the order in array
        for (index = 0; index < orderCounter; index++) {
            if (orders[index] == targetOrder) {
                break;
            }
        }

        //deleting the order and shifting the array
        if (index != orderCounter - 1) {
            for (int i = 0; i < orderCounter - 1; i++) {
                orders[i] = orders[i + 1];
            }
            orders[orderCounter - 1] = null;
        } else {
            orders[orderCounter - 1] = null;
        }

        orderCounter--;
    }

    public Drink[] getOrders() {
        return orders;    
    }

    public Drink getOrder(int index) {
        return orders[index - 1];
    }
    public void printOrders() {
        for (int i = 0; i < orderCounter; i++) {
            System.out.println(i + 1 + "- " + orders[i].getName() + " " + orders[i].getPrice());
        }
        System.out.println(orderCounter + 1 + "- " + "Exit");
    }

    public int getOrderCounter() {
        return orderCounter;
    }

    public void showInfo() {
        System.out.println(name + " - " + id);
        for (int i = 0; i < orderCounter; i++) {
            System.out.println("\t[" + orders[i].getName() + "]");
        }
    }
}