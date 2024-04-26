package org.example.view;// view.CustomerSearchFrm96.java
import org.example.DAO.PaymentDAO96;
import org.example.model.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class CustomerSearchFrm96 extends JFrame {
    private JTextField txtInputName;
    private JButton btnSearch;
    private JTable tblKhachHang96;

    private PaymentDAO96 paymentDAO;

    public CustomerSearchFrm96() {
        setTitle("Customer Search Form");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 400);
        setLayout(new BorderLayout());

        paymentDAO = new PaymentDAO96();

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());
        txtInputName = new JTextField(20);
        inputPanel.add(txtInputName);
        btnSearch = new JButton("Search");
        inputPanel.add(btnSearch);

        JPanel tablePanel = new JPanel();
        tablePanel.setLayout(new BorderLayout());
        tblKhachHang96 = new JTable();
        JScrollPane scrollPane = new JScrollPane(tblKhachHang96);
        tablePanel.add(scrollPane, BorderLayout.CENTER);

        JPanel selectPanel = new JPanel();
        selectPanel.setLayout(new FlowLayout());
        JButton btnSelect = new JButton("Select");
        selectPanel.add(btnSelect);


        add(inputPanel, BorderLayout.NORTH);
        add(tablePanel, BorderLayout.CENTER);
        add(selectPanel, BorderLayout.SOUTH);

        btnSelect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = tblKhachHang96.getSelectedRow();
                String id = tblKhachHang96.getValueAt(row, 0).toString();
                openBookingListForm(id);
            }
        });
        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = txtInputName.getText();
                searchCustomer(name);
            }
        });
    }

    private void searchCustomer(String name) {
        try {

            List<KhachHang96> customers = paymentDAO.searchCustomerByName(name);
            displayCustomers(customers);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void displayCustomers(List<KhachHang96> customers) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Name");
        model.addColumn("Email");
        model.addColumn("Address");
        for (KhachHang96 customer : customers) {
            model.addRow(new Object[]{customer.getId(), customer.getName(), customer.getEmail(), customer.getAddress()});
        }
        tblKhachHang96.setModel(model);
    }

    private void openBookingListForm(String id) {
        BookingListFrm96 bookingListFrm96 = new BookingListFrm96(id);
        bookingListFrm96.setVisible(true);
    }

}