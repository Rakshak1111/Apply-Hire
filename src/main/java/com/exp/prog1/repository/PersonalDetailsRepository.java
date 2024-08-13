package com.exp.prog1.repository;

import com.exp.prog1.controller.PersonalRecordsController;
import com.exp.prog1.dto.PersonalDetailsRecord;
import com.exp.prog1.entity.PersonalDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalDetailsRepository extends JpaRepository<PersonalDetails,Long> {

}
