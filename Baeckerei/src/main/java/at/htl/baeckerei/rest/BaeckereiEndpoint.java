package at.htl.baeckerei.rest;

import at.htl.baeckerei.model.Kunde;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("baeckerei")
@Produces({
        MediaType.APPLICATION_JSON,
        MediaType.TEXT_PLAIN,
        MediaType.APPLICATION_XML
})

public class BaeckereiEndpoint {

   /*@GET
    @Path("{id}")
    public Kunde find(@PathParam("id") long id){
        return null;
    }

    @GET
    public List<Kunde> findAll(){
        List<Kunde> all = new ArrayList<>();
        all.add(find(1));
        return all;
    }


    */
}
