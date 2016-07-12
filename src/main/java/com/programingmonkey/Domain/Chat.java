package com.programingmonkey.Domain;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Feng on 7/11/16.
 */
@Entity
@Component
@Table
public class Chat {
    private int id;
    private Count sender;
    private Count reciver;
    private Date  date;
    private String content;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @OneToOne
    public Count getSender() {
        return sender;
    }

    public void setSender(Count sender) {
        this.sender = sender;
    }
    @OneToOne
    public Count getReciver() {
        return reciver;
    }

    public void setReciver(Count reciver) {
        this.reciver = reciver;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
