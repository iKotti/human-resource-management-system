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
      <div className="ui card fluid">
        <div className="content">
          <div className="header">
            <h2>{jobPosting.jobPostingName}</h2>
          </div>
          <div className="meta">
            <span className="right floated time">
              <i className="calendar check outline icon"></i>
              {jobPosting.creationDate}
            </span>
            <p>
              <span className="category">
                -
              </span>
            </p>
            <p>
              <span className="category">
                Son Başvuru Tarihi : {jobPosting.applicationDeadline}
              </span>
            </p>
            <p>
              <span className="category">
                Maaş : {jobPosting.minSalary} - {jobPosting.maxSalary}
              </span>
            </p>
          </div>
          <div className="description">
            <p>{jobPosting.description}</p>
          </div>
        </div>
        <div className="extra content">
          <div className="right floated author">
            <div className="ui animated fade primary button" tabIndex="0">
              <div className="visible content">Başvur</div>
              <div className="hidden content">
                <i className="right arrow icon"></i>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}
