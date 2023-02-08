package org.acme.repository;

import org.acme.models.HolidayDate;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.Date;
import java.util.List;

@ApplicationScoped
public class HolidayDateRepository {
    
    @PersistenceContext
    EntityManager entityManager;

    public List<HolidayDate> findAll() {
        return entityManager.createQuery("SELECT m FROM HolidayDate m", HolidayDate.class)
          .getResultList();
      }

    public HolidayDate findByDate(Date date){
      return entityManager.createQuery("SELECT d FROM HolidayDate d WHERE d.date = :date",HolidayDate.class).setParameter("date", date).setMaxResults(1).getSingleResult();

    }

      public HolidayDate findById(Long id) {
        return entityManager.find(HolidayDate.class, id);
      }
    
      public HolidayDate save(HolidayDate holidayDate) {
        entityManager.persist(holidayDate);
        return holidayDate;
      }
}
