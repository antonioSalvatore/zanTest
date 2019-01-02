package com.letsjam.controllers.interfaces;

import com.letsjam.business_objects.entities.MusicianEntity;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/musician")
public interface MusicianController {

    //TODO Here all the return type must be changed to Response in order to make RESTful services;
    // TODO so also the methods implementations will change

    @POST
    @Path("/signup")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Response signUp(MusicianEntity musicianEntity);

    @GET
    @Path("/hello/{param}")
    @Produces(MediaType.TEXT_PLAIN)
    Response printMessage(@PathParam("param") String msg);

}
