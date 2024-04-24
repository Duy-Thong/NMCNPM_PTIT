package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model1.*;
public class PaymentDAO96 {
    // Database connection
    private Connection dbConnect;

    public PaymentDAO96() {
        // Initialize database connection
        // You need to implement this method based on your database configuration
        dbConnect = initializeDBConnection();
    }

    private Connection initializeDBConnection() {
        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Set up the connection properties
            String dbURL = "jdbc:mysql://localhost:3306/nmcnpm";
            String username = "root";
            String password = "";

            Connection connection = DriverManager.getConnection(dbURL, username, password);
            return connection;
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    // Method to search customers by name
    public List<KhachHang96> searchCustomerByName(String name) throws SQLException {
        List<KhachHang96> customers = new ArrayList<>();
        String query = "SELECT * FROM tblKhachHang96 WHERE name LIKE ?";
        try {
            PreparedStatement statement = dbConnect.prepareStatement(query);
            statement.setString(1, "%" + name + "%");
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                KhachHang96 customer = new KhachHang96();
                customer.setId(result.getString("id"));
                customer.setName(result.getString("name"));
                customer.setEmail(result.getString("email"));
                customer.setAddress(result.getString("address"));
                customers.add(customer);
            }
        } catch (SQLException ex) {
            throw ex;
        }
        return customers;
    }

    public List<PhieuThueSan96> getBookingsByCustomerId(String customerId) throws SQLException {
        List<PhieuThueSan96> bookings = new ArrayList<>();
        String query = "SELECT * FROM tblPhieuThueSan96 WHERE customerId = ?";
        try {
            PreparedStatement statement = dbConnect.prepareStatement(query);
            statement.setString(1, customerId);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                PhieuThueSan96 booking = new PhieuThueSan96();
                booking.setId(result.getString("id"));
                booking.setKhachHang(getCustomerById(result.getString("customerId")));
                booking.setListMatHang(getUsedProductsByBookingId(booking.getId()));
                booking.setListSanThue(getRentalsByBookingId(booking.getId()));
                booking.setListSanThuePhatSinh(getRentalInAdvanceByBookingId(booking.getId()));
                booking.setCreateTime(result.getDate("createTime"));
                bookings.add(booking);
            }
        } catch (SQLException ex) {
            throw ex;
        }
        return bookings;
    }

    private List<SanThuePhatSinh96> getRentalInAdvanceByBookingId(String id) {
        List<SanThuePhatSinh96> rentals = new ArrayList<>();
        String query = "SELECT * FROM tblSanThuePhatSinh96 WHERE phieuThueSanId = ?";
        try {
            PreparedStatement statement = dbConnect.prepareStatement(query);
            statement.setString(1, id);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                SanThuePhatSinh96 rental = new SanThuePhatSinh96();
                rental.setId(result.getString("id"));
                rentals.add(rental);
            }
            return rentals;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return rentals;
    }


    private KhachHang96 getCustomerById(String customerId) {
        String query = "SELECT * FROM tblKhachHang96 WHERE id = ?";
        try {
            PreparedStatement statement = dbConnect.prepareStatement(query);
            statement.setString(1, customerId);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                KhachHang96 customer = new KhachHang96();
                customer.setId(result.getString("id"));
                customer.setName(result.getString("name"));
                customer.setEmail(result.getString("email"));
                customer.setAddress(result.getString("address"));
                return customer;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    private List<MatHangDaSuDung96> getUsedProductsByBookingId(String id) {
        List<MatHangDaSuDung96> products = new ArrayList<>();
        String query = "SELECT * FROM tblMatHangDaSuDung96 WHERE phieuThueSanId = ?";
        try {
            PreparedStatement statement = dbConnect.prepareStatement(query);
            statement.setString(1, id);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                MatHangDaSuDung96 product = new MatHangDaSuDung96();
                product.setId(result.getString("id"));
                products.add(product);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return products;
    }

    private List<SanThue96> getRentalsByBookingId(String id) {
        List<SanThue96> rentals = new ArrayList<>();
        String query = "SELECT * FROM tblSanThue96 WHERE phieuThueSanId = ?";
        try {
            PreparedStatement statement = dbConnect.prepareStatement(query);
            statement.setString(1, id);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                SanThue96 rental = new SanThue96();
                rental.setId(result.getString("id"));
                rentals.add(rental);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return rentals;
    }


    public void createHoaDonFromPhieuThueSan(PhieuThueSan96 booking) {
        String query = "INSERT INTO tblHoaDonThueSan96 (id, phieuThueSanId, totalAmount) VALUES (?, ?, ?)";
        try {
            PreparedStatement statement = dbConnect.prepareStatement(query);
            statement.setString(1, booking.getId());
            statement.setString(2, booking.getId());
            statement.setDouble(3, booking.getPaymentAmount());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public PhieuThueSan96 getBookingById(String bookingId) {
        String query = "SELECT * FROM tblPhieuThueSan96 WHERE id = ?";
        try {
            PreparedStatement statement = dbConnect.prepareStatement(query);
            statement.setString(1, bookingId);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                PhieuThueSan96 booking = new PhieuThueSan96();
                booking.setId(result.getString("id"));
                booking.setKhachHang(getCustomerById(result.getString("customerId")));
                booking.setListMatHang(getUsedProductsByBookingId(booking.getId()));
                booking.setListSanThue(getRentalsByBookingId(booking.getId()));
                booking.setListSanThuePhatSinh(getRentalInAdvanceByBookingId(booking.getId()));
                booking.setCreateTime(result.getDate("createTime"));
                return booking;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
