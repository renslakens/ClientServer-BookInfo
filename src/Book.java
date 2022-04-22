package src;

import com.google.gson.annotations.SerializedName;

public class Book {
    @SerializedName("id")
    private String id;
    @SerializedName("volumeInfo")
    private BookDetail bookDetail;

    public BookDetail getBookDetail() {
        return bookDetail;
    }
}
