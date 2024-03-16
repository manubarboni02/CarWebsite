package SpringBoot.CarWebsite.Controller;

import SpringBoot.CarWebsite.Model.Car;
import SpringBoot.CarWebsite.Model.SecurityUser;
import SpringBoot.CarWebsite.Repository.UserRepository;
import SpringBoot.CarWebsite.Service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class  CarController {

    private final CarService carService;
    private final UserRepository userRepository;
    @Autowired
    public CarController(CarService carService, UserRepository userRepository) {
        this.carService = carService;
        this.userRepository = userRepository;
    }

    @PreAuthorize(value = "hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    @GetMapping("/show")
    public String showCars(Model model, @AuthenticationPrincipal SecurityUser currentuser, @Param("filter1") String filter1, @Param("filter2") String filter2, @Param("filter3") String filter3) {
        if(filter1==null && filter2==null && filter3==null) {
            model.addAttribute("cars", carService.getCars());
        }
        else {
            model.addAttribute("cars", carService.findAllByKeywords(filter1, filter2, filter3));
        }
        model.addAttribute("car",new Car());
        model.addAttribute("currentUser", userRepository.findByUsername(currentuser.getUsername()));
        return "mainpage";
    }

    @PostMapping("/edit")
    public String editCar(@RequestParam("action") String action){
        if(action.equals("add"))
            return "forward:/add";
        if(action.equals("modify"))
            return "forward:/modify";
        if(action.equals("delete"))
            return "forward:/delete";
        return "redirect:/show";
    }
    @PostMapping( "/add")
    public String addCar(Car car)
    {
                boolean notAdded = carService.addCar(car);
                if(notAdded)
                    return "redirect:/show?notAdded=true";
                return "redirect:/show";
    }
    @PostMapping("/modify")
    public String modifyCar(Car car)
    {
        boolean notModified = carService.modifyCar(car);
        if(notModified)
            return "redirect:/show?notModified=true";
        return "redirect:show";
    }
    @PostMapping("/delete")
    public String deleteCar(Car car)
    {
        boolean notDeleted = carService.deleteCar(car);
        if(notDeleted)
            return "redirect:/show?notDeleted=true";
        return "redirect:/show";
    }
}
