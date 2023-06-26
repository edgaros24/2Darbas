package lt.viko.eif.ejurkoit.soap.vet.soapvet.model;

import jakarta.xml.bind.annotation.XmlType;
/**
 * Represents a specialist for the animals of the owner
 * Represented by {@link Owner} class
 *
 * @author Edgar
 * @see Owner
 * @since 1.0
 */

@XmlType(name = "specialist", propOrder = {"SName", "SLastname", "specialization"})
public class Specialist {
    protected String SName;
    protected String SLastname;
    protected String specialization;


    public String getSName() {
        return SName;
    }

    public void setSName(String SName) {
        this.SName = SName;
    }

    public String getSLastname() {
        return SLastname;
    }

    public void setSLastname(String SLastname) {
        this.SLastname = SLastname;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public Specialist() {
    }


    public Specialist(String name, String lastname, String specialization) {
        this.SName = name;
        this.SLastname = lastname;
        this.specialization = specialization;
    }

}
