/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cst8218.assignment2.soha0021_bhan0075.service;

import cst8218.assignment2.soha0021_bhan0075.entity.Bouncer;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;  
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import jakarta.ws.rs.core.Context;
import java.net.URI;
import java.util.List;

/**
 * Stateless session bean responsible for handling RESTful web service operations 
 * related to the Bouncer entity. Implements CRUD operations and supports roles 
 * like "Admin" and "RestUser".
 */
@Stateless
@Path("bouncers")
@RolesAllowed({"Admin", "RestUser"}) // Restricts access based on roles
public class BouncerFacadeREST extends AbstractFacade<Bouncer> {

    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager em;  // EntityManager used for interacting with the database

    @Override
    protected EntityManager getEntityManager() {
        return em;  // Returns the EntityManager instance for persistence operations
    }

    public BouncerFacadeREST() {
        super(Bouncer.class);  // Calls the superclass constructor with the Bouncer entity class
    }

    /**
     * Handles the POST request to create a new Bouncer or update an existing one.
     * 
     * @param entity The Bouncer entity to be created or updated.
     * @param uriInfo Provides URI information for creating the Location header in the response.
     * @return Response with 201 Created status, Location header, and entity in the body.
     */
    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})  // Accepts both XML and JSON
    public Response createPost(Bouncer entity, @Context UriInfo uriInfo) {
        super.create(entity); // Calls the create method from AbstractFacade to persist the entity

        // Constructs the URI for the newly created resource
        URI location = URI.create(uriInfo.getRequestUri().getPath() + "/" + entity.getId());

        // Returns a response with status 201 (Created), Location header, and the entity in the body
        return Response.status(Response.Status.CREATED)
                .location(location)
                .entity(entity)
                .build();
    }

    /**
     * Handles the PUT request to update an existing Bouncer by its ID.
     * 
     * @param id The ID of the Bouncer to be updated.
     * @param entity The Bouncer entity with updated data.
     */
    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})  // Accepts both XML and JSON
    public void edit(@PathParam("id") Long id, Bouncer entity) {
        super.edit(entity);  // Calls the edit method from AbstractFacade to update the entity
    }

    /**
     * Handles the DELETE request to remove a Bouncer by its ID.
     * 
     * @param id The ID of the Bouncer to be removed.
     */
    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        super.remove(super.find(id));  // Finds and removes the Bouncer by ID
    }

    /**
     * Handles the GET request to retrieve a specific Bouncer by its ID.
     * 
     * @param id The ID of the Bouncer to be retrieved.
     * @return The Bouncer entity corresponding to the provided ID.
     */
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})  // Produces JSON as response
    public Bouncer find(@PathParam("id") Integer id) {
        return super.find(id);  // Calls the find method from AbstractFacade to retrieve the entity
    }

    /**
     * Handles the GET request to retrieve all Bouncers.
     * 
     * @return A list of all Bouncer entities.
     */
    @GET
    @Override
    @Produces({MediaType.APPLICATION_JSON})  // Produces JSON as response
    public List<Bouncer> findAll() {
        return super.findAll();  // Calls the findAll method from AbstractFacade to retrieve all entities
    }

    /**
     * Handles the GET request to retrieve a range of Bouncers.
     * 
     * @param from The starting index for the range.
     * @param to The ending index for the range.
     * @return A list of Bouncer entities within the specified range.
     */
    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})  // Produces both XML and JSON
    public List<Bouncer> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});  // Calls the findRange method from AbstractFacade to retrieve the specified range of entities
    }

    /**
     * Handles the GET request to retrieve the count of Bouncers.
     * 
     * @return The total number of Bouncer entities.
     */
    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)  // Produces plain text response
    public String countREST() {
        return String.valueOf(super.count());  // Calls the count method from AbstractFacade to get the total count
    }

}
