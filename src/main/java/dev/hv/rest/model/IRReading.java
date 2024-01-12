package dev.hv.rest.model;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public interface IRReading {
    
    String getComment();

    IRCustomer getCustomer();

    Date getDateOfReading();

    String getKindOfMeter();

    double getMeterCount();

    int getMeterID();

    String printDateofreading();

    void setComment(String comment);

    void setCustomer(IRCustomer customer);

    void setDateOfReading(Date dateOfReading);

    void setKindOfMeter(String kindOfMeter);

    void setMeterCount(double meterCount);

    void setMeterID(int meterId);

}
