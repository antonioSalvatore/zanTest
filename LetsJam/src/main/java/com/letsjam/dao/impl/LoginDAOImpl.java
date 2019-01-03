package com.letsjam.dao.impl;

import com.letsjam.business_objects.entities.LoginEntity;
import com.letsjam.dao.interfaces.LoginDAO;
import com.letsjam.dao.utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.NoResultException;

public class LoginDAOImpl implements LoginDAO {

    private static final transient Logger logger = LoggerFactory.getLogger(LoginDAOImpl.class);

    @Override
    public LoginEntity getLoginEntityFromUsernameAndPassword(String query) throws Exception {
        LoginEntity loginEntity = null;

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transactionObj = session.beginTransaction();

        boolean error = false;

        try{
            loginEntity = (LoginEntity) session
                    .createQuery(query)
                    .getSingleResult();

        } catch(NoResultException noResEx){

            logger.warn("No entity found for this query!");

        }

        finally {
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

        return loginEntity;
    }
}
