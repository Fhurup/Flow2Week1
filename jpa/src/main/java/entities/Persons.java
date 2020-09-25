/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author fh
 */
@Entity
public class Persons implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int year;

    @ManyToMany(mappedBy = "persons", cascade = CascadeType.PERSIST)
    List<SwimStyle> styles;

    @OneToMany(mappedBy = "person", cascade = CascadeType.PERSIST)
    List<Fee> fees;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Address address;

    public List<Fee> getFees() {
        return fees;
    }

    public void addFees(Fee fee) {
        this.fees.add(fee);
        if (fee != null) {
            fee.setPerson(this);
        }
    }

    public void addSwimStyle(SwimStyle ss) {
        if (ss != null) {
            this.styles.add(ss);
            ss.getPersons().add(this);
        }

    }

    public void removeSwimStyle(SwimStyle ss){
        if(ss != null){
            styles.remove(ss);
            ss.getPersons().remove(this);
        }
    }
    
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
        if (address != null) {
            address.setPerson(this);
        }
    }

    public Long getId() {
        return id;
    }

    public Persons(String name, int year) {
        this.name = name;
        this.year = year;
        this.fees = new ArrayList<>();
        this.styles = new ArrayList<>();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Persons() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

}
