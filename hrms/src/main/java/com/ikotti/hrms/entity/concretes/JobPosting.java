package com.ikotti.hrms.entity.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "job_postings")
public class JobPosting {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "job_posting_id")
	private int id;

	@Column(name = "description")
	private String description;

	@Column(name = "min_salary")
	private double minSalary;

	@Column(name = "max_salary")
	private double maxSalary;

	@Column(name = "number_of_open_position")
	private int numberOfOpenPosition;

	@Column(name = "application_deadline")
	private LocalDate applicationDeadline;
	
	@Column(name = "creation_date")
	private LocalDate creationDate = LocalDate.now();
	
	@Column(name="is_active")
	private Boolean activationStatus;
	
	@Column(name="job_posting_name")
	private String jobPostingName;
	
	@Column(name="is_confirm")
	private Boolean isConfirm;
	
	@ManyToOne()
	@JoinColumn(name = "job_position_id")
	private JobPosition jobPosition;

	@ManyToOne()
	@JoinColumn(name = "city_id")
	private City city;
	
	@ManyToOne()
	@JoinColumn(name = "employer_id")
	private Employer employer;
	
	@ManyToOne()
	@JoinColumn(name = "working_place_type")
	private WorkingPlaceType workingPlaceType;
	
	@ManyToOne()
	@JoinColumn(name = "working_time_type")
	private WorkingTimeType workingTimeType;

}
