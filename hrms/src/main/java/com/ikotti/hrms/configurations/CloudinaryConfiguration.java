package com.ikotti.hrms.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.ikotti.hrms.core.utilities.pictureService.CloudinaryPictureManager;
import com.ikotti.hrms.core.utilities.pictureService.PictureService;

@Configuration
public class CloudinaryConfiguration {
    @Bean
    public Cloudinary cloudinaryService(){
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "***",
                "api_key", "***",
                "api_secret", "***"));
    }

    @Bean
    public PictureService pictureService(){
        return new CloudinaryPictureManager(cloudinaryService());
    }
}
