package dev.hv.db.model;
import java.beans.ConstructorProperties;

import org.jdbi.v3.core.mapper.reflect.ColumnName;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Reading implements IDReading {
    @ColumnName("r_Id")
    private int Id;

    @ColumnName("r_cId")
    private int cId;

    @ColumnName("r_MeterId")
    private int MeterId;

    @ColumnName("r_KindOfMeter")
    private String KindOfMeter;

    @ColumnName("r_MeterCount")
    private Double MeterCount;

    @ColumnName("r_Substitute")
    private int Substitute;

    @ColumnName("r_Comment")
    private String Comment;

    @ConstructorProperties({"r_id", "c_cId", "r_MeterId", "r_KindOfMeter", "r_MeterCount", "r_Substitute", "r_Comment"})
    public Reading(int Id, int cId, int MeterId, String KindOfMeter, Double MeterCount, int Substitute, String Comment) {
        this.Id = Id;
        this.cId = cId;
        this.MeterId = MeterId;
        this.KindOfMeter = KindOfMeter;
        this.MeterCount = MeterCount;
        this.Substitute = Substitute;
        this.Comment = Comment;
    }

    @Override
    public int getId() {
        return Id;
    }

    @Override
    public void setId(int id) {
        this.Id = id;
    }

    @Override
    public int getcId() {
        return cId;
    }

    @Override
    public void setcId(int cId) {
        this.cId = cId;
    }

    @Override
    public int getMeterId() {
        return MeterId;
    }

    @Override
    public void setMeterId(int meterId) {
        this.MeterId = meterId;
    }

    @Override
    public String getKindOfMeter() {
        return KindOfMeter;
    }

    @Override
    public void setKindOfMeter(String kindOfMeter) {
        this.KindOfMeter = kindOfMeter;
    }

    @Override
    public double getMeterCount() {
        return MeterCount;
    }

    @Override
    public void setMeterCount(double meterCount) {
        this.MeterCount = meterCount;
    }

    @Override
    public int getSubstitute() {
        return Substitute;
    }

    @Override
    public void setSubstitute(int substitute) {
        this.Substitute = substitute;
    }

    @Override
    public String getComment() {
        return Comment;
    }

    @Override
    public void setComment(String comment) {
        this.Comment = comment;
    }
}
