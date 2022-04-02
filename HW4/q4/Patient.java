import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Patient {
    
    private String firstName;
    private String lastName;
    private int age;
    private String address;
    private ArrayList<Report> reports;

    //constructor
    public Patient(String firstName, String lastName, int age, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.address = address;
        reports = new ArrayList<>();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public void addReport(Report report) {
        reports.add(report);
    }

    public void viewPatient() {
        System.out.println("Name: " + firstName + " " + lastName);
        System.out.println("Age: " + age);
        System.out.println("Address: " + address);
        System.out.println();
    }

    public void patientMenuHandler(Hospital hospital) {
        Main.clearScreen();
        printMenu();
        int choice = Main.input.nextInt();
        while (choice != 4) {
            switch (choice) {
                case 1:
                    Main.clearScreen();
                    viewPatient();
                    System.out.println("Press enter to back to menu...");
                    Main.input.nextLine();
                    Main.input.nextLine();
                    Main.clearScreen();
                    break;

                case 2:
                    Main.input.nextLine();
                    Main.clearScreen();
                    System.out.println("Enter the type of doctor: ");
                    String type = Main.input.nextLine();
                    switch (type.toLowerCase()) {
                        case "eyes specialist":
                        case "ear specialist":
                        case "heart specialist":
                        case "bones specialist":
                        case "lungs specialist":
                            Main.clearScreen();
                            bookAppointment(hospital, type);
                            break;
                            
                        default: 
                            System.out.println("The doctor's type is invalid!");
                            System.out.println("Press enter to back to menu...");
                            Main.input.nextLine();
                            break;
                    }
                    break;

                case 3:
                    Main.clearScreen();
                    viewReports(); // must be corrected
                    System.out.println("Press enter to back to menu...");
                    Main.input.nextLine();
                    Main.input.nextLine();             
                    break;

                default:
                    System.out.println("Invalid input!");
                    System.out.println("Press enter to back to menu...");
                    Main.input.nextLine();
                    Main.input.nextLine();
                    break;
            }
            Main.clearScreen();
            printMenu();
            choice = Main.input.nextInt();
        }
    }

    private void printMenu() {
        System.out.println("1. ViewProfile");
        System.out.println("2. BookAppointments");
        System.out.println("3. ViewReport");
        System.out.println("4. LogOut");
    }

    private ArrayList<Doctor> viewProperDoctors(Hospital hospital, String type) {
        int index = 1;
        ArrayList<Doctor> doctors = new ArrayList<>();
        for (Doctor doctor : hospital.getDoctors()) {
            if (doctor.getDoctorType().toLowerCase().equals(type.toLowerCase())) {
                System.out.printf("%d. ", index);
                doctor.viewDoctor();
                doctors.add(doctor);
                index++;
            }
        }
        return doctors;
    }

    private void bookAppointment(Hospital hospital, String type) {
        Main.clearScreen();
        ArrayList<Doctor> properDoctors = viewProperDoctors(hospital, type);
        if (properDoctors.size() == 0) {
            System.out.println("There is no doctor with this type!");
            return;
        } 
        System.out.printf("\nEnter the index of the doctor you want: ");
        int choice = Main.input.nextInt();
        if (choice <= 0 || choice > properDoctors.size()) {
            return;
        }
        Doctor doctor = properDoctors.get(choice - 1);
        // this part must be changed
        LocalDateTime date = LocalDateTime.now().plusDays(7);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String formattedDateTime = date.format(formatter);
        Appointment appointment  = new Appointment(doctor.getFirstName(), doctor.getLastName(), this.firstName, this.lastName, doctor.getDoctorType(), formattedDateTime);
        doctor.addAppointment(appointment);
        System.out.println("The appointment is added!");
        System.out.println("Press enter to back to menu...");
        Main.input.nextLine();
        Main.input.nextLine();
    }
    
    private void viewReports() {
        Main.clearScreen();
        if (reports.size() == 0) {
            System.out.println("There is no report for this patient!");
            return;
        }
        int index = 1;
        for (Report report : reports) {
            System.out.println(index);
            System.out.println("Doctor: " + report.getDoctorFirstName() + " " + report.getDoctorLastName());
            System.out.println("Medicine prescribed: " + report.getMedicinePrescribed());
            index++;
        }
        System.out.printf("\nEnter the index of report: ");
        int choice = Main.input.nextInt();
        while (choice < 1 || choice > reports.size()) {
            System.out.printf("Invalid index. Try again: ");
            choice = Main.input.nextInt();
        }
        Main.clearScreen();
        reports.get(choice - 1).showReport();
    }

    @Override
    public boolean equals(Object obj) {
        Patient patient = (Patient) obj;
        if (!this.firstName.equals(patient.getFirstName()) || !this.lastName.equals(patient.getLastName()) || this.age != patient.getAge()) {
            return false;
        }
        return true;
    }
}
