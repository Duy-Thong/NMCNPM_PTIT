package model1;

import java.util.List;
import java.util.UUID;

public class SanThuePhatSinh96 {
    private String id;
    private SanMini96 sanMini;
    private List<ThoiGian96> thoiGianThue;
    private float price;
    private String reason;

    // Một constructor rằng
    public SanThuePhatSinh96() {
        this.id = UUID.randomUUID().toString();
    }
    // Constructor
    public SanThuePhatSinh96( SanMini96 sanMini, List<ThoiGian96> thoiGianThue, String reason) {
        this.id = UUID.randomUUID().toString();
        this.sanMini = sanMini;
        this.thoiGianThue = thoiGianThue;
        // Tính giá tiền dựa trên giá của sân mini và số giờ thuê
        this.price = getPrice();
        this.reason = reason;
    }

    // Getter and Setter methods
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public SanMini96 getSanMini() {
        return sanMini;
    }

    public void setSanMini(SanMini96 sanMini) {
        this.sanMini = sanMini;
    }

    public List<ThoiGian96> getThoiGianThue() {
        return thoiGianThue;
    }

    public void setThoiGianThue(List<ThoiGian96> thoiGianThue) {
        this.thoiGianThue = thoiGianThue;
    }

    public float getPrice() {
        float price = 0;
        for (ThoiGian96 thoiGian : thoiGianThue) {
            price += sanMini.getPrice() * (thoiGian.getEndTime() - thoiGian.getStartTime());
        }
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
