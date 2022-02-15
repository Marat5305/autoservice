package popytka_sozdaniya.training100500.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import popytka_sozdaniya.training100500.entities.CarEntity;
import popytka_sozdaniya.training100500.entities.ClientEntity;
import popytka_sozdaniya.training100500.repos.CarRepos;
import popytka_sozdaniya.training100500.repos.ClientRepos;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import popytka_sozdaniya.training100500.repos.UserRepos;

import javax.jws.WebParam;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@PreAuthorize("hasAnyAuthority('ADMIN, USER')")
public class indexController {

    @Autowired
    private CarRepos carRepos;

    @Autowired
    private ClientRepos clientRepos;

    @GetMapping("/")
    public String index(Model model){
            return "redirect:/index";
    }

    @GetMapping("/index")
    //Вывод домашней страницы и вывод title
    public String home(Model model) {
        model.addAttribute("title", "Лучший автосервис");
        return "index";
    }
    //Переход на страничку для админов
    @GetMapping("/index/AllInfoAdmin")
    public String infoAdmin(Model model){
        return "AllInfoAdmin";
    }

    //Переход на страничку для получения статуса работ
    //@PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/index/info")
    public String info(Model model){
        return "info";
    }

    //Переход на страничку для подачи заявки
    @GetMapping("/index/add")
    public String addsubmit(Model model)
    {
        return "add";
    }

    @GetMapping("/index/contacts")
    public String contacts(Model model)
    {
        return "contacts";
    }


    @PostMapping("/index/add")
    public String indexSubmitAdd(@RequestParam String fio,
                                 @RequestParam String carModel,
                                 @RequestParam String damages,
                                 Model model){
        ClientEntity client = new ClientEntity(fio);//добавляет фио из формы на странице add
        CarEntity car = new CarEntity(carModel, damages);//добавляет данные машины из формы на странице add

        clientRepos.save(client);
        carRepos.save(car);
        //return "redirect:/index";
        return "index";
    }
    //узнать статус работ над машиной
    @PostMapping("/index/info")
      public String getInfo(@RequestParam Integer id, Model model){
        Optional<CarEntity> findcar = carRepos.findById(id);
        ArrayList<CarEntity> res = new ArrayList<>();
        findcar.ifPresent(res::add);

        model.addAttribute("findcar", res);

        return "carinfo";
    }
}