package org.simplesearch.rest;

import org.simplesearch.CianParser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * Created by Валерий on 10.11.14.
 */
@RestController
public class SimpleRestController {
    @RequestMapping(value="/get", produces="application/json; charset=UTF-8")
    public CianParser urlRequester(@RequestParam(value="url", defaultValue="") String url) throws IOException{
        CianParser cp = new CianParser(url);
        return cp;
    }
}
