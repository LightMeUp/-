package com.programingmonkey.Dao.Implements;

import com.programingmonkey.Domain.VerifyCode;
import com.programingmonkey.Utils.EntityManagerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Feng on 7/12/16.
 */
@Repository
public class VerifyCodeDao extends  BaseDaoImp {
    @PersistenceContext
    private EntityManager entityManager;
    public VerifyCode findByOptions(String  mobile,String verifyCode){
        String sql ="select v from VerifyCode v where v.mobile=:mobile and v.verifycode=:verifycode " +
                "order by v.activetime asc ";
       Query query= entityManager.createQuery(sql).setParameter("mobile",mobile).setParameter("verifycode",verifyCode);
        if (query.getResultList()==null || query.getResultList().size() <1)
            return null;
        else
        return (VerifyCode) query.getResultList().get(0);
    }

    public VerifyCode  findByMobile(String  mobile){

        String sql ="select v from VerifyCode  v where  v.mobile=:mobile order by  v.activetime asc";
        Query query = entityManager.createQuery(sql).setParameter("mobile",mobile);
        List<VerifyCode> verifyCodes = query.getResultList();
        if (verifyCodes==null || verifyCodes.size() <1)
            return  null;
        else return verifyCodes.get(0);
    }


}
