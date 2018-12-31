package com.letsjam.controllers.impl;

import com.letsjam.business_logic.impl.MusicianBLImpl;
import com.letsjam.business_logic.interfaces.MusicianBL;
import com.letsjam.business_objects.entities.MusicianEntity;
import com.letsjam.controllers.interfaces.MusicianController;

import javax.inject.Inject;
import java.util.List;

public class MusicianControllerImpl implements MusicianController {

    //TODO Here all the return type must be changed to Response in order to make RESTful services;
    // TODO so also the methods implementations will change

    private MusicianBLImpl musicianBL = new MusicianBLImpl();

    @Override
    public void signUp(MusicianEntity musicianEntity){
        musicianBL.signUp(musicianEntity);
    }

    /*@Override
    public List<MusicianEntity> searchAllMusicians(){
        return musicianBL.searchAllMusicians();
    }*/
}
