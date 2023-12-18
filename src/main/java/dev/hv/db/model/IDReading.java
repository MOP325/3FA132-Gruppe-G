package dev.hv.db.model;

// The interface defines methods for structuring reading data in the database.
public interface IDReading {
   int getId();

   void setId(int id);

   int getcId();

   void setcId(int cId);

   int getMeterId();

   void setMeterId(int meterId);

   String getKindOfMeter();

   void setKindOfMeter(String kindOfMeter);

   double getMeterCount();

   void setMeterCount(double meterCount);

   int getSubstitute();

   void setSubstitute(int substitute);

   String getComment();

   void setComment(String comment);
}
