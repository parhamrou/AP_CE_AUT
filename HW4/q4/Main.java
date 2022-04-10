import java.util.Scanner;

public class Main {
    /**
     * This is the main method. We manage the program and show the first menu in this method.
     */
    public static final Scanner input = new Scanner(System.in);
    public static void main(String[] args) {     

        Hospital hospital = new Hospital();
        Admin admin = new Admin();
        clearScreen();
        FirstMenu();
        int choice = input.nextInt();
        while (choice != 5) {
            switch (choice) {
                case 1:
                    clearScreen();
                    System.out.printf("Enter the password of the admin: ");
                    int password = input.nextInt();
                    if (password != 123) {
                        System.out.println("Your password isn't correct!");
                        break;
                    }
                    admin.adminMenuHandler(hospital);
                    break;

                case 2:
                    if (hospital.viewPatients() == -1) {
                        System.out.println("Press enter to back to menu...");
                        Main.input.nextLine();
                        Main.input.nextLine();
                        break;
                    }
                    System.out.println("\nEnter the index of the patient: ");
                    int index = input.nextInt();
                    if (index < 0 || index > hospital.getPatients().size()) {
                        clearScreen();
                        System.out.println("Invalid index!");
                        System.out.println("Press enter to back to menu...");
                        Main.input.nextLine();
                        Main.input.nextLine();
                        Main.clearScreen();
                        break;
                    }
                    hospital.getPatients().get(index - 1).patientMenuHandler(hospital);
                    break;

                case 3:
                    clearScreen();
                    hospital.viewDoctors();
                    System.out.printf("Enter the index of the doctor: ");
                    index = input.nextInt();
                    if (index < 0 || index > hospital.getDoctors().size()) {
                        System.out.println("Invalid index!");
                        System.out.println("Press enter to back to menu...");
                        Main.input.nextLine();
                        Main.input.nextLine();
                        break;
                    }
                    hospital.getDoctors().get(index - 1).doctorMenuHandler(hospital);
                    break;

                case 4:
                    clearScreen();
                    hospital.addPatient();
                    System.out.println("Press enter to back to menu...");
                    Main.input.nextLine();

                    break;
                    
                default:
                    clearScreen();
                    System.out.println("Invalid input!");
                    System.out.println("Press enter to back to menu...");
                    Main.input.nextLine();
                    Main.input.nextLine();
                    break;
            }
            clearScreen();
            FirstMenu();
            choice = input.nextInt();
        }
    }

    /**
     * This method shows the first menu of program.
     */
    private static void FirstMenu() {
        System.out.println("1. ADMIN - LOGIN");
        System.out.println("2. PATIENT - LOGIN");
        System.out.println("3. DOCTOR - LOGIN");
        System.out.println("4. PATIENT - SIGNUP");
        System.out.println("5. EXIT");
    }

    /**
     * This method is for cleaning the console.
     */
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
