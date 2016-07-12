package com.programingmonkey.Dao.Implements;

import com.programingmonkey.Domain.Count;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Feng on 7/12/16.
 */
@Repository
public class CountDao extends BaseDaoImp {
    @PersistenceContext
    private EntityManager entityManager;
    @Transactional
    public List<Count> findByMobile(String mobile){
        System.out.println(mobile.getClass() + mobile);
        String sql ="select c from Count  c  where c.mobile=:mobile ";
        Query query = entityManager.createQuery(sql);
        query.setParameter("mobile",mobile);
        return (List<Count>) query.getResultList();
    }
}
