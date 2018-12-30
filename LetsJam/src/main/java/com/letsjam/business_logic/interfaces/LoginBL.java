package com.letsjam.business_logic.interfaces;

import com.letsjam.business_objects.entities.LoginEntity;
import com.letsjam.business_objects.web.TransferObject;

public interface LoginBL extends GenericBL{

    LoginEntity getLoginEntityFromUsernameAndPassword(TransferObject<LoginEntity> loginTransferObject);
}
