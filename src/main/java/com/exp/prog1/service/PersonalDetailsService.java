package com.exp.prog1.service;

import com.exp.prog1.dto.PersonalDetailsRecord;
import com.exp.prog1.entity.PersonalDetails;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface PersonalDetailsService {

    String savePersonalDetails(PersonalDetailsRecord record);

    Optional<PersonalDetails> getPersonalDetails(Long id);
}
