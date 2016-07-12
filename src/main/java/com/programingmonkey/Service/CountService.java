package com.programingmonkey.Service;
import com.programingmonkey.Dao.Implements.CountDao;
import com.programingmonkey.Domain.Count;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Feng on 7/12/16.
 */
@Service
public class CountService {
    @Autowired
    private CountDao dao;
    public void create(Count count) {
        dao.add(count);
    }

    public boolean isRegist(String mobile){
        List<Count> counts= dao.findByMobile(mobile);
       if (counts==null || counts.size() <1){
           return false;   //not regist;
       }
        else  return true;

    }
}
