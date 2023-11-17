package dev.hv.rest.model;

public class Readings implements IRReading {

    private String comment;
    private IRCustomer customer;
    private Long dateOfReading;
    private Integer id;
    private String kindOfMeter;
    private Double meterCount;
    private String meterId;
    private Boolean substitute;

    // Konstruktor
    public Readings(String comment, IRCustomer customer, Long dateOfReading, Integer id,
                   String kindOfMeter, Double meterCount, String meterId, Boolean substitute) {
        this.comment = comment;
        this.customer = customer;
        this.dateOfReading = dateOfReading;
        this.id = id;
        this.kindOfMeter = kindOfMeter;
        this.meterCount = meterCount;
        this.meterId = meterId;
        this.substitute = substitute;
    }

    // Implementierung der Interface-Methoden
    @Override
    public String getComment() {
        return comment;
    }

    @Override
    public IRCustomer getCustomer() {
        return customer;
    }

    @Override
    public Long getDateofreading() {
        return dateOfReading;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public String getKindofmeter() {
        return kindOfMeter;
    }

    @Override
    public Double getMetercount() {
        return meterCount;
    }

    @Override
    public String getMeterid() {
        return meterId;
    }

    @Override
    public Boolean getSubstitute() {
        return substitute;
    }

    @Override
    public String printDateofreading() {
        return null;
    }

    @Override
    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public void setCustomer(IRCustomer customer) {
        this.customer = customer;
    }

    @Override
    public void setDateofreading(Long dateOfReading) {
        this.dateOfReading = dateOfReading;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public void setKindofmeter(String kindOfMeter) {
        this.kindOfMeter = kindOfMeter;
    }

    @Override
    public void setMetercount(Double meterCount) {
        this.meterCount = meterCount;
    }

    @Override
    public void setMeterid(String meterId) {
        this.meterId = meterId;
    }

    @Override
    public void setSubstitute(Boolean substitute) {
        this.substitute = substitute;
    }
}
