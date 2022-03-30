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
        System.out.println("Address: \n" + address);
    }

    public void patientMenuHandler(Hospital hospital) {
        printMenu();
        int choice = Main.input.nextInt();
        while (choice != 4) {
            switch (choice) {
                case 1:
                    viewPatient();
                    break;

                case 2:
                    Main.input.nextLine();
                    System.out.println("Enter the type of doctor: ");
                    String type = Main.input.nextLine();
                    switch (type.toLowerCase()) {
                        case "eyes specialist":
                        case "ear specialist":
                        case "heart specialist":
                        case "bones specialist":
                        case "lungs specialist":
                            bookAppointment(hospital, type);
                            break;
                            
                        default: 
                            System.out.println("The doctor's type is invalid!");
                            break;
                    }
                    break;

                case 3:
                    viewReports(); // must be corrected                
                    break;

                default:
                    System.out.println("Invalid input!");
                    break;
            }
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
        ArrayList<Doctor> properDoctors = viewProperDoctors(hospital, type);
        if (properDoctors.size() == 0) {
            return;
        } 
        System.out.printf("Enter the index of the doctor you want: ");
        int choice = Main.input.nextInt();
        if (choice <= 0 || choice > properDoctors.size()) {
            System.out.println("Invalid input!");
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
    }
    
    private void viewReports() {
        if (reports.size() == 0) {
            System.out.println("There is not report for this patient!");
            return;
        }
        for (Report report : reports) {
            report.showReport();
        }
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
