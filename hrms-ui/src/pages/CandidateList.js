import React, { useState, useEffect } from "react";
import CandidateService from "../services/CandidateService";

export default function CandidateList() {
  const [candidates, setCandidates] = useState([]);

  useEffect(() => {
    let candidateService = new CandidateService();

    candidateService
      .getCandidates()
      .then((result) => setCandidates(result.data.data));
  });
  return (
    <div className="mb-2">
      <h4> İş Arayanlar </h4>
      <div className="ui cards">
        {candidates.map((candidate) => (
          <div className="ui blue card">
            <div className="content">
              <div className="center aligned author mb-1">
                <img
                  alt=""
                  className="ui avatar image"
                  src="https://cdn4.iconfinder.com/data/icons/small-n-flat/24/user-alt-512.png"
                />
              </div>

              <div className="center aligned header">{candidate.firstName} {candidate.lastName}</div>
              <div className="center aligned description">
                <p>
                  <i className="envelope icon"></i> {candidate.email}
                </p>
              </div>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
}
