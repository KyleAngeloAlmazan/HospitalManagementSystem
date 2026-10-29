package hospitalmanagementsystem.dsa;

import hospitalmanagementsystem.model.Appointments;
import hospitalmanagementsystem.model.Doctor;
import hospitalmanagementsystem.model.Patient;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class SystemDataStructures {
    private PriorityQueue<Appointments> appointments;
    private List<Appointments> history;
    private PatientBST patientBST;

    public SystemDataStructures() {
        appointments = new PriorityQueue<>();
        history = new ArrayList<>();
        patientBST = new PatientBST();
    }
    
    // Verify if a patient exists by ID (Hashing / BST check)
    public boolean verifyPatientExists(int patientId) {
        // If you are using your PatientBST or a hash map for verification:
        return patientBST.search(patientId) != null; 
    }

    // Add a new patient to the system
    public void addPatient(Patient patient) {
        if (patient != null) {
            patientBST.insert(patient);
        }
    }

    // Adds appointment to the priority queue and history list
    public void addAppointment(Appointments a, Patient p, Doctor d) {
        appointments.offer(a);
        history.add(a);

        // Adds appointment to the patient if patient exists
        if (p != null) {
            p.getAppointments().add(a);
        }

        // Assigns patient to the doctor if doctor exists (Parsed to int to match Doctor model)
        if (d != null) {
            try {
                d.assignPatient(Integer.parseInt(a.getPatientId()));
            } catch (NumberFormatException e) {
                // Fallback if patientId contains letters; adjust Doctor.java if needed
                System.err.println("Error parsing patient ID to int: " + e.getMessage());
            }
        }
    }

    // Gets the next highest-priority appointment
    public Appointments processNextAppointment() {
        return appointments.poll();
    }

    // Gets all appointment records
    public List<Appointments> getAppointmentHistory() {
        return history;
    }

    // Gets the appointment priority queue
    public PriorityQueue<Appointments> getAppointmentPriorityQueue() {
        return appointments;
    }
}