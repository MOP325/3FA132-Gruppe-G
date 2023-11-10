package dev.hv.db.model;

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
