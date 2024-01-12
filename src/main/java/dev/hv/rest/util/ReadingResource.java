package dev.hv.rest.util;

import dev.hv.db.dao.ReadingDAO;
import dev.hv.db.model.Reading;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/readings")
@Produces(MediaType.APPLICATION_JSON)
public class ReadingResource {
    private final ReadingDAO readingDAO;

    public ReadingResource(ReadingDAO readingDAO) {
        this.readingDAO = readingDAO;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void createReading(Reading reading) {
        readingDAO.insert(
                reading.getcId(),
                reading.getMeterId(),
                reading.getKindOfMeter(),
                reading.getMeterCount(),
                reading.getSubstitute(),
                reading.getComment()
        );
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateReading(@PathParam("id") int id, Reading reading) {
        readingDAO.update(
                id,
                reading.getcId(),
                reading.getMeterId(),
                reading.getKindOfMeter(),
                reading.getMeterCount(),
                reading.getSubstitute(),
                reading.getComment()
        );
    }

    @GET
    @Path("/{id}")
    public Reading getReadingById(@PathParam("id") int id) {
        return readingDAO.findById(id);
    }

    @GET
    public List<Reading> getAllReadings() {
        return readingDAO.findAll();
    }

    @DELETE
    @Path("/{id}")
    public void deleteReading(@PathParam("id") int id) {
        readingDAO.delete(id);
    }
}
