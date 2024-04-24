import java.util.UUID;

public class SanThuePhatSinh96 {
    private String id;
    private SanMini96 sanMini;
    private ThoiGian96 thoiGianThue;
    private float price;
    private String reason;

    // Một constructor rằng
    public SanThuePhatSinh96() {
        this.id = UUID.randomUUID().toString();
    }
    // Constructor
    public SanThuePhatSinh96( SanMini96 sanMini, ThoiGian96 thoiGianThue, String reason) {
        this.id = UUID.randomUUID().toString();
        this.sanMini = sanMini;
        this.thoiGianThue = thoiGianThue;
        // Tính giá tiền dựa trên giá của sân mini và số giờ thuê
        this.price = sanMini.getPrice() * (thoiGianThue.getEndTime() - thoiGianThue.getStartTime());
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

    public ThoiGian96 getThoiGianThue() {
        return thoiGianThue;
    }

    public void setThoiGianThue(ThoiGian96 thoiGianThue) {
        this.thoiGianThue = thoiGianThue;
    }

    public float getPrice() {
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
