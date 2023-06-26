package lt.viko.eif.ejurkoit.soap.vet.soapvet.util;

import org.apache.fop.apps.*;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.transform.*;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Converts xsl file to a pdf file using RestController
 */
@RestController
@RequestMapping("/pdf")
public class ConvertToPDF {
    @GetMapping("/convert")
public static void convertToPDF() throws IOException, TransformerException, FOPException {
    File xslFile = new File("C:\\Users\\edgar\\JavaProjects\\soap-vet\\src\\main\\resources\\VetClinic1.xsl");
    StreamSource xmlSource = new StreamSource(new File("C:\\Users\\edgar\\JavaProjects\\soap-vet\\generated.xml"));
    FopFactory fopFactory = FopFactory.newInstance(new File(".").toURI());
    FOUserAgent foUserAgent = fopFactory.newFOUserAgent();
    OutputStream out;
    out = new java.io.FileOutputStream("VetClinic1.pdf");
    try{
        Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, foUserAgent, out);
        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer = factory.newTransformer(new StreamSource(xslFile));

        Result res = new SAXResult(fop.getDefaultHandler());
        transformer.transform(xmlSource, res);
    }
    finally {
        out.close();
    }
}
}
