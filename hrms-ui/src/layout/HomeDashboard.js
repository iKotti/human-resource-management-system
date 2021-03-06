import React from "react";
import { Route } from "react-router-dom";
import { Container, Grid } from "semantic-ui-react";
import AddJobPosting from "../pages/AddJobPosting";
import CandidateList from "../pages/CandidateList";
import ConfirmJobPosting from "../pages/ConfirmJobPosting";
import EmployeeList from "../pages/EmployeeList";
import EmployerList from "../pages/EmployerList";
import JobPositionList from "../pages/JobPositionList";
import JobPostingDetail from "../pages/JobPostingDetail";
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
              <Route exact path="/" component={JobPostingList}/>
              <Route exact path="/jobpostings" component={JobPostingList}/>
              <Route path="/jobpostings/:id" component={JobPostingDetail}/>
              <Route path="/candidates" component={CandidateList}/>
              <Route path="/jobpositions" component={JobPositionList}/>
              <Route path="/employees" component={EmployeeList}/>
              <Route path="/employers" component={EmployerList}/>
              <Route path="/addjobposting" component={AddJobPosting}/>
              <Route path="/confirmjobposting" component={ConfirmJobPosting}/>
              
            </Grid.Column>
          </Grid.Row>
        </Grid>
      </Container>
    </div>
  );
}
