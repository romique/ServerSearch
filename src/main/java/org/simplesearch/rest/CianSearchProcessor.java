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
 * Created by Валерий on 12.11.14.
 */
@Service
public class CianSearchProcessor {

    public CianSearchData parse(String url) throws IOException{
        Connection connection = Jsoup.connect(url);
        connection.userAgent("Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv 1.8 1.6) Gecko/20070725 Firefox/2.0.0.6").referrer("http://google.com");
        Document doc = connection.get();
        CianSearchData searchdata = new CianSearchData();

        Elements pages = doc.select("fieldset");
        Elements links = pages.select("td[id~=.*comment]").select("a");
        List<CianPageData> cianPageDescs = new ArrayList();
        CianParser parser = new CianParser();
        for (Element link : links){
            cianPageDescs.add(parser.parse("http://www.cian.ru"+link.attr("href")));
        }
        searchdata.setAppartments(cianPageDescs);
        return searchdata;
    }
}
