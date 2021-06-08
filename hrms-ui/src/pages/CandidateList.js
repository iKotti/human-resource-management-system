import React, { useState, useEffect } from "react";
import CandidateService from "../services/CandidateService";
/* import { Table } from "semantic-ui-react"; */

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
      {/* <Table color="red" className="mb-2">
        <Table.Header>
          <Table.Row>
            <Table.HeaderCell>Ad</Table.HeaderCell>
            <Table.HeaderCell>Soyad</Table.HeaderCell>
            <Table.HeaderCell>Email</Table.HeaderCell>
            <Table.HeaderCell>Doğum Yılı</Table.HeaderCell>
            <Table.HeaderCell>TC Kimlik No</Table.HeaderCell>
          </Table.Row>
        </Table.Header>

        <Table.Body>
          {candidates.map((candidate) => (
            <Table.Row key={candidate.id}>
              <Table.Cell>{candidate.firstName}</Table.Cell>
              <Table.Cell>{candidate.lastName}</Table.Cell>
              <Table.Cell>{candidate.email}</Table.Cell>
              <Table.Cell>{candidate.birthDate}</Table.Cell>
              <Table.Cell>{candidate.nationalIdentity}</Table.Cell>
            </Table.Row>
          ))}
        </Table.Body>
      </Table> */}

      <div class="ui cards">
        {candidates.map((candidate) => (
          <div class="ui blue card">
            <div class="content">
              <div class="center aligned author mb-1">
                <img
                  alt=""
                  class="ui avatar image"
                  src="https://cdn4.iconfinder.com/data/icons/small-n-flat/24/user-alt-512.png"
                />
              </div>

              <div class="center aligned header">{candidate.firstName} {candidate.lastName}</div>
              <div class="center aligned description">
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
