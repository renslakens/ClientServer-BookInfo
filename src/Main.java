package src;

import com.google.gson.*;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Voer uw ISBN nummer in: ");
        String isbn = scan.nextLine();

        URL bookInfo = new URL("https://www.googleapis.com/books/v1/volumes?q=isbn:" + isbn);

        InputStream input = bookInfo.openStream();
        Reader reader = new InputStreamReader(input, "UTF-8");
        JsonResult result  = new Gson().fromJson(reader, JsonResult.class);

        //Output
        System.out.println("ISBN: " + isbn );
        System.out.println("Title: " + result.getBookDetail().getTitle() );
        System.out.println("Subtitle: " + result.getBookDetail().getSubTitle() );
        result.getBookDetail().getAuthors().forEach(author -> System.out.println("Author: " + author));
        System.out.println("Description: " + result.getBookDetail().getDescription() );
        System.out.println("Pages: " + result.getBookDetail().getPageCount() );
        System.out.println("Language: " + result.getBookDetail().getLanguage() );
    }
}
