package src;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BookDetail {
    @SerializedName("title")
    private String title;
    @SerializedName("subtitle")
    private String subTitle;
    @SerializedName("publishedDate")
    private String publishedDate;
    @SerializedName("pageCount")
    private int pageCount;
    @SerializedName("printType")
    private String printType;
    @SerializedName("language")
    private String language;
    @SerializedName("authors")
    private List<String> authors;
    @SerializedName("description")
    private String description;

    public String getTitle() {
        return title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public int getPageCount() {
        return pageCount;
    }

    public String getPrintType() {
        return printType;
    }

    public String getLanguage() {
        return language;
    }

    public List<String> getAuthors(){
        return authors;
    }

    public String getDescription() {
        return description;
    }
}
