package com.letsjam.business_logic.impl;

import com.letsjam.business_logic.interfaces.MusicianBL;
import com.letsjam.business_objects.entities.MusicianEntity;
import com.letsjam.dao.interfaces.MusicianDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.util.List;

public class MusicianBLImpl implements MusicianBL {

    private static final transient Logger logger = LoggerFactory.getLogger(MusicianBLImpl.class);

    @Inject
    private MusicianDAO musicianDAO;

    @Override
    public void signUp(MusicianEntity musicianEntity){

        logger.info("call signUp()");

        musicianDAO.saveMusician(musicianEntity);
    }

    @Override
    public List<MusicianEntity> searchAllMusicians(){

        logger.info("call searchAllMusicians()");

        return musicianDAO.searchAllMusicians();
    }
}
