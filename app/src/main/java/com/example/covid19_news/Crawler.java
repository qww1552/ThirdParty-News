package com.example.covid19_news;

import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

public class Crawler {
    /*public static Elements search(String location) {
        Document doc=null;
        Elements articles =null;
        String baseUrl = "https://news.google.com/rss/";
        String term = "search?q=%EC%BD%94%EB%A1%9C%EB%82%98%20%2B%20"
                +location
                +"&hl=ko&gl=KR&ceid=KR%3Ako";
        try {
            doc = Jsoup.connect(baseUrl+term).get();
            articles = doc.select("item");

        }catch (Exception e) {
            e.printStackTrace();
        }

        return articles;
    }*/
    public static Elements search(String searchTerm) {

        String string = NaverOpen.NaverNews(searchTerm);

        Document doc = Jsoup.parse(string);
        Elements items = null;

        items = doc.select("item");

        return items;
    }
}