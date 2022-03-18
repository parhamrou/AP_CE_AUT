import java.util.HashSet;
import java.util.Map;

/**
 * This class is used to managing and executing all the commands that are given from user. 
 * In this class we have a object of class "Inventory" to have a list of store's products
 * and we have a HashSet consists of objects of class "perosn" to have a lit of store's clients.
 */
public class Store {
    
    public Inventory inventory;
    private HashSet<Person> persons;

    // constructor
    public Store() {
        inventory = new Inventory();
        persons = new HashSet<>();

        //creating pruducts
        Product pizza = new Product("Pizza", "Food", 19.99, "2022-04-05T21:00", "2022-04-09T21:00");
        Product steak = new Product("Steak", "Food", 100.00, "2022-03-06T21:30", "2022-03-09T12:00");
        Product Burger = new Product("Burger", "Food", 15.75, "2022-03-03T08:30", "2022-03-03T20:30");
        Product coffee = new Product("Coffee", "Drink", 8.50, "2022-04-01T13:20", "2022-04-01T15:20");
        Product chocolate = new Product("Chocolate", "Snack", 17.99, "2020-01-12T10:50", "2023-01-12T10:50");
        Product snack = new Product("Snack", "Snack", 3.49, "2021-06-14T16:30", "2022-06-14T16:30");
        Product soda = new Product("Soda", "Drink", 7.00, "2022-03-11T15:30", "2022-06-11T15:30");
        Product noodle = new Product("Noodle", "Food", 35.00, "2022-02-28T13:20", "2022-03-01T12:00");
        
        // adding to the inventory
        inventory.addProduct(pizza, 10);
        inventory.addProduct(steak, 5);
        inventory.addProduct(Burger, 100);
        inventory.addProduct(coffee, 50);
        inventory.addProduct(chocolate, 15);
        inventory.addProduct(snack, 12);
        inventory.addProduct(soda, 80);
        inventory.addProduct(noodle, 40);

    }

    /**
    * this method is used to add a new client to the inventory HashSet
    * at first it calls searchUser method to make sure that the input userName
    * is not already in the list
    * if the username is new, is creates a new object of class Persons and 
    * adds it to the hashSet
    * else, it prints a message and ends
    * @param name  This is the name of the person
    * @param userName  This is the username of the person
    * @param balance  this is the initial balance for the person
    */
    public void addperson(String name, String userName, double balance) {
        Person person = searchUser(userName);
        if (person != null) {
            System.out.println("This username already exist!");
            return;
        }
        person = new Person(name, userName, balance);
        persons.add(person);
        System.out.println("Successfully added user.");
    }

    /**
    * This method is used to change the balance of an existing person.
    * At first, it checks if the person is in the list or not
    * and if the answer is true, it changes the balance.
    * @param userName   This is the username of the person
    * @param amount     This is the new balance of the person
    */
    public void changeBalance(String userName, Double amount) {
        Person person = searchUser(userName);
        if (person == null) {
            System.out.println("Invalid username.");
            return;
        }
        person.setBalance(amount);
        System.out.println("Successfully transmitted.");       
    }

    /**
    * This method is used to iterate on the persons HashSet and 
    * print the information of the persons.
    * At first it checks if the number of persons is zero, it prints a message
    * and ends.
    */
    public void printPeople() {
        if (persons.size() == 0) {
            System.out.println("There is no one here!");
            return;
        }
        int index = 1;
        for (Person person : persons) {
            System.out.println(index + ". " + person);
            index++;
        }
    }

    /**
    * This simple method is used to printing all the products and their infomation.
    * it calls an other method from inventory object to print.
    */
    public void printMenu() {
        inventory.printInventory();
    }

    /**
    * This method is used to add a order to the basket of the person.
    * At first, it checks if the user is in the list or not and if 
    * the entered food's name is valid or not, and
    * then if the answers is true, it adds the product to the user's basket.
    * @param userName   This is the person's username.
    * @param food       This is the name of the product
    */
    public void addOrder(String userName, String food) {
        Map.Entry<Product, Integer> entry = searchFood(food);

        // cheking if the food is valid or not
        if (entry == null) {
            System.out.println("Invalid food.");
            return;    
        }
        if (entry.getValue().intValue() == 0) {
            System.out.println("Out of stock.");
            return;
        }
        Person person = searchUser(userName);
        if (person == null) {
            System.out.println("Invalid username.");
            return;
        }
        Product product = entry.getKey();
        person.getBasket().addProduct(product);
        // reduce the stock of the product after order.
        inventory.getInventory().put(product, entry.getValue().intValue() - 1);
        System.out.println("Successfully added to your basket.");
        return;
    }

