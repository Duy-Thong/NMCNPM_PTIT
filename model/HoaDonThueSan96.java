import java.util.Date;

public class HoaDonThueSan96 {
    private String id;
    private User96 user;
    private PhieuThueSan96 phieuThueSan;
    private Date createTime;
    private float paymentAmount;
    private String status;
    private String note;

    // Empty constructor
    public HoaDonThueSan96() {
        
    }
    // Constructor
    public HoaDonThueSan96(String id, User96 user, PhieuThueSan96 phieuThueSan, String status, String note) {
        this.id = id;
        this.user = user;
        this.phieuThueSan = phieuThueSan;
        this.createTime = new Date();
        this.paymentAmount = phieuThueSan.getPaymentAmount() - phieuThueSan.getDeposit();
        this.status = status;
        this.note = note;
    }

    // Getter and Setter methods
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User96 getUser() {
        return user;
    }

    public void setUser(User96 user) {
        this.user = user;
    }

    public PhieuThueSan96 getPhieuThueSan() {
        return phieuThueSan;
    }

    public void setPhieuThueSan(PhieuThueSan96 phieuThueSan) {
        this.phieuThueSan = phieuThueSan;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
