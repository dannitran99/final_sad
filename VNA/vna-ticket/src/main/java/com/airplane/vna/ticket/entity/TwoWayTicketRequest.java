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
 *         &lt;element name="dateGo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="dateReturn" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="from" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="to" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="adult" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="toddler" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="baby" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "dateGo",
    "dateReturn",
    "from",
    "to",
    "adult",
    "toddler",
    "baby"
})
@XmlRootElement(name = "TwoWayTicketRequest")
public class TwoWayTicketRequest {

    @XmlElement(required = true)
    protected String dateGo;
    @XmlElement(required = true)
    protected String dateReturn;
    @XmlElement(required = true)
    protected String from;
    @XmlElement(required = true)
    protected String to;
    @XmlElement(required = true)
    protected String adult;
    @XmlElement(required = true)
    protected String toddler;
    @XmlElement(required = true)
    protected String baby;

    /**
     * Gets the value of the dateGo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateGo() {
        return dateGo;
    }

    /**
     * Sets the value of the dateGo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateGo(String value) {
        this.dateGo = value;
    }

    /**
     * Gets the value of the dateReturn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateReturn() {
        return dateReturn;
    }

    /**
     * Sets the value of the dateReturn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateReturn(String value) {
        this.dateReturn = value;
    }

    /**
     * Gets the value of the from property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFrom() {
        return from;
    }

    /**
     * Sets the value of the from property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFrom(String value) {
        this.from = value;
    }

    /**
     * Gets the value of the to property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTo() {
        return to;
    }

    /**
     * Sets the value of the to property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTo(String value) {
        this.to = value;
    }

    /**
     * Gets the value of the adult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdult() {
        return adult;
    }

    /**
     * Sets the value of the adult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdult(String value) {
        this.adult = value;
    }

    /**
     * Gets the value of the toddler property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getToddler() {
        return toddler;
    }

    /**
     * Sets the value of the toddler property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToddler(String value) {
        this.toddler = value;
    }

    /**
     * Gets the value of the baby property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBaby() {
        return baby;
    }

    /**
     * Sets the value of the baby property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBaby(String value) {
        this.baby = value;
    }

}