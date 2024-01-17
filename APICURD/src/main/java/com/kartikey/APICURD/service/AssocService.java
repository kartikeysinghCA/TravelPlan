package com.kartikey.APICURD.service;

import com.kartikey.APICURD.model.Assoc;
import com.kartikey.APICURD.model.Travel;
import com.kartikey.APICURD.repository.AssocRepository;
import com.kartikey.APICURD.repository.TravelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AssocService {
    @Autowired
    private AssocRepository assocRepository;

    public String createNewAssoc(Assoc assoc) {
        assocRepository.save(assoc);
        return "Association ID:" + assoc.getAssoid() + ", " + assoc.getEmpid() + "->" + assoc.getTrid() + " Saved!";
    }

    public List<Assoc> getAllAssoc() {
        List<Assoc> assocList = new ArrayList<>();
        assocRepository.findAll().forEach(assocList::add);
        return assocList;
    }

    public Optional<Assoc> getAssocById(long assoid) {
        return assocRepository.findById(assoid);
    }

    public String updateAssocById(long assoid, Assoc newAsso) {
        Optional<Assoc> assoc = assocRepository.findById(assoid);
        if (assoc.isPresent()) {
            Assoc oldAsso = assoc.get();
            if(newAsso.getEmpid()>0)
                oldAsso.setEmpid(newAsso.getEmpid());
            if(newAsso.getTrid()>0)
                oldAsso.setTrid(newAsso.getTrid());
            assocRepository.save(oldAsso);
            return "Association ID:" + assoid + ", " + oldAsso.getEmpid() + "->" + oldAsso.getTrid() + " Updated!";
        } else {
            return "Association DNE!";
        }
    }

    public String deleteAssocById(long assoid) {
        Optional<Assoc> assoc = assocRepository.findById(assoid);
        if (assoc.isPresent()) {
            Assoc existAsso = assoc.get();
            assocRepository.deleteById(assoid);
            return "Association ID:" + assoid + ", " + existAsso.getEmpid() + "->" + existAsso.getTrid() + " Deleted!";
        } else {
            return "Association DNE!";
        }
    }

    public String deleteAllAssoc() {
        assocRepository.deleteAll();
        return "All Associations Deleted!!";
    }
}
