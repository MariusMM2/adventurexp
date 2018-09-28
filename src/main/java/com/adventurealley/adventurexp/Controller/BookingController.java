package com.adventurealley.adventurexp.Controller;

import com.adventurealley.adventurexp.model.Activity;
import com.adventurealley.adventurexp.repositories.ActivityRepository;
import com.adventurealley.adventurexp.repositories.IRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookingController {

    private IRepository<Activity> activityRepository = new ActivityRepository();

    @GetMapping("/activityInfo")
    public String details(@RequestParam("id") int id, Model model){
        Activity activity = activityRepository.read(id);
        assert activity != null;
        model.addAttribute("activity", activity);
        return "activityInfo";
    }

    @GetMapping("/homePage")
    public String home(){
        return "homePage";
    }
}
