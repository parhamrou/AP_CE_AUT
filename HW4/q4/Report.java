public class Report {
    
    private String doctorFirstName;
    private String doctorLastName;
    private String patientFirstName;
    private String patientLastName;
    private String medicinePrescribed;
    private String doctorsComment;

    //constructor
    public Report(String doctorFirstName, String doctorLastName, String patientFirstName, String patientLastName, String medicinePrescribed, String doctorsComment) {
        this.doctorFirstName = doctorFirstName;
        this.doctorLastName = doctorLastName;
        this.patientFirstName = patientFirstName;
        this.patientLastName = patientLastName;
        this.medicinePrescribed = medicinePrescribed;
        this.doctorsComment = doctorsComment;
    }

    public void showReport() {
        System.out.format("Doctor: %s %s\nPatient:  %s %s\nMedicinePrescribed: %s\nDoctor's comment: %s\n\n", doctorFirstName, doctorLastName, patientFirstName, patientLastName, medicinePrescribed, doctorsComment);
    }
}
