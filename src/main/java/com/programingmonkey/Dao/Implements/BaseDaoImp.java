package com.programingmonkey.Dao.Implements;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;

/**
 * Created by Feng on 7/11/16.
 */
@Repository
public class BaseDaoImp  {

    @PersistenceContext
    private EntityManager entityManager;
    @Transactional
    public void add( Object object) {
        entityManager.persist(object);

    }
    @Transactional
    public void delete( Object object) {
        entityManager.remove(object);
    }
    @Transactional
    public void update(Object object) {
        entityManager.merge(object);


    }

    public Object find(Class aClass, Serializable id) {
        return entityManager.find(aClass,id);
    }
}
