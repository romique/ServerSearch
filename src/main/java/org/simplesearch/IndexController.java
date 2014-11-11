package org.simplesearch;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Валерий on 10.11.14.
 */
@Controller
public class IndexController {
    private static String message="Hello World!";

    @RequestMapping(value="/")
    public String indexcontrolller(ModelMap model){
        model.addAttribute("message", message);
        return "index";
    }
}
