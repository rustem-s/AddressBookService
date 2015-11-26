package me.pio.addressbook.service.domain;

import javax.persistence.*;

/**
 * Created by Rustem.Saidaliyev on 22.11.2015.
 */
@Entity
@Table(name = "address")
public class Address {

    private Long id;
    private String address;
    private String city;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