    /**
    * this method is for checking out a specific client.
    * At first it checks if the user is in the list or not
    * and if the answer if true, it does the checkout.
    * @param userName   This is the user's username.
    */
    public void checkout(String userName) {
        Person person = searchUser(userName);
        // cheking if the username is valid or not
        if (person == null) {
            System.out.println("Invalid username.");
            return;
        }
        double totalBill = 0;
        Basket basket = person.getBasket();
        for (Product product : basket.getBasket()) {
            switch (product.getCategory()) {
                case "Drink":
                    totalBill += product.getPrice() * 1.35;
                    break;
                case "Food":
                    totalBill += product.getPrice() * 1.10;
                    break;
                case "Snack":
                    totalBill += product.getPrice() * 1.20;
                    break;
            } 
        }
        //cheking if the user can affod the bill or not
        if (person.getBalance() < totalBill) {
            System.out.println("You can't afford your bill.");
            return;
        }
        System.out.format("%s's bill= %.2f\n", userName, totalBill);
        System.out.format("tax : %.2f  net : %.2f\n", (totalBill - person.getBasket().totalPrice()), person.getBasket().totalPrice());
        person.setBalance(person.getBalance() - totalBill);
        person.getBasket().clearBasket();
        System.out.format("Your new balance= %.2f\n", person.getBalance());
        System.out.println("Have a good day.");
    }

    /**
    * This method is used to print all the products of 
    * the given user's basket. 
    * At first it checks if the given username is valid or not
    * and if the answer is true, it calls the showBasket method.
    * @param userName   This is the user's username;
    */
    public void printBasket(String userName) {
        Person person = searchUser(userName);
        if (person == null) {
            System.out.println("Invalid username.");
            return;
        }
        person.getBasket().showBasket();
    }

    /**
    * This method is used to remove a product from the user's basket.
    * At first it checks if the username is valid or not and if it is, 
    * it checks if the entered index is valid or not and if it is, 
    * it removes the product with the index that is given.
    * @param userName  This is user's username.
    * @param index  This is index of the product of the list that we want to remove.
    */
    public void removeBasketProduct(String userName, int index) {
        Person person = searchUser(userName);
        if (person == null) {
            System.out.println("Invalid username.");
            return;
        }
        // cheking if the input index if valid or not
        if (index < 1 || index > person.getBasket().getBasketSize()) {
            System.out.println("Invalid index.");
            return;
        }
        Product product = person.getBasket().getProduct(index);
        person.getBasket().removeProduct(index);
        // adding to the stock of the product after canceling the order
        inventory.getInventory().put(product, inventory.getInventory().get(product) + 1);
        System.out.println("Successfully removed.");
    }

    /**
    * This method is used to remove a product from the menu of the store.
    * At first it checks if the enterd food's name is valid or not and if it is, 
    * it removes that from the menu.
    * @param food  This is the food's name that we want to remove.
    */
    public void removeInventory(String food) {
        Map.Entry<Product, Integer> entry = searchFood(food);
        if (entry == null) {
            System.out.println("Invalid food.");
            return;
        }
        inventory.getInventory().remove(entry.getKey(), entry.getValue());
        System.out.println("Successfully removed.");
    }

    /**
    * This method is used to change a product's stock from the menu.
    * It checks if the entered food's name and the entered amount is valid
    * or not and if the answer if true, it changes the stock.
    * @param food  This is food's name that we want to change the stock of it.
    * @param amout  This is the new amount of the food.
    */
    public void changeStock(String food, int amount) {
        Map.Entry<Product, Integer> entry = searchFood(food);
        if (entry == null) {
            System.out.println("Invalid food.");
            return;
        }
        //cheking if the amount is negative
        if (entry.getValue().intValue() < -amount && amount < 0) {
            System.out.println("Greater than available amount in stock.");
            return;
        }
        inventory.changeStock(entry.getKey(), amount + entry.getValue().intValue());
        System.out.println("Successfully changed the amount.");
    }

    /**
    * This method is used to search in the client's HashSet using their 
    * unique usernames and check if the username is in the list or not.
    * @param userName This is the user's username.
    * @return Person if the persons is in the list, it returns the Person object and if is not, it returns null.
    */
    private Person searchUser(String userName) {
        for (Person person : persons) {
            if (person.getUserName().equals(userName)) {
                return person;
            }
        }
        // didn't found the user
        return null;
    }

    /**
    * This method is used to search in the HashMap of the prodcuts and check if
    * the product is in the list or not. 
    * @param food  This is food's name.
    * @return Entry This is the return if this method with Entry type, if the product is in the list, it 
    * returns it and if it is not, it returns null.
    */
    private Map.Entry<Product, Integer> searchFood(String food) {
        for (Map.Entry<Product, Integer> entry : inventory.getInventory().entrySet()) {
            if (entry.getKey().getName().equals(food)) {
                return entry;
            }
        }
        return null;
    }

}
