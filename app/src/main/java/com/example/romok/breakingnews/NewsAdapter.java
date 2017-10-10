package com.example.romok.breakingnews;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class NewsAdapter extends ArrayAdapter<News> {

    public NewsAdapter(Context context, List<News> news) {
        super(context, 0, news);
    }

    /**
     * Returns a list item view that displays information about the news at the given position
     * in the list of news.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if there is an existing list item view (called convertView) that we can reuse,
        // otherwise, if convertView is null, then inflate a new list item layout
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.news_list_item, parent, false);
        }

        //Find the news at the given position in the list of news
        News currentNews = getItem(position);

        //To display the title of the news in that TextView
        TextView titleView = (TextView) listItemView.findViewById(R.id.title);
        titleView.setText(currentNews.getTitle());

        //To display the description of the news in that TextView
        TextView descripView = (TextView) listItemView.findViewById(R.id.description);
        descripView.setText(currentNews.getDescription());

        //To display the image of the news in that TextView
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        Bitmap newsImage = currentNews.getImage();
        imageView.setImageBitmap(newsImage);

        return listItemView;
    }
}
