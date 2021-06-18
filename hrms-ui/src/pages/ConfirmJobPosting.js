import React, { useState, useEffect } from "react";
import JobPostingService from "../services/JobPostingService";

export default function ConfirmJobPosting() {
  const [jobPostings, setJobPostings] = useState([]);

  useEffect(() => {
    let jobPostingService = new JobPostingService();

    jobPostingService
      .getByIsConfirmFalse()
      .then((result) => setJobPostings(result.data.data));

      console.log(jobPostings);
  }, []);

  return (
    <div>
      <h3>Onay Bekleyen İş İlanları</h3>
      <table class="ui blue striped table">
      <thead>
          <tr>
          <th>İlan Sahibi</th>
            <th>İlan Başlığı</th>
            <th>Oluşturulma Tarihi</th>
            <th>Şehir</th>
            <th>İşlem</th>
          </tr>
        </thead>
        <tbody>
      {jobPostings.map((jobPosting) => (
          <tr>
            <td>{jobPosting.employer.companyName}</td>
            <td>{jobPosting.jobPostingName}</td>
            <td>{jobPosting.creationDate}</td>
            <td>{jobPosting.city.cityName}</td>
            <td>
            <button class="ui red button">Sil</button>
            <button class="ui blue button">Onayla</button>
            </td>
          </tr>
      ))}
      </tbody>
      </table>
    </div>
  );
}
