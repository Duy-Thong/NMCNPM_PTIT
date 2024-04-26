package org.example.view;

import org.example.DAO.PaymentDAO96;
import org.example.model.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InvoiceFrm96 extends JFrame {
    private JTextField txtMaPhieuThue;
    private JTextField txtThongTinKhachHang;
    private JTable tblSanThue96;
    private JTable tblSanThuePhatSinh96;
    private JTable tblMatHangDaSuDung96;
    private JTextField txtTienCoc;
    private JTextField txtTong;
    private JTextField txtTrangThai;
    private JButton btnSuaHoaDon;
    private JButton btnThanhToanNgay;

    private PaymentDAO96 paymentDAO;

    public InvoiceFrm96(PhieuThueSan96 phieuThueSan96) {
        setTitle("Invoice");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 600);
        setLayout(new BorderLayout());

        paymentDAO = new PaymentDAO96();

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(8, 2));

        JLabel lblMaPhieuThue = new JLabel("Mã Phiếu Thuê:");
        panel.add(lblMaPhieuThue);
        txtMaPhieuThue = new JTextField();
        txtMaPhieuThue.setEditable(false);
        panel.add(txtMaPhieuThue);

        JLabel lblThongTinKhachHang = new JLabel("Thông Tin Khách Hàng:");
        panel.add(lblThongTinKhachHang);
        txtThongTinKhachHang = new JTextField();
        txtThongTinKhachHang.setEditable(false);
        panel.add(txtThongTinKhachHang);

        JLabel lblSanThue96 = new JLabel("Danh Sách Sân Thuê:");
        panel.add(lblSanThue96);
        tblSanThue96 = new JTable();
        JScrollPane scrollPaneSanThue96 = new JScrollPane(tblSanThue96);
        panel.add(scrollPaneSanThue96);

        JLabel lblSanThuePhatSinh96 = new JLabel("Danh Sách Sân Thuê Phát Sinh:");
        panel.add(lblSanThuePhatSinh96);
        tblSanThuePhatSinh96 = new JTable();
        JScrollPane scrollPaneSanThuePhatSinh96 = new JScrollPane(tblSanThuePhatSinh96);
        panel.add(scrollPaneSanThuePhatSinh96);

        JLabel lblMatHangDaSuDung96 = new JLabel("Danh Sách Mặt Hàng Đã Sử Dụng:");
        panel.add(lblMatHangDaSuDung96);
        tblMatHangDaSuDung96 = new JTable();

        JScrollPane scrollPaneMatHangDaSuDung96 = new JScrollPane(tblMatHangDaSuDung96);
        panel.add(scrollPaneMatHangDaSuDung96);

        JLabel lblTienCoc = new JLabel("Tiền Cọc:");
        panel.add(lblTienCoc);
        txtTienCoc = new JTextField();
        txtTienCoc.setEditable(false);
        panel.add(txtTienCoc);

        JLabel lblTong = new JLabel("Tổng:");
        panel.add(lblTong);
        txtTong = new JTextField();
        txtTong.setEditable(false);
        panel.add(txtTong);

        JLabel lblTrangThai = new JLabel("Trạng Thái:");
        panel.add(lblTrangThai);
        txtTrangThai = new JTextField();
        txtTrangThai.setEditable(false);
        panel.add(txtTrangThai);

        btnSuaHoaDon = new JButton("Sửa Hóa Đơn");
        panel.add(btnSuaHoaDon);

        btnThanhToanNgay = new JButton("Thanh Toán Ngay");
        panel.add(btnThanhToanNgay);

        add(panel, BorderLayout.CENTER);

        loadInvoiceDetails(phieuThueSan96);

        btnSuaHoaDon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                suaHoaDon(phieuThueSan96);
            }
        });

        btnThanhToanNgay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                thanhToanNgay(phieuThueSan96);
            }
        });
    }

    private void loadInvoiceDetails(PhieuThueSan96 phieuThueSan96) {
        // Load invoice details from the provided PhieuThueSan96 object
        txtMaPhieuThue.setText(phieuThueSan96.getId());
        txtThongTinKhachHang.setText(phieuThueSan96.getKhachHang().getName());
        DefaultTableModel modelSanThue96 = new DefaultTableModel();
        modelSanThue96.addColumn("ID");
        modelSanThue96.addColumn("Tên Sân");
        modelSanThue96.addColumn("Giá");
        for (SanThue96 sanThue : phieuThueSan96.getListSanThue()) {
            modelSanThue96.addRow(new Object[]{sanThue.getId(), sanThue.getSanMini().getName(), sanThue.getPrice()});
        }
        tblSanThue96.setModel(modelSanThue96);

        DefaultTableModel modelSanThuePhatSinh96 = new DefaultTableModel();
        modelSanThuePhatSinh96.addColumn("ID");
        modelSanThuePhatSinh96.addColumn("Tên Sân");
        modelSanThuePhatSinh96.addColumn("Giá");
        modelSanThuePhatSinh96.addColumn("Lý Do");
        for (SanThuePhatSinh96 sanThuePhatSinh : phieuThueSan96.getListSanThuePhatSinh()) {
            modelSanThuePhatSinh96.addRow(new Object[]{sanThuePhatSinh.getId(), sanThuePhatSinh.getSanMini().getName(), sanThuePhatSinh.getPrice(), sanThuePhatSinh.getReason()});
        }
        tblSanThuePhatSinh96.setModel(modelSanThuePhatSinh96);

        DefaultTableModel modelMatHangDaSuDung96 = new DefaultTableModel();
        modelMatHangDaSuDung96.addColumn("ID");
        modelMatHangDaSuDung96.addColumn("Tên Mặt Hàng");
        modelMatHangDaSuDung96.addColumn("Số Lượng");
        modelMatHangDaSuDung96.addColumn("Giá");
        for (MatHangDaSuDung96 matHangDaSuDung : phieuThueSan96.getListMatHang()) {
            modelMatHangDaSuDung96.addRow(new Object[]{matHangDaSuDung.getId(), matHangDaSuDung.getMatHang().getName(), matHangDaSuDung.getQuantity(), matHangDaSuDung.getTotal()});
        }
        tblMatHangDaSuDung96.setModel(modelMatHangDaSuDung96);
        txtTienCoc.setText(String.valueOf(phieuThueSan96.getDeposit()));
        txtTong.setText(String.valueOf(phieuThueSan96.getPaymentAmount()));
        txtTrangThai.setText(phieuThueSan96.getStatus());
    }

    private void suaHoaDon(PhieuThueSan96 phieuThueSan96) {
        // Add your code here to edit the invoice
    }

    private void thanhToanNgay(PhieuThueSan96 phieuThueSan96) {
        // Process instant payment
        paymentDAO.createHoaDonFromPhieuThueSan(phieuThueSan96);
        JOptionPane.showMessageDialog(this, "Thanh toán thành công!");
        ManagerFrm96 managerFrm96 = new ManagerFrm96();
        managerFrm96.setVisible(true);
        setVisible(false);
    }
}
