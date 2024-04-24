package app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import app.data.Booking;
import app.data.Guest;
import app.data.Visitor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Controller
@Transactional
public class HotelController {
    
    @PersistenceContext
    private EntityManager em;

    @GetMapping
    public String index(Model model) {
        var visitors = em.createQuery("SELECT g FROM Guest g", Guest.class)
                        .getResultStream()
                        .map(Visitor::fromGuest)
                        .sorted((u, v) -> -u.lastVisit().compareTo(v.lastVisit()))
                        .toList();
        model.addAttribute("people", visitors);
        model.addAttribute("guest", new Guest());
        return "welcome";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute(name = "guest") Guest input) {
        input.getBookings().add(new Booking(input));
        em.merge(input);
        return "redirect:./";
    }
}
