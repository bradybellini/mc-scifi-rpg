package scifi.scifi.supabase;

import java.io.IOException;

public class Read {

    private Connection conn;

    public String getAllPlayers() throws IOException, InterruptedException {
        return conn.getRequest("player?select=*").body();
    }

}
