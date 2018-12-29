package com.letsjam.dao.interfaces;

import com.letsjam.business_objects.entities.MusicianEntity;

public interface MusicianDAO {

    /**
     * Save the musician entity in input into the DB
     *
     * @param musicianEntity the musician entity
     */
    void saveMusician(MusicianEntity musicianEntity);
}
