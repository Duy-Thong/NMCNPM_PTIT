import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class BookingListFrm96 extends JFrame {
    private JTable tblPhieuThueSan96;
    private JButton btnThanhToan;

    private PaymentDAO96 paymentDAO;

    public BookingListFrm96(String customerId) {
        setTitle("Booking List");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 400);
        setLayout(new BorderLayout());

        paymentDAO = new PaymentDAO96();

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        tblPhieuThueSan96 = new JTable();
        JScrollPane scrollPane = new JScrollPane(tblPhieuThueSan96);
        panel.add(scrollPane, BorderLayout.CENTER);
        btnThanhToan = new JButton("Thanh Toán");
        panel.add(btnThanhToan, BorderLayout.SOUTH);

        add(panel, BorderLayout.CENTER);

        btnThanhToan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                processPayment();
            }
        });

        loadBookingList(customerId);
    }

    private void loadBookingList(String customerId) {
        try {
            List<PhieuThueSan96> bookings = paymentDAO.getBookingsByCustomerId(customerId);
            displayBookings(bookings);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void displayBookings(List<PhieuThueSan96> bookings) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Start Time");
        model.addColumn("End Time");
        model.addColumn("Price");

        for (PhieuThueSan96 booking : bookings) {
            model.addRow(new Object[]{booking.getId(), booking.getStartTime(), booking.getEndTime(), booking.getPrice()});
        }

        tblPhieuThueSan96.setModel(model);
    }

    private void processPayment() {
        // Add your code here to process payment for the selected booking
    }
}