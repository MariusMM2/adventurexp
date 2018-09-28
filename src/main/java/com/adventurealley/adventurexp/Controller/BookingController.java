package com.adventurealley.adventurexp.Controller;

import com.adventurealley.adventurexp.forms.BookingForm;
import com.adventurealley.adventurexp.model.Activity;
import com.adventurealley.adventurexp.model.Booking;
import com.adventurealley.adventurexp.repositories.ActivityRepository;
import com.adventurealley.adventurexp.repositories.BookingRepository;
import com.adventurealley.adventurexp.repositories.IRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookingController {

    private IRepository<Activity> activityRepository = ActivityRepository.getInstance();
    private IRepository<Booking>  bookingRepository = BookingRepository.getInstance();

    @GetMapping("/activityInfo")
    public String details(@RequestParam("id") int id, Model model){
        Activity activity = activityRepository.read(id);
        assert activity != null;
        model.addAttribute("activity", activity);
        return "activityInfo";
    }

    @PostMapping("/activityInfo")
    public String book(Model model, @ModelAttribute("bookingForm") BookingForm bookingForm, @RequestParam("id") int id){
        System.out.println(bookingForm);
        if (!bookingForm.validate()){
            model.addAttribute("errorMessage", "Invalid field");
            return "activityInfo";
        }

        Activity activity = activityRepository.read(id);
        assert activity != null;
        model.addAttribute("activity", activity);

        Booking booking = bookingForm.toModel();

        int id = bookingRepository.create(booking);
        if(id == -1){
            model.addAttribute("errorMessage", "Error creating the booking (database error)");
        }

        model.addAttribute("successMessage", "Your booking number #" + id + " has been registered!");

        return "activityInfo";
    }

    @GetMapping("/")
    public String home(){
        return "index";
    }
}
