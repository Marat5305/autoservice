/*package popytka_sozdaniya.training100500.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import popytka_sozdaniya.training100500.entities.ClientEntity;
import popytka_sozdaniya.training100500.repos.ClientRepos;

@Controller
@RequestMapping("/UserEntity")
@PreAuthorize("hasAuthority('ADMIN')")
public class ClientController {

    @Autowired
    private ClientRepos clientRepos;

    @GetMapping("/toEditClient/{id}/clientEdit")
    private String getClientEdit()
    {
        return "clientEdit";
    }
    @PostMapping("/toEditClient/{id}/clienEdit")
    private String editClient(@PathVariable(value = "id") int id,
                              @RequestParam String FIO,
                              @RequestParam String Passport,
                              @RequestParam String Residence)
    {
        ClientEntity clientEntity = clientRepos.findClientEntityById(id);
        clientEntity.setFio(FIO);
        clientEntity.setPassportNumber(Passport);
        clientEntity.setResidenceAdress(Residence);

        clientRepos.save(clientEntity);
        return "redirect:/UserEntity";
    }
}
*/
