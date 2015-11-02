
package cliente;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the cliente package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ObtenerFactura_QNAME = new QName("http://ws/", "obtenerFactura");
    private final static QName _ProcesarFactura_QNAME = new QName("http://ws/", "procesarFactura");
    private final static QName _ProcesarFacturaResponse_QNAME = new QName("http://ws/", "procesarFacturaResponse");
    private final static QName _ObtenerFacturaResponse_QNAME = new QName("http://ws/", "obtenerFacturaResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: cliente
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ObtenerFactura }
     * 
     */
    public ObtenerFactura createObtenerFactura() {
        return new ObtenerFactura();
    }

    /**
     * Create an instance of {@link ProcesarFactura }
     * 
     */
    public ProcesarFactura createProcesarFactura() {
        return new ProcesarFactura();
    }

    /**
     * Create an instance of {@link ProcesarFacturaResponse }
     * 
     */
    public ProcesarFacturaResponse createProcesarFacturaResponse() {
        return new ProcesarFacturaResponse();
    }

    /**
     * Create an instance of {@link ObtenerFacturaResponse }
     * 
     */
    public ObtenerFacturaResponse createObtenerFacturaResponse() {
        return new ObtenerFacturaResponse();
    }

    /**
     * Create an instance of {@link Factura }
     * 
     */
    public Factura createFactura() {
        return new Factura();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerFactura }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "obtenerFactura")
    public JAXBElement<ObtenerFactura> createObtenerFactura(ObtenerFactura value) {
        return new JAXBElement<ObtenerFactura>(_ObtenerFactura_QNAME, ObtenerFactura.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProcesarFactura }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "procesarFactura")
    public JAXBElement<ProcesarFactura> createProcesarFactura(ProcesarFactura value) {
        return new JAXBElement<ProcesarFactura>(_ProcesarFactura_QNAME, ProcesarFactura.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProcesarFacturaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "procesarFacturaResponse")
    public JAXBElement<ProcesarFacturaResponse> createProcesarFacturaResponse(ProcesarFacturaResponse value) {
        return new JAXBElement<ProcesarFacturaResponse>(_ProcesarFacturaResponse_QNAME, ProcesarFacturaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerFacturaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "obtenerFacturaResponse")
    public JAXBElement<ObtenerFacturaResponse> createObtenerFacturaResponse(ObtenerFacturaResponse value) {
        return new JAXBElement<ObtenerFacturaResponse>(_ObtenerFacturaResponse_QNAME, ObtenerFacturaResponse.class, null, value);
    }

}
