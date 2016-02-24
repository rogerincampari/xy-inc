package br.com.xyinc.xyincgps.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import br.com.xyinc.xyincgps.dao.POIDAO;
import br.com.xyinc.xyincgps.model.POI;

@Path("/POI")
public class POIService {

	private POIDAO dao = new POIDAO();
	
	@GET
	@Path("/searchAll")
	@Produces("application/json")
	public List<POI> search(){
		try {
			return dao.listFull();
		} catch (Exception e) {
			throw new WebApplicationException(500);
		}
	}
	@GET
	@Path("/search")
	@Produces("application/json")
	public List<POI> search(@QueryParam("referenceX") Integer referenceX, @QueryParam("referenceY") Integer referenceY){
		try {
			return dao.listByReferences(referenceX, referenceY);
		} catch (Exception e) {
			throw new WebApplicationException(500);
		}
	}

	@GET
	@Path("/searchMax")
	@Produces("application/json")
	public List<POI> searchMax(@QueryParam("referenceX") Integer referenceX, 
							   @QueryParam("referenceY") Integer referenceY, 
							   @QueryParam("maxDistance") Integer maxDistance){
		try {
			return dao.listByProximity(referenceX, referenceY, maxDistance);
		} catch (Exception e) {
			throw new WebApplicationException(500);
		}
	
	}

	@POST
	@Path("/save")
	@Consumes("application/json")
	public Response save(POI poi ){
		try {
			poi = dao.merge(poi);
			return Response.status(200).entity("Register POI sucess!").build();
		} catch (Exception e) {
			throw new WebApplicationException(500);
		}
	}

	@DELETE
	@Path("/delete")
	@Consumes("application/json")
	public Response delete(POI poi){
		try {
			dao.delete(poi);
			return Response.status(200).entity("Delete POI sucess!").build();
		} catch (Exception e) {
			throw new WebApplicationException(500);
		}
	}

}
