import axios from "axios";

export default class WorkingTimeTypeService {
  getWorkingTimeTypes() {
    return axios.get("http://localhost:8080/api/workingTimeTypes/getAll");
  }
}
