package hospitalmanagementsystem.dsa;

import hospitalmanagementsystem.model.Appointments;
import hospitalmanagementsystem.model.Doctor;
import hospitalmanagementsystem.model.Patient;

import java.util.*;

public class SystemDataStructures {

    private PatientBST patientTree;
    private Map<Integer, Patient> patientHashMap;
    private Map<Integer, Doctor> doctorMap;
    private PriorityQueue<Appointments> appointmentPriorityQueue;
    
    // List to keep history of all appointments for GUI tables & reporting
    private List<Appointments> appointmentHistory;

    public SystemDataStructures() {
        this.patientTree = new PatientBST();
        this.patientHashMap = new HashMap<>();
        this.doctorMap = new HashMap<>();
        this.appointmentHistory = new ArrayList<>();

        // Priority Queue ordered by Urgency Level
        this.appointmentPriorityQueue = new PriorityQueue<>();
    }

    // --- PATIENT MANAGEMENT ---
    public void addPatient(Patient patient) {
        patientTree.insert(patient);
        patientHashMap.put(patient.getId(), patient);
    }

    public Patient getPatient(int patientId) {
        return patientHashMap.get(patientId);
    }

    public boolean verifyPatientExists(int patientId) {
        return patientHashMap.containsKey(patientId);
    }

  public void removePatient(int patientId) {
    patientTree.remove(patientId);
    patientHashMap.remove(patientId);
}

    public List<Patient> getAllPatients() {
        return new ArrayList<>(patientHashMap.values());
    }

    // --- DOCTOR MANAGEMENT ---
    public void addDoctor(Doctor doctor) {
        doctorMap.put(doctor.getId(), doctor);
    }

    public Doctor getDoctor(int doctorId) {
        return doctorMap.get(doctorId);
    }

    // ADDED: Returns Doctor list directly usable by JComboBox drop-downs in GUI
    public List<Doctor> getDoctorList() {
        return new ArrayList<>(doctorMap.values());
    }

    // --- APPOINTMENT MANAGEMENT ---
    public void scheduleAppointment(Appointments appointment) {
        appointmentPriorityQueue.add(appointment);
        appointmentHistory.add(appointment); // Save to total history

        Patient patient = patientHashMap.get(appointment.getPatientId());
        if (patient != null) {
            patient.getAppointments().add(appointment);
        }

        Doctor doctor = doctorMap.get(appointment.getDoctorId());
        if (doctor != null && patient != null) {
            doctor.assignPatient(patient.getId());
        }
    }

    public Appointments processNextAppointment() {
        return appointmentPriorityQueue.poll();
    }

    // ADDED: Returns full history for appointment tables
    public List<Appointments> getAppointmentHistory() {
        return appointmentHistory;
    }

    public PriorityQueue<Appointments> getAppointmentPriorityQueue() {
        return appointmentPriorityQueue;
    }
}