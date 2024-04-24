import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PaymentDAO96 {
    private Connection dbConnect;

    // Constructor
    public PaymentDAO96(Connection dbConnect) {
        this.dbConnect = dbConnect;
    }

    // Search customer by name
    public void SearchCustomer(String name) {
        String query = "SELECT * FROM Customers WHERE name = ?";
        try {
            PreparedStatement statement = dbConnect.prepareStatement(query);
            statement.setString(1, name);
            ResultSet result = statement.executeQuery();
            // Process the result...
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exceptions
        }
    }

    // Find booking invoice by id
    public void TimPhieuDatSan(String id) {
        String query = "SELECT * FROM BookingInvoices WHERE id = ?";
        try {
            PreparedStatement statement = dbConnect.prepareStatement(query);
            statement.setString(1, id);
            ResultSet result = statement.executeQuery();
            // Process the result...
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exceptions
        }
    }

    // Create invoice
    public void TaoHoaDon() {
        String query = "INSERT INTO Invoices (column1, column2, ...) VALUES (?, ?, ...)";
        try {
            PreparedStatement statement = dbConnect.prepareStatement(query);
            // Set parameters for the statement
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exceptions
        }
    }
}
