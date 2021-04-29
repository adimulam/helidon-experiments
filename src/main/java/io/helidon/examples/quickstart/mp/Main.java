package io.helidon.examples.quickstart.mp;

import io.helidon.microprofile.server.Server;
import io.helidon.config.Config;
import static io.helidon.config.ConfigSources.classpath;
import static io.helidon.config.ConfigSources.file;
import java.io.IOException;

public final class Main {

    private Main() { } 

    public static void main(final String[] args) throws IOException {
        Server server = startServer();
        System.out.println("http://localhost:" + server.port() + "/greet");
    }

    static Server startServer() {
        return Server.builder()
            .config(buildConfig()) 
            .build()
            .start();
    }

    private static Config buildConfig() {
        return Config.builder()
            .sources(
                file("config-file.properties"), 
                classpath("META-INF/microprofile-config.properties"))
            .build();
    }
}
