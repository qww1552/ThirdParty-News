package com.example.covid19_news;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Item> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String searchTerm ="제주";
        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);



        AsyncCrawl task = new AsyncCrawl();
        task.execute(searchTerm);


    }

    private class AsyncCrawl extends AsyncTask<String, Void, Elements> {

        @Override
        protected Elements doInBackground(String... lists) {
            if(lists.length != 1) {
                throw new IllegalArgumentException();
            }
            String term = lists[0];
            Elements items = Crawler.search(term);

            return items;
        }

        @Override
        protected void onPostExecute(Elements elements) {
            super.onPostExecute(elements);
            if(elements!=null){
                for(Element item:elements){
                    String title = item.select("title").text();
                    String link = item.select("link").text();
                    String pubdate=item.select("pubDate").text();

                    list.add(new Item(title, link, pubdate));
                }
            }


            MyAdapter myAdapter = new MyAdapter(list);
            recyclerView.setAdapter(myAdapter);
        }
    }
}
