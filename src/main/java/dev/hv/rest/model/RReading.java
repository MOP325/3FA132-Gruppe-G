package dev.hv.rest.model;

import java.text.SimpleDateFormat;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.transform.stax.StAXResult;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "reading")
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class RReading implements IRCustomer {

    @XmlElement
    @JsonProperty
    private int MeterID;

    @XmlElement
    @JsonProperty
    private String Comment;

    @XmlElement
    @JsonProperty
    private String DateOfReading;

    @XmlElement
    @JsonProperty
    private String KindOfMeter;

    @XmlElement
    @JsonProperty
    private double MeterCOunt;

    @XmlElement
    @JsonProperty
    private IRCustomer customer;

    @Override
    public String printDateofreading() {
        if (DateOfReading == null) {
            return "No Date Available";
        }
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(DateOfReading);
    }
}
