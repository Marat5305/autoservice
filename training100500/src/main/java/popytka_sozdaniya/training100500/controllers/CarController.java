/*package popytka_sozdaniya.training100500.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import popytka_sozdaniya.training100500.entities.CarEntity;
import popytka_sozdaniya.training100500.repos.CarRepos;

@Controller
@RequestMapping("/UserEntity")
@PreAuthorize("hasAuthority('ADMIN')")
public class CarController {
    @Autowired
    private CarRepos carRepos;

    //обработчики для редактирования записей с машинами
    @GetMapping("/toEditCar/{id}/carEdit")
    private String getCarEdit(@PathVariable Long id)
    {
        return "carEdit";
    }
    @PostMapping("/toEditCar/{id}/carEdit")
    private String carEdit(@PathVariable(value = "id") Long id,
                           @RequestParam String Car_model,
                           @RequestParam String STS,
                           @RequestParam String State_number,
                           @RequestParam String Damages,
                           @RequestParam String Service,
                           @RequestParam String Results_of_work)
    {
        CarEntity carEntity = carRepos.findCarEntityById(id);
        carEntity.setCarModel(Car_model);
        carEntity.setSts(STS);
        carEntity.setStateNumber(State_number);
        carEntity.setDamages(Damages);
        carEntity.setService(Service);
        carEntity.setResultsOfWork(Results_of_work);
        carRepos.save(carEntity);

        return "redirect:/UserEntity";


    }
}
*/