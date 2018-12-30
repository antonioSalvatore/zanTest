package com.letsjam.dao.impl;

import com.letsjam.dao.interfaces.MusicianDAO;
import com.letsjam.dao.utils.HibernateUtil;
import com.letsjam.business_objects.entities.MusicianEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class MusicianDAOImpl implements MusicianDAO {

    private static final transient Logger logger = LoggerFactory.getLogger(MusicianDAOImpl.class);

    @Override
    public void saveMusician(final MusicianEntity musicianEntity){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transactionObj = session.beginTransaction();

        try{
            session.save(musicianEntity);
            transactionObj.commit();
        } catch (HibernateException hibernateEx){
            if(transactionObj.isActive()){
                try{
                    transactionObj.rollback();
                } catch (RuntimeException rex){
                    logger.error("Can't rollback the transaction! ", rex);
                }
            }

            // TODO Show the error to FE

        } finally {
            try{
                session.close();
            } catch (HibernateException hibernateEx){
                logger.error("Can't close the session! ", hibernateEx);
            }
        }
    }

    /*@Override
    public List<MusicianEntity> searchAllMusicians(){

        List<MusicianEntity> musicians = new ArrayList<>();

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transactionObj = session.beginTransaction();

        try{
            musicians = (List<MusicianEntity>) session
                    .createQuery(FROM_CLAUSE +" " + ENTITY + " " + ALIAS + " " + ORDER_BY_CLAUSE + " m.surname ASC")
                    .list();
            transactionObj.commit();

        } catch (HibernateException hibernateEx){
            if(transactionObj.isActive()){
                try{
                    transactionObj.rollback();
                } catch (RuntimeException rex){
                    logger.error("Can't rollback the transaction! ", rex);
                }
            }

            // TODO Show the error to FE

        } finally {
            try{
                session.close();
            } catch (HibernateException hibernateEx){
                logger.error("Can't close the session! ", hibernateEx);
            }
        }

        return musicians;
    }*/

    @Override
    public List<MusicianEntity> searchMusicians(final String query){
        List<MusicianEntity> musicians = new ArrayList<>();

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transactionObj = session.beginTransaction();

        try{
            musicians = (List<MusicianEntity>) session
                    .createQuery(query)
                    .list();
            transactionObj.commit();

        } catch (HibernateException hibernateEx){
            if(transactionObj.isActive()){
                try{
                    transactionObj.rollback();
                } catch (RuntimeException rex){
                    logger.error("Can't rollback the transaction! ", rex);
                }
            }

            // TODO Show the error to FE

        } finally {
            try{
                session.close();
            } catch (HibernateException hibernateEx){
                logger.error("Can't close the session! ", hibernateEx);
            }
        }

        return musicians;
    }
}
