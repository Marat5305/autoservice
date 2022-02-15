package popytka_sozdaniya.training100500.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import popytka_sozdaniya.training100500.entities.Role;
import popytka_sozdaniya.training100500.entities.UserEntity;
import popytka_sozdaniya.training100500.repos.UserRepos;
import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepos userRepos;

    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(UserEntity user, Map<String, Object> model) {
        UserEntity userFromDb =  userRepos.findByUsername(user.getUsername());

        if (userFromDb != null){
            model.put("message", "User exists!");
            return "registration";
        }
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepos.save(user);

        return "redirect:/login";
    }
}