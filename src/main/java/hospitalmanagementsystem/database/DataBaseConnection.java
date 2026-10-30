package hospitalmanagementsystem.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

// Opens connections to the SQLite database and creates the tables the first time the app runs
public class DataBaseConnection {
    // The database is a single file named hospital.db, created in the folder the app is run from
    private static final String URL = "jdbc:sqlite:hospital.db";

    // Returns a new connection to the database file
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL);
    }

    // Creates the patients and appointments tables if they don't exist yet
    public static void initialize() {
        String patients = "CREATE TABLE IF NOT EXISTS patients ("
                + "id INTEGER PRIMARY KEY, "
                + "name TEXT NOT NULL, "
                + "age INTEGER, "
                + "gender TEXT, "
                + "medical_history TEXT)";

        String appointments = "CREATE TABLE IF NOT EXISTS appointments ("
                + "appointment_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "patient_id INTEGER NOT NULL, "
                + "patient_name TEXT, "
                + "patient_age INTEGER, "
                + "patient_gender TEXT, "
                + "doctor_name TEXT, "
                + "medical_history TEXT, "
                + "concern TEXT, "
                + "appointment_date TEXT, "
                + "urgency_level INTEGER)";

        try (Connection conn = getConnection(); Statement st = conn.createStatement()) {
            st.execute(patients);
            st.execute(appointments);
        } catch (SQLException e) {
            System.err.println("Could not set up the database: " + e.getMessage());
        }
    }
}