
public class Admin {

    /**
     * This method is for adding new doctor to the hospital by the admin.
     * @param hospital This is the hospital object that we want to add the doctor to.
     */
    private void addDoctor(Hospital hospital) {
        System.out.printf("Enter doctor's first name: ");
        String firstName = Main.input.nextLine();
        System.out.printf("Enter doctor's last name: ");
        String lastName = Main.input.nextLine();
        System.out.printf("Enter doctor's age: ");
        int age = Main.input.nextInt();
        Main.input.nextLine();
        if (age < 0) { // cheking the age is valid or not
            System.out.println("The age is invalid!");
            return;
        }
        System.out.printf("Enter doctor's type: ");
        String doctorType = Main.input.nextLine();
        
        // cheking if the doctor's type is valid or not
        switch (doctorType.toLowerCase()) {
            case "eyes specialist":
            case "ear specialist":
            case "heart specialist":
            case "bones specialist":
            case "lungs specialist":
                break;

            default: 
                System.out.println("The doctor's type is invalid!");
                System.out.println("Press enter to back to menu...");
                Main.input.nextLine();
                return;
        }
        System.out.printf("Enter doctor's entry charge: ");
        double entryCharge = Main.input.nextDouble();
        Doctor doctor = new Doctor(firstName, lastName, age, doctorType, entryCharge);
        hospital.addDoctor(doctor);
        System.out.println("Press enter to back to menu...");
        Main.input.nextLine();
        Main.input.nextLine();
    }

    /**
     * This method is for viewing the information of doctors of the hospital.
     * @param hospital  This is the hospital that we want to show its doctors' information.
     */
    private void viewDoctors(Hospital hospital) {
        hospital.viewDoctors();
    }

    /**
     * This method is for viewing the information of the patients of the hospital.
     * @param hospital This is the hospital that we wnat to show its patients' information.
     */
    private void viewPatients(Hospital hospital) {
        if (hospital.viewPatients() == -1) {
            return;
        }
    }

    /**
     * This method is for printing the admin's menu.
     */
    private void menuPrinter() {
        System.out.println("1. DoctorsList");
        System.out.println("2. PatientsList");
        System.out.println("3. AddDoctor");
        System.out.println("4. LogOut");
    }

    /**
     * This method is for managing the choices of the user and calling the proper methods.
     * @param hospital This is the hospital that we want to work with its methods and...
     */
    public void adminMenuHandler(Hospital hospital) {
        Main.clearScreen();
        menuPrinter();
        int choice = Main.input.nextInt();
        while (choice != 4) {
            switch (choice) {
                case 1:
                    Main.clearScreen(); 
                    viewDoctors(hospital);
                    System.out.println("Press enter to back to menu...");
                    Main.input.nextLine();
                    Main.input.nextLine();
                    break;

                case 2:
                    Main.clearScreen();
                    viewPatients(hospital);
                    System.out.println("Press enter to back to menu...");
                    Main.input.nextLine();
                    Main.input.nextLine();
                    break;
            
                case 3:
                    Main.input.nextLine();
                    Main.clearScreen();
                    addDoctor(hospital);
                    break;

               default:
                    System.out.println("Your input is invalid!");
                    System.out.println("Press enter to back to menu...");
                    Main.input.nextLine();
                    Main.input.nextLine();
            }
        Main.clearScreen();
        menuPrinter();
        choice = Main.input.nextInt();
        }
    }
}
