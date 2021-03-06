
package org.hx.commonservices.cinclearance.hbe;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import org.hx.commonservices.cinclearance.request.CINClearanceRequest;
import org.hx.commonservices.cinclearance.response.CINClearanceResponse;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.7-b01-
 * Generated source version: 2.1
 * 
 */
@WebService(name = "HBECINClearance", targetNamespace = "http://org/hx/commonservices/CINClearance/HBE/")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    org.hx.commonservices.cinclearance.request.ObjectFactory.class,
    org.hx.commonservices.cinclearance.response.ObjectFactory.class,
    org.hx.commonservices.cinclearance.exception.ObjectFactory.class
})
public interface HBECINClearance {


    /**
     * 
     * @param request
     * @return
     *     returns org.hx.commonservices.cinclearance.response.CINClearanceResponse
     * @throws CinServiceException
     */
    @WebMethod
    @WebResult(name = "CINClearanceResponse", targetNamespace = "http://org/hx/commonservices/CINClearance/Response/", partName = "response")
    public CINClearanceResponse processSearch(
        @WebParam(name = "CINClearanceRequest", targetNamespace = "http://org/hx/commonservices/CINClearance/Request/", partName = "request")
        CINClearanceRequest request)
        throws CinServiceException
    ;

    /**
     * 
     * @param request
     * @return
     *     returns org.hx.commonservices.cinclearance.response.CINClearanceResponse
     * @throws CinServiceException
     */
    @WebMethod
    @WebResult(name = "CINClearanceResponse", targetNamespace = "http://org/hx/commonservices/CINClearance/Response/", partName = "response")
    public CINClearanceResponse rankClearanceResults(
        @WebParam(name = "CINClearanceResponse", targetNamespace = "http://org/hx/commonservices/CINClearance/Response/", partName = "request")
        CINClearanceResponse request)
        throws CinServiceException
    ;

}
