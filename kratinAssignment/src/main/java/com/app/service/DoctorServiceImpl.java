package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.DoctorDao;
import com.app.myexceptions.ResourceNotFoundException;
import com.app.pojos.Doctor;

@Service
@Transactional
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	private DoctorDao docDao;

	@Override
	public Doctor addDoctor(Doctor newDoctor) {
		Doctor addedDoc = docDao.save(newDoctor);
		return addedDoc;
	}

	@Override
	public Doctor authenticateDoc(String uname, String pwd) {
		Doctor doctor = docDao.findByDocUserNameAndDocPassword(uname, pwd)
				.orElseThrow(() -> new ResourceNotFoundException("user not found"));
		return doctor;
	}

}
