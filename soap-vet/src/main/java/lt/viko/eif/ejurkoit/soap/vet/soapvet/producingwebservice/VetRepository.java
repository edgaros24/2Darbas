package lt.viko.eif.ejurkoit.soap.vet.soapvet.producingwebservice;

import jakarta.annotation.PostConstruct;
import lt.viko.eif.ejurkoit.soap.vet.soapvet.model.Animal;
import lt.viko.eif.ejurkoit.soap.vet.soapvet.model.Owner;
import lt.viko.eif.ejurkoit.soap.vet.soapvet.model.Specialist;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Creates objects of a owner and his pets
 * This class is needed for the SOAPUI
 */
@Component
public class VetRepository {
private static final Map<String, Owner> owners = new HashMap<>();

@PostConstruct
    public void initData(){
    Owner owner1 = new Owner();
    owner1.setName("Vardenis");
    owner1.setLastname("Pavardenis");
    Animal animal1 = new Animal();
    animal1.setName("Tom");
    animal1.setGender("Male");
    animal1.setType("Cat");
    owner1.setAnimals(List.of(animal1));
    Specialist specialist1 = new Specialist();
    specialist1.setSName("Ona");
    specialist1.setSLastname("Onute");
    specialist1.setSpecialization("Surgeon");
    owner1.setSpecialist(specialist1);
    owners.put(owner1.getName(), owner1);

    Owner owner2 = new Owner();
    owner2.setName("Alexander");
    owner2.setLastname("Kim");
    Animal animal2 = new Animal();
    animal2.setName("Mary");
    animal2.setGender("Female");
    animal2.setType("Cat");
    owner2.setAnimals(List.of(animal2));
    Specialist specialist2 = new Specialist();
    specialist2.setSName("Petras");
    specialist2.setSLastname("Petraitis");
    specialist2.setSpecialization("Surgeon");
    owner2.setSpecialist(specialist2);
    owners.put(owner2.getName(), owner2);
}

public Owner findOwner(String name){return owners.get(name);}
}
