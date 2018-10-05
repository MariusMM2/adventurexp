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

import java.util.ArrayList;

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
    public String book(Model model, @ModelAttribute("bookingForm") BookingForm bookingForm, @RequestParam("id") int aid){
        System.out.println(bookingForm);

        Activity activity = activityRepository.read(aid);
        assert activity != null;
        model.addAttribute("activity", activity);

        if (!bookingForm.validate()){
            model.addAttribute("errorMessage", "Invalid field");
            return "activityInfo";
        }



        Booking booking = bookingForm.toModel();

        int id = bookingRepository.create(booking);
        if(id == -1){
            model.addAttribute("errorMessage", "Error creating the booking (database error)");
        }

        model.addAttribute("successMessage", "Your booking number #" + id + " has been registered!");

        return "activityInfo";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute(new Activity());
        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Activity activity){
        activityRepository.create(activity);
        return "redirect:/";

    }

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("activities", activityRepository.readAll());
        return "index";
    }

    @GetMapping("/searchBooking")
    public String search(Model model){
        model.addAttribute("bookings", bookingRepository.readAll());
        model.addAttribute("searchString", "");
        
        return "searchBooking";
    }
    
    @PostMapping("/searchBooking")
    public String search(Model model, @ModelAttribute("searchString") String searchString){
        ArrayList<Booking> foundBookings = new ArrayList<>();
        ArrayList<Booking> allBookings = bookingRepository.readAll();

        for (Booking booking : allBookings) {
            if (booking.getName().toLowerCase().contains(searchString.toLowerCase())){
                foundBookings.add(booking);
            }
        }
//        model.
        System.out.println(searchString);
        System.out.println(foundBookings.toString());
        model.addAttribute("bookings", foundBookings);
        
        return "searchBooking";
    }
}
