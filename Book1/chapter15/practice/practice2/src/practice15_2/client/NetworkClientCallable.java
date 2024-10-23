package practice15_2.client;

import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.Callable;

public class NetworkClientCallable implements Callable<RequestResponse> {
    private final practice15_2.client.RequestResponse lookup;

    public NetworkClientCallable(practice15_2.client.RequestResponse lookup) {
        this.lookup = lookup;
    }

    @Override
    public RequestResponse call() throws Exception {
        try (Socket sock = new Socket(lookup.host, lookup.port);
             Scanner scanner = new Scanner(sock.getInputStream())) {
            lookup.response = scanner.next();
            return lookup;
        }
    }
}
