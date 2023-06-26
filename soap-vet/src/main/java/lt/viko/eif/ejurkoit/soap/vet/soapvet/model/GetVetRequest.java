package lt.viko.eif.ejurkoit.soap.vet.soapvet.model;

import jakarta.xml.bind.annotation.*;

/**
 * represents a request object used in a SOAP web service
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"name"})
@XmlRootElement(name = "getVetRequest")
public class GetVetRequest {
    @XmlElement(required = true)
    protected String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
