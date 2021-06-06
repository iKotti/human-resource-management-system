package com.ikotti.hrms.core.utilities.pictureService;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.ikotti.hrms.core.utilities.results.DataResult;
import com.ikotti.hrms.core.utilities.results.ErrorDataResult;
import com.ikotti.hrms.core.utilities.results.SuccessDataResult;

@Service
public class CloudinaryPictureManager implements PictureService {
	private Cloudinary cloudinary;

	@Autowired
	public CloudinaryPictureManager(Cloudinary cloudinary) {
		this.cloudinary = cloudinary;
	}

	@Override
	public DataResult<?> save(MultipartFile file) {
		try {
			Map uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
			return new SuccessDataResult<Map>(uploadResult);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ErrorDataResult<Map>();
	}
}
