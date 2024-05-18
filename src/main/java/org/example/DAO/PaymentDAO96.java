package org.example.DAO;

import org.example.model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class PaymentDAO96 {
    // Database connection
    private Connection dbConnect;

    public PaymentDAO96() {

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
        String query = "SELECT * FROM tblPhieuThueSan96 WHERE khachHangId = ?";
        try {
            PreparedStatement statement = dbConnect.prepareStatement(query);
            statement.setString(1,customerId);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                PhieuThueSan96 booking = new PhieuThueSan96();
                booking.setId(result.getString("id"));
                booking.setKhachHang(getCustomerById(result.getString("khachHangId")));
                booking.setListMatHang(getUsedProductsByBookingId(booking.getId()));
                booking.setListSanThue(getRentalsByBookingId(booking.getId()));
                booking.setListSanThuePhatSinh(getRentalInAdvanceByBookingId(booking.getId()));
                booking.setCreateTime(result.getDate("createTime"));
                booking.setPaymentAmount(result.getFloat("paymentAmount"));
                booking.setDeposit(result.getFloat("deposit"));
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
                String query1 = "SELECT * FROM tblSanMini96 WHERE id = ?";
                PreparedStatement statement1 = dbConnect.prepareStatement(query1);
                statement1.setString(1,result.getString("sanMiniId"));
                ResultSet result1 = statement1.executeQuery();
                if (result1.next()) {
                    SanMini96 sanMini = new SanMini96();
                    sanMini.setId(result1.getString("id"));
                    sanMini.setName(result1.getString("name"));
                    sanMini.setPrice(result1.getFloat("price"));
                    rental.setSanMini(sanMini);
                }
                String query2 = "SELECT * FROM tblThoiGian96 WHERE sanThueId = ?";
                PreparedStatement statement2 = dbConnect.prepareStatement(query2);
                statement2.setString(1,result.getString("id"));
                ResultSet result2 = statement2.executeQuery();
                List<ThoiGianPhatSinh96> times = new ArrayList<>();
                while (result2.next()) {
                    ThoiGianPhatSinh96 time = new ThoiGianPhatSinh96();
                    time.setId(result2.getString("id"));
                    time.setStartTime(result2.getTimestamp("startTime"));
                    time.setEndTime(result2.getTimestamp("endTime"));
                    times.add(time);
                }
                rental.setThoiGianThue(times);
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

    public List<MatHangDaSuDung96> getUsedProductsByBookingId(String id) {
        List<MatHangDaSuDung96> usedproducts = new ArrayList<>();
        String query = "SELECT * FROM tblMatHangDaSuDung96 WHERE phieuThueSanId = ?";
        try {
            PreparedStatement statement = dbConnect.prepareStatement(query);
            statement.setString(1, id);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                MatHangDaSuDung96 usedproduct = new MatHangDaSuDung96();
                usedproduct.setId(result.getString("id"));
                String query1 = "SELECT * FROM tblMatHang96 WHERE id = ?";
                PreparedStatement statement1 = dbConnect.prepareStatement(query1);
                statement1.setString(1,result.getString("matHangId"));
                ResultSet result1 = statement1.executeQuery();
                if (result1.next()) {
                    MatHang96 product = new MatHang96();
                    product.setId(result1.getString("id"));
                    product.setName(result1.getString("name"));
                    product.setPrice(result1.getFloat("price"));
                    usedproduct.setMatHang(product);
                }
                usedproduct.setQuantity(result.getInt("quantity"));
                usedproducts.add(usedproduct);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return usedproducts;
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
                String query1 = "SELECT * FROM tblSanMini96 WHERE id = ?";
                PreparedStatement statement1 = dbConnect.prepareStatement(query1);
                statement1.setString(1,result.getString("sanMiniId"));
                ResultSet result1 = statement1.executeQuery();
                if (result1.next()) {
                    SanMini96 sanMini = new SanMini96();
                    sanMini.setId(result1.getString("id"));
                    sanMini.setName(result1.getString("name"));
                    sanMini.setPrice(result1.getFloat("price"));
                    rental.setSanMini(sanMini);
                }
                String query2 = "SELECT * FROM tblThoiGian96 WHERE sanThueId = ?";
                PreparedStatement statement2 = dbConnect.prepareStatement(query2);
                statement2.setString(1,result.getString("id"));
                ResultSet result2 = statement2.executeQuery();
                List<ThoiGian96> times = new ArrayList<>();
                while (result2.next()) {
                    ThoiGian96 time = new ThoiGian96();
                    time.setId(result2.getString("id"));
                    time.setStartTime(result2.getTimestamp("startTime"));
                    time.setEndTime(result2.getTimestamp("endTime"));
                    times.add(time);
                }
                rental.setThoiGianThue(times);
                rentals.add(rental);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return rentals;
    }


    public void createHoaDonFromPhieuThueSan(PhieuThueSan96 booking) {
        HoaDonThueSan96 invoice = new HoaDonThueSan96();
        String currentUserId = "1";
        String query = "INSERT INTO tblHoaDonThueSan96 (id, userId,phieuThueSanId, paymentAmount,createTime,status) VALUES (?, ?,?,?, ?,?)";
        try {
            PreparedStatement statement = dbConnect.prepareStatement(query);
            statement.setString(1, invoice.getId());
            statement.setString(2,currentUserId );
            statement.setString(3, booking.getId());
            statement.setDouble(4, booking.getPaymentAmount()-booking.getDeposit());
            statement.setDate(5, new Date(System.currentTimeMillis()));
            statement.setString(6, "Da thanh toan");
            statement.executeUpdate();
            String query1 = "UPDATE tblPhieuThueSan96 SET status = ? WHERE id = ?";
            PreparedStatement statement1 = dbConnect.prepareStatement(query1);
            statement1.setString(1, "Da thanh toan");
            statement1.setString(2, booking.getId());
            statement1.executeUpdate();
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
                booking.setKhachHang(getCustomerById(result.getString("khachHangId")));
                booking.setListMatHang(getUsedProductsByBookingId(booking.getId()));
                booking.setListSanThue(getRentalsByBookingId(booking.getId()));
                booking.setListSanThuePhatSinh(getRentalInAdvanceByBookingId(booking.getId()));
                booking.setPaymentAmount(result.getFloat("paymentAmount"));
                booking.setCreateTime(result.getDate("createTime"));
                booking.setDeposit(result.getFloat("deposit"));
                booking.setStatus(result.getString("status"));
                return booking;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
