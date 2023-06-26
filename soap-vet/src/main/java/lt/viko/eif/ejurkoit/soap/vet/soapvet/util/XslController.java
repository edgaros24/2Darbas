package lt.viko.eif.ejurkoit.soap.vet.soapvet.util;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;

/**
 * Converts xml file  to xsl using RestController
 */
@RestController
public class XslController {
    @GetMapping(value = "/transform", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> generateXSL() {
        try {
            File xmlFile = ResourceUtils.getFile("C:\\Users\\edgar\\JavaProjects\\soap-vet\\generated.xml");
            File xsltFile = ResourceUtils.getFile("C:\\Users\\edgar\\JavaProjects\\soap-vet\\src\\main\\resources\\VetClinic1.xsl");

            StreamSource xmlSource = new StreamSource(xmlFile);
            StreamSource xsltSource = new StreamSource(xsltFile);

            StringWriter stringWriter = new StringWriter();
            StreamResult streamResult = new StreamResult(stringWriter);

            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer(xsltSource);

            transformer.transform(xmlSource, streamResult);

            HttpHeaders responseHeaders = new HttpHeaders();
            responseHeaders.setContentType(MediaType.APPLICATION_XML);

            return ResponseEntity.ok()
                    .headers(responseHeaders)
                    .body(stringWriter.toString());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
