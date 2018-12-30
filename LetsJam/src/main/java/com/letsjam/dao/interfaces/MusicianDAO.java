package com.letsjam.dao.interfaces;

import com.letsjam.business_objects.entities.MusicianEntity;
import com.letsjam.business_objects.web.FilterObject;

import java.util.List;

public interface MusicianDAO{

    /**
     * Save the musician entity in input into the DB
     *
     * @param musicianEntity the musician entity
     */
    void saveMusician(final MusicianEntity musicianEntity);

    /*List<MusicianEntity> searchAllMusicians();*/

    List<MusicianEntity> searchMusicians(final String query);
}
