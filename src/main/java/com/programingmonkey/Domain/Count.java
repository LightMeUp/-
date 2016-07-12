package com.programingmonkey.Domain;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Feng on 7/11/16.
 */
@Component
@Entity(name = "Count")
@Table(name = "Count",schema = "CompusLifeAssistance")
public class Count {

    private String id;   // 账号
    private String name;  // 姓名
    private String sex;   // 性别
    private java.sql.Date birthday;  // 出生日期
    private String  mobile;   // 手机号
    private String email;   // 邮箱
    private String instroduction;   // 个人介绍
    private int ischecked;     // 是否已经认证
    private String SecurityToken;   // 安全码
    private Infor infor;
    private Date registDate;
    private Date lastLoginDate;
    private String salt;



    @Id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "name",length = 15)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "sex",length = 4)
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @DateTimeFormat
    public java.sql.Date getBirthday() {
        return birthday;
    }

    public void setBirthday(java.sql.Date birthday) {
        this.birthday = birthday;
    }
    @Column(name = "mobile",length = 11,unique = true)
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @Column(name = "instroduction",length = 40)
    public String getInstroduction() {
        return instroduction;
    }

    public void setInstroduction(String instroduction) {
        this.instroduction = instroduction;
    }
    @Column(name = "ischecked")
    public int getIschecked() {
        return ischecked;
    }

    public void setIschecked(int ischecked) {
        this.ischecked = ischecked;
    }

    @Column(name = "securitytoken",unique = true)
    public String getSecurityToken() {
        return SecurityToken;
    }

    public void setSecurityToken(String securityToken) {
        SecurityToken = securityToken;
    }

    @OneToOne(cascade = CascadeType.REMOVE )
    public Infor getInfor() {
        return infor;
    }

    public void setInfor(Infor infor) {
        this.infor = infor;
    }


    public Date getRegistDate() {
        return registDate;
    }

    public void setRegistDate(Date registDate) {
        this.registDate = registDate;
    }

    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}
