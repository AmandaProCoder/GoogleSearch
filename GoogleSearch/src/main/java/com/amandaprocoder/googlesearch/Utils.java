package com.amandaprocoder.googlesearch;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class Utils {

    public static String getHTTPBody(String url){
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        String body = null;
        try {
            HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if(response.statusCode() == 200){
                body = response.body().toString();
            }
        } catch (Exception e) {
            return body;
        }
        return body;
    }
}
