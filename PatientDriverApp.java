
/*
 * Class: CMSC203 
 * Instructor:
 * Description: (Give a brief description for each Class)
 * Due: MM/DD/YYYY
 * Platform/compiler:eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Essemoo Nkemka
*/


public class PatientDriverApp {

    public static void main(String[] args) {
        // Create a Patient object with sample data
        Patient patient = new Patient("John", "A.", "Doe", "123 Main St", "Springfield", "IL", "62704", "217-555-1234", "Jane Doe", "217-555-5678");

        // Create three Procedure objects using different constructors
        Procedure procedure1 = new Procedure(); // No-arg constructor
        procedure1.setProcedureName("X-ray");
        procedure1.setProcedureDate("06/12/2023");
        procedure1.setPractitionerName("Dr. Smith");
        procedure1.setProcedureCharges(250.00);

        Procedure procedure2 = new Procedure("Blood Test", "06/13/2023"); // Constructor with name and date
        procedure2.setPractitionerName("Dr. Brown");
        procedure2.setProcedureCharges(150.00);

        Procedure procedure3 = new Procedure("MRI Scan", "06/14/2023", "Dr. Green", 1250.00); // Constructor with all attributes

        // Display patient information
        displayPatient(patient);

        // Display procedure information
        
        displayProcedure(procedure1);
        displayProcedure(procedure2);
        displayProcedure(procedure3);

        // Calculate and display total charges
        double totalCharges = calculateTotalCharges(procedure1, procedure2, procedure3);
        System.out.printf("\nTotal Charges: $%,.2f\n", totalCharges);
        
        System.out.println("\n \n ");
        System.out.println("Student Name: Essemo'o Nkemka \n" +
            "MC# :\n" +
            "Due Date:10/02/2024");
    }

    // Method to display patient information
    public static void displayPatient(Patient patient) {
       
        System.out.println(patient.toString());
    }

    // Method to display procedure information
    public static void displayProcedure(Procedure procedure) {
        System.out.println(procedure.toString() + "\t");
    }

    // Method to calculate total charges for three procedures
    public static double calculateTotalCharges(Procedure procedure1, Procedure procedure2, Procedure procedure3) {
        return procedure1.getProcedureCharges() + procedure2.getProcedureCharges() + procedure3.getProcedureCharges();
    }
}

