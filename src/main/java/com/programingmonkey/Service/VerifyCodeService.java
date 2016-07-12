package com.programingmonkey.Service;

import com.programingmonkey.Dao.Implements.VerifyCodeDao;
import com.programingmonkey.Domain.VerifyCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by Feng on 7/12/16.
 */
@Service
public class VerifyCodeService {
    @Autowired
    private VerifyCodeDao dao;

    public  void  add(VerifyCode code){
        dao.add(code);
    }

    public  void delete(VerifyCode verifyCode){
        dao.delete(verifyCode);
    }
    public void update(VerifyCode verifyCode){
        dao.update(verifyCode);
    }
    public VerifyCode findByOptions(String mobile,String verifycode){
       return  dao.findByOptions(mobile,verifycode);
    }
    public boolean isVerifyCodeEffective(String mobile,String verifycode){
        VerifyCode verifyCode = findByOptions(mobile,verifycode);
        Date current  = new Date();
        // 当前系统时间 小于 验证码的失效时间,返回true
        if (current.getTime()<= verifyCode.getActivetime().getTime())
            return true;  // 验证码有效
        else return  false;    // 验证码失效
    }
    public boolean isTooOften(String mobile){
        VerifyCode verifyCode =dao.findByMobile(mobile);
        if (verifyCode==null)return false;
        else {
            if (new Date().getTime() -verifyCode.getRequesttime().getTime() <60 * 1000)
                return true;
            else return false;
        }

    }

}
