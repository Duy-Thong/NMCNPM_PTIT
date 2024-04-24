package model1;

import java.util.UUID;

public class MatHangDaSuDung96 {
    private String id;
    private MatHang96 matHang;
    private int quantity;
    private float total;
    public MatHangDaSuDung96() {
        this.id = UUID.randomUUID().toString();
    }
    // Constructor
    public MatHangDaSuDung96( MatHang96 matHang, int quantity) {
        this.id = UUID.randomUUID().toString();
        this.matHang = matHang;
        this.quantity = quantity;
        // Tính tổng dựa trên quantity nhân với giá của mặt hàng
        this.total = quantity * matHang.getPrice();
    }

    // Getter and Setter methods
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public MatHang96 getMatHang() {
        return matHang;
    }

    public void setMatHang(MatHang96 matHang) {
        this.matHang = matHang;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        this.total = quantity * matHang.getPrice();
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
}
