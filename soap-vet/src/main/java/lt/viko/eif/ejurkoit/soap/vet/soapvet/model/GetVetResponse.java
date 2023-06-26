package lt.viko.eif.ejurkoit.soap.vet.soapvet.model;

import jakarta.xml.bind.annotation.*;

/**
 * represents a response object for a SOAP web service
 * Represented by {@link Owner} class
 *
 * @author Edgar
 * @see Owner
 * @since 1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "owner"
})
@XmlRootElement(name = "getVetResponse")
public class GetVetResponse {
    @XmlElement(required = true)

    protected Owner owner;
    /**
     * Gets the value of the owner property.
     *
     * @return
     *     possible object is
     *     {@link Owner }
     *
     */
    public Owner getOwner() {
        return owner;
    }
    /**
     * Sets the value of the owner property.
     *
     * @param owner
     *     allowed object is
     *     {@link Owner }
     *
     */
    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}
