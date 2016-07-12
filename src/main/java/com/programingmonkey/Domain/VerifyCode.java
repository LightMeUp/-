package com.programingmonkey.Domain;
import org.springframework.stereotype.Component;
import javax.persistence.*;
import java.util.Date;

/**
 * Created by Feng on 7/12/16.
 */
@Entity
@Table
@Component
public class VerifyCode {
    private int id;
    private String mobile;          // 电话
    private String verifycode;   // 验证码
    private Date  activetime;  // 有效时间
    private Date requesttime; // 请求验证码时间

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getVerifycode() {
        return verifycode;
    }

    public void setVerifycode(String verifycode) {
        this.verifycode = verifycode;
    }

    public Date getActivetime() {
        return activetime;
    }

    public void setActivetime(Date activetime) {
        this.activetime = activetime;
    }

    public Date getRequesttime() {
        return requesttime;
    }

    public void setRequesttime(Date requesttime) {
        this.requesttime = requesttime;
    }
}
