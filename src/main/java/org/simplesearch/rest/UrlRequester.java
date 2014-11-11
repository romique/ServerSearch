package org.simplesearch.rest;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by Валерий on 10.11.14.
 */
public class UrlRequester {
    private String url;
    private Document doc;
    private Elements divs;

    public String getUrl(){
        return this.url;
    }

    public UrlRequester(String url) throws IOException{
        this.url = url;
        Connection connection = Jsoup.connect(url);
        connection.userAgent("Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv 1.8 1.6) Gecko/20070725 Firefox/2.0.0.6").referrer("http://google.com");
        doc = connection.get();
        divs = doc.select("div");
    }

    public String getDivsByClassName(String className){
        String result = "";
        for (Element element : divs){
            if (element.className().equals(className)){
                result += element.toString();
            }
        }
        return result;
    }
}
