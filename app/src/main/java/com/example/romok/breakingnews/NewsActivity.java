package com.example.romok.breakingnews;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class NewsActivity extends AppCompatActivity {

    /**
     * URL for the News Data
     */
    private static final String NEWS_REQUEST_URL = "https://newsapi.org/v1/articles?source=the-times-of-india&sortBy=latest&apiKey=f232315a440647c38061b5a39b611a09";

    private NewsAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        ListView newsListView = (ListView) findViewById(R.id.list);

        //Create a new adapter that takes an empty list of News
        mAdapter = new NewsAdapter(this, new ArrayList<News>());

        //Setting the adapter to the ListView
        newsListView.setAdapter(mAdapter);

        newsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                News currentNews = mAdapter.getItem(position);

                //Convert the String URL into a URI object
                Uri newsUri = Uri.parse(currentNews.getUrl());

                //Create a new intent to view the earthquake URI
                Intent websiteIntent = new Intent(Intent.ACTION_VIEW, newsUri);

                //Send an intent to launch a new activity
                startActivity(websiteIntent);
            }
        });

        //Start the AsyncTask to fetch the News data
        NewsAsyntask task = new NewsAsyntask();
        task.execute(NEWS_REQUEST_URL);
    }

    private class NewsAsyntask extends AsyncTask<String, Void, List<News>> {

        @Override
        protected List<News> doInBackground(String... urls) {
            // Don't perform the request if there are no URLs, or the first URL is null
            if (urls.length == 0 || urls[0] == null) {
                return null;
            }

            List<News> result = QueryUtils.fetchNewsData(urls[0]);
            return result;
        }

        @Override
        protected void onPostExecute(List<News> data) {
            //Clear the previous News data
            mAdapter.clear();

            //If there is valid list of list of news attach them to the adapter
            //This will update the ListView
            if (data != null && !data.isEmpty()) {
                mAdapter.addAll(data);
            }
        }
    }
}
