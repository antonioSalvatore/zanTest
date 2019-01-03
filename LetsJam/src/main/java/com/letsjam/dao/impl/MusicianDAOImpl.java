package com.letsjam.dao.impl;

import com.letsjam.dao.interfaces.MusicianDAO;
import com.letsjam.dao.utils.HibernateUtil;
import com.letsjam.business_objects.entities.MusicianEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
public class MusicianDAOImpl implements MusicianDAO {

    private static final transient Logger logger = LoggerFactory.getLogger(MusicianDAOImpl.class);

    @Override
    public void saveMusician(final MusicianEntity musicianEntity){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transactionObj = session.beginTransaction();

        try{
            session.save(musicianEntity);
        } catch (HibernateException hibernateEx){
            logger.error("There's been an error during the saving!");
        } finally {
            try{
                transactionObj.commit();
                session.close();
            } catch (Exception hibernateEx){
                if(transactionObj.isActive()){
                    try{
                        transactionObj.rollback();
                    } catch (RuntimeException rex){
                        logger.error("Can't rollback the transaction! ", rex);
                    }
                }
                logger.error("Can't close the session! ", hibernateEx);
            }
        }
    }

    @Override
    public List<MusicianEntity> searchMusicians(final String query) throws Exception {
        List<MusicianEntity> musicians = new ArrayList<>();

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transactionObj = session.beginTransaction();

        boolean error = false;

        try{
            musicians = (List<MusicianEntity>) session
                    .createQuery(query)
                    .list();

        } catch (HibernateException hibernateEx){
            logger.error("There's been an error during the search!");
            error = true;
        } finally {

            try{
                transactionObj.commit();
                session.close();
            } catch (Exception hibernateEx){
                error = true;

                if(transactionObj.isActive()){
                    try{
                        transactionObj.rollback();
                    } catch (RuntimeException rex){
                        logger.error("Can't rollback the transaction! ", rex);
                    }
                }
                logger.error("Can't close the session! ", hibernateEx);
            }

            if(error)
                throw new Exception();
        }

        return musicians;
    }

    @Override
    public void updateMusician(final MusicianEntity musicianEntityWithUpdatedFields, final Long id) throws Exception {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transactionObj = session.beginTransaction();

        boolean error = false;

        MusicianEntity musicianEntityFromDB = (MusicianEntity) session.get(MusicianEntity.class, id);
        musicianEntityFromDB.setAge(musicianEntityWithUpdatedFields.getAge());
        musicianEntityFromDB.setCity(musicianEntityWithUpdatedFields.getCity());
        musicianEntityFromDB.setEmail(musicianEntityWithUpdatedFields.getEmail());
        musicianEntityFromDB.setMusicalInstrument(musicianEntityWithUpdatedFields.getMusicalInstrument());
        musicianEntityFromDB.setName(musicianEntityWithUpdatedFields.getName());
        musicianEntityFromDB.setSurname(musicianEntityWithUpdatedFields.getSurname());

        try{
            //session.update(musicianEntityFromDB);//No need to update manually as it will be updated automatically on transaction close.
            transactionObj.commit();

        } catch (Exception hibernateEx){
            error = true;

            if(transactionObj.isActive()){
                try{
                    transactionObj.rollback();
                } catch (RuntimeException rex){
                    logger.error("Can't rollback the transaction! ", rex);
                }
            }

        } finally {
            try{
                session.close();
            } catch (HibernateException hibernateEx){
                logger.error("Can't close the session! ", hibernateEx);
                error = true;
            }

            if(error)
                throw new Exception();
        }
    }

    @Override
    public void deleteMusician(final Long id){

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transactionObj = session.beginTransaction();

        try{
            MusicianEntity musicianEntity = (MusicianEntity) session.get(MusicianEntity.class, id);
            session.delete(musicianEntity);

        } catch (HibernateException hibernateEx){
            logger.error("There's been an error during the deleting!");
        } finally {
            try{
                transactionObj.commit();
                session.close();
            } catch (Exception hibernateEx){
                if(transactionObj.isActive()){
                    try{
                        transactionObj.rollback();
                    } catch (RuntimeException rex){
                        logger.error("Can't rollback the transaction! ", rex);
                    }
                }
                logger.error("Can't close the session! ", hibernateEx);
            }
        }
    }

    @Override
    public MusicianEntity getMusicianById(final Long id) throws Exception {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transactionObj = session.beginTransaction();

        boolean error = false;

        MusicianEntity musicianEntityFromDB = null;

        try{
            musicianEntityFromDB = (MusicianEntity) session.get(MusicianEntity.class, id);

        } catch (HibernateException hibernateEx){
            error = true;
            logger.error("There's been an error during the getting of the entity!");

        } finally {
            try{
                transactionObj.commit();
                session.close();
            } catch (Exception hibernateEx){

                error = true;

                if(transactionObj.isActive()){
                    try{
                        transactionObj.rollback();
                    } catch (RuntimeException rex){
                        logger.error("Can't rollback the transaction! ", rex);
                    }
                }
                logger.error("Can't close the session! ", hibernateEx);

            }

            if(error)
                throw new Exception();
        }

        return musicianEntityFromDB;
    }
}
