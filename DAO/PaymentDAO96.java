import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class PaymentDAO96 {
    private Connection dbConnect;
    public PaymentDAO96() {
        dbConnect = initializeDBConnection();
    }
    private Connection initializeDBConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String dbURL = "jdbc:mysql://localhost:3306/NMCNPM";
            String username = "root";
            String password = "";
            Connection connection = DriverManager.getConnection(dbURL, username, password);
            return connection;
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
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
                customer.setBirthday(result.getDate("birthday"));
                customer.setPhoneNumber(result.getString("phoneNumber"));
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
                booking.setStartTime(result.getTime("startTime"));
                booking.setEndTime(result.getTime("endTime"));
                booking.setPrice(result.getDouble("price"));
                bookings.add(booking);
            }
        } catch (SQLException ex) {
            throw ex;
        }
        return bookings;
    }
    public void createHoaDonFromPhieuThueSan(PhieuThueSan96 phieuThueSan96) throws SQLException {
    String query = "INSERT INTO tblHoaDonThueSan96 (id, userId, phieuThueSanId, createTime, paymentAmount, status, note) VALUES (?, ?, ?, ?, ?, ?, ?)";
    try {
        PreparedStatement statement = dbConnect.prepareStatement(query);
        statement.setString(1, phieuThueSan96.getId()); // ID của hóa đơn
        statement.setString(2, current_user_id); // ID của người dùng
        statement.setString(3, phieuThueSan96.getId()); // ID của phiếu thuê sân
        statement.setTimestamp(4, new Timestamp(System.currentTimeMillis())); // Thời gian tạo hóa đơn
        statement.setFloat(5, phieuThueSan96.getPrice() - phieuThueSan96.getDeposit()); // Số tiền thanh toán
        statement.setString(6, "Đã thanh toán"); // Trạng thái thanh toán
        statement.setString(7, "");// Ghi chú, có thể để trống hoặc thêm ghi chú từ người dùng
        statement.executeUpdate();
    } catch (SQLException ex) {
        throw ex;
    }
    }
}
