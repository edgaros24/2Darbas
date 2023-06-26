package lt.viko.eif.ejurkoit.soap.vet.soapvet.producingwebservice;

import jakarta.annotation.PostConstruct;
import lt.viko.eif.ejurkoit.soap.vet.soapvet.model.Animal;
import lt.viko.eif.ejurkoit.soap.vet.soapvet.model.Owner;
import lt.viko.eif.ejurkoit.soap.vet.soapvet.model.Specialist;
import lt.viko.eif.ejurkoit.soap.vet.soapvet.util.JAXBUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

/**
 * Main method
 */
@ComponentScan(basePackages = "lt.viko.eif.ejurkoit.soap.vet.soapvet")

@SpringBootApplication
public class SoapVetApplication {
	private JAXBUtil jaxbUtil;

	@Autowired
	public SoapVetApplication(JAXBUtil jaxbUtil){
		this.jaxbUtil = jaxbUtil;
	}

	public static void main(String[] args) {
		SpringApplication.run(SoapVetApplication.class, args);
	}

	@PostConstruct
	public void init() {
		run();
	} //method used in order to run the run method

	public void run(){ //creates objects and converts to XML

		Animal animal1 = new Animal();
		animal1.setName("Tom");
		animal1.setGender("Male");
		animal1.setType("Cat");
		Specialist specialist1 = new Specialist();
		specialist1.setSName("Ona");
		specialist1.setSLastname("Onute");
		specialist1.setSpecialization("Surgeon");
		Owner owner1 = new Owner("Vardenis", "Pavardenis", specialist1, List.of(animal1));
		jaxbUtil.generateXml(owner1);
	}
}
