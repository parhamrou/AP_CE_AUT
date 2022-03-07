
public class MenuHandler {
   
    String[] firstMenu; 
    String[] clientMenu;

    public MenuHandler() {
        firstMenu = new String[] {"Signup", "Login client", "Login admin", "Exit"};
        clientMenu = new String[] {"Order drink", "Cancel order", "Log out"};
    }

    public void printFirstMenu() {
        for (int i = 0; i < firstMenu.length; i++) {
            System.out.println(i + 1 + "- " + firstMenu[i]);
        }
    }

    public void printClientMenu() {
        for (int i = 0; i < clientMenu.length; i++) {
            System.out.println(i + 1 + "- " + clientMenu[i]);
        }
    }

    public void printAdminMenu() {
        System.out.println("Enter your ID: ");
    }

}
