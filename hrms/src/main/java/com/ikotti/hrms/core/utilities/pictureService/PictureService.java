package com.ikotti.hrms.core.utilities.pictureService;

import org.springframework.web.multipart.MultipartFile;

import com.ikotti.hrms.core.utilities.results.DataResult;

public interface PictureService {
	DataResult<?> save(MultipartFile file);
}
