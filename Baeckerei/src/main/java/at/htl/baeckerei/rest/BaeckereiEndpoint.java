package at.htl.baeckerei.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("baeckerei")
public class BaeckereiEndpoint {

    @GET
    @Path("{id}")
    public Kunde find(@PathParam("id") long id){
        return new Kunde("Lisa " + id);
    }
}
