package com.ikotti.hrms.entity.dtos;

import java.util.List;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ikotti.hrms.entity.concretes.Candidate;
import com.ikotti.hrms.entity.concretes.CandidateAbility;
import com.ikotti.hrms.entity.concretes.CandidateEducation;
import com.ikotti.hrms.entity.concretes.CandidateExperience;
import com.ikotti.hrms.entity.concretes.CandidateLanguage;
import com.ikotti.hrms.entity.concretes.CandidatePicture;
import com.ikotti.hrms.entity.concretes.CandidateSocialMedia;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CurriculumVitaeDto {
	
	@JsonIgnore
	Candidate candidate;
	 
	private List<@Valid CandidateAbility> candidateAbilities;
	private List<@Valid CandidateEducation> candidateEducations;
	private List<@Valid CandidateExperience> candidateExperinces;
	private List<@Valid CandidateSocialMedia> candidateSocialMedias;
	private List<@Valid CandidateLanguage> candidateLanguages;
}
