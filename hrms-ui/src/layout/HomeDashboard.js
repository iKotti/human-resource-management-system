import React from "react";
import { Container, Grid } from "semantic-ui-react";
import CandidateList from "../pages/CandidateList";
import JobPositionList from "../pages/JobPositionList";
import JobPostingList from "../pages/JobPostingList";
import SearchBar from "../pages/SearchBar";
import Categories from "./Categories";

export default function HomeDashboard() {
  return (
    <div>
      <SearchBar />
      <Container>
        <Grid>
          <Grid.Row>
            <Grid.Column width={3}>
              <Categories />
            </Grid.Column>
            <Grid.Column width={13}>
              <JobPositionList />
              <CandidateList />
              <JobPostingList />
            </Grid.Column>
          </Grid.Row>
        </Grid>
      </Container>
    </div>
  );
}
