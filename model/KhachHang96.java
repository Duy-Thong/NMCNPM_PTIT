import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
public class KhachHang96 {
    private String id;
    private String name;
    private String phoneNumber;
    private String email;
    private String address;
    private Date birthday;
    private List<PhieuThueSan96> listPhieuThueSan;
    private List<HoaDonThueSan96> listHoaDon;
    
    // Empty constructor
    public KhachHang96() {
        this.id = UUID.randomUUID().toString();
    }

    // Constructor
    public KhachHang96( String name, String phoneNumber, String email, String address, Date birthday) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.birthday = birthday;
        this.listPhieuThueSan = new ArrayList<>();
        this.listHoaDon = new ArrayList<>();
    }

    // Getter and Setter methods
    public String getId() {
        return id;
    }

    public void setId(String ID) {
        this.id = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public List<PhieuThueSan96> getListPhieuThueSan() {
        return listPhieuThueSan;
    }

    public void setListPhieuThueSan(List<PhieuThueSan96> listPhieuThueSan) {
        this.listPhieuThueSan = listPhieuThueSan;
    }

    public List<HoaDonThueSan96> getListHoaDon() {
        return listHoaDon;
    }

    public void setListHoaDon(List<HoaDonThueSan96> listHoaDon) {
        this.listHoaDon = listHoaDon;
    }
}
