import React, { useState, useEffect } from "react";
import JobPostingService from "../services/JobPostingService";
import { Table } from "semantic-ui-react";

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
      <Table color="blue" className="mb-2">
        <Table.Header>
          <Table.Row>
            <Table.HeaderCell>Şirket Adı</Table.HeaderCell>
            <Table.HeaderCell>Başlık</Table.HeaderCell>
            <Table.HeaderCell>Aranan Eleman Sayısı</Table.HeaderCell>
            <Table.HeaderCell>İlan Tarihi</Table.HeaderCell>
            <Table.HeaderCell>Son Başvuru Tarihi</Table.HeaderCell>
          </Table.Row>
        </Table.Header>

        <Table.Body>
          {jobPostings.map((jobPosting) => (
            <Table.Row key={jobPosting.id}>
              <Table.Cell>{jobPosting.companyName}</Table.Cell>
              <Table.Cell>{jobPosting.jobPostingName}</Table.Cell>
              <Table.Cell>{jobPosting.numberOfOpenPosition}</Table.Cell>
              <Table.Cell>{jobPosting.creationDate}</Table.Cell>
              <Table.Cell>{jobPosting.applicationDeadline}</Table.Cell>
            </Table.Row>
          ))}
        </Table.Body>
      </Table>
    </div>
  );
}