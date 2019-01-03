package com.letsjam.dao.interfaces;

import com.letsjam.business_objects.entities.LoginEntity;

public interface LoginDAO {
    LoginEntity getLoginEntityFromUsernameAndPassword(String query) throws Exception;
}
