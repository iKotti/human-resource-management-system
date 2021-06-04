package com.ikotti.hrms.entity.dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobPostingListDto {
	private String companyName;
	private String jobPostingName;
	private int numberOfOpenPosition;
	private Date creationDate;
	private Date applicationDeadline;
}
