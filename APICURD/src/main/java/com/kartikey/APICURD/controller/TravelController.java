package com.kartikey.APICURD.controller;

import com.kartikey.APICURD.model.Travel;
import com.kartikey.APICURD.service.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class TravelController {
    @Autowired
    private TravelService travelService;

    @PostMapping("/travel")
    public String createNewEmployee(@RequestBody Travel travel) {
        return travelService.createNewTravel(travel);
    }

    @GetMapping("/travel")
    public ResponseEntity<List<Travel>> getAllTravel() {
        List<Travel> travList = travelService.getAllTravel();
        return new ResponseEntity<>(travList, HttpStatus.OK);
    }

    @GetMapping("/travel/{trid}")
    public ResponseEntity<Travel> getTravelById(@PathVariable long trid) {
        Optional<Travel> trv = travelService.getTravelById(trid);
        return trv.map(travel -> new ResponseEntity<>(travel, HttpStatus.FOUND))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/travel/{pechan}")
    public String updateTravelById(@PathVariable long pechan, @RequestBody Travel newTrv) {
        return travelService.updateTravelById(pechan, newTrv);
    }

    @DeleteMapping("/travel/{trid}")
    public String deleteEmployeeById(@PathVariable long trid) {
        return travelService.deleteTravelById(trid);
    }

    @DeleteMapping("/travel")
    public String deleteEmployees() {
        return travelService.deleteAllTravel();
    }
}
