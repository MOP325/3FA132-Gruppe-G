package dev.hv.db.dao;

import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import dev.hv.db.model.Reading;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import java.util.List;

// Interface for database access to the "reading" table, defines methods for inserting, updating, querying, and deleting user data.
public interface ReadingDAO {

    @SqlUpdate("INSERT INTO readings (r_cId, r_MeterId, r_KindOfMeter, r_MeterCount, r_Substitute, r_Comment) VALUES (:cId, :meterId, :kindOfMeter, :meterCount, :substitute, :comment)")
    void insert(@Bind("cId") int cId, @Bind("meterId") int meterId, @Bind("kindOfMeter") String kindOfMeter,
            @Bind("meterCount") double meterCount, @Bind("substitute") int substitute, @Bind("comment") String comment);

    @SqlUpdate("UPDATE readings SET r_cId = :cId, r_MeterId = :meterId, r_KindOfMeter = :kindOfMeter, r_MeterCount = :meterCount, r_Substitute = :substitute, r_Comment = :comment WHERE r_Id = :id")
    void update(@Bind("id") int id, @Bind("cId") int cId, @Bind("meterId") int meterId,
            @Bind("kindOfMeter") String kindOfMeter, @Bind("meterCount") double meterCount,
            @Bind("substitute") int substitute, @Bind("comment") String comment);

    @SqlQuery("SELECT * FROM readings WHERE r_Id = :id")
    Reading findById(@Bind("id") int id);

    @SqlQuery("SELECT * FROM readings")
    List<Reading> findAll();

    @SqlUpdate("DELETE FROM readings WHERE r_Id = :id")
    void delete(@Bind("id") int id);
}
