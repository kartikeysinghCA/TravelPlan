package com.kartikey.APICURD.controller;

import com.kartikey.APICURD.model.Assoc;
import com.kartikey.APICURD.service.AssocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class AssocController {
    @Autowired
    private AssocService assocService;

    @PostMapping("/assoc")
    public String createNewAssoc(@RequestBody Assoc assoc) {
        return assocService.createNewAssoc(assoc);
    }

    @GetMapping("/assoc")
    public ResponseEntity<List<Assoc>> getAllAssoc() {
        List<Assoc> assocList= assocService.getAllAssoc();
        return new ResponseEntity<>(assocList, HttpStatus.OK);
    }

    @GetMapping("/assoc/{assoid}")
    public ResponseEntity<Assoc> getAssocById(@PathVariable long assoid) {
        Optional<Assoc> assoc = assocService.getAssocById(assoid);
        return assoc.map(asso -> new ResponseEntity<>(asso, HttpStatus.FOUND))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/assoc/{pechan}")
    public String updateAssocById(@PathVariable long pechan, @RequestBody Assoc newAssoc) {
        return assocService.updateAssocById(pechan, newAssoc);
    }

    @DeleteMapping("/assoc/{assoid}")
    public String deleteAssocById(@PathVariable long assoid) {
        return assocService.deleteAssocById(assoid);
    }

    @DeleteMapping("/assoc")
    public String deleteAssoc() {
        return assocService.deleteAllAssoc();
    }
}
