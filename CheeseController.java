package org.launchcode.cheese.mvc.Controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@RequestMapping("cheese")
public class CheeseController {

    static ArrayList<String> cheeses = new ArrayList<>();  //an object that will pass through the view

    //request path now: /cheese
    @RequestMapping(value = "")
    public String index(Model model) {  //Controller method passes through 'value'

        model.addAttribute("cheeses", cheeses); //passes the cheeses through the view
        model.addAttribute("title", "My Cheeses"); //this passes data into the view

        return "cheese/index"; //return this template & displays what's in the index.html file
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddCheeseForm(Model model) {

        model.addAttribute("title", "Add Cheese");

        return "cheese/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddCheeseForm(@RequestParam String cheeseName) {

        cheeses.add(cheeseName);

        //Redirect to /cheese
        return "redirect:";
    }

}
