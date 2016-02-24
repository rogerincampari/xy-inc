package br.com.xyinc.xyincgps.test;

import static com.jayway.restassured.RestAssured.expect;
import static com.jayway.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import br.com.xyinc.xyincgps.model.POI;

public class POITest {
	
	private static String URI_BASE = "http://localhost:8080/xyincgps/rest/POI";
	
	@Test
	public void savePOITest() throws Exception {
		POI poi = new POI();
		poi.setDescriptionPOI("Teste POI");
		poi.setReferenceX(20);
		poi.setReferenceY(10);
		
		expect().
			statusCode(200).when().given().contentType("application/json").body(poi).post(URI_BASE+"/save");
	}
	
	@Test
	public void searchPOITest() throws Exception {
		Map<String, Integer> params = new HashMap<String, Integer>();
		params.put("referenceX", 27);
		params.put("referenceY", 12);
		
		given().queryParameters(params).when().get(URI_BASE+"/search").then().statusCode(200);
	}

	@Test
	public void searchPOIMaxTest() throws Exception {
		Map<String, Integer> params = new HashMap<String, Integer>();
		params.put("referenceX", 20);
		params.put("referenceY", 10);
		params.put("maxDistance", 10);
		
		given().queryParameters(params).when().get(URI_BASE+"/searchMax").then().statusCode(200);
	}
}
