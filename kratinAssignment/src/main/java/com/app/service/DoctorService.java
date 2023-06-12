package com.app.service;

import com.app.pojos.Doctor;

public interface DoctorService {

	Doctor addDoctor(Doctor newDoctor);

	Doctor authenticateDoc(String uname, String pwd);

}
