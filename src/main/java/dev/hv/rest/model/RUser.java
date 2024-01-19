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
@XmlRootElement(name = "user")
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class RUser implements IRUser {

    @XmlElement
    @JsonProperty
    private int UserID;

    @XmlElement
    @JsonProperty
    private String FirstName;

    @XmlElement
    @JsonProperty
    private String LastName;

    @XmlElement
    @JsonProperty
    private String Password;

    @XmlElement
    @JsonProperty
    private String Token;

    public RUser(String firstName, String lastName, String password, String token, int userID) {
        this.UserID = userID;
        this.FirstName = firstName;
        this.LastName = lastName;
        this.Password = password;
        this.Token = token;
    }
}