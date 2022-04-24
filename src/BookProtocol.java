package src;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLOutput;
import java.util.ArrayList;

public class BookProtocol {

    private static final int WAITING = 0;
    private static final int TELLTITLE = 1;
    private static final int TELLDESCRIPTION = 2;
    private static final int ANOTHER = 3;

    private int state = WAITING;

    private String[] clues = { "Turnip", "Little Old Lady", "Atch", "Who", "Who" };
    private String[] answers = { "Turnip the heat, it's cold in here!",
            "I didn't know you could yodel!",
            "Bless you!",
            "Is there an owl in here?",
            "Is there an echo in here?" };
    private ArrayList<String> input = new ArrayList<>();

    public String processInput(String theInput) throws IOException {
        String theOutput = null;
        input.add(theInput);
        JsonResult result = null;
        if(input.size() >= 2) {
            URL bookInfo = new URL("https://www.googleapis.com/books/v1/volumes?q=isbn:" + input.get(1));

            InputStream input = bookInfo.openStream();
            Reader reader = new InputStreamReader(input, "UTF-8");
            result = new Gson().fromJson(reader, JsonResult.class);
        }


        if (state == WAITING) {
            theOutput = "Enter ISBN for desired book";

            state = TELLTITLE;
        } else if (state == TELLTITLE) {
            theOutput = result.getBookDetail().getTitle() + " Want to know the description too? (y/n)";
            state = TELLDESCRIPTION;
        } else if (state == TELLDESCRIPTION) {
            if (theInput.equalsIgnoreCase("y")) {

                theOutput = "" + result.getBookDetail().getDescription();
                state = ANOTHER;
            } else {
                theOutput = "Ah you already know what it's about, good for you";
                state = ANOTHER;
            }

        }
        return theOutput;
    }
}
