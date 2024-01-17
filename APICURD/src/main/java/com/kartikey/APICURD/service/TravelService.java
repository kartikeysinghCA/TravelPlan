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
public class TravelService {
    @Autowired
    private TravelRepository travelRepository;
    @Autowired
    private AssocRepository assocRepository;

    public String createNewTravel(Travel travel) {
        travelRepository.save(travel);
        return "Travel " + travel.getTrid() + " " + travel.getTName() + " saved in DB!";
    }

    public List<Travel> getAllTravel() {
        List<Travel> travelList = new ArrayList<>();
        travelRepository.findAll().forEach(travelList::add);
        return travelList;
    }

    public Optional<Travel> getTravelById(long trid) {
        return travelRepository.findById(trid);
    }

    public String updateTravelById(long trid, Travel newTrav) {
        Optional<Travel> trav = travelRepository.findById(trid);
        if (trav.isPresent()) {
            Travel oldTrav = trav.get();
            if(newTrav.getTName()!=null)
                oldTrav.setTName(newTrav.getTName());
            if(newTrav.getTDesc()!=null)
                oldTrav.setTDesc(newTrav.getTDesc());
            if(newTrav.getTDate()!=null)
                oldTrav.setTDate(newTrav.getTDate());
            travelRepository.save(oldTrav);
            return "Travel " + trid + " " + oldTrav.getTName() + " was Updated!";
        } else {
            return "Travel DNE!";
        }
    }

    public String deleteTravelById(long trid) {
        Optional<Travel> trav = travelRepository.findById(trid);
        if (trav.isPresent()) {
            Travel existtrav = trav.get();

            deleteAssociationsByTravId(trid);
            travelRepository.deleteById(trid);
            return "Travel " + trid + " " + existtrav.getTName() + " was Deleted!";
        } else {
            return "Travel DNE!";
        }
    }
    private void deleteAssociationsByTravId(long trid) {
        List<Assoc> associationsToDelete = assocRepository.findByTrid(trid);
        assocRepository.deleteAll(associationsToDelete);
    }

    public String deleteAllTravel() {
        travelRepository.deleteAll();
        assocRepository.deleteAll();
        return "All Travels Deleted!!";
    }
}
