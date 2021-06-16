package com.ikotti.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ikotti.hrms.business.abstracts.CandidateVerificationService;
import com.ikotti.hrms.business.abstracts.CandidateAbilityService;
import com.ikotti.hrms.business.abstracts.CandidateEducationService;
import com.ikotti.hrms.business.abstracts.CandidateExperienceService;
import com.ikotti.hrms.business.abstracts.CandidateLanguageService;
import com.ikotti.hrms.business.abstracts.CandidateService;
import com.ikotti.hrms.business.abstracts.CandidateSocialMediaService;
import com.ikotti.hrms.core.utilities.results.DataResult;
import com.ikotti.hrms.core.utilities.results.Result;
import com.ikotti.hrms.core.utilities.results.SuccessDataResult;
import com.ikotti.hrms.core.utilities.results.SuccessResult;
import com.ikotti.hrms.dataAccess.abstracts.CandidateDao;
import com.ikotti.hrms.entity.concretes.Candidate;
import com.ikotti.hrms.entity.dtos.CurriculumVitaeDto;

@Service
public class CandidateManager implements CandidateService {

	private CandidateDao candidateDao;
	private CandidateVerificationService candidateVerificationService;
	private CandidateAbilityService candidateAbilityService;
	private CandidateEducationService candidateEducationService;
	private CandidateExperienceService candidateExperienceService;
	private CandidateLanguageService candidateLanguageService;
	private CandidateSocialMediaService candidateSocialMediaService;

	@Autowired
	public CandidateManager(CandidateDao candidateDao, CandidateVerificationService candidateVerificationService,
			CandidateAbilityService candidateAbilityService, CandidateEducationService candidateEducationService,
			CandidateExperienceService candidateExperienceService, CandidateLanguageService candidateLanguageService,
			CandidateSocialMediaService candidateSocialMediaService) {
		this.candidateDao = candidateDao;
		this.candidateVerificationService = candidateVerificationService;
		this.candidateAbilityService = candidateAbilityService;
		this.candidateEducationService = candidateEducationService;
		this.candidateExperienceService = candidateExperienceService;
		this.candidateLanguageService = candidateLanguageService;
		this.candidateSocialMediaService = candidateSocialMediaService;
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(), "Data Listelendi");
	}

	@Override
	public Result add(Candidate candidate) {

		Result checkTotal = candidateVerificationService.checkTotal(candidate);

		if (!checkTotal.isSuccess()) {
			return checkTotal;
		}

		this.candidateDao.save(candidate);
		return new SuccessResult("İş arayan başarıyla kaydedildi.");
	}

	@Override
	public DataResult<CurriculumVitaeDto> getCvByCandidateId(int candidateId) {
		CurriculumVitaeDto cv = new CurriculumVitaeDto();
		cv.setCandidate(candidateDao.getById(candidateId));
		cv.setCandidateAbilities(candidateAbilityService.getAllByCandidateId(candidateId).getData());
		cv.setCandidateEducations(candidateEducationService.getAllOrderByFinishYearAsc().getData());
		cv.setCandidateExperinces(
				candidateExperienceService.getAllByCandidateIdOrderByFinishDate(candidateId).getData());
		cv.setCandidateLanguages(candidateLanguageService.getAllByCandidateId(candidateId).getData());
		cv.setCandidateSocialMedias(candidateSocialMediaService.getAllByCandidateId(candidateId).getData());
		return new SuccessDataResult<CurriculumVitaeDto>(cv, "CV başarıyla getirildi.");
	}
}
