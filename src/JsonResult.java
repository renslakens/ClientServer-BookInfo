package src;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class JsonResult {
    @SerializedName("kind")
    private String kind;
    @SerializedName("totalItems")
    private int totalItems;
    @SerializedName("items")
    private List<Book> books;

    public Book getBook() {
        return books.get(0);
    }

    public BookDetail getBookDetail() {
        return books.get(0).getBookDetail();
    }
}
