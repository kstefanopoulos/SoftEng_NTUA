package ch2;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;

public class FindLocation {
	
	public FindLocation() {}
	
	public String[] getLatLongPositions(String address) throws Exception
	{
	  int responseCode = 0;
	  String api = "http://maps.googleapis.com/maps/api/geocode/xml?address=" + URLEncoder.encode(address, "UTF-8") + "&sensor=true";
	  URL url = new URL(api);
	  HttpURLConnection httpConnection = (HttpURLConnection)url.openConnection();
	  httpConnection.connect();
	  responseCode = httpConnection.getResponseCode();
	  if(responseCode == 200)
	  {
	    DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();;
	    Document document = builder.parse(httpConnection.getInputStream());
	    XPathFactory xPathfactory = XPathFactory.newInstance();
	    XPath xpath = xPathfactory.newXPath();
	    XPathExpression expr = xpath.compile("/GeocodeResponse/status");
	    String status = (String)expr.evaluate(document, XPathConstants.STRING);
	    if(status.equals("OK"))
	    {
	       expr = xpath.compile("//geometry/location/lat");
	       String latitude = (String)expr.evaluate(document, XPathConstants.STRING);
	       expr = xpath.compile("//geometry/location/lng");
	       String longitude = (String)expr.evaluate(document, XPathConstants.STRING);
	       return new String[] {latitude, longitude};
	    }
	   
	    	else if(status.equals("OVER_QUERY_LIMIT"))
	    	{
	    	    Thread.sleep(1000);
	    	    return getLatLongPositions(address);
	    	} 
	    
	  }
	  return null;
	}

	public float distFrom(float lat1, float lng1, float lat2, float lng2) {
	    double earthRadius = 6371000; //meters
	    double dLat = Math.toRadians(lat2-lat1);
	    double dLng = Math.toRadians(lng2-lng1);
	    double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
	               Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
	               Math.sin(dLng/2) * Math.sin(dLng/2);
	    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
	    float dist = (float) (earthRadius * c);

	    return dist;
	    }


}
