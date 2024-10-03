public class Procedure {
    // Fields
    private String procedureName;
    private String procedureDate;
    private String practitionerName;
    private double procedureCharges;

    // No-arg constructor
    public Procedure() {
        this.procedureName = "";
        this.procedureDate = "";
        this.practitionerName = "";
        this.procedureCharges = 0.0;
    }

    // Constructor with procedure name and date
    public Procedure(String procedureName, String procedureDate) {
        this.procedureName = procedureName;
        this.procedureDate = procedureDate;
        this.practitionerName = "";
        this.procedureCharges = 0.0;
    }

    // Constructor with all attributes
    public Procedure(String procedureName, String procedureDate, String practitionerName, double procedureCharges) {
        this.procedureName = procedureName;
        this.procedureDate = procedureDate;
        this.practitionerName = practitionerName;
        this.procedureCharges = procedureCharges;
    }

    // Accessor (getter) methods
    public String getProcedureName() { return procedureName; }
    public String getProcedureDate() { return procedureDate; }
    public String getPractitionerName() { return practitionerName; }
    public double getProcedureCharges() { return procedureCharges; }

    // Mutator (setter) methods
    public void setProcedureName(String procedureName) { this.procedureName = procedureName; }
    public void setProcedureDate(String procedureDate) { this.procedureDate = procedureDate; }
    public void setPractitionerName(String practitionerName) { this.practitionerName = practitionerName; }
    public void setProcedureCharges(double procedureCharges) { this.procedureCharges = procedureCharges; }

    // toString method to display all procedure information
   
    public String toString() {
        return "    Procedure: " + procedureName + "\n" +
               "    ProcedureDate= " + procedureDate + "\n" +
               "    Practitioner= " + practitionerName + "\n" +
               "    Charge=" + procedureCharges + "\n";
    }
}
