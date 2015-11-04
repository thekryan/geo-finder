package org.gkrajewski.geofinder;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.gkrajewski.geofinder.model.GeoObjectList;
import org.gkrajewski.geofinder.model.GeoObjectWithDistance;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;


public class GeoFinderClient {

    public static void main(String[] args) {

        try {

            String urlString =
                    "http://localhost:8080/geo-finder/rest/geoobjects/query?longitude=18.667042&latitude=50.298551&distance=300";

            System.out.println("Using JSON Client..");
            useJsonClient(urlString);
            // System.out.println("Using Jersey Client..");
            // useJerseyClient(urlString);
            //
            // System.out.println("Using java.net.url Client..");
            // useJavanNetUrlClient(urlString);

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    private static void useJsonClient(String urlString) {
        ClientConfig config = new DefaultClientConfig();
        Client client = Client.create(config);
        WebResource service = client.resource(urlString);
        // Get JSON for application
        ClientResponse response = service.accept("application/json").get(ClientResponse.class);
        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
        }

        String output = response.getEntity(String.class);

        System.out.println("Output from Server .... \n");
        System.out.println(output);
    }

    private static void useJavanNetUrlClient(String urlString) {

        try {

            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/xml");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
            }

            JAXBContext jaxbContext = JAXBContext.newInstance(GeoObjectList.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            GeoObjectList geoObjectList = (GeoObjectList) jaxbUnmarshaller.unmarshal(conn.getInputStream());

            conn.disconnect();

            System.out.println("Output from Server .... \n");
            for (GeoObjectWithDistance geo : geoObjectList.getGeoObjects()) {
                System.out.println(geo);
            }

        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        } catch (JAXBException e) {

            e.printStackTrace();
        }

    }

    private static void useJerseyClient(String urlString) {

        Client client = Client.create();
        WebResource webResource = client.resource(urlString);

        ClientResponse response = webResource.accept("application/xml").get(ClientResponse.class);

        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
        }

        GeoObjectList geoObjects = response.getEntity(GeoObjectList.class);

        System.out.println("Output from Server .... \n");
        for (GeoObjectWithDistance geo : geoObjects.getGeoObjects()) {
            System.out.println(geo);
        }

    }
}
