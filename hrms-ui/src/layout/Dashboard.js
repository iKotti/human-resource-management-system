import React from "react";
import { Grid } from "semantic-ui-react";
import CandidateList from "../pages/CandidateList";
import JobPositionList from "../pages/JobPositionList";
import JobPostingList from "../pages/JobPostingList";
import Categories from './Categories'

export default function dashboard() {
  return (
    <div>
      <Grid>
        <Grid.Row>
          <Grid.Column width={3}>
            <Categories />
          </Grid.Column>
          <Grid.Column width={13}>
            <JobPositionList/>
            <CandidateList/>
            <JobPostingList/>
          </Grid.Column>
        </Grid.Row>
      </Grid>
    </div>
  );
}
