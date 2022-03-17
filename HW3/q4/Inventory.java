import java.util.HashMap;
import java.util.Map;

/**
 * This class has a HashMap consists of the Products that 
 * are in the store and their stock.
 */
public class Inventory {
    
    private HashMap<Product, Integer> inventory;

    // constructor
    public Inventory() {
        inventory = new HashMap<>();
    }

    /**
    * This method is used to add a product to the menu of the store.
    * @param product  it is a refrence to an object from class Product.
    * @param number   This is the new product's stock.
    */
    public void addProduct(Product product, int number) {
        inventory.put(product, number);
    }

    /**
    * This method is used to remove a product from the menu.
    * @param product  This is a refrence to an object from class Product that we want to remove from menu.
    */
    public void removeProduct(Product product) {
        inventory.remove(product);
    }

    /**
    * This method is used to change the stock of a product in the menu.
    * @param product  This is the product that we want to change its stock.
    * @param newNumber This is the new stock that we want to set for the product.
    */
    public void changeStock(Product product, int newNumber) {
        inventory.put(product, newNumber);
    }


    public HashMap<Product, Integer> getInventory() {
        return inventory;
    }


    public int getNumber(Product product) {
        int number = inventory.get(product);
        return number;
    }

    /**
    * This method is used to iterate on the inventory HashMap and print information of
    * all the products that are in the menu.
    */
    public void printInventory() {
        for (Map.Entry<Product, Integer> entry : inventory.entrySet()) {
            System.out.println(entry.getKey().toString() + "   instock " + entry.getValue().intValue());
        }
    }
}
