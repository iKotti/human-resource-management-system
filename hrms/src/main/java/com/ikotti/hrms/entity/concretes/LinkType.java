package com.ikotti.hrms.entity.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name="link_types")
public class LinkType {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

	@NotNull
	@NotBlank
    @Column(name="type")
    private String type;

    @OneToMany(mappedBy = "linkType")
    @JsonIgnore()
    private List<CandidateSocialMedia> candidateSocialMedia;
}
