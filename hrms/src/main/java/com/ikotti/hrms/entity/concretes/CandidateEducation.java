package com.ikotti.hrms.entity.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "candidate_educations")
public class CandidateEducation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "school_name")
	@NotBlank
	@NotNull
	private String schoolName;

	@Column(name = "department_name")
	@NotBlank
	@NotNull
	private String departmentName;

	@Column(name = "start_year")
	@NotNull
	private int startYear;

	@Column(name = "finish_year")
	private int finishYear;

	@ManyToOne()
	@JsonIgnore
	@JoinColumn(name = "candidate_id")
	private Candidate candidate;
}
