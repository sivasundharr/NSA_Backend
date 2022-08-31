package com.lti.nsp.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.lti.nsp.pojo.studentreg;

public interface StudentRepository extends JpaRepository<studentreg , Long> {

	studentreg findByAadharNumber(String aadharNumber);
	
	
}
