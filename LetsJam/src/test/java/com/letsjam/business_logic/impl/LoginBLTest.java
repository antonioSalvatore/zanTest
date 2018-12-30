package com.letsjam.business_logic.impl;

import com.letsjam.business_logic.interfaces.LoginBL;
import com.letsjam.business_objects.entities.LoginEntity;
import com.letsjam.business_objects.enums.LoginEnum;
import com.letsjam.business_objects.web.TransferObject;
import com.letsjam.helper.WeldJUnit4Runner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

@RunWith(WeldJUnit4Runner.class)
public class LoginBLTest {

    private static final transient Logger logger = LoggerFactory.getLogger(LoginBLTest.class);

    @Inject
    private LoginBL loginBL;

    @Test
    public void shouldGetLoginEntityFromUsernameAndPassword(){

        LoginEntity loginEntityFromTransferObject = LoginEntity.Builder.aLoginEntity()
                .withUsername("klarivo")
                .withPassword("blablakad")
                .build();

        TransferObject<LoginEntity> loginTransferObject = TransferObject.Builder.<LoginEntity>aTransferObject()
                .withGenericData(loginEntityFromTransferObject)
                .build();

        LoginEntity loginEntity = loginBL.getLoginEntityFromUsernameAndPassword(loginTransferObject);

        logger.info("The search has given this result: \n\n" + loginEntity.toString());
    }

}
