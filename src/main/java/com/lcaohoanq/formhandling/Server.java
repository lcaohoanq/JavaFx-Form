package com.lcaohoanq.formhandling;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        try {
            // Create a ServerSocket listening on port 3000
            ServerSocket serverSocket = new ServerSocket(3000);
            System.out.println("Server started on port 3000...");

            // Listen for incoming connections
            while (true) {
                // Accept the connection
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress().getHostName());

                // Create input and output streams for communication
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                // Read the request from the client
                String request = in.readLine();
                System.out.println("Received request: " + request);

                // Check if the request is for the root "/"
                if (request.startsWith("GET / ")) {
                    // Send the HTML response for the root
                    out.println("HTTP/1.1 200 OK");
                    out.println("Content-Type: text/html");
                    out.println("");
                    out.println("<html><body><h1>Welcome to the Home Page!</h1></body></html>");
                } else {
                    // Send a 404 response for other requests
                    out.println("HTTP/1.1 404 Not Found");
                    out.println("Content-Type: text/plain");
                    out.println("");
                    out.println("404 Not Found");
                }

                // Close streams and socket
                in.close();
                out.close();
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


