package org.simplesearch.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * Created by Валерий on 10.11.14.
 */
@RestController
public class SimpleRestController {

    @Autowired CianParser parser;
    @RequestMapping(value="/get", produces="application/json; charset=UTF-8")
    public CianPageData get(@RequestParam(value="url", defaultValue="") String url) throws IOException{
        return parser.parse(url);
    }
}
