package com.example.lti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.lti.nsp.*;
import com.lti.nsp.controller.InstituteController;
import com.lti.nsp.controller.MinistryController;
import com.lti.nsp.controller.NodalOfficerController;
import com.lti.nsp.controller.StudentController;
import com.lti.nsp.pojo.InstituteDetail;
import com.lti.nsp.pojo.InstituteLogin;
import com.lti.nsp.pojo.Ministrylogin;
import com.lti.nsp.pojo.NodalOfficerLogin;
import com.lti.nsp.pojo.studentlogin;
import com.lti.nsp.pojo.studentreg;

@SpringBootTest(classes=NationalScholarshipApplication.class)
class allDetailsTest {
    @Autowired
	private InstituteController instCtrl;
	
    @Autowired
	private NodalOfficerController nodCtrl;
	
    @Autowired
    private StudentController studCtrl;
    
    @Autowired
    private MinistryController miniCtrl;
	@Test
	public void testInstituteRegister() {
		InstituteDetail instMod=new InstituteDetail();
		instMod.setAddressLine1("d");
		instMod.setAddressLine2("fr");
		instMod.setAffiUnivState("fgf");
		instMod.setAffilatedUBName("45");
		instMod.setCity("mumbai");
		instMod.setDisecode(849);
		instMod.setInstiCode("ABCD");
		
		
		InstituteDetail res= instCtrl.addInstitute(instMod);
		assertNotNull(res);
	}

	
	@Test
	public void testAllInstituteDetail() {
		System.out.println(instCtrl.getAllInstituteDetail());
		assertEquals((instCtrl.getAllInstituteDetail().size()),4);
	}
	@Test
	public void testvalidateUser() {
		
		InstituteLogin instMod=new InstituteLogin();
		instMod.setEmailid("ankitasaha34@gmail.com");
		instMod.setPassword("hi");
		assertEquals(instCtrl.validateUser(instMod),true);

	}
	@Test
    public void testNodalLogin(){
		NodalOfficerLogin nodMod=new NodalOfficerLogin();
		nodMod.setUsername("nodal123");
		nodMod.setPassword("nodal");
		assertEquals(nodCtrl.nodalLoginCheck(nodMod),true);
	}
	
	@Test
	public void testGetInstituteAppliations() {
		assertNotEquals((nodCtrl.getAllInstitutes()).size(),0);
	}
	
	

	@Test
	public void testRegisterstudent() {
		studentreg stuMod=new studentreg();
		stuMod.setAadharNumber("380183206828");
		stuMod.setName("Hari");
		stuMod.setEmail("thughari3@gmail.com");
		stuMod.setGender("male");
		studentreg res= studCtrl.createStudent(stuMod);
		assertNotNull(res);

	}
	@Test
    public void testStudentLogin(){
		studentlogin stuMod=new studentlogin();
		stuMod.setAadharNumber("895922625262");
		stuMod.setPassword("avinash");
		boolean res=studCtrl.validateUser(stuMod);
		assertEquals(true,res);
	}
    @Test
	public void teststudentdetails()
	{
    	assertNotEquals((studCtrl.studentdetails()).size(),0);
	}
    
   
  
	@Test
    public void testMinistryLogin(){
		Ministrylogin miniMod=new Ministrylogin();
		miniMod.setUsername("nodal123");
		miniMod.setPassword("nodal");
		assertEquals(miniCtrl.ministryLoginCheck(miniMod),true);
	}
	
	@Test
	public void testGetNodalDetails() {
		assertNotEquals((nodCtrl.nodalDetails()).size(),0);
	}
	
	
	
}
