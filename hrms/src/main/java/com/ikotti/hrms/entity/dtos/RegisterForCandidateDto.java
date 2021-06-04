package com.ikotti.hrms.entity.dtos;

import java.util.Date;

import com.ikotti.hrms.entity.abstacts.UserDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterForCandidateDto extends UserDto {
	private String firstName;
	private String lastName;
	private String nationalIdentity;
	private Date birthDate;
}
