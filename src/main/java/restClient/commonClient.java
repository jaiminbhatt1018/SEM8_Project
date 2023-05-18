/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/JerseyClient.java to edit this template
 */
package restClient;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

/**
 * Jersey REST client generated for REST resource:commonRest [common]<br>
 * USAGE:
 * <pre>
 *        commonClient client = new commonClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author Bhatt Jaimin
 */
public class commonClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/ps8/resources";

    public commonClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("common");
    }

    public String goHome() throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("home");
        return resource.request(javax.ws.rs.core.MediaType.TEXT_HTML).get(String.class);
    }

    public Response authenticateReq(String token) throws ClientErrorException {
        return webTarget.path("auth").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).header("Authorization", token!=null?"Bearer "+token : "").get();
    }

    public Response checkLogin(Object requestEntity ) throws ClientErrorException {
     
        return webTarget.path("checkLogin").request(javax.ws.rs.core.MediaType.TEXT_PLAIN).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), Response.class);
    }

    public void close() {
        client.close();
    }
    
}
