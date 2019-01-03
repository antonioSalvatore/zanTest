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

    GenericResult<StatusEnum, MusicianEntity> getMusicianEntityFromLoginEntity(final TransferObject<LoginEntity> loginTransferObject);

    GenericResult<StatusEnum, MusicianEntity> updateMusician(final MusicianEntity musicianEntityWithUpdatedFields);

    GenericResult<StatusEnum, MusicianEntity> deleteMusician(final Long id);

    MusicianEntity getMusicianById(final Long id) throws Exception;
}
