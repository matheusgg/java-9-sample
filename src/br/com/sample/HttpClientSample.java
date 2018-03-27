package br.com.sample;

import static jdk.incubator.http.HttpClient.newHttpClient;
import static jdk.incubator.http.HttpRequest.newBuilder;
import static jdk.incubator.http.HttpResponse.BodyHandler.asString;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.CompletableFuture;

import jdk.incubator.http.HttpResponse;

public class HttpClientSample {

    public static void main (final String... args) throws URISyntaxException, IOException, InterruptedException {
        // HttpClient
        //        final HttpRequest request = HttpRequest.newBuilder()
        //                .uri(new URI("http://private-857c32-randomtestsapi.apiary-mock.com/test"))
        //                .GET()
        //                .build();
        //        final HttpClient client = HttpClient.newHttpClient();
        //        final HttpResponse<String> response = client.send(request, HttpResponse.BodyHandler.asString());
        //        System.out.println("HTTP Version: " + response.version());
        //        System.out.println("Status Code: " + response.statusCode());
        //        System.out.println("Content: " + response.body());

        // followRedirects / version
        //        final HttpClient client = newBuilder()
        //                .followRedirects(HttpClient.Redirect.SECURE)
        //                .version(HttpClient.Version.HTTP_2)
        //                .build();
        //        final HttpRequest request = HttpRequest.newBuilder()
        //                .uri(new URI("https://www.google.com/"))
        //                .GET()
        //                .build();
        //        final HttpResponse<String> response = client.send(request, HttpResponse.BodyHandler.asString());
        //        System.out.println("HTTP Version: " + response.version());
        //        System.out.println("Status Code: " + response.statusCode());
        //        System.out.println("Content: " + response.body());

        //        final String body = newHttpClient()
        //                .send(newBuilder(new URI("https://turini.github.io/livro-java-9/books.csv"))
        //                                .GET()
        //                                .build(),
        //                        asString())
        //                .body();
        //        System.out.println(body);

        // Async
        final CompletableFuture<HttpResponse<String>> future = newHttpClient()
                .sendAsync(newBuilder(new URI("https://turini.github.io/livro-java-9/books.csv"))
                                .GET()
                                .build(),
                        asString());
        System.out.println("Sent!");
        final HttpResponse<String> response = future.join();
        System.out.println(response.body());
    }
}
