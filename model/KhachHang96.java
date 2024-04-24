import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class KhachHang96 {
    private String ID;
    private String name;
    private String phoneNumber;
    private String email;
    private String address;
    private Date birthday;
    private List<PhieuThueSan96> listPhieuThueSan;
    private List<HoaDon96> listHoaDon;
    
    // Empty constructor
    public KhachHang96() {}

    // Constructor
    public KhachHang96(String ID, String name, String phoneNumber, String email, String address, Date birthday) {
        this.ID = ID;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.birthday = birthday;
        this.listPhieuThueSan = new ArrayList<>();
        this.listHoaDon = new ArrayList<>();
    }

    // Getter and Setter methods
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
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

    public List<HoaDon96> getListHoaDon() {
        return listHoaDon;
    }

    public void setListHoaDon(List<HoaDon96> listHoaDon) {
        this.listHoaDon = listHoaDon;
    }
}
