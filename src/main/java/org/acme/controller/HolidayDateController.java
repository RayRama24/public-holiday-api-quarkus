package org.acme.controller;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.acme.models.HolidayDate;
import org.acme.service.HolidayDateService;

@Path("/holidayDate")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class HolidayDateController {
    
    @Inject
    HolidayDateService holidayDateService;

    @GET
    public List<HolidayDate> getAllDates(){
        return holidayDateService.findAll();
    }

    @POST
    public Response addDates(HolidayDate holidayDate){
        return holidayDateService.addHolidayDate(holidayDate);
    }

    @GET
    @Path("/{id}")
    public HolidayDate getDateById(@PathParam("id") Long id){
        return holidayDateService.getHolidayDateById(id);
    }

}
