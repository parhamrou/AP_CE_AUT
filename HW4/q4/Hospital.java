import java.util.ArrayList;

public class Hospital {

    private ArrayList<Doctor> doctors;
    private ArrayList<Patient> patients;

    // constructor
    public Hospital() {
        doctors = new ArrayList<>();
        patients = new ArrayList<>();
    }

    public ArrayList<Doctor> getDoctors() {
        return doctors;
    }

    public ArrayList<Patient> getPatients() {
        return patients;
    }

    /**
     * This method is for adding a new doctor to the doctors list in this class. 
     * @param doctor The new object from Doctor class that we want to add to doctors.
     */
    public void addDoctor(Doctor doctor) {
        if (doctors.contains(doctor)) {
            System.out.println("The doctor is in the list already!");
            return;
        }
        doctors.add(doctor);
        System.out.println("The doctor is added succesfully!");
    }

    /**
     * This method is for adding a new patient to the patients list in this class.
     * In this method, the information of the new patient is given from the user and 
     * then if the patienhas not been added before, it will be added to the list.
     */
    public void addPatient() {
        Main.input.nextLine();
        System.out.printf("Enter the patient's first name: ");
        String firstName = Main.input.nextLine();
        System.out.printf("Enter the patient's last name: ");
        String lastName = Main.input.nextLine();
        System.out.printf("Enter the patient's age: ");
        int age = Main.input.nextInt();
        Main.input.nextLine();
        System.out.printf("Enter the patient's address: ");
        String address = Main.input.nextLine();
        Patient patient = new Patient(firstName, lastName, age, address);
        if (patients.contains(patient)) {
            System.out.println("This patient has been added!");
            return;
        }
        patients.add(patient);
        System.out.println("The patient is added succesfully!");
    }

    /**
     * This method is for viewing the infomation of all doctors in the class.
     */
    public void viewDoctors() {
        if (doctors.size() == 0) {
            System.out.println("There is no doctor in the list!");
            return;
        }
        int index = 1;
        for (Doctor doctor : doctors) {
            System.out.printf(index + ". ");
            doctor.viewDoctor();
            index++;
        }
    }

    /**
     * This method is for viewing the information of all patients in the class.
     * @return it will return if there is no patient in the last and return 1 if at least there is one patient.
     */
    public int viewPatients() {
        if (patients.size() == 0) {
            Main.clearScreen();
            System.out.println("There is no patient in the list!");
            return -1;
        }
        int index = 1;
        Main.clearScreen();
        for (Patient patient : patients) {
            System.out.print(index + ". ");
            patient.viewPatient();
            index++;
        }
        return 1;
    }
}