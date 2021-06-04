package com.ikotti.hrms.business.abstracts;

import java.util.List;

import com.ikotti.hrms.core.utilities.results.DataResult;
import com.ikotti.hrms.core.utilities.results.Result;
import com.ikotti.hrms.entity.concretes.LinkType;

public interface LinkTypeService {
	Result add(LinkType linkType);

	DataResult<List<LinkType>> getAll();
}
