package popytka_sozdaniya.training100500.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import popytka_sozdaniya.training100500.entities.*;
import popytka_sozdaniya.training100500.repos.*;
import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/UserEntity")
@PreAuthorize("hasAuthority('ADMIN')")

public class UserController {
    @Autowired
    private UserRepos userRepos;//репозиторий пользователей

    @Autowired
    private CarRepos carRepos;//репозиторий автомобилей

    @Autowired
    private ClientRepos clientRepos;//репозиторий клиентов

    @Autowired
    private PaymentRepos paymentRepos;//репозиторий оплат

    @Autowired
    private PartsRepos partsRepos;//репозиторий запчастей

    @Autowired
    private WorkerRepos workerRepos;//репозиторий работников

    @GetMapping
    public String userList(Model model) {

        List<UserEntity> usersAndRoles = userRepos.findAll();
        model.addAttribute("users", usersAndRoles);

        List<CarEntity> carEntities = carRepos.findAll();
        model.addAttribute("cars", carEntities);

        List<ClientEntity> clientEntities = clientRepos.findAll();
        model.addAttribute("clients", clientEntities);

        List<PaymentEntity> paymentEntities = paymentRepos.findAll();
        model.addAttribute("payments", paymentEntities);

        List<PartsEntity> partsEntities = partsRepos.findAll();
        model.addAttribute("parts", partsEntities);
        return "userList";
    }


//Обработчики для редактирования пользователя
    @GetMapping("/toUserEdit/{id}/userEdit")
    public String UserEdit(@PathVariable(value = "id") Long id, Model model)
    {
        return "userEdit";
    }
    @PostMapping("/toUserEdit/{id}/userEdit")
    public String userEdit(@PathVariable(value = "id") Long id,
                           @RequestParam String username,
                           @RequestParam String password,
                           @RequestParam boolean active,
                           @RequestParam String role)
    {
        UserEntity userEntity = userRepos.findUserEntityById(id);
        userEntity.setUsername(username);
        userEntity.setPassword(password);
        userEntity.setActive(active);
        Set<String> roles = Arrays.stream(Role.values()).
                map(Role::name).
                collect(Collectors.toSet());
        userEntity.getRoles().clear();
        if(roles.contains(role))
        {
            userEntity.getRoles().add(Role.valueOf(role));
        }
        userRepos.save(userEntity);

        return "redirect:/UserEntity";
    }
//Обработчики для удаления пользователя

    @GetMapping("/toUserDelete/{id}")
    public String userDelete(@PathVariable(value = "id") Long id)
    {
        UserEntity user_delete = userRepos.findUserEntityById(id);
        userRepos.delete(user_delete);
        return "redirect:/UserEntity";
    }
    //Обработчики для добавления пользователя
    @GetMapping("/userAdd")
    public String toAddUser()
    {
        return "userAdd";
    }
    @PostMapping("/userAdd")
    public String AddUser(UserEntity userEntity,
                           @RequestParam Long id,
                           @RequestParam String username,
                           @RequestParam String password,
                           @RequestParam boolean active)
                           //@RequestParam String role)
    {
       userEntity.setId(id);
       userEntity.setUsername(username);
       userEntity.setPassword(password);
       userEntity.setActive(active);
       userEntity.setRoles(Collections.singleton(Role.USER));
        userRepos.save(userEntity);
       return "redirect:/UserEntity";
    }
}
