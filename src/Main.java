package src;

import com.google.gson.*;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        String[] arg = {"4444"};
        args = arg;
        if (args.length != 1) {
            System.err.println("Usage: java BookServer <port number>");
            System.exit(1);
        }

        int portNumber = Integer.parseInt(args[0]);

        try (
                ServerSocket serverSocket = new ServerSocket(portNumber);
                Socket clientSocket = serverSocket.accept();
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))
        ) {

            String inputLine, outputLine;

            // Initiate conversation with client
            BookProtocol kkp = new BookProtocol();
            outputLine = kkp.processInput(null);
            out.println(outputLine);

            while ((inputLine = in.readLine()) != null) {
                outputLine = kkp.processInput(inputLine);
                out.println(outputLine);
                if (outputLine.equals("Bye."))
                    break;
            }
        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port "
                    + portNumber + " or listening for a connection");
            System.out.println(e.getMessage());
        }
    }







        //Output
        /*System.out.println("ISBN: " + isbn );
        System.out.println("Title: " + result.getBookDetail().getTitle() );
        System.out.println("Subtitle: " + result.getBookDetail().getSubTitle() );
        result.getBookDetail().getAuthors().forEach(author -> System.out.println("Author: " + author));
        System.out.println("Description: " + result.getBookDetail().getDescription() );
        System.out.println("Pages: " + result.getBookDetail().getPageCount() );
        System.out.println("Language: " + result.getBookDetail().getLanguage() );*/

}
