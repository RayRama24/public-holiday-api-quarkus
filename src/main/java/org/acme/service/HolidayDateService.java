package org.acme.service;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.transaction.Transactional;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.core.Response;

import org.acme.models.HolidayDate;
import org.acme.models.Result;
import org.acme.repository.HolidayDateRepository;

import io.quarkus.hibernate.orm.panache.PanacheQuery;


@Transactional
@ApplicationScoped
public class HolidayDateService {
    
    @Inject
//    HolidayDateRepo holidayDateRepo;
    HolidayDateRepository holidayDateRepo;

    private Result result;

    public List<HolidayDate> findAll(){
        return holidayDateRepo.findAll();
    //    return holidayDateRepo.listAll();
    }

  
    // public HolidayDate addHolidayDate(HolidayDate holidayDate){

    //     if (holidayDate.getDate() == null){
    //         throw new BadRequestException("Tanggal tidak boleh kosong");
    //     }else if (holidayDate.getDescription().length() > 250){
    //         throw new BadRequestException("Deskripsi tidak boleh lebih dari 250 kata");
    //     }else {
    //         return holidayDateRepo.save(holidayDate);
    //     }
      
    // }
    public Response addHolidayDate(HolidayDate holidayDate){
        result = new Result();
        // HolidayDate check = holidayDateRepo;
        if (holidayDate.getDate() == null || holidayDate.getDescription().isEmpty()){
            result.setCode(400);
            result.setSuccess(false);
            result.setMessage("Tanggal dan deskripsi tidak boleh kosong");
            return Response.status(400).entity(result).build();
      
        }       
        else if (holidayDate.getDescription().length() > 50){
            result.setCode(400);
            result.setSuccess(false);
            result.setMessage("deskripsi tidak boleh lebih dari 50 karakter");
            return Response.status(400).entity(result).build();
           
        }
        else if(holidayDateRepo.findByDate(holidayDate.getDate()) != null){
            result.setCode(400);
            result.setSuccess(false);
            result.setMessage("tanggal sudah ada");
            return Response.status(400).entity(result).build();
        }
            result.setMessage("Berhasil membuat date baru!");
            holidayDateRepo.save(holidayDate);
            return Response.ok(holidayDate).build();           
    }

    public HolidayDate getHolidayDateById(Long id){
        return holidayDateRepo.findById(id);
    }
}
