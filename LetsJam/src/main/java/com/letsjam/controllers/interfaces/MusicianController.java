package com.letsjam.controllers.interfaces;

import com.letsjam.business_objects.entities.MusicianEntity;

import java.util.List;

public interface MusicianController {

    //TODO Here all the return type must be changed to Response in order to make RESTful services;
    // TODO so also the methods implementations will change

    void signUp(MusicianEntity musicianEntity);

    List<MusicianEntity> searchAllMusicians();
}
