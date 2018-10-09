package com.adventurealley.adventurexp.Controller;

import com.adventurealley.adventurexp.forms.BookingForm;
import com.adventurealley.adventurexp.forms.BookingSearchForm;
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

import java.time.LocalDate;

@Controller
public class BookingController {

    private IRepository<Activity> activityRepository = ActivityRepository.getInstance();
    private IRepository<Booking>  bookingRepository = BookingRepository.getInstance();


    @GetMapping("/activityInfo")
    public String details(@RequestParam("id") int id, Model model){
        Activity activity = activityRepository.read(id);
        assert activity != null;
        model.addAttribute("activity", activity);
        model.addAttribute("bookingForm", new BookingForm());
        return "activityInfo";
    }

    //TODO: fix booking creation
    @PostMapping("/activityInfo")
    public String book(Model model, @ModelAttribute("bookingForm") BookingForm bookingForm, @RequestParam("id") int aid){
        bookingForm.setActivityId(aid);
        bookingForm.setEndDate(LocalDate.now().plusMonths(1));
        System.out.println(bookingForm);

        Activity activity = activityRepository.read(aid);
        assert activity != null;
        model.addAttribute("activity", activity);

        if (!bookingForm.validate()){
            System.out.println("Form did not validate");
            model.addAttribute("errorMessage", "Invalid field");
            return "activityInfo";
        }

        Booking booking = bookingForm.toModel();

        int id = bookingRepository.create(booking);
        if(id == -1){
            System.out.println("Error creating booking");
            model.addAttribute("errorMessage", "Error creating the booking (database error)");
        }

        System.out.println("Success!");

        model.addAttribute("successMessage", "Your booking number #" + id + " has been registered!");

        return "activityInfo";
    }

    @GetMapping("/activityEdit")
    public String edit(@RequestParam("id") int id, Model model){
        Activity activity = activityRepository.read(id);
        assert activity != null;
        model.addAttribute("activity", activity);
        return "activityEdit";
    }

    @PostMapping("/activityEdit")
    public String edit(@ModelAttribute("activity") Activity activity){
        activityRepository.update(activity);
        return "redirect:/activityInfo?id=" + activity.getId();
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
        BookingSearchForm form = new BookingSearchForm();

        model.addAttribute("searchForm", form);
        model.addAttribute("bookings", bookingRepository.readAll());
        return "searchBooking";
    }
    
    @PostMapping("/searchBooking")
    public String search(Model model, @ModelAttribute("searchForm") BookingSearchForm searchForm){

        model.addAttribute("bookings", searchForm.search(bookingRepository.readAll()));
        return "searchBooking";
    }
}
