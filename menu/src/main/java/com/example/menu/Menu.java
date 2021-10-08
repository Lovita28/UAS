package com.example.menu;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Menu {
    private @Id @GeneratedValue Long id;
    private String name;
    private Long price;
    private String image;
    private String description;

    Menu() {}

    Menu(String name, Long price, String image, String description){
        this.name = name;
        this.price = price;
        this.image = image;
        this.description = description;
    }

    public Long getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public Long getPrice(){
        return this.price;
    }

    public String getImage(){
        return this.image;
    }

    public String getDescription(){
        return this.description;
    }

    public void setId(Long id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setPrice(Long price){
        this.price = price;
    }

    public void setImage(String image){
        this.image = image;
    }

    public void setDescription(String description){
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
        return true;
        if (!(o instanceof Menu))
        return false;
        Menu menu = (Menu) o;
        return Objects.equals(this.id, menu.id) && Objects.equals(this.name, menu.name)
                && Objects.equals(this.price, menu.price)
                && Objects.equals(this.image, menu.image)
                && Objects.equals(this.description, menu.description);
            
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.price, this.image, this.description);
    }

    @Override
    public String toString() {
        return "Menu{" + "id=" + this.id + ", name='" + this.name + '\'' + ", price='" + this.price + '\'' + ", image='" + this.image + '\'' +", description='" + this.description + '\'' +'}';
    }

}
