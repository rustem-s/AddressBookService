package me.pio.addressbook.service.domain;

import javax.persistence.*;

/**
 * Created by Rustem.Saidaliyev on 22.11.2015.
 */
@Entity
@Table(name = "company")
public class Company {

    private Long id;
    private String name;

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
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
