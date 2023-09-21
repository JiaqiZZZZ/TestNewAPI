package com.citi.techfest.ikigai.tsc.service;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.citi.techfest.ikigai.tsc.entity.Participant;
import com.citi.techfest.ikigai.tsc.repository.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.citi.techfest.ikigai.tsc.util.Constants;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ParticipantService {

    @Autowired
    private ParticipantRepository participantRepository;

    @Autowired
    private DynamoDBMapper dynamoDBMapper;

    public List<Participant> getAllParticipants() {
        return participantRepository.findAll();
    }

    public List<Participant> getAllNavigators() {
        return participantRepository.findByRole(Constants.NAVIGATOR);
    }

    public List<Participant> getAllCaseWorkers() {
        return participantRepository.findByRole(Constants.CASEWORKER);
    }

    public List<Participant> getAllBeneficiaries() {
        return participantRepository.findByRole(Constants.BENEFICIARY);
    }
    public Optional<Participant> getParticipantById(String id) {
        return participantRepository.findById(id);
    }

    public List<Participant> getBeneficiariesByNavigatorID(String nid, String role) {
        return participantRepository.findByAssignedNavigatorIDAndRole(nid, role);
    }

    public List<Participant> getBeneficiariesByCaseWorkerID(String cid) {
        Optional<Participant> caseWorker = participantRepository.findById(cid);
        if(caseWorker.isPresent()){
            String orgName = caseWorker.get().getOrganizationName();
            String serviceName = caseWorker.get().getServiceName();
            return participantRepository.findByOrganizationNameAndServiceName(orgName, serviceName);
        }
        else return null;
    }
    public Participant createParticipant(Participant participant) {
        return participantRepository.save(participant);
    }

    public Participant updateParticipant(String id, Participant participant) {
        Optional<Participant> optionalParticipant = participantRepository.findById(id);
        if (optionalParticipant.isPresent()) {
            participant.setId(id);
            return participantRepository.save(participant);
        }
        return null;
    }

    public void deleteParticipant(String id) {
        participantRepository.deleteById(id);
    }
}