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
        }
    public PhieuThueSan96( KhachHang96 khachHang, List<SanThue96> listSanThue) {
        this.id = UUID.randomUUID().toString();
        this.khachHang = khachHang;
        this.listSanThue = listSanThue;
        this.listSanThuePhatSinh = new ArrayList<>();
        this.listMatHang = new ArrayList<>();
        this.createTime = new Date(); // Lấy thời gian hiện tại
        this.paymentAmount = getPaymentAmount();
        this.deposit = paymentAmount * 0.1f;    
        this.status = "Chưa thanh toán";
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
    }

    public List<SanThuePhatSinh96> getListSanThuePhatSinh() {
        return listSanThuePhatSinh;
    }

    public void setListSanThuePhatSinh(List<SanThuePhatSinh96> listSanThuePhatSinh) {
        this.listSanThuePhatSinh = listSanThuePhatSinh;
    }

    public List<MatHangDaSuDung96> getListMatHang() {
        return listMatHang;
    }

    public void setListMatHang(List<MatHangDaSuDung96> listMatHang) {
        this.listMatHang = listMatHang;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public float getPaymentAmount() {
        float paymentAmount = 0;
        for (SanThue96 sanThue : listSanThue) {
            paymentAmount += sanThue.getPrice();
        }
        for (SanThuePhatSinh96 sanThue : listSanThuePhatSinh) {
            paymentAmount += sanThue.getPrice();
        }
        for (MatHangDaSuDung96 matHang : listMatHang) {
            paymentAmount += matHang.getTotal();
        }        
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
}
