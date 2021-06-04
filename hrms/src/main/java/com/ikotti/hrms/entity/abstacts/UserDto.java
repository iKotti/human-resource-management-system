package com.ikotti.hrms.entity.abstacts;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class UserDto {
	private String firstName;
	private String lastName;
	private String nationalIdentity;
	private Date dateOfBirth;
	private String description;
}
