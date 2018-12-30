package com.letsjam.business_logic.impl;

import com.letsjam.business_logic.interfaces.LoginBL;
import com.letsjam.business_objects.entities.LoginEntity;
import com.letsjam.business_objects.web.TransferObject;
import com.letsjam.dao.interfaces.LoginDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

public class LoginBLImpl implements LoginBL {

    private static final transient Logger logger = LoggerFactory.getLogger(MusicianBLImpl.class);

    private static final String ENTITY = "LoginEntity";
    private static final String ALIAS = "l";

    @Inject
    private LoginDAO loginDAO;

    @Override
    public LoginEntity getLoginEntityFromUsernameAndPassword(final TransferObject<LoginEntity> loginTransferObject){

        LoginEntity loginEntity = null;

        if (loginTransferObject != null){

            // Get the login entity
            final LoginEntity loginEntityFromTransferObject = loginTransferObject.getGenericData();

            if(loginEntityFromTransferObject != null) {

                // Initialize the query string
                String query = FROM_CLAUSE + " " + ENTITY + " " + ALIAS + " ";

                if(loginEntityFromTransferObject.getUsername() != null && !loginEntityFromTransferObject.getUsername().isEmpty() &&
                        loginEntityFromTransferObject.getPassword() != null && !loginEntityFromTransferObject.getPassword().isEmpty()){

                    query += WHERE_CLAUSE + " " + ALIAS + ".username " + EQUALS_SYMBOL + " '" + loginEntityFromTransferObject.getUsername()  + "' " +
                            AND_CLAUSE + " " + ALIAS + ".password " + EQUALS_SYMBOL + " '" + loginEntityFromTransferObject.getPassword() + "' ";

                    loginEntity = loginDAO.getLoginEntityFromUsernameAndPassword(query);

                } else {
                    logger.error("Invalid username and/or password!");
                }
            }
        }

        return loginEntity;
    }
}
