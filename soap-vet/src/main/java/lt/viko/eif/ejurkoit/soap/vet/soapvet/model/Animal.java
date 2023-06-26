package lt.viko.eif.ejurkoit.soap.vet.soapvet.model;

import jakarta.xml.bind.annotation.XmlList;
import jakarta.xml.bind.annotation.XmlType;
/**
 * Represents animals of the owner
 * Represented by {@link Owner} class
 *
 * @author Edgar
 * @see Owner
 * @since 1.0
 */
@XmlType(name = "animals", propOrder = {"name", "gender", "type"})
public class Animal {
protected String name;
protected String gender;
protected String type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public Animal() {

    }
    /**
     * @param name   string name of the animal
     * @param gender string gender of the animal
     * @param type   string type of animal (dog, cat)
     */
    public Animal(String name, String gender, String type) {
        this.name = name;
        this.gender = gender;
        this.type = type;
    }
}
