package lt.viko.eif.ejurkoit.soap.vet.soapvet.model;

import jakarta.xml.bind.annotation.XmlRegistry;

@XmlRegistry
public class ObjectFactory {
    public ObjectFactory() {
    }
    public GetVetRequest createGetVetRequest(){return new GetVetRequest();}

    public GetVetResponse createGetVetResponse(){return new GetVetResponse();}
    public Owner createOwner(){return new Owner();}
}
