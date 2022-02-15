package popytka_sozdaniya.training100500.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class addController {

    //переход на страницу админов
    @GetMapping("/add/AllInfoAdmin")
    private String addIndex(Model model){
        return "redirect:/index/AllInfoAdmin";
    }
    //переход на страницу для получения статуса работ
    @GetMapping("/add/info")
    private String addInfo(Model model){

        return "redirect:/index/info";

    }
    //переход на страницу с контактами
    @GetMapping("/add/contacts")
    private String addContacts(Model model){

        return "redirect:/index/contacts";
    }
    /*@GetMapping("/add/add")
    private String addAdd(Model model){
        return "redirect:/index/add";
    }*/
}
