package com.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Doctor;

public interface DoctorDao extends JpaRepository<Doctor, Long> {

	public Optional<Doctor> findByDocUserNameAndDocPassword(String uname, String pwd);

}
