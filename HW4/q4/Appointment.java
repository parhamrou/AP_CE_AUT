import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Appointment {
    
    private String doctorFirstName;
    private String doctorLastName;
    private String patientFirstName;
    private String patientLastName;
    private String doctorType;
    private LocalDateTime date;

    //constructor
    public Appointment(String doctorFirstName, String doctorLastName, String patientFirstName, String patientLastName, String doctorType, String date) {
        this.doctorFirstName = doctorFirstName;
        this.doctorLastName = doctorLastName;
        this.patientFirstName = patientFirstName;
        this.patientLastName = patientLastName;
        this.doctorType = doctorType;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        this.date = LocalDateTime.parse(date, formatter);
    }

    public String getPatientFirstName() {
        return patientFirstName;
    }

    public String getPatientLastName() {
        return patientLastName;
    }

    public void showAppointment() {
        System.out.println("Patient's name: " + patientFirstName + " " + patientLastName);
        System.out.println("date: " + date);
    } 
}
