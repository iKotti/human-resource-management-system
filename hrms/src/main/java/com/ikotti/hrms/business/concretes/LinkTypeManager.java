package com.ikotti.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ikotti.hrms.business.abstracts.LinkTypeService;
import com.ikotti.hrms.core.utilities.results.DataResult;
import com.ikotti.hrms.core.utilities.results.Result;
import com.ikotti.hrms.core.utilities.results.SuccessDataResult;
import com.ikotti.hrms.core.utilities.results.SuccessResult;
import com.ikotti.hrms.dataAccess.abstracts.LinkTypeDao;
import com.ikotti.hrms.entity.concretes.LinkType;

@Service
public class LinkTypeManager implements LinkTypeService {

	private LinkTypeDao linkTypeDao;

	@Autowired
	public LinkTypeManager(LinkTypeDao linkTypeDao) {
		this.linkTypeDao = linkTypeDao;
	}

	@Override
	public Result add(LinkType linkType) {
		linkTypeDao.save(linkType);
		return new SuccessResult("Link tipi başarıyla eklendi.");
	}

	@Override
	public DataResult<List<LinkType>> getAll() {
		return new SuccessDataResult<List<LinkType>>(linkTypeDao.findAll());
	}

}
