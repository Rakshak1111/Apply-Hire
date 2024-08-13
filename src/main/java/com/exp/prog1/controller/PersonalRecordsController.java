package com.exp.prog1.controller;

import com.exp.prog1.dto.PersonalDetailsRecord;
import com.exp.prog1.entity.PersonalDetails;
import com.exp.prog1.service.PersonalDetailsService;
import com.exp.prog1.repository.PersonalDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/personalDetails")
public class PersonalRecordsController {

    @Autowired
    private PersonalDetailsRepository personalDetailsRepository;

    @Autowired
    private PersonalDetailsService personalDetailsService;

    @GetMapping(value = "/get/{id}")
    public ResponseEntity<Optional<PersonalDetails>> getPersonalRecords(@PathVariable Long id) {
        try {
            Optional<PersonalDetails> personalDetails = personalDetailsService.getPersonalDetails(id);
            return ResponseEntity.ok(personalDetails);

        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }


    @PostMapping(value = "/save")
    public ResponseEntity<String> createPersonalRecord(@RequestBody PersonalDetailsRecord personalDetailsRecord) {
        try{
            personalDetailsService.savePersonalDetails(personalDetailsRecord);
            return ResponseEntity.ok("Personal Details has been saved into the DB successfully");

        } catch (Exception e){
            return ResponseEntity.internalServerError().body("Error saving record: " + e.getMessage());

        }
    }

}
