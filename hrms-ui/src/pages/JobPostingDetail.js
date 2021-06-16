import React, { useState, useEffect } from "react";
import { useParams } from "react-router";
import JobPostingService from "../services/JobPostingService";

export default function JobPostingDetail() {
  let { id } = useParams();

  const [jobPosting, setJobPosting] = useState({});

  useEffect(() => {
    let jobPostingService = new JobPostingService();
    jobPostingService
      .getById(id)
      .then((result) => setJobPosting(result.data.data));
  }, []);

  return (
    <div>
      <div class="ui card fluid">
        <div class="content">
          <div class="header">
            <h2>{jobPosting.jobPostingName}</h2>
          </div>
          <div class="meta">
            <span class="right floated time">
              <i class="calendar check outline icon"></i>
              {jobPosting.creationDate}
            </span>
            <p>
              <span class="category">
                {jobPosting.employer.companyName} · {jobPosting.city.cityName}
              </span>
            </p>
            <p>
              <span class="category">
                Son Başvuru Tarihi : {jobPosting.applicationDeadline}
              </span>
            </p>
            <p>
              <span class="category">
                Maaş : {jobPosting.minSalary} - {jobPosting.maxSalary}
              </span>
            </p>
          </div>
          <div class="description">
            <p>{jobPosting.description}</p>
          </div>
        </div>
        <div class="extra content">
          <div class="right floated author">
            <div class="ui animated fade primary button" tabindex="0">
              <div class="visible content">Başvur</div>
              <div class="hidden content">
                <i class="right arrow icon"></i>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}
