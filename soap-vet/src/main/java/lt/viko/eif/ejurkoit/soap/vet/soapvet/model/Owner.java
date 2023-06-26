package lt.viko.eif.ejurkoit.soap.vet.soapvet.model;

import jakarta.xml.bind.annotation.*;

import java.util.List;
/**
 * Represents main object
 */
@XmlRootElement (name = "owner")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VetClinic", propOrder = {
        "name",
        "lastname",
        "specialist",
        "animals"
})
public class Owner {
    @XmlElement(required = true)
protected String name;
    @XmlElement(required = true)
protected String lastname;
    @XmlElement(required = true)
    @XmlSchemaType(name = "specialist")
protected Specialist specialist;
    @XmlElementWrapper(name = "animals")
    @XmlElement(name = "animal")
protected List<Animal> animals;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Specialist getSpecialist() {
        return specialist;
    }

    public void setSpecialist(Specialist specialist) {
        this.specialist = specialist;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }
    public Owner(String name, String lastname, Specialist specialist, List<Animal> animals) {
        this.name = name;
        this.lastname = lastname;
        this.specialist = specialist;
        this.animals = animals;
    }

    public Owner() {
    }


}
