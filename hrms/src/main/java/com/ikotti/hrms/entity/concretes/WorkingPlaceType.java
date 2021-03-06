package com.ikotti.hrms.entity.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "working_place_types")
public class WorkingPlaceType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int workingPlaceTypeId;

	@Column(name = "working_place_name")
	private String workingPlaceName;
	
	@JsonIgnore
	@OneToMany(mappedBy = "workingPlaceType")
	private List<JobPosting> jobPostings;

}
