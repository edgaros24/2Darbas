package lt.viko.eif.ejurkoit.soap.vet.soapvet.producingwebservice;

import lt.viko.eif.ejurkoit.soap.vet.soapvet.model.GetVetRequest;
import lt.viko.eif.ejurkoit.soap.vet.soapvet.model.GetVetResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

/**
 * Endpoint used for SOAPUI
 */
@Endpoint
public class VetEndpoint {
private static final String NAMESPACE_URI = "http://spring.io/guides/lt/viko/eif/ejurkoit/soap/vet/soapvet/model";
private VetRepository vetRepository;

@Autowired
    public VetEndpoint (VetRepository vetRepository) {this.vetRepository = vetRepository;}

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getVetRequest")
@ResponsePayload
    public GetVetResponse getVet(@RequestPayload GetVetRequest request) {
        GetVetResponse response = new GetVetResponse();
        response.setOwner(vetRepository.findOwner(request.getName()));

        return response;
    }
}
