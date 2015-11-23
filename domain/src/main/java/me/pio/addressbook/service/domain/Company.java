package me.pio.addressbook.service.domain;

import javax.persistence.*;

/**
 * Created by Rustem.Saidaliyev on 22.11.2015.
 */
@Entity
public class Company {
//    @JsonIgnore
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Company company = (Company) o;

        if (id != company.id) return false;
        if (name != null ? !name.equals(company.name) : company.name != null) return false;

        return true;
    }

}
