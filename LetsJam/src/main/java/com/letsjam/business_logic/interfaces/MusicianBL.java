package com.letsjam.business_logic.interfaces;

import com.letsjam.business_objects.entities.MusicianEntity;
import com.letsjam.business_objects.web.FilterObject;

import java.util.List;

public interface MusicianBL extends GenericBL{

    void signUp(final MusicianEntity musicianEntity);

    /*List<MusicianEntity> searchAllMusicians();*/

    List<MusicianEntity> searchMusicians(final FilterObject filterObject);
}
