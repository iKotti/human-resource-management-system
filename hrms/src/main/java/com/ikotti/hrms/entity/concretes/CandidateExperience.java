package com.ikotti.hrms.entity.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="candidate_experiences")
@AllArgsConstructor
@NoArgsConstructor
public class CandidateExperience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "company_name")
    @NotBlank
    @NotNull
    private String companyName;

    @Column(name = "position")
    @NotBlank
    @NotNull
    private String position;

    @Column(name = "start_date")
    @NotNull
    private LocalDate startDate;

    @Column(name = "finish_date")
    private LocalDate finishDate;

    @ManyToOne()
    @JsonIgnore()
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;

}
