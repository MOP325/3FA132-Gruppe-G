package dev.hv.rest.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "customer")
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class RCustomer implements IRCustomer {

    @XmlElement
    @JsonProperty
    private int CustomerID;

    @XmlElement
    @JsonProperty
    private String FirstName;

    @XmlElement
    @JsonProperty
    private String LastName;

    public RCustomer (String FirstName, String LastName, int CustomerID) {
        this.CustomerID = CustomerID;
        this.FirstName = FirstName;
        this.LastName = LastName;
    }
}
