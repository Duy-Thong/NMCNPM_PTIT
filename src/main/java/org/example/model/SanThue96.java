package org.example.model;

import java.util.List;
import java.util.UUID;

public class SanThue96 {
    private String id;
    private SanMini96 sanMini;
    private List<ThoiGian96> thoiGianThue;
    private float price;

    public SanThue96() {
        this.id = UUID.randomUUID().toString();
    }
    // Constructor
    public SanThue96(SanMini96 sanMini, List<ThoiGian96> thoiGianThue) {
        this.id = UUID.randomUUID().toString();
        this.sanMini = sanMini;
        this.thoiGianThue = thoiGianThue;
        this.price = getPrice();
    }

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
        return (ThoiGian96) thoiGianThue;
    }

    public void setThoiGianThue(ThoiGian96 thoiGianThue) {
        this.thoiGianThue = (List<ThoiGian96>) thoiGianThue;
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
}
