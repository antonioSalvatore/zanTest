package com.letsjam.business_logic.interfaces;

import com.letsjam.business_objects.entities.MusicianEntity;

import java.util.List;

public interface MusicianBL {

    void signUp(MusicianEntity musicianEntity);

    List<MusicianEntity> searchAllMusicians();
}
