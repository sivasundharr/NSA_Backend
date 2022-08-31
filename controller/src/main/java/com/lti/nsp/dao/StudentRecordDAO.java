package com.lti.nsp.dao;

import com.lti.nsp.pojo.studentreg;

public interface StudentRecordDAO {

	
	studentreg findStudent(String aadharNumber);
}
