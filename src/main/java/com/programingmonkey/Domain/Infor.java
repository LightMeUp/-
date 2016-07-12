package com.programingmonkey.Domain;

import com.sun.management.MissionControl;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Feng on 7/11/16.
 */
@Component
@Entity
@Table(name = "Infor",schema = "CompusLifeAssistance")
public class Infor {
    private int id;
    private int level;
    private int expr;
    private int integral;
    private Count count;
    private Set<Mission> mwatched; // watched mission
    private Set<Mission> mpublished; // published mission
    private Set<Mission> maccepted; // acceped mission;
    private Set<MissionType>subscriptions; // 我的订阅
    private Set<Count> friends;
    private Set<Chat> chathistory;

    @OneToMany
    public Set<Count> getFriends() {
        return friends;
    }

    public void setFriends(Set<Count> friends) {
        this.friends = friends;
    }

    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExpr() {
        return expr;
    }

    public void setExpr(int expr) {
        this.expr = expr;
    }

    public int getIntegral() {
        return integral;
    }

    public void setIntegral(int integral) {
        this.integral = integral;
    }

    @OneToMany
    public Set<Mission> getMwatched() {
        return mwatched;
    }

    public void setMwatched(Set<Mission> mwatched) {
        this.mwatched = mwatched;
    }

    @OneToMany
    public Set<Mission> getMpublished() {
        return mpublished;
    }

    public void setMpublished(Set<Mission> mpublished) {
        this.mpublished = mpublished;
    }
    @OneToMany
    public Set<Mission> getMaccepted() {
        return maccepted;
    }

    public void setMaccepted(Set<Mission> maccepted) {
        this.maccepted = maccepted;
    }
    @OneToMany
    public Set<MissionType> getSubscriptions() {
        return subscriptions;
    }
    public void setSubscriptions(Set<MissionType> subscriptions) {
        this.subscriptions = subscriptions;
    }

    @OneToOne
    @JoinColumn
    public Count getCount() {
        return count;
    }

    public void setCount(Count count) {
        this.count = count;
    }

    @OneToMany
    public Set<Chat> getChathistory() {
        return chathistory;
    }

    public void setChathistory(Set<Chat> chathistory) {
        this.chathistory = chathistory;
    }
}
