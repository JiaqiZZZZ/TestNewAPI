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
@RequestMapping("/api/org")
public class OrganizationController {

    @Autowired
    private ParticipantService orgWorkerService;

    @GetMapping("/caseworkers")
    public ResponseEntity getAllOrgWorkers() {
        return ResponseEntity.ok(orgWorkerService.getAllCaseWorkers());
    }

    @PostMapping("/add")
    public ResponseEntity<Participant> createNewStaffProfile(@RequestBody Participant orgWorker) {
        //logic to assemble the navigator
        Participant createdParticipant = orgWorkerService.createParticipant(orgWorker);
        return new ResponseEntity<>(createdParticipant, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Participant> updateBeneficiary(@PathVariable String id, @RequestBody Participant participant) {
        Participant updatedParticipant = orgWorkerService.updateParticipant(id, participant);
        return new ResponseEntity<>(updatedParticipant, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePBeneficiary(@PathVariable String id) {
        orgWorkerService.deleteParticipant(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/getBeneficiariesByCaseworker/{id}")
    public ResponseEntity<List<Participant>> getAllBeneficiariesByCaseworker(@PathVariable String id) {
        List<Participant> matchedList = orgWorkerService.getBeneficiariesByCaseWorkerID(id);
        if(matchedList == null || matchedList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(matchedList, HttpStatus.OK);
    }
}
