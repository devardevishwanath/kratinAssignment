package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "doctors")
@ToString(exclude = { "patients", "prescriptions" })
@NoArgsConstructor
@Getter
@Setter
public class Doctor extends BaseEntity {
	@Column(length = 20, nullable = false, name = "doc_name")
	String docName;

	@Column(unique = true, length = 20, nullable = false)
	String docUserName;

	@Column(length = 50, nullable = false)
	String docPassword;

	@OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	List<Patient> patients = new ArrayList<>();

	@OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<Prescription> prescriptions = new ArrayList<Prescription>();
}
