package com.letsjam.dao.interfaces;

import com.letsjam.business_objects.entities.MusicianEntity;

import java.util.List;

public interface MusicianDAO{

    /**
     * Save the musician entity in input into the DB
     *
     * @param musicianEntity the musician entity
     */
    void saveMusician(final MusicianEntity musicianEntity);

    List<MusicianEntity> searchMusicians(final String query) throws Exception;

    void updateMusician(final MusicianEntity musicianEntityWithUpdatedFields, final Long id) throws Exception;

    void deleteMusician(final Long id);

    MusicianEntity getMusicianById(final Long id) throws Exception ;
}
