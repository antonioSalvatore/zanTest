package com.letsjam.controllers.interfaces;

import com.letsjam.business_objects.entities.LoginEntity;
import com.letsjam.business_objects.entities.MusicianEntity;
import com.letsjam.business_objects.web.FilterObject;
import com.letsjam.business_objects.web.TransferObject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/musician")
public interface MusicianController {

    @POST
    @Path("/signup")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Response signUp(final MusicianEntity musicianEntity);

    @POST
    @Path("/search")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Response searchMusicians(final FilterObject filterObject);

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Response login(final TransferObject<LoginEntity> transferObject);

    @POST
    @Path("/editProfile")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Response editProfile(final MusicianEntity musicianEntityWithUpdatedFields);
}
