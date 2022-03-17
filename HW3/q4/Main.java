import java.util.Scanner;

/**
 * This is the Main class. in this class and in
 * the main method, we read the user's commands and 
 * call the proper methods from different objects to 
 * do the commands.
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Store store = new Store();

        // reading the user's choice for the first time
        String choice = input.nextLine();
        while (!choice.equals("exit")) {
            // spliting the String
            String[] strArray = choice.split(" ");
            if (choice.contains("add.p")) {
                store.addperson(strArray[1], strArray[2], Double.parseDouble(strArray[3]));        
            
            } else if (choice.contains("balance")) {
                store.changeBalance(strArray[1], Double.parseDouble(strArray[2]));
            
            } else if (choice.contains("people")) {
                store.printPeople();
            
            } else if (choice.contains("menu")) {
                store.printMenu();
            
            } else if (choice.contains("order")) {
                store.addOrder(strArray[1], strArray[2]);
            
            } else if (choice.contains("checkout")) {
                store.checkout(strArray[1]);
            
            } else if (choice.contains("basket")) {
                store.printBasket(strArray[1]);
            
            } else if (choice.contains("remove.b")) {
                store.removeBasketProduct(strArray[1], Integer.parseInt(strArray[2]));
            
            } else if (choice.contains("inventory") && choice.contains("remove")) {
                if (!strArray[1].equals("ceit-2022")) {
                    System.out.println("Invalid password.");
                } else {
                    store.removeInventory(strArray[3]);
                }
            
            } else if (choice.contains("inventory") && choice.contains("change")) {
                if (!strArray[1].equals("ceit-2022")) {
                    System.out.println("Invalid password.");
                } else {
                    store.changeStock(strArray[3], Integer.parseInt(strArray[4]));
                }
            
            } else {
                System.out.println("Invalid input.");
            }
            // reading user's choice again
            choice = input.nextLine();
        }
        System.out.println("Have a nice day, chief.");
    }
}