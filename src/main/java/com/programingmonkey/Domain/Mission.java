package com.programingmonkey.Domain;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by Feng on 7/11/16.
 */
@Component
@Entity
@Table
public class Mission {
    private int id;
    private MissionType missionType;       // 任务类型编码
    private String content;       // 任务内容
    private Location location;   // 地点
    private Date publishDate;   // 任务发布时间
    private Date startDate;     // 任务开始时间
    private Date endDate;       // 任务结束日期
    private Set<Message> messages;   // 留言
    private Count publisher;   // 任务发布状态
    private MissionStatus missionStatus;
    private Count recipient;   // 任务接受者
    private Date acceptDate;// 任务接受日期


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @OneToOne
    public MissionType getTypecode() {
        return missionType;
    }

    public void setTypecode(MissionType typecode) {
        this.missionType = typecode;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @OneToOne
    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    @OneToMany
    public Set<Message> getMessages() {
        return messages;
    }

    public void setMessages(Set<Message> messages) {
        this.messages = messages;
    }

    @OneToOne
    public Count getPublisher() {
        return publisher;
    }

    public void setPublisher(Count publisher) {
        this.publisher = publisher;
    }

    public MissionStatus getMissionStatus() {
        return missionStatus;
    }

    public void setMissionStatus(MissionStatus missionStatus) {
        this.missionStatus = missionStatus;
    }
    @OneToOne
    public Count getRecipient() {
        return recipient;
    }

    public void setRecipient(Count recipient) {
        this.recipient = recipient;
    }

    public Date getAcceptDate() {
        return acceptDate;
    }

    public void setAcceptDate(Date acceptDate) {
        this.acceptDate = acceptDate;
    }
}
