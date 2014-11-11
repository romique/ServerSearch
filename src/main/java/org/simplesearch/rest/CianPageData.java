package org.simplesearch.rest;

import java.util.List;

/**
 * Created by Валерий on 11.11.14.
 */
public class CianPageData {
    private String url;
    private String descr;
    private List<String> images;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
}
