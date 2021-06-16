package com.ikotti.hrms.entity.dtos;

import java.time.LocalDate;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobPostingListDto {
	private int id;
	private String companyName;
	private String jobPostingName;
	private int numberOfOpenPosition;
	private LocalDate creationDate;
	private LocalDate applicationDeadline;
	private String description;
}
