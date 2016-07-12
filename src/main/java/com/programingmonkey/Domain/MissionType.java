package com.programingmonkey.Domain;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Feng on 7/11/16.
 */
@Component
@Entity
@Table
public class MissionType {
    private String typeCode;
    private String name;
    private String instroction;

    @Id
    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInstroction() {
        return instroction;
    }

    public void setInstroction(String instroction) {
        this.instroction = instroction;
    }

//    MTExpress,
//    MTCourse,
//    MTFood,
//    MTHomeWork,
//    MTAccompany,
}
