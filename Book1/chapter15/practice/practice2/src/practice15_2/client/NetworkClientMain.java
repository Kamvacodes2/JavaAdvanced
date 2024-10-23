package practice15_2.client;

import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.concurrent.*;

public class NetworkClientMain {

    public static void main(String[] args) {
//        String host = "localhost";
//        for (int port = 10000; port < 10010; port++) {
//            RequestResponse lookup = new RequestResponse(host, port);
//            try (Socket sock = new Socket(lookup.host, lookup.port);
//                    scanner = new Scanner(sock.getInputStream());) {
//                lookup.response = scanner.next();
//                System.out.println(lookup.host + ":" + lookup.port + " " + lookup.response);
//            } catch (NoSuchElementException | IOException ex) {
//                System.out.println("Error talking to " + host + ":" + port);
//            }
        ExecutorService es = Executors.newCachedThreadPool();
        Map<RequestResponse, Future<RequestResponse>> callables = new HashMap<>();
        String host = "localhost";
        for(int port=10000; port<=10010; port++) {
            RequestResponse lookup = new RequestResponse(host, port);
            NetworkClientCallable callable = new NetworkClientCallable(lookup);
            Future<RequestResponse> future = es.submit(callable);
            callables.put(lookup, future);
        }
        es.shutdown();
        try {
            es.awaitTermination(5, TimeUnit.SECONDS);
        }catch (InterruptedException e) {
            System.out.println("Stopped waiting early");
        }
        for(RequestResponse lookup : callables.keySet()) {
            Future<RequestResponse> future = callables.get(lookup);
            try{
                lookup=future.get();
                System.out.println(lookup.host+":"+lookup.port +" "+lookup.response);
            }catch (ExecutionException | InterruptedException ex) {
                System.out.println("Error talking to "+lookup.host+":"+lookup.port +" "+lookup.response);
            }
        }
    }
}