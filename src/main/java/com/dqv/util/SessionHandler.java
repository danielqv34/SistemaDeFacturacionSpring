package com.dqv.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ezequ on 10/22/2016.
 */
@Transactional
public abstract class SessionHandler {

    @Autowired
    private SessionFactory  sessionFactory;

    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    public void guardar(Object object){
        getSession().save(object);
    }
    public void actualizar(Object object){
        getSession().update(object);
    }

    public void borrar(Object object){
        getSession().delete(object);
    }
}
