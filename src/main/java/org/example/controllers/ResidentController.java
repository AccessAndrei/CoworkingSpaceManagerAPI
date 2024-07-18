package org.example.controllers;

import org.example.dto.ResidentDTO;
import org.example.services.ResidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/residents")
public class ResidentController {

    private final ResidentService residentService;

    @Autowired
    public ResidentController(ResidentService residentService) {
        this.residentService = residentService;
    }

    @PostMapping("/check-subscription")
    public ResidentDTO checkAndUpdateSubscription() {
        return residentService.checkAndUpdateSubscription();
    }
}