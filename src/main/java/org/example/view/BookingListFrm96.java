package org.example.view;

import org.example.DAO.PaymentDAO96;
import org.example.model.PhieuThueSan96;

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
        JTextArea txtCustomerInfo = new JTextArea();
        txtCustomerInfo.setText("Customer ID: " + customerId);
        panel.add(txtCustomerInfo, BorderLayout.NORTH);
        tblPhieuThueSan96 = new JTable();
        JScrollPane scrollPane = new JScrollPane(tblPhieuThueSan96);
        panel.add(scrollPane, BorderLayout.CENTER);
        btnThanhToan = new JButton("Thanh Toán");
        panel.add(btnThanhToan, BorderLayout.SOUTH);

        add(panel, BorderLayout.CENTER);
        loadBookingList(customerId);
        btnThanhToan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = tblPhieuThueSan96.getSelectedRow();
                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(BookingListFrm96.this, "Please select a booking");
                    return;
                }
                String bookingId = (String) tblPhieuThueSan96.getValueAt(selectedRow, 0);
                PhieuThueSan96 booking = paymentDAO.getBookingById(bookingId);
                processPayment( booking);
            }
        });


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
        model.addColumn("Create Time");
        model.addColumn("Deposit");
        model.addColumn("Price");
        model.addColumn("Status");

        for (PhieuThueSan96 booking : bookings) {
            model.addRow(new Object[]{booking.getId(), booking.getCreateTime(), booking.getDeposit(), booking.getPaymentAmount() , booking.getStatus()});
        }
        tblPhieuThueSan96.setModel(model);
    }

    private void processPayment( PhieuThueSan96 booking) {
        InvoiceFrm96 invoiceFrm96 = new InvoiceFrm96(booking);
        invoiceFrm96.setVisible(true);
        setVisible(false);

        JOptionPane.showMessageDialog(this, "Payment processed successfully!");
    }
}