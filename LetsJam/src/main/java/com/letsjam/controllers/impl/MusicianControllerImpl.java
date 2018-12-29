package com.letsjam.controllers.impl;

import com.letsjam.business_logic.interfaces.MusicianBL;
import com.letsjam.business_objects.entities.MusicianEntity;
import com.letsjam.controllers.interfaces.MusicianController;

import javax.inject.Inject;

public class MusicianControllerImpl implements MusicianController {

    @Inject
    private MusicianBL musicianBL;

    @Override
    public void signUp(MusicianEntity musicianEntity){
        musicianBL.signUp(musicianEntity);
    }
}
