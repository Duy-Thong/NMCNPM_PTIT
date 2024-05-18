package org.example.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class PhieuThueSan96 {
    private String id;
    private KhachHang96 khachHang;
    private List<SanThue96> listSanThue;
    private List<SanThuePhatSinh96> listSanThuePhatSinh;
    private List<MatHangDaSuDung96> listMatHang;
    private Date createTime;
    private float paymentAmount;
    private float deposit;
    private String status;

    public PhieuThueSan96() {
        this.id = UUID.randomUUID().toString();
        this.listSanThue = new ArrayList<>();
        this.listSanThuePhatSinh = new ArrayList<>();
        this.listMatHang = new ArrayList<>();
        this.createTime = new Date();
        this.status = "Chưa thanh toán";
    }

    public PhieuThueSan96(KhachHang96 khachHang, List<SanThue96> listSanThue) {
        this();
        this.khachHang = khachHang;
        this.listSanThue = listSanThue;
        updatePaymentAndDeposit();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public KhachHang96 getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang96 khachHang) {
        this.khachHang = khachHang;
    }

    public List<SanThue96> getListSanThue() {
        return listSanThue;
    }

    public void setListSanThue(List<SanThue96> listSanThue) {
        this.listSanThue = listSanThue;
        updatePaymentAndDeposit();
    }

    public List<SanThuePhatSinh96> getListSanThuePhatSinh() {
        return listSanThuePhatSinh;
    }

    public void setListSanThuePhatSinh(List<SanThuePhatSinh96> listSanThuePhatSinh) {
        this.listSanThuePhatSinh = listSanThuePhatSinh;
        updatePaymentAndDeposit();
    }

    public List<MatHangDaSuDung96> getListMatHang() {
        return listMatHang;
    }

    public void setListMatHang(List<MatHangDaSuDung96> listMatHang) {
        this.listMatHang = listMatHang;
        updatePaymentAndDeposit();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public float getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(float paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public float getDeposit() {
        return deposit;
    }

    public void setDeposit(float deposit) {
        this.deposit = deposit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private void updatePaymentAndDeposit() {
        this.paymentAmount = calculatePaymentAmount();
        this.deposit = this.paymentAmount * 0.1f;
    }

    private float calculatePaymentAmount() {
        float paymentAmount = 0;
        if (this.listSanThue != null) {
            for (SanThue96 sanThue : this.listSanThue) {
                paymentAmount += sanThue.getPrice();
            }
        }
        if (this.listSanThuePhatSinh != null) {
            for (SanThuePhatSinh96 sanThue : this.listSanThuePhatSinh) {
                paymentAmount += sanThue.getPrice();
            }
        }
        if (this.listMatHang != null) {
            for (MatHangDaSuDung96 matHang : this.listMatHang) {
                paymentAmount += matHang.getTotal();
            }
        }
        return paymentAmount;
    }
}
