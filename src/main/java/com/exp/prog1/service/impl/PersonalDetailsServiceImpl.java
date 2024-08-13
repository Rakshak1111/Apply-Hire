package com.exp.prog1.service.impl;

import com.exp.prog1.dto.PersonalDetailsRecord;
import com.exp.prog1.entity.PersonalDetails;
import com.exp.prog1.repository.PersonalDetailsRepository;
import com.exp.prog1.service.PersonalDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
class PersonalDetailsServiceImpl implements PersonalDetailsService {
    @Autowired
    private PersonalDetailsRepository personalDetailsRepository;

    @Override
    public Optional<PersonalDetails> getPersonalDetails(Long id) {
        Optional<PersonalDetails> personalDetails = personalDetailsRepository.findById(id);
        return personalDetails;
    }

    @Override
    public String savePersonalDetails(PersonalDetailsRecord record) {
        PersonalDetails personalDetails = new PersonalDetails();
        personalDetails.setName(record.getName());
        personalDetails.setAge(record.getAge());
        personalDetails.setAddress(record.getAddress());
        personalDetails.setNumber(record.getNumber());
        personalDetails.setEmail(record.getEmail());
        personalDetailsRepository.save(personalDetails);
        return "Record saved successfully with ID: " + personalDetails.getId();
    }

}