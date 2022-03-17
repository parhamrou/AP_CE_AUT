import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * This class is used to keep the information of the different products
 * of the store. it has different fields to have the different information of 
 * the products.
 */
public class Product {

    private String name;
    private String category;
    private double price;
    private LocalDateTime manufactureDate;
    private LocalDateTime expirationDate;

    // constructor
    public Product(String name, String category, double price, String manufactureDate, String expirationDate) {
        this.name = name;
        this.category = category;
        this.price = price;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        this.manufactureDate = LocalDateTime.parse(manufactureDate, formatter);
        this.expirationDate = LocalDateTime.parse(expirationDate, formatter);
    }


    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }
    
    
    @Override
    public String toString() {
        String string = String.format("name= '%s'    category= '%s'    price= %.2f    manufactureDate= %s    expirationDate= %s", name, category, price, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm").format(manufactureDate), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm").format(expirationDate));
        return string;
    }
}