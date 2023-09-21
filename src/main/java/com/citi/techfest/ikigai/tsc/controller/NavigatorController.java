package com.citi.techfest.ikigai.tsc.controller;


import com.citi.techfest.ikigai.tsc.entity.Participant;
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

    @GetMapping("/staff")
    public ResponseEntity getAllStaff() {
        return ResponseEntity.ok(navigatorService.getAllParticipants());
    }

    @PostMapping("/add")
    public ResponseEntity<Participant> createNewStaffProfile(@RequestBody Participant navigator) {
        //logic to assemble the navigator
        Participant createdParticipant = navigatorService.createParticipant(navigator);
        return new ResponseEntity<>(createdParticipant, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Participant> updateBeneficiary(@PathVariable String id, @RequestBody Participant participant) {
        Participant updatedParticipant = navigatorService.updateParticipant(id, participant);
        return new ResponseEntity<>(updatedParticipant, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePBeneficiary(@PathVariable String id) {
        navigatorService.deleteParticipant(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/getBeneficiariesByNavigator/{id}")
    public ResponseEntity<List<Participant>> getAllBeneficiariesByNavigator(@PathVariable String id) {
        List<Participant> matchedList = navigatorService.getBeneficiariesByNavigatorID(id, Constants.BENEFICIARY);
        return new ResponseEntity<>(matchedList, HttpStatus.OK);
    }
}