package scifi.scifi.supabase;

import scifi.scifi.McScifi;

import java.io.IOException;
import java.net.Authenticator;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Connection {

    private HttpClient client = HttpClient.newHttpClient();


    public HttpResponse<String> getRequest(String query) throws IOException, InterruptedException {
        var request = HttpRequest.newBuilder(URI.create(query))
                .header("apikey", McScifi.getPlugin(McScifi.class).getConfig().getString("supabaseprivatekey"))
                .build();

        return client.send(request, HttpResponse.BodyHandlers.ofString());

    }



}
