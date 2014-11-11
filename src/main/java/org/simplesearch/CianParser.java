package org.simplesearch;


import org.simplesearch.rest.UrlRequester;

import java.io.IOException;

/**
 * Created by Валерий on 10.11.14.
 */
public class CianParser {
    private final static String IMAGES = "object_descr_images_w";
    private final static String TITLE = "object_descr_title";
//    private final static String ADDR = "object_descr_addr";
    private final static String METRO = "object_descr_metro";

    private String title;
    private String metro;
//    private String addr="ad";
    private String images;
    private String url;

    public CianParser(String url) throws IOException{
        UrlRequester urlRequester = new UrlRequester(url);
        this.title = urlRequester.getDivsByClassName(TITLE);
        this.metro = urlRequester.getDivsByClassName(METRO);
//        this.addr = urlRequester.getDivsByClassName(ADDR);
        this.images = urlRequester.getDivsByClassName(IMAGES);
    }
}
