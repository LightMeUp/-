package com.programingmonkey.Utils;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * Created by Feng on 7/12/16.
 */
public class SaltEncrypt {
    public static String Encrypt(String password,String salt){
        return DigestUtils.md5Hex(password+salt);
    }
}
