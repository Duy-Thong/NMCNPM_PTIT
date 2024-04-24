public class User96 {
    private String id;
    private String name;
    private String email;
    private String address;
    private String position;

    public User96() {}
    // Constructor
    public User96(String id, String name, String email, String address, String position) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.position = position;
    }

    // Getter and Setter methods
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
