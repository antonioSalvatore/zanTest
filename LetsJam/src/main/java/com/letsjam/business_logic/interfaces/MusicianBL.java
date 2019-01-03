package com.letsjam.business_logic.interfaces;

import com.letsjam.business_objects.entities.LoginEntity;
import com.letsjam.business_objects.entities.MusicianEntity;
import com.letsjam.business_objects.enums.StatusEnum;
import com.letsjam.business_objects.web.FilterObject;
import com.letsjam.business_objects.web.GenericResult;
import com.letsjam.business_objects.web.TransferObject;

import java.util.List;

public interface MusicianBL extends GenericBL{

    GenericResult<StatusEnum, MusicianEntity> signUp(final MusicianEntity musicianEntity);

    GenericResult<StatusEnum, MusicianEntity> searchMusicians(final FilterObject filterObject);

    MusicianEntity getMusicianEntityFromLoginEntity(final TransferObject<LoginEntity> loginTransferObject);

    void updateMusician(final MusicianEntity musicianEntityWithUpdatedFields);

    void deleteMusician(final Long id);
}
