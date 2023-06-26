package lt.viko.eif.ejurkoit.soap.vet.soapvet.util;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import lt.viko.eif.ejurkoit.soap.vet.soapvet.model.Owner;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Generates XML file using marshaller
 */
@Component
public class JAXBUtil {
    public void generateXml(Owner owner) {
        try {
            // Create JAXB context and marshaller
            JAXBContext context = JAXBContext.newInstance(Owner.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);


            // Generate XML
            FileWriter fileWriter = new FileWriter("generated.xml");
            marshaller.marshal(owner, fileWriter);
            fileWriter.close();

        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        }
    }
}
