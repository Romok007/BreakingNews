package com.example.romok.breakingnews;

import android.graphics.Bitmap;

public class News {

    /**
     * Title of the news
     */
    private String mTitle;

    /**
     * Description of the news
     */
    private String mDescription;

    /**
     * Url of the news
     */
    private String mUrl;

    /**
     * Image related to the news
     */
    private Bitmap mImage;

    public News(String title, String description, String url, Bitmap image) {
        mTitle = title;
        mDescription = description;
        mUrl = url;
        mImage = image;
    }

    /**
     * Returns the title of the News.
     */
    public String getTitle() {
        return mTitle;
    }

    /**
     * Returns the description of the news.
     */
    public String getDescription() {
        return mDescription;
    }

    /**
     * Returns the url of the news.
     */
    public String getUrl() {
        return mUrl;
    }

    /**
     * Returns the image related to the news.
     */
    public Bitmap getImage() {
        return mImage;
    }
}
