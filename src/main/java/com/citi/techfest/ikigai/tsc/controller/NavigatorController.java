package com.citi.techfest.ikigai.tsc.controller;


import com.citi.techfest.ikigai.tsc.entity.Participant;
import com.citi.techfest.ikigai.tsc.entity.ServicePlan;
import com.citi.techfest.ikigai.tsc.entity.SocialService;
import com.citi.techfest.ikigai.tsc.service.ParticipantService;
import com.citi.techfest.ikigai.tsc.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tsc")
public class NavigatorController {

    @Autowired
    private ParticipantService navigatorService;


    @GetMapping("/{navigatorId}/assigned-participants")
    public List<Participant> getAssignedParticipants(@PathVariable String navigatorId) {
        return navigatorService.getAssignedParticipants(navigatorId);
    }

    @GetMapping("/all-participants")
    public List<Participant> getAllParticipants() {
        return navigatorService.getAllParticipants();
    }

    @GetMapping("/participant-profile/{participantName}")
    public Participant getParticipantProfile(@PathVariable String participantID) {
        return navigatorService.getParticipantById(participantID).get();
    }

    @GetMapping("/{navigatorId}/assigned-participants/services")
    public List<ServicePlan> getAssignedParticipantsServices(@PathVariable String navigatorId) {
        return navigatorService.getAssignedParticipantsServices(navigatorId);
    }

    @PostMapping("/{navigatorId}/assign-participant")
    public void assignParticipantToNavigator(@PathVariable String navigatorId, @RequestBody Participant participant) {
        navigatorService.assignParticipantToNavigator(navigatorId, participant);
    }

    @PostMapping("/createServicePlan/{participantId}")
    public void bookServiceForBeneficiary(@RequestBody List<ServicePlan> serviceplanList, @PathVariable String participantId) {
        navigatorService.bookServiceForBeneficiary(serviceplanList, participantId);
    }

}