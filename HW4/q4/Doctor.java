import java.lang.ref.Cleaner.Cleanable;
import java.util.ArrayList;

public class Doctor {
    
    private String firstName;
    private String lastName;
    private int age;
    private String doctorType;
    private double entryCharge;
    private ArrayList<Appointment> appointments;

    //constructor
    public Doctor(String firstName, String lastName, int age, String doctorType, double entryCharge) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.doctorType = doctorType;
        this.entryCharge = entryCharge;
        appointments = new ArrayList<>();
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

    public ArrayList<Appointment> getAppointments() {
        return appointments;
    }

    public double getEntryCharge() {
        return entryCharge;
    }
    
    public void viewDoctor() {
        System.out.println("Name: " + firstName + " " + lastName);
        System.out.println("Doctor's type: " + doctorType);
        System.out.println("Entry Charge: " + entryCharge);
        System.out.println();
    }
    
    public String getDoctorType() {
        return doctorType;
    }

    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

    private int ViewAppointments() {
        int index = 1;
        for (Appointment appointment : appointments) {
            System.out.printf("%d. \n", index);
            appointment.showAppointment();
            index++;
        }
        if (index == 1) {
            System.out.println("The list is empty!");
            return -1;
        }
        return 1;
    }

    private void addReport(Hospital hospital) {
        if (ViewAppointments() == -1) {
            System.out.println("Press enter to back to menu...");
            Main.input.nextLine();
            Main.input.nextLine(); 
            return;
        }
        Main.input.nextLine();
        System.out.printf("\nEnter the index of the appointment: ");
        int choice = Main.input.nextInt();
        if (choice <= 0 || choice > appointments.size()) {
            System.out.println("Invalid index!");
            return;
        }
        Patient patient = searchPatient(appointments.get(choice - 1).getPatientFirstName(), appointments.get(choice - 1).getPatientLastName(), hospital);
        Main.input.nextLine();
        Main.clearScreen();
        System.out.printf("Write the prescribed of the report: ");
        String prescribed = Main.input.nextLine();
        System.out.printf("Write your comment: ");
        String comment = Main.input.nextLine();
        Report report = new Report(this.firstName, this.lastName, patient.getFirstName(), patient.getLastName(), prescribed, comment);
        patient.addReport(report);
        appointments.remove(choice - 1); // removing the appointment after writing the report
        System.out.println("The report is added!");
        System.out.println("Press enter to back to menu...");
        Main.input.nextLine(); 
    }

    private void menuPrinter() {
        System.out.println("1. ViewProfile");
        System.out.println("2. ViewAppointments");
        System.out.println("3. Logout");
    }

    public void doctorMenuHandler(Hospital hospital) {
        Main.clearScreen();
        menuPrinter();
        int choice = Main.input.nextInt();
        while (choice != 3) {
            switch (choice) {
                case 1:
                    Main.clearScreen();
                    viewDoctor();
                    System.out.println("Press enter to back to menu...");
                    Main.input.nextLine();
                    Main.input.nextLine();
                    break;

                case 2:
                    Main.clearScreen();
                    addReport(hospital);   
                    break;

                default:
                    break;
            }
            Main.clearScreen();
            menuPrinter();
            choice = Main.input.nextInt();
        }
    }

    private Patient searchPatient(String firstName, String lastName, Hospital hospital) {
        for (Patient patient : hospital.getPatients()) {
            if (firstName.equals(patient.getFirstName()) && lastName.equals(patient.getLastName())) {
                return patient;
            }
        }
        return null;
    }

    @Override
    public boolean equals(Object obj) {
        Doctor doctor = (Doctor) obj;
        if (!this.firstName.equals(doctor.getFirstName()) || !this.lastName.equals(doctor.getLastName()) || this.age != doctor.getAge() || !this.doctorType.equals(doctor.getDoctorType())) {
            return false;
        }
        return true;
    }
}
