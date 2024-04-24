public class SanMini96 {
    private String id;
    private String name;
    private float price;
    private String type;
    private String description;
    
    // Constructor rỗng
    public SanMini96() {
       this.id = UUID.randomUUID().toString();
    }
    // Constructor
    public SanMini96(String id, String name, float price, String type, String description) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.price = price;
        this.type = type;
        this.description = description;
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
