package com.lti.nsp.service;
import java.util.*;

import com.lti.nsp.pojo.*;

public interface StudentRecordService {

	public studentreg addStudent(studentreg student);
	
	public studentreg findStudent(String aadharNumber);
	
	public studentlogin credsUsed(studentlogin sl);
	
}
