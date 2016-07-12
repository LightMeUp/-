package com.programingmonkey.Utils;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;
import java.util.UUID;

/**
 * Created by Feng on 7/12/16.
 */
public class StringUtil {
    private static  String[] str={"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"
            ,"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z",
    "0","1","2","3","4","5","6","7","8","9"};


    // get a rand string
    public static String  getSalt(){
        return RandomStringUtils.randomAlphabetic(16);
    }

    public static int RandomNumber(){
            Random random = new Random();
        return random.nextInt(str.length);
    }
    public static String getVerifyCode(){
        String verifyCode="";
        for (int i=0;i<6;i++){
            verifyCode+= str[RandomNumber()];
        }
        return verifyCode;
    }

    public static String getUUID(){
        UUID uuid =UUID.randomUUID();
        return uuid.toString();
    }

}
