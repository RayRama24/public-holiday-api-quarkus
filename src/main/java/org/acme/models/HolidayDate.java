package org.acme.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="holiday_date")
public class HolidayDate {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date date;
    private String holidayName;
    
    public HolidayDate() {
    }

    public HolidayDate(Long id, Date date, String holidayName) {
        this.id = id;
        this.date = date;
        this.holidayName = holidayName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getholidayName() {
        return holidayName;
    }

    public void setholidayName(String holidayName) {
        this.holidayName = holidayName;
    }

   
    
}
