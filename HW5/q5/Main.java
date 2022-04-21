public class Main {
    public static void main(String[] args) {
        Site site = new Site();
        site.manager();
    }

    public static void clear() {
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }

    public static void pressEnter() {
        System.out.println("Press Enter to back to menu...");
        Site.scanner.nextLine();
    }
}
