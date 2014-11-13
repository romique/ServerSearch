package org.simplesearch.rest;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Валерий on 10.11.14.
 */
@Service
public class CianParser {
    private final static String IMAGES = "object_descr_images_w";
    private final static String PRICE = "object_descr_price";
    private final static String TITLE = "object_descr_title";
    private final static String ADDR = "object_descr_addr";
    private final static String METRO = "object_descr_metro";

    public CianParser(){}

    public CianPageData parse(String url) throws IOException{
        CianPageData pageData = new CianPageData();

        Connection connection = Jsoup.connect(url);
        connection.userAgent("Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv 1.8 1.6) Gecko/20070725 Firefox/2.0.0.6").referrer("http://google.com");
        Document doc = connection.get();

        Elements titles = doc.select("."+TITLE);
        Elements addrs = doc.select("."+ADDR);
        Elements metros = doc.select("." + METRO);
        Elements price = doc.select("."+PRICE);
        Elements srcs = doc.select("."+IMAGES).select("img");

        String descr = price.text() + "<br />" + titles.text() + "<br />" + addrs.text() + "<br />" + metros.text();
        List<String> images = new ArrayList<String>();
        for (Element element : srcs){
            images.add(element.attr("src"));
        }

        pageData.setUrl(url);
        pageData.setDescr(descr);
        pageData.setImages(images);
        return pageData;
    }
}
