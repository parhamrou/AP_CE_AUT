import java.util.ArrayList;

/**
 * This class represents the basket of each client. 
 * it has an ArrayList of the products to save the 
 * products that the person wants to buy.
 */
public class Basket {

    private ArrayList<Product> basket;

    //constructor
    public Basket() {
        basket = new ArrayList<>();
    }

    /**
    * This method is used to calculate the total price of the procuts of
    * the basket.
    * @return double  This is the total price of the products of the basket.
    */
    public double totalPrice() {
        double total = 0;
        for (Product product : basket) {
            total += product.getPrice();
        }
        return total;
    }

    /**
    * This method is used to add a product to a user's basket.
    * @param product  This is a refrence to the Product onject that we want to add
    * to the basket.
    */
    public void addProduct(Product product) {
        basket.add(product);
    }

    /**
    * This method is used to remove a product from user's basket.
    * @param index  This is the index of the product that we want to
    * delete in the ArrayList.
    */
    public void removeProduct(int index) {
        basket.remove(index - 1);
    }

    
    public ArrayList<Product> getBasket() {
        return basket;
    }

    /**
    * This method is used after user decides to checkout.
    * it removes all the products from the ArrayList of the products. 
    */
    public void clearBasket() {
        basket.clear();
    }

    /**
    * This method is used to print information of all the 
    * products that are in the user's basket.
    */
    public void showBasket() {
        if (basket.size() == 0) {
            System.out.println("There is nothing in the basket.");
            return;
        }
        for (int i = 0; i < basket.size(); i++) {
            System.out.println(i + 1 + ". " + basket.get(i).getName() + " " + basket.get(i).getCategory() + " " + basket.get(i).getPrice());
        }
    }

    
    public int getBasketSize() {
        return basket.size();
    }


    public Product getProduct(int index) {
        return basket.get(index - 1);
    }

}
