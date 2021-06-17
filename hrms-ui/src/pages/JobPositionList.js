import React, { useState, useEffect } from "react";
import JobPositionService from "../services/JobPositionService";
import { Table } from "semantic-ui-react";

export default function JobPositionList() {
  const [jobPositions, setJobPositions] = useState([]);

  useEffect(() => {
    let jobPositionService = new JobPositionService();

    jobPositionService
      .getJobPositions()
      .then((result) => setJobPositions(result.data));
  });

  return (
    <div>
      <h4>İş Pozisyonları</h4>
      <Table color="blue" className="mb-2">
        <Table.Header>
          <Table.Row>
            <Table.HeaderCell>İş Adı</Table.HeaderCell>
          </Table.Row>
        </Table.Header>

        <Table.Body>
          {jobPositions.map((jobPosition) => (
            <Table.Row key={jobPosition.id}>
              <Table.Cell>{jobPosition.title}</Table.Cell>
            </Table.Row>
          ))}
        </Table.Body>
      </Table>
    </div>
  );
}
