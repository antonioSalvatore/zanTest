package com.letsjam.dao.impl;

import com.letsjam.business_objects.entities.LoginEntity;
import com.letsjam.dao.interfaces.LoginDAO;
import com.letsjam.dao.utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginDAOImpl implements LoginDAO {

    private static final transient Logger logger = LoggerFactory.getLogger(LoginDAOImpl.class);

    @Override
    public LoginEntity getLoginEntityFromUsernameAndPassword(String query){
        LoginEntity loginEntity = null;

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transactionObj = session.beginTransaction();

        try{
            loginEntity = (LoginEntity) session
                    .createQuery(query)
                    .getSingleResult();
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

        return loginEntity;
    }
}
