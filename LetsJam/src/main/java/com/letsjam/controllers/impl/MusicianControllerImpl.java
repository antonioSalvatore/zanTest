package com.letsjam.controllers.impl;

import com.letsjam.business_logic.impl.LoginBLImpl;
import com.letsjam.business_logic.impl.MusicianBLImpl;
import com.letsjam.business_logic.interfaces.MusicianBL;
import com.letsjam.business_objects.entities.LoginEntity;
import com.letsjam.business_objects.entities.MusicianEntity;
import com.letsjam.business_objects.enums.StatusEnum;
import com.letsjam.business_objects.web.FilterObject;
import com.letsjam.business_objects.web.GenericResult;
import com.letsjam.business_objects.web.TransferObject;
import com.letsjam.controllers.interfaces.MusicianController;
import org.jboss.resteasy.specimpl.ResteasyHttpHeaders;
import org.jboss.resteasy.spi.ResteasyProviderFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

public class MusicianControllerImpl implements MusicianController {

    //TODO Here all the return type must be changed to Response in order to make RESTful services;
    // TODO so also the methods implementations will change

    private static final transient Logger logger = LoggerFactory.getLogger(MusicianControllerImpl.class);

    @Inject
    private MusicianBLImpl musicianBL;

    @Override
    @POST
    public Response signUp(MusicianEntity musicianEntity){

        final GenericResult<StatusEnum, MusicianEntity> genericResult = musicianBL.signUp(musicianEntity);

        return Response.ok(genericResult, MediaType.APPLICATION_JSON).build();
    }

    @Override
    @POST
    public Response searchMusicians(final FilterObject filterObject){

        final GenericResult<StatusEnum, MusicianEntity> genericResult = musicianBL.searchMusicians(filterObject);

        return Response.ok(genericResult, MediaType.APPLICATION_JSON).build();
    }

    @Override
    @POST
    public Response login(final TransferObject<LoginEntity> loginTransferObject){

        final GenericResult<StatusEnum, MusicianEntity> genericResult = musicianBL.getMusicianEntityFromLoginEntity(loginTransferObject);

        return Response.ok(genericResult, MediaType.APPLICATION_JSON).build();
    }

    @Override
    public Response editProfile(final MusicianEntity musicianEntityWithUpdatedFields){

        final GenericResult<StatusEnum, MusicianEntity> genericResult = musicianBL.updateMusician(musicianEntityWithUpdatedFields);

        return Response.ok(genericResult, MediaType.APPLICATION_JSON).build();
    }

    @Override
    public Response deleteProfile(final Long musicianId){

        final GenericResult<StatusEnum, MusicianEntity> genericResult = musicianBL.deleteMusician(musicianId);

        return Response.ok(genericResult, MediaType.APPLICATION_JSON).build();
    }

}
