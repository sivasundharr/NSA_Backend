package com.lti.nsp.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.nsp.pojo.InstituteDetail;
import com.lti.nsp.pojo.InstituteLogin;
import com.lti.nsp.pojo.ScholarshipApplication;
import com.lti.nsp.pojo.studentreg;
import com.lti.nsp.repository.InstituteDetailsRepository;
import com.lti.nsp.repository.ScholarshipApplicationRepository;
import com.lti.nsp.repository.StudentRepository;
import com.lti.nsp.service.InstituteDetailsServiceImpl;

import org.springframework.web.bind.annotation.*;



@RestController  
@CrossOrigin(origins = "http://localhost:4200")
public class InstituteController {

	@Autowired
	private InstituteDetailsServiceImpl instituteImpl;
	
	@Autowired
	StudentRepository studentRepo;
	
	@Autowired
	InstituteDetailsRepository institute;
	
	@Autowired
	ScholarshipApplicationRepository sar;
	
	List<ScholarshipApplication> sa;
	
	//adding institute
	@PostMapping("/institutes")
	public InstituteDetail addInstitute(@Valid@RequestBody InstituteDetail application)
	{
		System.out.println("Academic Details work!");
		
		instituteImpl.addInstitute(application);
		return application;
	}
	
	//view all institute details
	@GetMapping("/instituterecord")
	public List<InstituteDetail> getAllInstituteDetail() {
		// TODO Auto-generated method stub
		return instituteImpl.getAllInstituteDetail();
	}

	
	//login validation
	@PostMapping("/institutelogin")
	public boolean validateUser(@RequestBody InstituteLogin sl) {
		String a = sl.getEmailid();
		String p = sl.getPassword();
		List<InstituteDetail> ls = instituteImpl.getAllInstituteDetail();
		
		for(InstituteDetail s : ls) {
			if((a.equals(s.getEmailid())) && (p.equals(s.getPassword()))) {
				return true;
			}
		}
		return false;
	}
	
	
	//find institute by email
	@GetMapping("/institutes/{emailid}")
	public InstituteDetail institutehome(@PathVariable String emailid) {
		InstituteDetail institute1 = institute.findByEmailid(emailid);
		return institute1;
	}
	
	@GetMapping("/studentininstitute/{emailid}")
	public List<ScholarshipApplication> findStudents(@PathVariable String emailid){
		InstituteDetail ins = institute.findByEmailid(emailid);
		String code = ins.getInstiCode();
		List<ScholarshipApplication> scholar = sar.findByInstiCode(code);
		this.sa = scholar;
		return scholar;
	}
	
//	@PutMapping("/instiApproval/{instiCode}")
//	public String updateStatus(@PathVariable(value="instiCode") String instiCode) {
		//Optional<InstituteDetail> i = institute.findByInstiCode(instiCode);
		//InstituteDetail application = i.get(); 
//		List<ScholarshipApplication> scholar = sar.findByInstiCode(instiCode);
//		studentreg reg = null;
//		for(ScholarshipApplication sa : scholar)
//		{
///			String aadharNoo  = sa.getAadhar();
//			reg =  studentRepo.findByAadharNumber(aadharNoo);
//			reg.setApplicationstatus("Approved by Institute");
//			studentRepo.save(reg);
			
//		}
///		return reg.getApplicationstatus();
		
//		application.setApplication_status("approved by nodal officer");
//		institute.save(application); 
		
	//}
	
	
	

	
	
}
	
	