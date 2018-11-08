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

// Controller class for the api

@Path("/extract")
public class KeywordExtractorController {

    /**
     * Keyword extractor method end point.
     *
     * @param request HttpServletRequest
     * @param form    MultivaluedMap
     * @return JSONData
     */

    @POST
    @Path("/keyword")
    @Consumes(APPLICATION_FORM_URLENCODED)
    @Produces("application/json;charset=utf-8")
    public Response extractKeywords(@Context HttpServletRequest request, MultivaluedMap<String,String> form){
        JSONObject data = KeywordExtractorProvider.indexDocument(request, form);

        return Response.status(data.getInt("status")).entity(data.toString()).build();
    }

}
