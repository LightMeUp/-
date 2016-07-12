package com.programingmonkey.Test;

import com.programingmonkey.Utils.SaltEncrypt;
import com.programingmonkey.Utils.StringUtil;
import org.junit.Test;

/**
 * Created by Feng on 7/12/16.
 */
public class UtilsTest {
    @Test
    public void testSaltEncrypt(){
     String HashPWD=  SaltEncrypt.Encrypt("123456", StringUtil.getSalt());
        System.out.println(HashPWD);
    }
    @Test
    public void getRandom(){
        System.out.println(StringUtil.RandomNumber());
    }

    @Test
    public void GetVerifyCode(){
        System.out.println(StringUtil.getVerifyCode());
    }
}
