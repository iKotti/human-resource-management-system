import axios from "axios";

export default class JobPostingService {
  add(jobPosting) {
    return axios.post("http://localhost:8080/api/jobpostings/add",jobPosting);
  }

  getJobPostings() {
    return axios.get("http://localhost:8080/api/jobpostings/getall");
  }

  getById(id) {
    return axios.get("http://localhost:8080/api/jobpostings/getById?id=" + id);
  }

  getByIsConfirmFalse() {
    return axios.get(
      "http://localhost:8080/api/jobpostings/getByIsConfirmed?isConfirm=false"
    );
  }

  getByIsConfirmTrue() {
    return axios.get(
      "http://localhost:8080/api/jobpostings/getByIsConfirmed?isConfirm=true"
    );
  }
}
