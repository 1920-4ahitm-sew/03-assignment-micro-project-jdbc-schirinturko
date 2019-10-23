package at.htl.baeckerei.rest;

import at.htl.baeckerei.model.Kunde;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.ArrayList;
import java.util.List;

@Path("baeckerei")
public class BaeckereiEndpoint {

    @GET
    @Path("{id}")
    public Kunde find(@PathParam("id") long id){
        return new Kunde();
    }

    @GET
    public List<Kunde> findAll(){
        List<Kunde> all = new ArrayList<>();
        all.add(find(42));
        return all;
    }
}
