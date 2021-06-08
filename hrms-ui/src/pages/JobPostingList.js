import React, { useState, useEffect } from "react";
import JobPostingService from "../services/JobPostingService";

export default function JobPostingList() {
  const [jobPostings, setJobPostings] = useState([]);

  useEffect(() => {
    let jobPostingService = new JobPostingService();

    jobPostingService
      .getJobPostings()
      .then((result) => setJobPostings(result.data.data));
  });
  return (
    <div>
      <h4> İş İlanları </h4>
      <div class="ui cards">
        {jobPostings.map((jobPosting) => (
          <div className="ui blue card">
            <div className="content">
              <div className="header">{jobPosting.jobPostingName}</div>

              <div className="meta">
                <span className="right floated time">
                  
                </span>
                <p className="company">
                  <i className="building icon"></i> {jobPosting.companyName}
                </p>
              </div>
              <div className="description">
                <p>{jobPosting.description}</p>
              </div>
            </div>
            <div className="extra content">
              <div className="left centered author">
                <div class="ui animated small blue button" tabindex="0">
                  <div class="visible content">Görüntüle</div>
                  <div class="hidden content">
                    <i class="right arrow icon"></i>
                  </div>
                </div>
              </div>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
}
