package com.programingmonkey.Service;

import com.programingmonkey.Dao.TestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Feng on 7/11/16.
 */
@Service
public class TestService {
    @Autowired
    private TestDao dao;
    public String test(){
        return dao.test();
    }
}
