package com.letsjam.dao.impl;

import com.letsjam.dao.interfaces.MusicianDAO;
import com.letsjam.dao.utils.HibernateUtil;
import com.letsjam.business_objects.entities.MusicianEntity;
import org.hibernate.Session;

public class MusicianDAOImpl implements MusicianDAO {

    @Override
    public void saveMusician(MusicianEntity musicianEntity){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.save(musicianEntity);
        session.getTransaction().commit();
        session.close();
    }
}
