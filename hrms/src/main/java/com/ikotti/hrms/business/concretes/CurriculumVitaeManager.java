package com.ikotti.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ikotti.hrms.business.abstracts.CandidateAbilityService;
import com.ikotti.hrms.business.abstracts.CandidateEducationService;
import com.ikotti.hrms.business.abstracts.CandidateExperienceService;
import com.ikotti.hrms.business.abstracts.CandidateLanguageService;
import com.ikotti.hrms.business.abstracts.CandidatePictureService;
import com.ikotti.hrms.business.abstracts.CandidateSocialMediaService;
import com.ikotti.hrms.business.abstracts.CurriculumVitaeService;
import com.ikotti.hrms.core.utilities.results.DataResult;
import com.ikotti.hrms.core.utilities.results.Result;
import com.ikotti.hrms.core.utilities.results.SuccessDataResult;
import com.ikotti.hrms.core.utilities.results.SuccessResult;
import com.ikotti.hrms.dataAccess.abstracts.CandidateDao;
import com.ikotti.hrms.entity.concretes.Candidate;
import com.ikotti.hrms.entity.dtos.CurriculumVitaeDto;

@Service
public class CurriculumVitaeManager implements CurriculumVitaeService {

	private CandidateDao candidateDao;
	private CandidateAbilityService candidateAbilityService;
	private CandidateEducationService candidateEducationService;
	private CandidateExperienceService candidateExperienceService;
	private CandidateLanguageService candidateLanguageService;
	private CandidateSocialMediaService candidateSocialMediaService;
	private CandidatePictureService candidatePictureService;

	@Autowired
	public CurriculumVitaeManager(CandidateDao candidateDao, CandidateAbilityService candidateAbilityService,
			CandidateEducationService candidateEducationService, CandidateExperienceService candidateExperienceService,
			CandidateLanguageService candidateLanguageService, CandidateSocialMediaService candidateSocialMediaService,
			CandidatePictureService candidatePictureService) {
		this.candidateDao = candidateDao;
		this.candidateAbilityService = candidateAbilityService;
		this.candidateEducationService = candidateEducationService;
		this.candidateExperienceService = candidateExperienceService;
		this.candidateLanguageService = candidateLanguageService;
		this.candidateSocialMediaService = candidateSocialMediaService;
		this.candidatePictureService = candidatePictureService;
	}

	@Override
	public Result add(CurriculumVitaeDto curriculumVitaeDto, int candidateId) {

		Candidate candidate = candidateDao.getById(candidateId);
		curriculumVitaeDto.setCandidate(candidate);

		curriculumVitaeDto.getCandidateAbilities()
				.forEach(candidateAbility -> candidateAbility.setCandidate(candidate));
		candidateAbilityService.addAll(curriculumVitaeDto.getCandidateAbilities(), candidateId);

		curriculumVitaeDto.getCandidateEducations()
				.forEach(candidateEducation -> candidateEducation.setCandidate(candidate));
		candidateEducationService.addAll(curriculumVitaeDto.getCandidateEducations(), candidateId);

		curriculumVitaeDto.getCandidateExperinces()
				.forEach(candidateExperience -> candidateExperience.setCandidate(candidate));
		candidateExperienceService.addAll(curriculumVitaeDto.getCandidateExperinces(), candidateId);

		curriculumVitaeDto.getCandidateLanguages()
				.forEach(candidateLanguage -> candidateLanguage.setCandidate(candidate));
		candidateLanguageService.addAll(curriculumVitaeDto.getCandidateLanguages(), candidateId);

		curriculumVitaeDto.getCandidateSocialMedias()
				.forEach(candidateSocialMedia -> candidateSocialMedia.setCandidate(candidate));
		candidateSocialMediaService.addAll(curriculumVitaeDto.getCandidateSocialMedias(), candidateId);
		
		curriculumVitaeDto.getCandidatePictures().forEach(candidatePicture->candidatePicture.setCandidate(candidate));
		candidatePictureService.addAll(curriculumVitaeDto.getCandidatePictures(), candidateId);
		
		return new SuccessResult("CV Başarıyla Kaydedildi.");
	}
}
