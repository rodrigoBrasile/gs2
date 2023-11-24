package br.com.exaltasamba.enterprisechallenge.web;

import br.com.exaltasamba.enterprisechallenge.domain.auth.AuthException;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;

public class SimpleHttpServer {

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8866), 0);

        server.createContext("/auth", exchange -> {
            try {
                String requestBody = readRequestBody(exchange);
                var jsonResult = new AuthCommand().execute(requestBody);
                sendJsonResponse(exchange, jsonResult);
            }
            catch (AuthException e) {
                sendJsonResponse(exchange, "", 401);
            }
            catch (Exception e) {
                System.err.println(e.getMessage());
            }
        });

        server.createContext("/lista-medicos", exchange -> {
            try {
                String requestBody = readRequestBody(exchange);
                String jsonResult = new ListaMedicosCommand().execute(requestBody);
                sendJsonResponse(exchange, jsonResult);
            }
            catch (Exception e) {
                System.err.println(e.getMessage());
            }
        });

        server.createContext("/cadastra-medico", exchange -> {
            try {
                String requestBody = readRequestBody(exchange);
                new CadastraMedicoCommand().execute(requestBody);
                sendJsonResponse(exchange, "");
            }
            catch (Exception e) {
                System.err.println(e.getMessage());
            }
        });

        server.createContext("/atualiza-medico", exchange -> {
            try {
                String requestBody = readRequestBody(exchange);
                new AtualizaMedicoCommand().execute(requestBody);
                sendJsonResponse(exchange, "");
            }
            catch (Exception e) {
                System.err.println(e.getMessage());
            }
        });

        server.createContext("/remove-medico", exchange -> {
            String requestBody = readRequestBody(exchange);
            new RemoveMedicoCommand().execute(requestBody);
            sendJsonResponse(exchange, "");
        });

        server.start();
        System.out.println("Servidor iniciado");
    }

    private static String readRequestBody(HttpExchange exchange) throws IOException {
        InputStreamReader isr = new InputStreamReader(exchange.getRequestBody(), StandardCharsets.UTF_8);
        BufferedReader br = new BufferedReader(isr);
        int b;
        StringBuilder buf = new StringBuilder();
        while ((b = br.read()) != -1) {
            buf.append((char) b);
        }
        br.close();
        isr.close();
        return buf.toString();
    }

    private static void sendJsonResponse(HttpExchange exchange, String response) throws IOException {
        sendJsonResponse(exchange, response, 200);
    }

    private static void sendJsonResponse(HttpExchange exchange, String response, int httpStatusCode) throws IOException {
        exchange.getResponseHeaders().set("Content-Type", "application/json");
        exchange.sendResponseHeaders(httpStatusCode, response.getBytes().length);
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}
