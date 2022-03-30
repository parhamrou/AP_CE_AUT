import java.util.Scanner;

public class Main {
    public static final Scanner input = new Scanner(System.in);
    public static void main(String[] args) {     

        Hospital hospital = new Hospital();
        Admin admin = new Admin();

        FirstMenu();
        int choice = input.nextInt();
        while (choice != 5) {
            switch (choice) {
                case 1:
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
                        break;
                    }
                    System.out.println("Enter the index of the patient: ");
                    int index = input.nextInt();
                    if (index < 0 || index > hospital.getPatients().size()) {
                        System.out.println("Invalid index!");
                        break;
                    }
                    hospital.getPatients().get(index - 1).patientMenuHandler(hospital);
                    break;

                case 3:
                    hospital.viewDoctors();
                    System.out.println("Inter the index of the doctor: ");
                    index = input.nextInt();
                    if (index < 0 || index > hospital.getDoctors().size()) {
                        System.out.println("Invalid index!");
                        break;
                    }
                    hospital.getDoctors().get(index - 1).doctorMenuHandler(hospital);
                    break;

                case 4:
                    hospital.addPatient();
                    break;
                    
                default:
                    System.out.println("Invalid input!");
                    break;
            }
            FirstMenu();
            choice = input.nextInt();
        }
    }

    private static void FirstMenu() {
        System.out.println("1. ADMIN - LOGIN");
        System.out.println("2. PATIENT - LOGIN");
        System.out.println("3. DOCTOR - LOGIN");
        System.out.println("4. PATIENT - SIGNUP");
        System.out.println("5. EXIT");
    }

    public static void clearScreen() {
        System.out.print("Everything on the console will cleared");
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
