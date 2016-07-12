package com.programingmonkey.Domain;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Feng on 7/12/16.
 */
@Entity
@Component
@Table
public class Message {
    private int id;
    private Mission mission;
    private Count sender;
    private Date sendDate;
    private String Content;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @ManyToOne
    public Mission getMission() {
        return mission;
    }

    public void setMission(Mission mission) {
        this.mission = mission;
    }
    @ManyToOne
    public Count getSender() {
        return sender;
    }

    public void setSender(Count sender) {
        this.sender = sender;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
