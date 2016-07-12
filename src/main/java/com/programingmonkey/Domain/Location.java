package com.programingmonkey.Domain;

import org.springframework.stereotype.Component;

import javax.persistence.*;

/**
 * Created by Feng on 7/11/16.
 */
@Entity
@Component
@Table
public class Location {
    private int id;
    private String locationcode;
    private String name;
    private String locationdesc;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocationcode() {
        return locationcode;
    }

    public void setLocationcode(String locationcode) {
        this.locationcode = locationcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocationdesc() {
        return locationdesc;
    }

    public void setLocationdesc(String locationdesc) {
        this.locationdesc = locationdesc;
    }
}
