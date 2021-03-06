package com.example.arfurniture.models;

import java.io.Serializable;

public class WishlistModel implements Serializable {
    String id, name, image,description,i1,i2,i3,i4;
    Long price;

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setI1(String i1) {
        this.i1 = i1;
    }

    public void setI2(String i2) {
        this.i2 = i2;
    }

    public void setI3(String i3) {
        this.i3 = i3;
    }

    public void setI4(String i4) {
        this.i4 = i4;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }

    public String getI1() {
        return i1;
    }

    public String getI2() {
        return i2;
    }

    public String getI3() {
        return i3;
    }

    public String getI4() {
        return i4;
    }

    public Long getPrice() {
        return price;
    }
}
