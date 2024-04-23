package app.controllers;


import org.springframework.stereotype.Controller;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Controller
@Transactional
public class HotelController {
    
    @PersistenceContext
    private EntityManager em;
}
