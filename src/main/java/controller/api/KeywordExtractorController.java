package controller.api;

import controller.provider.KeywordExtractorProvider;
import org.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_FORM_URLENCODED;

@Path("/extract")
public class KeywordExtractorController {

    @POST
    @Path("/keyword")
    @Consumes(APPLICATION_FORM_URLENCODED)
    @Produces("application/json;charset=utf-8")
    public Response getSiteAllCallReport(@Context HttpServletRequest request, MultivaluedMap<String,String> form){
        JSONObject data = KeywordExtractorProvider.indexDocument(request, form);

        return Response.ok().entity(data.toString()).build();
    }

}
