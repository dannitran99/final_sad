//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.05.03 at 09:36:45 AM ICT 
//


package com.airplane.vna.ticket.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ListTicket" type="{entity.ticket.vna.airplane.com}customList"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "listTicket"
})
@XmlRootElement(name = "AllTicketResponse")
public class AllTicketResponse {

    @XmlElement(name = "ListTicket", required = true)
    protected CustomList listTicket;

    /**
     * Gets the value of the listTicket property.
     * 
     * @return
     *     possible object is
     *     {@link CustomList }
     *     
     */
    public CustomList getListTicket() {
        return listTicket;
    }

    /**
     * Sets the value of the listTicket property.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomList }
     *     
     */
    public void setListTicket(CustomList value) {
        this.listTicket = value;
    }

}