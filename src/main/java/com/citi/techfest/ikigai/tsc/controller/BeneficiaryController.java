package com.citi.techfest.ikigai.tsc.controller;


import com.citi.techfest.ikigai.tsc.entity.Participant;
import com.citi.techfest.ikigai.tsc.service.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.citi.techfest.ikigai.tsc.util.Constants;

import java.util.List;

@RestController
@RequestMapping("/api/beneficiary")
public class BeneficiaryController {

    @Autowired
    private ParticipantService participantService;

    @PostMapping
    public ResponseEntity<Participant> createBeneficiary(@RequestBody Participant participant) {
        Participant createdParticipant = participantService.createParticipant(participant);
        return new ResponseEntity<>(createdParticipant, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Participant> updateBeneficiary(@PathVariable String id, @RequestBody Participant participant) {
        Participant updatedParticipant = participantService.updateParticipant(id, participant);
        return new ResponseEntity<>(updatedParticipant, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePBeneficiary(@PathVariable String id) {
        participantService.deleteParticipant(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}