package scifi.scifi.supabase;

import scifi.scifi.McScifi;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class Connection {

    private HttpClient client = HttpClient.newHttpClient();
    private String baseURL = "https://ypallacrxhalhdrkcbug.supabase.co/rest/v1/";


    public HttpRequest createRequest(HttpRequest.Builder builder, String params) throws IOException, InterruptedException {

        builder.header("apikey", McScifi.getPlugin(McScifi.class).getConfig().getString("supabaseprivatekey"));
        builder.uri(URI.create(baseURL + params));
        HttpRequest request = builder.build();

        return request;
    }

    /*
     TODO there has to be a more efficient way to do this for the different request methods
     look into making a Builder builder (lol) for creating the builder? I thought about it but was not
     really coming up with anything that I felt would work. There is a lot of repeated code that could
     be moved to some catch all methods or something. idk this just seems inefficient but it works for
     now and can be cleaned up at a later  time.
    */

    public HttpResponse<String> getRequest(String params) throws IOException, InterruptedException {

        HttpRequest.Builder builder = HttpRequest.newBuilder();
        HttpRequest request = this.createRequest(builder, params);

        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }

    public HttpResponse<String> postRequest(String params, String data) throws IOException, InterruptedException {

        HttpRequest.Builder builder = HttpRequest.newBuilder();
        builder.POST(HttpRequest.BodyPublishers.ofString(data));
        HttpRequest request = this.createRequest(builder, params);

        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }

}
