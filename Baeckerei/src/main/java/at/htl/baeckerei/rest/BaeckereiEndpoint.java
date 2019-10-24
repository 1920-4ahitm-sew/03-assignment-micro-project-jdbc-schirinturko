package at.htl.baeckerei.rest;

import at.htl.baeckerei.at.htl.baeckerei.datenbank.Datenbank;
import at.htl.baeckerei.model.Kunde;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

@Path("baeckerei")
@Produces({
        MediaType.APPLICATION_JSON,
        MediaType.TEXT_PLAIN,
        MediaType.APPLICATION_XML
})

public class BaeckereiEndpoint {

    Datenbank db = new Datenbank();

    @GET
    @Path("{id}")
    public Kunde find(@PathParam("id") long id){
        Kunde kunde = null;
        try {
            kunde = db.getKunde((int) id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return kunde;
    }

    @GET
    public List<Kunde> findAll(){
        List<Kunde> allKunden = new LinkedList<>();
        try {
            allKunden = db.getAllKunden();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allKunden;
    }

    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") long id){
        System.out.println("deleted " + id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void save(Kunde kunde){
        System.out.println("Kunde = " + kunde);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void edit(@PathParam("id") long id, String name){
        System.out.println("Id = " + id);
        System.out.println("Kunde = " + name);
    }
}
