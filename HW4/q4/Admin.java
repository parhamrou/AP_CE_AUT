
public class Admin {
    
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
                return;
        }
        System.out.printf("Enter doctor's entry charge: ");
        double entryCharge = Main.input.nextDouble();
        Doctor doctor = new Doctor(firstName, lastName, age, doctorType, entryCharge);
        hospital.addDoctor(doctor);
    }

    private void viewDoctors(Hospital hospital) {
        hospital.viewDoctors();
    }

    private void viewPatients(Hospital hospital) {
        if (hospital.viewPatients() == -1) {
            return;
        }
    }

    private void menuPrinter() {
        System.out.println("1. DoctorsList");
        System.out.println("2. PatientsList");
        System.out.println("3. AddDoctor");
        System.out.println("4. LogOut");
    }

    public void adminMenuHandler(Hospital hospital) {
        menuPrinter();
        int choice = Main.input.nextInt();
        while (choice != 4) {
            switch (choice) {
                case 1: 
                    viewDoctors(hospital);
                    break;

                case 2:
                    viewPatients(hospital);
                    break;
            
                case 3:
                    Main.input.nextLine();
                    addDoctor(hospital);
                    break;

               default:
                    System.out.println("Your input is invalid!");
            }
        menuPrinter();
        choice = Main.input.nextInt();
        }
    }
}
