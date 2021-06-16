package com.ikotti.hrms.entity.concretes;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ikotti.hrms.entity.abstacts.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "candidates")
public class Candidate extends User {

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "birth_date")
	private LocalDate birthDate;

	@Column(name = "national_identity")
	private String nationalIdentity;

	@OneToMany(mappedBy = "candidate")
	@JsonIgnore
	private List<CandidateEducation> candidateEducations;

	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<CandidateExperience> candidateExperiences;

	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<CandidateLanguage> candidateLanguages;

	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<CandidateSocialMedia> candidateSocialMedias;

	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<CandidateAbility> candidateAbilities;

	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<CandidatePicture> candidatePictures;

}
