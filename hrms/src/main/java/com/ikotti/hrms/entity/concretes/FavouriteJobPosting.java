package com.ikotti.hrms.entity.concretes;

import java.time.LocalDateTime;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.format.DateTimeFormatter;  

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="favourite_job_postings")
public class FavouriteJobPosting {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="favourite_id")
	private int favouriteId;
	
	@ManyToOne()
	@JoinColumn(name = "candidate_id")
	private Candidate candidate;
	
	@ManyToOne()
	@JoinColumn(name = "job_posting_id")
	private JobPosting jobPosting;
	
	@Column(name="favourite_date")
	private LocalDateTime favouriteDate = LocalDateTime.now();

}
